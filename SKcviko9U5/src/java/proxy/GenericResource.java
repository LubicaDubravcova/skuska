/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.HashMap;
import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
@Path("generic")
@Singleton
public class GenericResource {

    @Context
    private UriInfo context;
    private HashMap<Integer,String> pon,ut,st,stv,pia;
    private HashMap<String,HashMap<Integer,String>> menu;

    
   
    public GenericResource() {
        pon=new HashMap<>();
        pon.put(1,"Kuracia polievka");
        pon.put(2,"Rezen");
        
        ut=new HashMap<>();
        st=new HashMap<>();
        stv=new HashMap<>();
        
        pia=new HashMap<>();
        pia.put(1,"Rajcinova polievka");
        pia.put(2,"Vyprazany syr");
        
        menu=new HashMap<>();
        menu.put("Pon", pon);
        menu.put("Ut", ut);
        menu.put("St", st);
        menu.put("Stv", stv);
        menu.put("Pia", pia);
    }

    /**
     funguje cez web
     */
    
    @GET
    @Path("{den}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPocet(@PathParam("den") String key) {
        HashMap<Integer,String> jedla=menu.get(key);
        Integer pocet= jedla.size();
        return pocet.toString();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @POST
    @Path("{den}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void postJedlo(@PathParam("den") String key,String content) {
        Integer index=1;
        
        HashMap<Integer,String> jedla=menu.get(key);
        while(jedla.containsKey(index)){
            index++;
        }
        jedla.put(index,content);
    }
    /*funguje cez web*/
    @GET
    @Path("{den}/{index}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJedlo(@PathParam("den") String key,@PathParam("index") int index) {
        HashMap<Integer,String> jedla=menu.get(key);
        return jedla.get(index);
    }
    
    @PUT
    @Path("{den}/{index}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putJedlo(@PathParam("den") String key,@PathParam("index") int index,String content) {
        
        HashMap<Integer,String> jedla=menu.get(key);
        if(jedla.containsKey(index)){
            jedla.put(index, content);
        }
    }
    
    @DELETE
    @Path("{den}/{index}")
    public void deleteJedlo(@PathParam("den") String key,@PathParam("index") int index){
        HashMap<Integer,String> jedla=menu.get(key);
        if(jedla.containsKey(index)){
            jedla.remove(index);
        }
    }
    
}
