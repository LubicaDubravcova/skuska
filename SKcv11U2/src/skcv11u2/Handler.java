/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv11u2;

import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Dell
 */
public class Handler extends DefaultHandler{
    private String pohlavie, meno, bydlisko, text;
    private boolean osoba;
    Set<String> mena=new HashSet<>();
    Set<String> mesta=new HashSet<>();
    Set<String> duplikaty=new HashSet<>();
    
   @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts)throws SAXException{
        if(localName.equals("osoba")){
            osoba=true;
            pohlavie=atrbts.getValue("gen");
            meno=null;
            bydlisko=null;
            text=null;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName){
       
            
        if(localName.equals("meno")){
            meno=text;
            System.out.println(meno);
            if(!mena.equals(meno))
                mena.add(meno);
            else 
                duplikaty.add(meno);
        }
        
        
        if (localName.equals("osoba")){
            if(("zena").equals(pohlavie))
                System.out.println(meno);
            
        }
        
        if(localName.equals("bydlisko")){
            bydlisko=text;
            System.out.println(bydlisko);
            
        }
        if(localName.equals("adresar")){
            for(String mesto:mesta)
                System.out.println(mesto);
        }
        
        
        if(localName.equals("adresar")){
            if(duplikaty.isEmpty())
                System.out.println("i=Nie su duplikty");
            else{
                System.out.println("Duplikaty si v tychto menach/mene:");
                for(String mena:duplikaty)
                    System.out.println(mena);
            }
        }
        
    }
    
    @Override
    public void characters(char[] ch, int start, int length){
        text = new String(ch, start, length);
    }
}
