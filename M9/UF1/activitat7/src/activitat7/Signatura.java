/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat7;

import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;
import java.util.Scanner;

/*
*File: Signatura.java
*Author: Maria Navarro
*Date: 13-11-2020
*Description: Activitat 7 Practica UF1 M9
 */

public class Signatura {
 
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int longitudC = 512;
        String frase;
        
        //GENEREM LES CLAUS
        KeyPair clau = randomGenerate(longitudC);
        PrivateKey clauPrivada = clau.getPrivate();
        PublicKey clauPublica = clau.getPublic();
      
        publicKeyFile(clauPublica);
        privateKeyFile(clauPrivada);
        
        System.out.println("Generant claus publiques i privades (arxius clauPublica i clauPrivada)...OK");
        System.out.println("Introdueix el missatge a signar:");
        frase = scan.nextLine();
        byte[] textBytes = frase.getBytes();
        
        
        
        System.out.println("Signant el missatge...OK");
	System.out.println("Generant arxiu firma_missatge...OK");
	System.out.println("Generant arxiu missatge...OK");
    }
    
    public static KeyPair randomGenerate(int longitudC) {
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
    
    public byte[] signData(byte[] data, PrivateKey priv) {
        byte[] signature = null;
        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(priv);
            signer.update(data);
            signature = signer.sign();
        }
        catch (Exception ex) {
           System.err.println("Error signant les dades: " + ex);
        }
        return signature;
    }

    public static void publicKeyFile(PublicKey clauPublica) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        try (FileWriter out = new FileWriter("clauPublica")) {
            out.write("—-COMENÇA LA CLAU PRIVADA RSA—- \n");
            out.write(encoder.encodeToString(clauPublica.getEncoded()));
            out.write("—-FINAL LA CLAU PRIVADA RSA—-");
        } catch (IOException ex) {
            System.out.println("ERROR guardant clau privada");
        }
    }

    public static void privateKeyFile(PrivateKey clauPrivada) throws IOException {  
        Base64.Encoder encoder = Base64.getEncoder();
        try (FileWriter out = new FileWriter("clauPrivada")) {
            out.write("—-COMENÇA LA CLAU PRIVADA RSA—- \n");
            out.write(encoder.encodeToString(clauPrivada.getEncoded()));
            out.write("—-FINAL LA CLAU PRIVADA RSA—-");
        } catch (IOException ex) {
            System.out.println("ERROR guardant clau privada");
        }

    }
}