/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv11u1;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Dell
 */
public class SKcv11U1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        JAXBContext context= JAXBContext.newInstance(Adresar.class);
        Unmarshaller um=context.createUnmarshaller();
        Adresar adresar=(Adresar) um.unmarshal(new File("adresar.xml"));
        
        for(Osoba o:adresar.getAdresar())
            System.out.println(o.getMeno());
        
        System.out.println("-------------------------");
        
        for(Osoba o:adresar.getAdresar()){
            if(o.getGen().compareTo("zena")==0)
                System.out.println(o.getMeno());
        }
        
        System.out.println("-------------------------");
        Set<String> mesta=new HashSet<>();
        for(Osoba o:adresar.getAdresar()){
            if(o.getBydlisko()!=null)
                mesta.add(o.getBydlisko()); 
        }
        for(String city:mesta)
            System.out.println(city);
        
        System.out.println("-------------------------");
        Set<String> duplikaty=new HashSet<>();
        Set<String> mena=new HashSet<>();
        
        for(Osoba o:adresar.getAdresar()){
            if(!mena.contains(o.getMeno()))
                    mena.add(o.getMeno());
            else
                duplikaty.add(o.getMeno());
        }
        
        if(duplikaty.isEmpty())
            System.out.println("Duplikaty nie su.");
        else{
            System.out.println("Duplikaty: ");
            for(String m:duplikaty)
            System.out.println(m);
        }
    }
    
}
