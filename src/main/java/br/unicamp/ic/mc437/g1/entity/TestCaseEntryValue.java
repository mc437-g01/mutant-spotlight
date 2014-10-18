package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@XmlRootElement
public class TestCaseEntryValue {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "data")
    private List<TestCaseEntryValueData> datas;

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
                "name='" + name + '\'' +
                ", datas=" + datas +
                '}';
    }
}
