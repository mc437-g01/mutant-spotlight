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

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class TestCaseEntryValueData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @Field
    @XmlElement(name = "event")
    private String event;

    @IndexedEmbedded
    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "testOutput")
    private TestCaseEntryValueDataTestOutput testCaseEntryValueDataTestOutput;

    @XmlElement(name = "processed")
    private Boolean processed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public TestCaseEntryValueDataTestOutput getTestCaseEntryValueDataTestOutput() {
        return testCaseEntryValueDataTestOutput;
    }

    public void setTestCaseEntryValueDataTestOutput(TestCaseEntryValueDataTestOutput testOutput) {
        this.testCaseEntryValueDataTestOutput = testOutput;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "TestCaseEntryValueData{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", testOutput=" + testCaseEntryValueDataTestOutput +
                ", processed=" + processed +
                '}';
    }
}
