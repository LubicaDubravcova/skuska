/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv11u1;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@XmlRootElement(name = "adresar",namespace = "http://xml.netbeans.org/schema/AdresarSchema")
public class Adresar {
    private List<Osoba> adresar;

    @XmlElement(name="osoba",namespace = "http://xml.netbeans.org/schema/AdresarSchema")
    public List<Osoba> getAdresar() {
        return adresar;
    }

    public void setAdresar(List<Osoba> adresar) {
        this.adresar = adresar;
    }

    public Adresar(List<Osoba> adresar) {
        this.adresar = adresar;
    }

    public Adresar() {
    }
    
    
}
