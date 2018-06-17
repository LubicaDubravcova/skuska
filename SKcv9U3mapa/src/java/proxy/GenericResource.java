/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;


import java.util.Map.Entry;
import java.util.TreeMap;
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
    private TreeMap<Integer,String> menu;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        menu=new TreeMap<>();
        menu.put(0,"Halusky");
        menu.put(1,"Rezen");
        menu.put(2,"Gulas");
    }

    /**
     * vrati textovu reprezentaciu celeho menu
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        String all = "";
        for (Entry<Integer,String> e: menu.entrySet())
            all = all + e.getValue() + "\n";
        return all;
    }

    @GET
    @Path("/{index: [0-9]+}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMenu(@PathParam("index") int x ) {
       return menu.get(x);
    }
    
    /**
     * modifikuje existujucu polozku v menu
     */
    @PUT
    @Path("{index: [0-9]+}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putMenu(@PathParam("index") int x, String content) {
        menu.put(x, content);
    }
    
    /**
     * prida novu polozku do menu
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void postMenu(String content) {
        int index=menu.lastKey();
        menu.put(index+1,content);
    }
    
    @DELETE
    @Path("{index: [0-9]+}")
    public void deleteMenu(@PathParam("index") int index){
        menu.remove(index);
    }
}
