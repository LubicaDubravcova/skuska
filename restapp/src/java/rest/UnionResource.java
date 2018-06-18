/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import pojo.Osoba;
import pojo.Zmluva;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("union")
@Singleton
public class UnionResource {

    @Context
    private UriInfo context;
    private Zmluva z1,z2;
    private HashMap<String,Zmluva> zmluvy;
    private List<Osoba> osoby;
    private Osoba o1,o2;
    

    /**
     * Creates a new instance of UnionResource
     */
    public UnionResource() {
        o1=new Osoba("Jozef Mrvicka","37");
        o2=new Osoba("Anna Mrvicka","32");
        osoby=new ArrayList();
        osoby.add(o1);
        osoby.add(o2);
        zmluvy=new HashMap<>();
        z1=new Zmluva("u1111","cestovne",osoby);
        z2=new Zmluva("u1112","zivotne",osoby);
        zmluvy.put("u1111",z1);  
        zmluvy.put("u1112",z2);
    }

    /**
     pocet zmluv
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPocet() {
        Integer pocet=zmluvy.size();
        return pocet.toString();
    }

    /**
     vlozenie novej poistnej zmluvy
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void postZmluvu(Zmluva content) {
        boolean rozhodnutie=false;
        for(Entry e:zmluvy.entrySet()){
            if(content.getCislo_zmluvy()==e.getKey())
                rozhodnutie=true;
        }
        if(rozhodnutie==false)
        zmluvy.put(content.getCislo_zmluvy(), content);
        
    }
        
    
    /**
     vyhlada zmluvu podla cisla zmluvy
     */
    @GET
    @Path("{cislo}")
    @Produces(MediaType.APPLICATION_XML)
    public Zmluva getZmluva(@PathParam ("cislo") String key) {
        if(zmluvy.containsKey(key))
            return zmluvy.get(key);
        else
            return null;
    }
    
    /**
     vlozenie novej osoby do poistnej zmluvy
     */
    @POST
    @Path("{cislo}")
    @Consumes(MediaType.APPLICATION_XML)
    
    public void postOsoba(@PathParam ("cislo") String key,Osoba content) {
       
        List<Osoba>o=new ArrayList<>();
         
        if(zmluvy.containsKey(key)){
            
            Zmluva z=zmluvy.get(key);
            
            o.add(content);
            //System.out.println(z);
            z.setOsoba(o);
        
               
            
        }
    }
}
