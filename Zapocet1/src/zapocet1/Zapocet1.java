/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zapocet1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dell
 */
public class Zapocet1 {

    public static int books(String title){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zapocet1PU");
        EntityManager em = emf.createEntityManager();
        int pocet=0;
        TypedQuery<Book> q= em.createNamedQuery("Book.FindByTitle", Book.class);
        List<Book> najdene=q.setParameter("title", title).getResultList();
        if (najdene!=null){
            for(Book b:najdene){
                pocet++;
            }
            return pocet;
        }
            
        return pocet;
    }
    
    public static boolean hastag(String tag, String author){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zapocet1PU");
        EntityManager em = emf.createEntityManager();
        
        boolean vysledok=false;
        TypedQuery<Book> q=em.createNamedQuery("Book.FindByName", Book.class);
        List<Book> najdene=q.setParameter("name",author).getResultList();
        
       // TypedQuery<Book> q2=em.createNamedQuery("Book.FindByTagAndAuthours", Book.class);
      //  List<Book> najdena=q2.setParameter("tag", tag).setParameter("name",author).getResultList();
        for(Book b:najdene){
            //int id=najdene.hashCode();
            System.out.println(najdene);
            /*for(Book b:najdena){
                vysledok=true;
            }*/
        }
        return vysledok;
    }
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zapocet1PU");
        EntityManager em = emf.createEntityManager();
        
        Person osoba=new Person();
        osoba.setName("ujko");
        
        Book kniha=new Book();
        kniha.setTitle("Cosi");
        String tag1="dom";
        ArrayList tagy= new ArrayList();
        tagy.add(tag1);
        kniha.setTags(tagy);
        ArrayList autori=new ArrayList();
        ArrayList knihy=new ArrayList();
        autori.add(osoba);
        knihy.add(kniha);
        kniha.setAuthors(autori);
        osoba.setPublications(knihy);
        
        em.getTransaction().begin();
        try {
            em.persist(kniha);
            em.persist(osoba);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        System.out.println("Pocet knih:"+books("Cosi"));
        //System.out.println(hastag("nieco","ujko"));
    }

    
    
}
