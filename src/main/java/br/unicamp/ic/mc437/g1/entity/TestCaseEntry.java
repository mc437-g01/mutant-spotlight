package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class TestCaseEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlElement(name = "key")
    private String key;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "value")
    private TestCaseEntryValue testCaseEntryValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public TestCaseEntryValue getTestCaseEntryValue() {
        return testCaseEntryValue;
    }

    public void setTestCaseEntryValue(TestCaseEntryValue value) {
        this.testCaseEntryValue = value;
    }

    @Override
    public String toString() {
        return "TestCaseEntry{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value=" + testCaseEntryValue +
                '}';
    }
}
