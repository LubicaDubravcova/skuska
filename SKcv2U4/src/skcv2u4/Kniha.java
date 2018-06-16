/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv2u4;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "KNIHA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kniha.findAll", query = "SELECT k FROM Kniha k"),
    @NamedQuery(name = "Kniha.findByNazov", query = "SELECT k FROM Kniha k WHERE k.nazov = :nazov"),
    @NamedQuery(name = "Kniha.findByAutor", query = "SELECT k FROM Kniha k WHERE k.autor = :autor"),
    @NamedQuery(name = "Kniha.findByPocet", query = "SELECT k FROM Kniha k WHERE k.pocet = :pocet")})
public class Kniha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAZOV")
    private String nazov;
    @Column(name = "AUTOR")
    private String autor;
    @Column(name = "POCET")
    private Integer pocet;

    public Kniha() {
    }

    public Kniha(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPocet() {
        return pocet;
    }

    public void setPocet(Integer pocet) {
        this.pocet = pocet;
    }

    public Kniha(String nazov, String autor, Integer pocet) {
        this.nazov = nazov;
        this.autor = autor;
        this.pocet = pocet;
    }

    public Kniha(String nazov, String autor) {
        this.nazov = nazov;
        this.autor = autor;
    }
 
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazov != null ? nazov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kniha)) {
            return false;
        }
        Kniha other = (Kniha) object;
        if ((this.nazov == null && other.nazov != null) || (this.nazov != null && !this.nazov.equals(other.nazov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "skcv2u4.Kniha[ nazov=" + nazov + " ]";
    }
    
}
