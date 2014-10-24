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

@Entity
@XmlRootElement
public class TestCaseResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlElement(name = "path")
    private String path;

    @XmlElement(name = "_testCaseKey")
    private String testCaseKey;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "testCaseExecutingOutput_MutantList")
    private List<TestOutput> testOutputs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTestCaseKey() {
        return testCaseKey;
    }

    public void setTestCaseKey(String testCaseKey) {
        this.testCaseKey = testCaseKey;
    }

    public List<TestOutput> getTestOutputs() {
        return testOutputs;
    }

    public void setTestOutputs(List<TestOutput> testOutputs) {
        this.testOutputs = testOutputs;
    }

    @Override
    public String toString() {
        return "TestCaseResult{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", testCaseKey='" + testCaseKey + '\'' +
                ", testOutputs=" + testOutputs +
                '}';
    }
}
