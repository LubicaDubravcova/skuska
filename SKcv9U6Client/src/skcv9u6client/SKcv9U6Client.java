/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv9u6client;

import org.glassfish.jersey.client.JerseyClient;

/**
 *
 * @author Dell
 */
public class SKcv9U6Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient c=new NewJerseyClient();
        System.out.println(c.getJazyky());
        System.out.println(c.getPreklad("DE", "house"));
        c.putPreklad("pejsek", "CZ", "dog");
        System.out.println(c.getPreklad("CZ", "dog"));
        c.deletePreklad("CZ");
        System.out.println(c.getPreklad("CZ", "dog"));
        c.deleteSlovo("SK", "dog");
        System.out.println(c.getPreklad("SK", "dog"));
    }
    
}
