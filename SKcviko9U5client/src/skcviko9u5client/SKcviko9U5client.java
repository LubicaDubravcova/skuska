/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skcviko9u5client;

/**
 *
 * @author Dell
 */
public class SKcviko9U5client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient c = new NewJerseyClient();
        System.out.println(c.getPocet("Pon"));
        System.out.println(c.getJedlo("Pon", "3"));
        //c.deleteJedlo("Pon", "1");
        //c.postJedlo("Kuracia polievka", "Pon");
       // c.putJedlo("Granadir", "Pon", "3");
    }
    
}
