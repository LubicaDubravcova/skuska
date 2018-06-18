/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;




/**
 *
 * @author Dell
 */

public class Osoba {
    private String meno;
    private String vek;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getVek() {
        return vek;
    }

    public void setVek(String vek) {
        this.vek = vek;
    }

    public Osoba(String meno, String vek) {
        this.meno = meno;
        this.vek = vek;
    }

    public Osoba() {
    }
    
    
}
