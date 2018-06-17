/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("slovnik")
@Singleton
public class GenericResource {

    @Context
    private UriInfo context;
    private HashMap<String,String> slova1,slova2,slova3;
    private HashMap<String,HashMap<String,String>> slovnik;
    private List<String> jazyky;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        jazyky=new ArrayList<>();
        jazyky.add("SK");
        jazyky.add("CZ");
        jazyky.add("DE");
        
        slova1=new HashMap<>();
        slova1.put("SK","pes");
        slova1.put("CZ","pes");
        slova1.put("DE","der Hund");
        
        slova2=new HashMap<>();
        slova2.put("SK","kvet");
        slova2.put("CZ","kvet");
        slova2.put("DE","die Blume");
        
        slova3=new HashMap<>();
        slova3.put("SK","dom");
        slova3.put("CZ","dum");
        slova3.put("DE","der Hause");
        
        slovnik=new HashMap<>();
        slovnik.put("dog", slova1);
        slovnik.put("flower", slova2);
        slovnik.put("house", slova3);
    }

    /**
     vrati podporovane jazyky
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJazyky() {
        String all="";
        for(String s:jazyky)
            all=all+s+"\n";
        return all;
    }
    
    /**
     vrati preklad slova do zadaneho jazyka
     */
    @GET
    @Path("{lang}/{word}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPreklad(@PathParam("word") String key,@PathParam("lang") String lang) {
        HashMap<String,String> slova=slovnik.get(key);
        return slova.get(lang); 
        
    }
    
    /**
     modifikuje preklad slova do zadaneho jazyka/vytvori
     */
    @PUT
    @Path("{lang}/{word}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putPreklad(@PathParam("word") String key,@PathParam("lang") String lang, String content) {
        HashMap<String,String> slova=slovnik.get(key);
        slova.put(lang,content); 
    }
    
    /**
     * odstrani cely prekladovy slovnik pre dany jazyk
     */
    @DELETE
    @Path("{lang}")
    public void deletePreklad(@PathParam("lang") String lang){
        for(Entry<String,HashMap<String,String>> e:slovnik.entrySet()){
            HashMap<String,String> slova=e.getValue();
            slova.remove(lang);
        }
    }
    
    /**
     * odstrani cely preklad slova pre dany jazyk
     */
    @DELETE
    @Path("{lang}/{word}")
    public void deleteSlovo(@PathParam("lang") String lang,@PathParam("word") String key){
        HashMap<String,String> slova=slovnik.get(key);
        slova.remove(lang);
        
    }
    /**
     vrati slovensky preklad ULOHA2
     */
    /*@GET
    @Path("/{slovo:[a-z]+}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSKPreklad(@PathParam("slovo") String key) {
        return slovnik.get(key);
    }*/

    /**
     modifikuje preklad/vytvori novy zaznam ULOHA2
     */
   /* @PUT
    @Path("{slovo:[a-z]+}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putSlovo(@PathParam("slovo") String key, String preklad) {
        slovnik.put(preklad, key);
    }*/
    
    /**
     * vymaze slovo ULOHA2
     */
    /*@DELETE
    @Path("{slovo:[a-z]+}")
    public void deleteSlovo(@PathParam("slovo") String key){
        slovnik.remove(key);
    }*/
}
