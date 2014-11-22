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
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class StateTransition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlAttribute(name = "isMutant")
    private Boolean isMutant;

    @Field
    @XmlElement(name = "event")
    private String event;

    @IndexedEmbedded
    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "guard")
    private StateTransitionGuard guard;

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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public StateTransitionGuard getGuard() {
        return guard;
    }

    public void setGuard(StateTransitionGuard guard) {
        this.guard = guard;
    }

    @Override
    public String toString() {
        return "StateTransition{" +
                "id=" + id +
                ", isMutant=" + isMutant +
                ", event='" + event + '\'' +
                ", guard=" + guard +
                '}';
    }
}
