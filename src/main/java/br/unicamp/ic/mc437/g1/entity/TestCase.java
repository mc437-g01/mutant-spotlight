package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "entry")
    private List<TestCaseEntry> testCaseEntries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TestCaseEntry> getTestCaseEntries() {
        return testCaseEntries;
    }

    public void setTestCaseEntries(List<TestCaseEntry> entries) {
        this.testCaseEntries = entries;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "id=" + id +
                ", entries=" + testCaseEntries +
                '}';
    }
}
