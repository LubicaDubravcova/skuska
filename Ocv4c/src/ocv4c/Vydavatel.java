/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocv4c;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Dell
 */
@Entity
public class Vydavatel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazov;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="vydavatel_id")
    private List<Kniha> publikacia;

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public List<Kniha> getPublikacia() {
        return publikacia;
    }

    public void setPublikacia(List<Kniha> publikacia) {
        this.publikacia = publikacia;
    }

    public Vydavatel(String nazov, List<Kniha> publikacia) {
        this.nazov = nazov;
        this.publikacia = publikacia;
    }

    public Vydavatel() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vydavatel)) {
            return false;
        }
        Vydavatel other = (Vydavatel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ocv4c.Vydavatel[ id=" + id + " ]";
    }
    
}
