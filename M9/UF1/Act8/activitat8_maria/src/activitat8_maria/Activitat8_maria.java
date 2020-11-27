package activitat8_maria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import java.util.Scanner;

/*
*File: Activitat8_maria.java
*Author: Maria Navarro
*Date: 26-11-2020
*Description: Activitat 8 Practica UF1 M9
*/

public class Activitat8_maria {

    public static void main(String[] args) throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {     
        Scanner scan = new Scanner(System.in);
        //variables globals
        KeyStore keystore = KeyStore.getInstance("JCEKS");
        FileInputStream fis = new FileInputStream("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M9\\UF1\\Act8\\clausmaria");
        String clau;
        String aliasCl;
        FileOutputStream fos;
        String clauEx;        
        int cont = 0;
        X509EncodedKeySpec X509EncodedKeySpec;
        Key clauExportada;
        
        //1) Visualitzar les claus que teniu emmagatzemades en el magatzem de claus anterior
        //carrego la keystore
        clau = "maria01";
        char[] arrayC = clau.toCharArray();
        keystore.load(fis, arrayC);
        
        //Creem una enumeració de string que conté els noms dels alias
        Enumeration<String> nomsAl = keystore.aliases();
        
        while(nomsAl.hasMoreElements()) {
            aliasCl = nomsAl.nextElement();
            System.out.println("Nom: " + aliasCl + "\t Algoritme: " + keystore.getKey(aliasCl, arrayC).getAlgorithm());
            
            byte[] arrayEnc = keystore.getKey(aliasCl, arrayC).getEncoded();
            System.out.println("Mida de la clau: " + arrayEnc.length + " bytes");
            
            //Comprobo si te certificat i el mostro
            if(keystore.getCertificateChain(aliasCl) == null) {
                System.out.println("No te certificat"); 
            } else {
                System.out.println("Certificat: " + ((X509Certificate)keystore.getCertificate(aliasCl)).getNotAfter());
            }
            System.out.println("Ultima modificació: " + keystore.getCreationDate(aliasCl));
        }
        
       //2) Poder exportar una clau en concret a un fitxer.
        System.out.println("Quina clau vols exportar? ");
        Enumeration<String> nomsAliasEx = keystore.aliases();
        clauEx = scan.nextLine();
        while(nomsAliasEx.hasMoreElements() && cont == 0) {
            aliasCl = nomsAliasEx.nextElement();
            if(aliasCl.equals(clauEx.trim())) {
                clauExportada = keystore.getKey(clauEx, arrayC);
                X509EncodedKeySpec = new X509EncodedKeySpec(clauExportada.getEncoded());
                fos = new FileOutputStream("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M9\\UF1\\Act8\\" + aliasCl + "Certificat.cer");
                
                System.out.println("Creat");
            }
            
        }
        
    }
}
