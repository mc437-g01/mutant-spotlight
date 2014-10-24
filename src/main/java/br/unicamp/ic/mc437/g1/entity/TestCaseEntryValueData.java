package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class TestCaseEntryValueData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @XmlElement(name = "event")
    private String event;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "testOutput")
    private TestCaseEntryValueDataTestOutput testOutput;

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

    public TestCaseEntryValueDataTestOutput getTestOutput() {
        return testOutput;
    }

    public void setTestOutput(TestCaseEntryValueDataTestOutput testOutput) {
        this.testOutput = testOutput;
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
                ", testOutput=" + testOutput +
                ", processed=" + processed +
                '}';
    }
}
