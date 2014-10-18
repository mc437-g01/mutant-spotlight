package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@XmlRootElement
public class TestCase {

    @XmlElement(name = "entry")
    private List<TestCaseEntry> entries;

    public List<TestCaseEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<TestCaseEntry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "entries=" + entries +
                '}';
    }
}
