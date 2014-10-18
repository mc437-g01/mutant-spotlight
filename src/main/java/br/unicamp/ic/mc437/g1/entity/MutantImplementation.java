package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@XmlRootElement
public class MutantImplementation {

    private Integer id;

    @XmlAttribute(name = "isMutant")
    private Boolean isMutant;

    @XmlElement(name = "content")
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MutantImplementation{" +
                "id=" + id +
                ", isMutant=" + isMutant +
                ", content='" + content + '\'' +
                '}';
    }
}
