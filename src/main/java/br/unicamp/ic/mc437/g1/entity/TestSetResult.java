package br.unicamp.ic.mc437.g1.entity;

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

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@XmlRootElement
public class TestSetResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @Field
    @XmlElement(name = "id")
    private String identifier;

    @Field
    @XmlElement(name = "cod")
    private String cod;

    @Field
    @XmlElement(name = "path")
    private String path;

    @IndexedEmbedded
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "testCaseResults")
    private List<TestCaseResult> testCaseResults;

    @XmlTransient
    private Integer score;

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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
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
        return "TestSetResult{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", cod='" + cod + '\'' +
                ", path='" + path + '\'' +
                ", testCaseResults=" + testCaseResults +
                ", score=" + score +
                '}';
    }
    
}
