package m9_act5;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
import javax.crypto.Cipher;

/*
*File: M9_Act5_NoDual.java
*Author: Maria Navarro
*Date: 8-11-2020
*Description: Activitat 5 Practica UF1 M9
*/

public class M9_Act5_NoDual {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
	String text;
	String textDes;
        String textEncr;
        int longitudC = 512;
        
	//DEMANEM LA FRASE
	System.out.println("TEXT: ");
	text = scan.nextLine();
        byte[] arrayText = text.getBytes();
        
	//GENEREM LES CLAUS
        long inicio = System.currentTimeMillis();
        KeyPair clau = randomGenerate(longitudC);
        PrivateKey clauPrivada = clau.getPrivate();
        PublicKey clauPublica = clau.getPublic();
        long fin = (System.currentTimeMillis() - inicio) * 100;
        //ENCRIPTACIÓ I DESENCRIPTACIÓ
	byte[] arrayTextE = encryptData(arrayText, clauPublica);
        textEncr = new String(arrayTextE);
        
        byte[] arrayTextD = decryptData(arrayTextE, clauPrivada);
        textDes = new String(arrayTextD);
        
        System.out.println("\nPublica: " + clauPublica + "\n Privada: " + clauPrivada + "\n Frase introduida per teclat: " + text + "\n Frase encriptada: " + textEncr + "\n Frase desencriptada: " + textDes + "\n");
        System.out.println("\n Temps en crear les claus: " + fin);
    }

    public static KeyPair randomGenerate(int longitudC) {
        KeyPair keys = null;
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(longitudC);
            keys = keyGen.genKeyPair();
        } catch (Exception ex) {
            System.err.println("Generador no disponible.");
	}
        return keys;
    }
	
    public static byte[] encryptData(byte[] data, PublicKey clauPubica) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, clauPubica);
            encryptedData = cipher.doFinal(data);
        }  catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }  
        return encryptedData;
    }

    public static byte[] decryptData(byte[] data, PrivateKey clauPrivada) {
        byte[] decryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, clauPrivada);
            decryptedData = cipher.doFinal(data);
        } catch (Exception ex) {
            System.err.println("Error desxifrant: " + ex);
        }
        return decryptedData;
    }
}