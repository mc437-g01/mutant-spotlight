package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class TestSetResult {

    private Integer id;

    @XmlElement(name = "id")
    private Integer identifier;

    @XmlElement(name = "cod")
    private String cod;

    @XmlElement(name = "path")
    private String path;

    @XmlElement(name = "testCaseResults")
    private List<TestCaseResult> testCaseResults;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<TestCaseResult> getTestCaseResults() {
        return testCaseResults;
    }

    public void setTestCaseResults(List<TestCaseResult> testCaseResults) {
        this.testCaseResults = testCaseResults;
    }


    @Override
    public String toString() {
        return "TestSetResult{" +
                "id=" + id +
                ", identifier=" + identifier +
                ", cod='" + cod + '\'' +
                ", path='" + path + '\'' +
                ", testCaseResults=" + testCaseResults +
                '}';
    }
}
