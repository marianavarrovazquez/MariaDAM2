package activitat7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
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
      
        publicKeyFile(clau);
        privateKeyFile(clau);
        
        System.out.println("Generant claus publiques i privades (arxius clauPublica i clauPrivada)...OK");
        System.out.println("Introdueix el missatge a signar:");
        frase = scan.nextLine();
        
        //TRANSFORMEM LA FRASE A BYTES
        byte[] textBytes = frase.getBytes();
        
        //CREEM LA VARIABLE SIGNATURA ON L
        byte[] signatura = signData(textBytes, clauPrivada);
        
        //CRIDEM AL METODE PER CREAR ELS ARXIUS FIRMA I MISSATGE
        ArxiuBytes(textBytes, "missatge");
        ArxiuBytes(signatura, "firma");
        
        System.out.println("Signant el missatge...OK");
	System.out.println("Generant arxiu firma_missatge...OK");
	System.out.println("Generant arxiu missatge...OK");
    }
    
    //LLANCEM UN RANDOM
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
    
    //SIGNEM LES DADES
    public static byte[] signData(byte[] textBytes, PrivateKey clauPrivada) {
        byte[] signature = null;
        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(clauPrivada);
            signer.update(textBytes);
            signature = signer.sign();
        }
        catch (Exception ex) {
           System.err.println("Error signant les dades: " + ex);
        }
        return signature;
    }

    //CREEM LA CLAU PUBLICA
    public static void publicKeyFile(KeyPair clau) throws IOException {
        try { 
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(clau.getPublic().getEncoded());
            FileOutputStream fos = new FileOutputStream("clauPublica");
            fos.write(x509EncodedKeySpec.getEncoded());
            fos.close();
        }
        catch (Exception e) { 
            System.out.println("ERROR guardant clau publica"); 
        }

    }

    //CREEM LA CLAU PRIVADA
    public static void privateKeyFile(KeyPair clau) throws IOException {  
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(clau.getPrivate().getEncoded());
            FileOutputStream fos = new FileOutputStream("clauPrivada");
            fos.write(pkcs8EncodedKeySpec.getEncoded());
            fos.close();
            }
        catch (Exception e) { 
            System.out.println("ERROR guardant clau privada"); 
        }
    }

    //CREEM EL METODE PER CREAR ELS ARXIUS MISSATGE I FIRMA
    public static void ArxiuBytes(byte[] data, String NomArxiu) {
        try (FileOutputStream fos = new FileOutputStream(NomArxiu)) {
            fos.write(data);
            fos.close();        
        } catch (IOException ex) {
           System.out.println("No se ha guardado el mensaje"); 
        }
    }
}