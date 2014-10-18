package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestOutput {

    private Integer id;

    @XmlElement(name = "dead")
    private Boolean dead;

    @XmlElement(name = "deathIndex")
    private Integer deathIndex;

    @XmlElement(name = "evalFailed")
    private String evalFailed;

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

    public String getEvalFailed() {
        return evalFailed;
    }

    public void setEvalFailed(String evalFailed) {
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
