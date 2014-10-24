package br.unicamp.ic.mc437.g1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@Entity
@XmlRootElement
public class TestCaseEntryValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    @XmlElement(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "data")
    private List<TestCaseEntryValueData> datas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestCaseEntryValueData> getDatas() {
        return datas;
    }

    public void setDatas(List<TestCaseEntryValueData> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "TestCaseEntryValue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datas=" + datas +
                '}';
    }
}
