/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv4u1b;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dell
 */
public class SKcv4U1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv4U1bPU");
        EntityManager em = emf.createEntityManager();
        
        Vydavatelstvo v=new Vydavatelstvo("Karadicova");
        Kniha k=new Kniha("Cervena ciapocka",v);
        Kniha k2=new Kniha("Oskar",v);
        em.getTransaction().begin();
        try {
            em.persist(v);
            em.persist(k2);
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
    

