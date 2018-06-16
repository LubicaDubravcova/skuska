/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv2u2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dell
 */
public class SKcv2U2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv2U2PU");
        EntityManager em = emf.createEntityManager();
        
        Osoba najdena= em.find(Osoba.class, 55L);
        
        
        if(najdena!=null)
            System.out.println("Osoba existuje: "+najdena);
        else
            System.out.println("Osoba neexistuje");    
          
    }

    
    
}
