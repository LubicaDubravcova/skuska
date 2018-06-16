/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocv4c;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static ocv4c.Obchod_.polozky;

/**
 *
 * @author Dell
 */
public class Ocv4c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor a=new Autor("Janko Daleky");
        List<Autor> autori=new ArrayList();
        autori.add(a);
        Polozka p=new Polozka(3.4);
        List<Polozka> polozky=new ArrayList();
        polozky.add(p);
        
        Kniha k=new Kniha("12358","Roky",autori,polozky);
        List <Kniha> knihy=new ArrayList();
        knihy.add(k);
        Obchod o=new Obchod("Martinus",polozky);
        Vydavatel v=new Vydavatel("IKAR",knihy);
       
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ocv4cPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(a);
            em.persist(p);
            em.persist(k);
            em.persist(o);
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
