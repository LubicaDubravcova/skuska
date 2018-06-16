/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv4u1;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dell
 */
public class SKcv4U1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv4U1PU");
        EntityManager em = emf.createEntityManager();
        
        Osoba o=new Osoba("Ondrej");
        Osoba o2=new Osoba("Milan");
        ArrayList autori=new ArrayList();
        autori.add(o);
        autori.add(o2);
        Kniha k=new Kniha("Cervena ciapocka",autori);
        em.getTransaction().begin();
        try {
            em.persist(o);
            em.persist(k);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
}
