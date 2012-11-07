package no.synth.resteasyinterceptordemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MyObject {
    public String name;
    public String role;

    MyObject() {
        // needed by jaxb
    }

    MyObject(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
