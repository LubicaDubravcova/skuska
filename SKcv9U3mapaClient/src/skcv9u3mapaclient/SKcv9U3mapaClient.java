/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcv9u3mapaclient;

/**
 *
 * @author Dell
 */
public class SKcv9U3mapaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient c= new NewJerseyClient();
        System.out.println(c.getAll());
        
        c.putMenu("Polievka", "0");
        System.out.println(c.getAll());
        c.postMenu("Zivanska");
        System.out.println(c.getAll());
        c.deleteMenu("0");
        System.out.println(c.getAll());
    }
    
}
