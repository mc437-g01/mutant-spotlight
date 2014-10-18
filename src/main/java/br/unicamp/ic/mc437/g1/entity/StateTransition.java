package br.unicamp.ic.mc437.g1.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernandogoncalves on 10/17/14.
 */
@XmlRootElement
public class StateTransition {

    private Integer id;

    @XmlAttribute(name = "isMutant")
    private Boolean isMutant;

    @XmlElement(name = "event")
    private String event;

    @XmlElement(name = "guard")
    private StateTransitionGuard guard;
}
