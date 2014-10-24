package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class Mutant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlElement(name = "buildFlag")
    private Boolean buildFlag;

    @XmlElement(name = "contextId")
    private String contextId;

    @XmlElement(name = "convFlag")
    private Boolean convFlag;

    @XmlElement(name = "ignoreErrors")
    private Boolean ignoreErrors;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "implementation")
    private List<MutantImplementation> implementatios;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "map")
    private MutantMap map;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "path")
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getBuildFlag() {
        return buildFlag;
    }

    public void setBuildFlag(Boolean buildFlag) {
        this.buildFlag = buildFlag;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public Boolean getConvFlag() {
        return convFlag;
    }

    public void setConvFlag(Boolean convFlag) {
        this.convFlag = convFlag;
    }

    public Boolean getIgnoreErrors() {
        return ignoreErrors;
    }

    public void setIgnoreErrors(Boolean ignoreErrors) {
        this.ignoreErrors = ignoreErrors;
    }

    public List<MutantImplementation> getImplementatios() {
        return implementatios;
    }

    public void setImplementatios(List<MutantImplementation> implementatios) {
        this.implementatios = implementatios;
    }

    public MutantMap getMap() {
        return map;
    }

    public void setMap(MutantMap map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Mutant{" +
                "id=" + id +
                ", buildFlag=" + buildFlag +
                ", contextId='" + contextId + '\'' +
                ", convFlag=" + convFlag +
                ", ignoreErrors=" + ignoreErrors +
                ", implementatios=" + implementatios +
                ", map=" + map +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
