package br.unicamp.ic.mc437.g1.entity;

import br.unicamp.ic.mc437.g1.util.StrangeDateAdapter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@XmlRootElement(name = "iTestResult")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlElement(name = "_date")
    @XmlJavaTypeAdapter(StrangeDateAdapter.class)
    private Date date;

    @XmlTransient
    private String email;

    @XmlTransient
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "testSetResults")
    private List<TestSetResult> testSetResults;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "_imutants")
    private List<Mutant> mutants;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "_imodel")
    private List<ResultModel> resultModels;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "_itestCases")
    private List<TestCase> testCases;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public List<ResultModel> getResultModels() {
        return resultModels;
    }

    public void setResultModels(List<ResultModel> models) {
        this.resultModels = models;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCase) {
        this.testCases = testCase;
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
                ", models=" + resultModels +
                ", testCase=" + testCases +
                '}';
    }
}
