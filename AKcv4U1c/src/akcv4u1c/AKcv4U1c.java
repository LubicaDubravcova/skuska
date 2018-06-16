/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akcv4u1c;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dell
 */
public class AKcv4U1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AKcv4U1cPU");
        EntityManager em = emf.createEntityManager();
        
        Kniha k=new Kniha("Cervena ciapocka");
        Kniha k2=new Kniha("Oskar");
        List<Kniha> knihy=new ArrayList();
        knihy.add(k);
        knihy.add(k2);
        Vydavatelstvo v=new Vydavatelstvo("Karadicova",knihy);
        
        em.getTransaction().begin();
        try {
            em.persist(k);
            em.persist(k2);
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
