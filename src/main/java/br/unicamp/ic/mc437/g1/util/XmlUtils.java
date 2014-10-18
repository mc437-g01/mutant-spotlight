package br.unicamp.ic.mc437.g1.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fernandogoncalves on 10/17/14.
 */

public class XmlUtils {

    private static final ConcurrentHashMap<Class<?>, JAXBContext> contextMap = new ConcurrentHashMap<Class<?>, JAXBContext>(64);

    private static final Logger logEx = LoggerFactory.getLogger("exceptions");

    private static JAXBContext loadContext(final Class<?> clazz) {

        JAXBContext jaxbContext = contextMap.get(clazz);

        if (jaxbContext != null) {
            return jaxbContext;
        }

        try {
            jaxbContext = JAXBContext.newInstance(clazz);
        } catch (JAXBException e) {
            logEx.error("Error while creating JaxbContext for class: {}", clazz, e);

            return null;
        }

        contextMap.putIfAbsent(clazz, jaxbContext);

        return jaxbContext;
    }

    public static <T> T readValue(final String xml, final Class<T> clazz) {

        Validate.notNull(xml, "Xml can't be null");
        Validate.notEmpty(xml, "Xml can't be empty");
        Validate.notNull(clazz, "Class can't be null");

        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());
            return doRead(byteArrayInputStream, clazz);
        } catch (JAXBException e) {
            logEx.error("Error while unmarshalling class: {}, xml: {}", clazz, xml);
            logEx.error("Exception is", e);
        } finally {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }

        return null;
    }

    public static <T> T readValue(final InputStream xml, final Class<T> clazz) {

        Validate.notNull(xml, "InputStream can't be null");
        Validate.notNull(clazz, "Class can't be null");

        try {
            return doRead(xml, clazz);
        } catch (JAXBException e) {

            String xmlString = "";
            try {
                xmlString = IOUtils.toString(xml);
            } catch (IOException e1) {
                // nothing
            }

            logEx.error("Error while unmarshalling class: {}, xml: {}", clazz, xmlString);
            logEx.error("Exception is", e);
        }

        return null;
    }

    public static String writeValueAsString(final Object obj) {

        Validate.notNull(obj, "Object can't be null");

        final JAXBContext context = loadContext(obj.getClass());

        if (context == null) {
            return null;
        }

        try {
            final Marshaller marshaller = context.createMarshaller();

            final StringWriter stringWriter = new StringWriter();

            marshaller.marshal(obj, stringWriter);

            return stringWriter.getBuffer().toString();

        } catch (JAXBException e) {
            logEx.error("Error while marshalling class: {}", obj.getClass());
            logEx.error("Exception is", e);
        }

        return null;
    }

    public static void writeValueToOutputStream(final Object obj, final OutputStream outputStream) {

        Validate.notNull(obj, "Object can't be null");
        Validate.notNull(outputStream, "OutputStream can't be null");

        final JAXBContext context = loadContext(obj.getClass());

        if (context == null) {
            return;
        }

        try {

            final Marshaller marshaller = context.createMarshaller();

            marshaller.marshal(obj, outputStream);

        } catch (JAXBException e) {
            logEx.error("Error while marshalling class: {}", obj.getClass());
            logEx.error("Exception is", e);
        }
    }

    private static <T> T doRead(final InputStream inputStream, final Class<T> clazz) throws JAXBException {
        final Unmarshaller unmarshaller;

        final JAXBContext context = loadContext(clazz);

        if (context == null) {
            return null;
        }

        unmarshaller = context.createUnmarshaller();
        final JAXBElement<T> element = unmarshaller.unmarshal(new StreamSource(inputStream), clazz);
        return element.getValue();
    }

}