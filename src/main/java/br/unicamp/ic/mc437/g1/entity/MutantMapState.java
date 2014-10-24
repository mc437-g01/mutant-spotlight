package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class MutantMapState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @XmlAttribute(name = "isMutant")
    private Boolean isMutant;

    @XmlElement(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "transition")
    private StateTransition transition;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateTransition getTransition() {
        return transition;
    }

    public void setTransition(StateTransition transition) {
        this.transition = transition;
    }

    @Override
    public String toString() {
        return "MutantMapState{" +
                "id=" + id +
                ", isMutant=" + isMutant +
                ", name='" + name + '\'' +
                ", transition=" + transition +
                '}';
    }
}
