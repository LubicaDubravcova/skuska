/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@XmlRootElement(name="zmluva")
public class Zmluva {
    private String cislo_zmluvy;
    private String druh;
    private List<Osoba> osoba;

    @XmlElement(name="cislo_zmluvy")
    public String getCislo_zmluvy() {
        return cislo_zmluvy;
    }

    public void setCislo_zmluvy(String cislo_zmluvy) {
        this.cislo_zmluvy = cislo_zmluvy;
    }

    @XmlElement(name="druh")
    public String getDruh() {
        return druh;
    }

    public void setDruh(String druh) {
        this.druh = druh;
    }

    @XmlElement(name="osoba")
    public List<Osoba> getOsoba() {
        return osoba;
    }

    public void setOsoba(List<Osoba> osoba) {
        this.osoba = osoba;
    }

    public Zmluva(String cislo_zmluvy,String druh, List<Osoba> osoba) {
        this.cislo_zmluvy=cislo_zmluvy;
        this.druh = druh;
        this.osoba = osoba;
    }

    public Zmluva() {
    }
    
    @Override
    public String toString() {
        return "cislo_zmluvy= " + cislo_zmluvy + " druh= "+druh+" osoba= "+osoba;
    }
}
