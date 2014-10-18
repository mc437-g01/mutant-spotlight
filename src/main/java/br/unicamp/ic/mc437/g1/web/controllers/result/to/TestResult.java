package br.unicamp.ic.mc437.g1.web.controllers.result.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@XmlRootElement(name = "iTestResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestResult {

    @XmlElement(name = "_date")
    private String date;

    @XmlElement(name = "testSetResults")
    private List<TestSetResult> testSetResults;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
