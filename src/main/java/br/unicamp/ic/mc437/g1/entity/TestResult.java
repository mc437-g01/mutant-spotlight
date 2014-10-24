package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.List;

@Entity
@XmlRootElement(name = "iTestResult")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @XmlElement(name = "_date")
    private Calendar date;

    private String email;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "testSetResults")
    private List<TestSetResult> testSetResults;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "_imutants")
    private List<Mutant> mutants;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "_imodel")
    private List<ResultModel> models;

    @OneToMany(cascade = CascadeType.ALL)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", testSetResults=" + testSetResults +
                ", mutants=" + mutants +
                ", models=" + models +
                ", testCase=" + testCase +
                '}';
    }
}
