/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restappclient;

import java.util.ArrayList;
import java.util.List;
import pojo.Osoba;
import pojo.Zmluva;

/**
 *
 * @author Dell
 */
public class RestappClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient c = new NewJerseyClient();
        System.out.println(c.getPocet());
       Zmluva z=c.getZmluva(Zmluva.class, "u1111");
        System.out.println(z);
        Osoba o=new Osoba("Anna Miezgova","23");
        
        //List<Osoba> osob=new ArrayList<>();
        //osob.add(o);
        //Zmluva z2=new Zmluva("u1234","cestovne",osob);
        //c.postZmluvu(z2);
        c.postOsoba(o, "u1111");
        //System.out.println(OS);
    }
    
}
