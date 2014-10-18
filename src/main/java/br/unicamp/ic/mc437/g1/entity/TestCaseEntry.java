package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@XmlRootElement
public class TestCaseEntry {

    @XmlElement(name = "key")
    private String key;

    @XmlElement(name = "value")
    private TestCaseEntryValue value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public TestCaseEntryValue getValue() {
        return value;
    }

    public void setValue(TestCaseEntryValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestCaseEntry{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
