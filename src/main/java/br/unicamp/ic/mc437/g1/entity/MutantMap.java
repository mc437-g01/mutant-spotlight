package br.unicamp.ic.mc437.g1.entity;

/**
 * Created by fernandogoncalves on 10/17/14.
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@XmlRootElement
public class MutantMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlAttribute(name = "isMutant")
    private Boolean isMutant;

    @XmlElement(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "state")
    private List<MutantMapState> mutantMapStates;

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

    public List<MutantMapState> getMutantMapStates() {
        return mutantMapStates;
    }

    public void setMutantMapStates(List<MutantMapState> state) {
        this.mutantMapStates = state;
    }

    @Override
    public String toString() {
        return "MutantMap{" +
                "id=" + id +
                ", isMutant=" + isMutant +
                ", name='" + name + '\'' +
                ", state=" + mutantMapStates +
                '}';
    }
}
