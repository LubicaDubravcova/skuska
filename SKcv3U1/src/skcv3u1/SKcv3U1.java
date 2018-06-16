/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv3u1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dell
 */
public class SKcv3U1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv3U1PU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Osoba> all=em.createNamedQuery("Osoba.findAll", Osoba.class);
        TypedQuery<Osoba> meno=em.createNamedQuery("Osoba.findByMeno", Osoba.class);
        meno.setParameter("meno", "Frantisek");
        TypedQuery<Osoba> vaha=em.createNamedQuery("Osoba.nahradVahu", Osoba.class);
       
        for(Osoba o:all.getResultList()){
            System.out.println(o);
        }
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv3U1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
