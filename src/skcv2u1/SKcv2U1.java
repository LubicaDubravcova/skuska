/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv2u1;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dell
 */
public class SKcv2U1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv2U1PU");
        EntityManager em = emf.createEntityManager();
        
        Osoba o1 = new Osoba("Frantisek",new Date(),65,176);
        Osoba o2 =new Osoba("Anna",null,0,165);
        Osoba o3 = new Osoba();
        
        
       
        
        
        em.getTransaction().begin();
        try {
            em.persist(o1);
            em.persist(o2);
            em.persist(o3);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
}
