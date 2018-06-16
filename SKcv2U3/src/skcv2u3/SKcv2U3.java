/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv2u3;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dell
 */
public class SKcv2U3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv2U3PU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery <Person> q= em.createNamedQuery("Person.findAll", Person.class);
        List<Person> result= q.getResultList();
        
        for(Person p:result){
            System.out.println(p);
        }
            
       
            
    }

    
}
