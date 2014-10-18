package br.unicamp.ic.mc437.g1.entity;

/**
 * Created by fernandogoncalves on 10/17/14.
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class MutantMap {

    private Integer id;

    @XmlAttribute(name = "isMutant")
    private Boolean isMutant;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "state")
    private List<MutantMapState> state;

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

    public List<MutantMapState> getState() {
        return state;
    }

    public void setState(List<MutantMapState> state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MutantMap{" +
                "id=" + id +
                ", isMutant=" + isMutant +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
