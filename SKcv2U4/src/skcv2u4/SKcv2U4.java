/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv2u4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dell
 */
public class SKcv2U4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader("/Users/Dell/Documents/NetBeansProjects/SKcv2U4/data1.csv"));
        while ((line = br.readLine()) != null) {

            String s[] = line.split(";");
            if (s.length < 3) {
                System.out.println("kratky riadok");
                return;
            }
            String nazov = s[0].trim();
            String autor = s[1].trim();
            String pocet = s[2].trim();
            
            if(pocet==null)
                pocet="0";
           
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKcv2U4PU");
            EntityManager em = emf.createEntityManager();
            if(nazov!=null ){
                Kniha k=new Kniha(nazov,autor);
                //Kniha k=new Kniha(nazov,autor,Integer.parseInt(pocet));
                if(k.equals(k)==false){
                    em.getTransaction().begin();
                    em.persist(k);
                    em.getTransaction().commit();
                }
            }
        }
    
}

   
    
}
