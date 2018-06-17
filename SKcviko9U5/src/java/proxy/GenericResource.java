/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
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
    private List<String> pon,ut,st,stv,pia;
    private HashMap<String,List<String>> menu;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        pon=new ArrayList<>();
        pon.add("Kuracia polievka");
        pon.add("Rezen");
        
        ut=new ArrayList<>();
        st=new ArrayList<>();
        stv=new ArrayList<>();
        
        pia=new ArrayList<>();
        pia.add("Rajcinova polievka");
        pia.add("Vyprazany syr");
        
        menu=new HashMap<>();
        menu.put("Pon", pon);
        menu.put("Ut", ut);
        menu.put("St", st);
        menu.put("Stv", stv);
        menu.put("Pia", pia);
    }

    /**
     * Retrieves representation of an instance of proxy.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{den}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getPocet(@PathParam("den") String key) {
        List<String> jedla=menu.get(key);
        return jedla.size();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @POST
    @Path("{den}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void postJedlo(@PathParam("den") String key,String content) {
        List<String> jedla=menu.get(key);
        jedla.add(content);
    }
    
    @GET
    @Path("{den}/{index}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJedlo(@PathParam("den") String key,@PathParam("index") int index) {
        List<String> jedla=menu.get(key);
        return jedla.get(index);
    }
    
    @PUT
    @Path("{den}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putJedlo(@PathParam("den") String key,String content) {
        
        List<String> jedla=menu.get(key);
        if(jedla.contains(content)){
            int index=jedla.indexOf(content);
            jedla.add(index, content);
        }
    }
    
    
}
