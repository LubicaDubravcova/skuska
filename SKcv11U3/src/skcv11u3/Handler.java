/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv11u3;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Dell
 */
public class Handler extends DefaultHandler{
    private boolean polozka,muka;
    private String nazovReceptu,nazovPolozky,jednotka,mnozstvo,text;
    
    @Override
    public void startElement(String uri,String localName, String qName,Attributes atrbts){
        if(localName.equals("recept")){
            nazovReceptu=null;
            nazovPolozky=null;
            jednotka=null;
            text=null;           
        }
        
        if(localName.equals("polozka")){
            polozka=true;
        }
        
        if(localName.equals("mnozstvo")){
            jednotka=atrbts.getValue("jednotka");
        }
    }
    
    @Override
    public void endElement(String uri,String localName, String qName){
        if(localName.equals("polozka")){
            polozka=false;
        }
        
        if(localName.equals("nazov")&&polozka){
            nazovPolozky=text;
            if(nazovPolozky.equals("muka"))
                muka=true;
        }
        
        if(localName.equals("nazov")&&!polozka){
            nazovReceptu=text;
        }
        
        if(localName.equals("recept")){
            if(muka)
                System.out.println(nazovReceptu);
            muka=false;
        }
            
    }
    
    @Override
    public void characters(char[] c,int start,int length){
        text=new String(c,start,length);
    }
    
}
