/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_act6_maria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/*
*File: Generacio.java
*Author: Maria Navarro
*Date: 8-11-2020
*Description: Activitat 6 Practica UF1 M9
*/

public class Generacio {
    public static void main(String[] args) throws FileNotFoundException {
        int longitudC = 512;
        
        //GENEREM LES CLAUS
        KeyPair clau = randomGenerate(longitudC);
        PrivateKey clauPrivada = clau.getPrivate();
        PublicKey clauPublica = clau.getPublic();
       
        //Guardem la clau publica en dos arxius
        File publicKey = new File ("clauPublica.txt");
        PrintStream writerPublic = new PrintStream (publicKey);        
        writerPublic.println(clauPublica);
        writerPublic.close();
        
        //Guardem la clau privada en dos arxius
        File privateKey = new File ("clauPrivada.txt");    
        PrintStream writerPrivate = new PrintStream (privateKey);  
        writerPrivate.println(clauPrivada);
        writerPrivate.close(); 
    }    

    private static KeyPair randomGenerate(int longitudC) {
        KeyPair clau = null;
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(longitudC);
            clau = keyGen.genKeyPair();
        } catch (Exception ex) {
            System.err.println("Generador no disponible.");
	}
        return clau;
    }
}
