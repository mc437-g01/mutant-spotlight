package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class TestCaseEntryValueDataTestOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @XmlAttribute(name = "expectedFault")
    private Boolean expectedFault;

    @XmlElement(name = "enterState")
    private String enterState;

    @XmlElement(name = "enterTransition")
    private String enterTransition;

    @XmlElement(name = "livingState")
    private String livingState;

    @XmlElement(name = "output")
    private String output;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getExpectedFault() {
        return expectedFault;
    }

    public void setExpectedFault(Boolean expectedFault) {
        this.expectedFault = expectedFault;
    }

    public String getEnterState() {
        return enterState;
    }

    public void setEnterState(String enterState) {
        this.enterState = enterState;
    }

    public String getEnterTransition() {
        return enterTransition;
    }

    public void setEnterTransition(String enterTransition) {
        this.enterTransition = enterTransition;
    }

    public String getLivingState() {
        return livingState;
    }

    public void setLivingState(String livingState) {
        this.livingState = livingState;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "TestCaseEntryValueDataTestOutput{" +
                "id=" + id +
                ", expectedFault=" + expectedFault +
                ", enterState='" + enterState + '\'' +
                ", enterTransition='" + enterTransition + '\'' +
                ", livingState='" + livingState + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
