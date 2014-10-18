package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.List;

@XmlRootElement(name = "iTestResult")
public class TestResult {

    private Integer id;

    @XmlElement(name = "_date")
    private Calendar date;

    private String email;

    @XmlElement(name = "testSetResults")
    private List<TestSetResult> testSetResults;

    @XmlElement(name = "_imutants")
    private List<Mutant> mutants;

    @XmlElement(name = "_imodel")
    private List<ResultModel> models;

    @XmlElement(name = "_itestCases")
    private List<TestCase> testCase;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TestSetResult> getTestSetResults() {
        return testSetResults;
    }

    public void setTestSetResults(List<TestSetResult> testSetResults) {
        this.testSetResults = testSetResults;
    }

    public List<Mutant> getMutants() {
        return mutants;
    }

    public void setMutants(List<Mutant> mutants) {
        this.mutants = mutants;
    }

    public List<ResultModel> getModels() {
        return models;
    }

    public void setModels(List<ResultModel> models) {
        this.models = models;
    }

    public List<TestCase> getTestCase() {
        return testCase;
    }

    public void setTestCase(List<TestCase> testCase) {
        this.testCase = testCase;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", testSetResults=" + testSetResults +
                ", mutants=" + mutants +
                ", models=" + models +
                ", testCase=" + testCase +
                '}';
    }
}
