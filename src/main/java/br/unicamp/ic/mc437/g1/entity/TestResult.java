package br.unicamp.ic.mc437.g1.entity;

import java.util.Date;
import java.util.List;

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

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

import br.unicamp.ic.mc437.g1.util.StrangeDateAdapter;

@Indexed
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

    @Field
    @XmlTransient
    private String email;

    @Field
    @XmlTransient
    private String name;
    
    @Field
    @XmlTransient
    private Integer score;

    @IndexedEmbedded
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "testSetResults")
    private List<TestSetResult> testSetResults;

    @IndexedEmbedded
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "_imutants")
    private List<Mutant> mutants;

    @IndexedEmbedded
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "_imodel")
    private List<ResultModel> resultModels;

    @IndexedEmbedded
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
    
    public void setScore (int scr){
    	this.score = scr;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
                ", resultModels=" + resultModels +
                ", testCases=" + testCases +
                ", score=" + score +
                '}';
    }
}
