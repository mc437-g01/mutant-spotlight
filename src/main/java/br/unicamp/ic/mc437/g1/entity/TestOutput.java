package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class TestOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlElement(name = "dead")
    private Boolean dead;

    @XmlElement(name = "deathIndex")
    private Integer deathIndex;

    @XmlElement(name = "evalFailed")
    private Boolean evalFailed;

    @XmlElement(name = "mutantKey")
    private String mutantKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }

    public Integer getDeathIndex() {
        return deathIndex;
    }

    public void setDeathIndex(Integer deathIndex) {
        this.deathIndex = deathIndex;
    }

    public Boolean getEvalFailed() {
        return evalFailed;
    }

    public void setEvalFailed(Boolean evalFailed) {
        this.evalFailed = evalFailed;
    }

    public String getMutantKey() {
        return mutantKey;
    }

    public void setMutantKey(String mutantKey) {
        this.mutantKey = mutantKey;
    }

    @Override
    public String toString() {
        return "TestOutput{" +
                "id=" + id +
                ", dead=" + dead +
                ", deathIndex=" + deathIndex +
                ", evalFailed='" + evalFailed + '\'' +
                ", mutantKey='" + mutantKey + '\'' +
                '}';
    }
}
