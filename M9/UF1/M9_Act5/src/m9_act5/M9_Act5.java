package m9_act5;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;

/*
*File: M9_Act5.java
*Author: Maria Navarro
*Date: 8-11-2020
*Description: Activitat 5 Practica UF1 M9
*/

public class M9_Act5 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner (System.in);
	String text;
	String textDes;
        String textEncr;
        
	//DEMANEM LA FRASE
	System.out.println("TEXT:");
	text = scan.nextLine();
        byte[] arrayText = text.getBytes();
        
	//GENEREM LES CLAUS
        KeyPair clau = randomGenerate(512);
        PrivateKey clauPrivada = clau.getPrivate();
        PublicKey clauPublica = clau.getPublic();
	
	byte[] arrayTextE = encryptData(arrayText, clauPublica);
        textEncr = new String(arrayTextE);
        byte[] arrayTextD = decryptData(arrayTextE, clauPrivada);
        textDes = new String(arrayTextD);
        
        System.out.println("\nPublica: " + clauPublica + "\n Privada: " + clauPrivada + "\n Frase encriptada: " + textEncr + "\n Frase desencriptada: " + textDes + "\n");
    }

    public static KeyPair randomGenerate(int longitudC) {
	KeyPair clau = null;
	try {
            KeyPairGenerator clauGen = KeyPairGenerator.getInstance("RSA");
            clauGen.initialize(longitudC);
            clau = clauGen.genKeyPair();
        } catch (Exception ex) {
            System.err.println("Generador no disponible.");
        }
        return clau;
    }
	
    public static byte[] encryptData(byte[] data, PublicKey clauPublica) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, clauPublica);
            encryptedData = cipher.doFinal(data);
        } catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }
    
    public static byte[] decryptData(byte[] data, PrivateKey clauPrivada) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, clauPrivada);
            encryptedData = cipher.doFinal(data);
        } catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }
}