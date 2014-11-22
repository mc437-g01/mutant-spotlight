package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.Field;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class StateTransitionGuard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlAttribute(name = "isMutant")
    private Boolean isMutant;

    @XmlElement(name = "cloneGlobalIndexAsTransitionIndex")
    private Boolean cloneGlobalIndexAsTransitionIndex;

    @XmlElement(name = "condition")
    private String condition;

    @XmlElement(name = "globalIndex")
    private String globalIndex;

    @XmlElement(name = "popArgs")
    private String popArgs;

    @XmlElement(name = "pushState")
    private String pushState;

    @Field
    @XmlElement(name = "targetState")
    private String targetState;

    @XmlElement(name = "transitionType")
    private String transitionType;

    @XmlElement(name = "tIndex")
    private String tIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsMutant() {
        return isMutant;
    }

    public void setIsMutant(Boolean isMutant) {
        this.isMutant = isMutant;
    }

    public Boolean getCloneGlobalIndexAsTransitionIndex() {
        return cloneGlobalIndexAsTransitionIndex;
    }

    public void setCloneGlobalIndexAsTransitionIndex(Boolean cloneGlobalIndexAsTransitionIndex) {
        this.cloneGlobalIndexAsTransitionIndex = cloneGlobalIndexAsTransitionIndex;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getGlobalIndex() {
        return globalIndex;
    }

    public void setGlobalIndex(String globalIndex) {
        this.globalIndex = globalIndex;
    }

    public String getPopArgs() {
        return popArgs;
    }

    public void setPopArgs(String popArgs) {
        this.popArgs = popArgs;
    }

    public String getPushState() {
        return pushState;
    }

    public void setPushState(String pushState) {
        this.pushState = pushState;
    }

    public String getTargetState() {
        return targetState;
    }

    public void setTargetState(String targetState) {
        this.targetState = targetState;
    }

    public String getTransitionType() {
        return transitionType;
    }

    public void setTransitionType(String transitionType) {
        this.transitionType = transitionType;
    }

    public String gettIndex() {
        return tIndex;
    }

    public void settIndex(String tIndex) {
        this.tIndex = tIndex;
    }

    @Override
    public String toString() {
        return "StateTransitionGuard{" +
                "id=" + id +
                ", isMutant=" + isMutant +
                ", cloneGlobalIndexAsTransitionIndex=" + cloneGlobalIndexAsTransitionIndex +
                ", condition='" + condition + '\'' +
                ", globalIndex='" + globalIndex + '\'' +
                ", popArgs='" + popArgs + '\'' +
                ", pushState='" + pushState + '\'' +
                ", targetState='" + targetState + '\'' +
                ", transitionType='" + transitionType + '\'' +
                ", tIndex='" + tIndex + '\'' +
                '}';
    }
}
