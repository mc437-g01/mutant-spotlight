package br.unicamp.ic.mc437.g1.web.controllers.result.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@XmlRootElement(name = "testSetResults")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestSetResult {

    @XmlElement(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
