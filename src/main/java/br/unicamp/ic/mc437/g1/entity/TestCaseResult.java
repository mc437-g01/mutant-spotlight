package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class TestCaseResult {

    private Integer id;

    @XmlElement(name = "path")
    private String path;

    @XmlElement(name = "_testCaseKey")
    private String testCaseKey;

    @XmlElement(name = "testCaseExecutionOutput_MutantList")
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
