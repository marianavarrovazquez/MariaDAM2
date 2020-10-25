package act4_maria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
*File: Act4_maria.java
*Author: Maria Navarro
*Date: 25-10-2020
*Description: Activitat 5 Practica UF1
*/

public class Act4_maria {
    public static void main(String[] args) throws IOException {
        //Variables globals
        String clau;
        String paraulaE;
        String fitxer;
        int keyS = 128;
        
        Scanner scan = new Scanner (System.in);
        
        //demanem la clau i arxiu per encriptar/desencriptar
        System.out.println("Introdueix la clau:");
        clau = scan.nextLine();
        System.out.println("Introdueix el nombre de fitxer:");
        fitxer = scan.nextLine();
        
        Path path = Paths.get(fitxer);
        
        //Generem la clau amb la size especificara
	SecretKey sKey = passwordKeyGeneration(clau, keyS);
        
        byte[] text;
        text = Files.readAllBytes(path);
	byte[] encriptData;
        encriptData = encryptData(sKey, text);
	byte[] decryptData;
        decryptData = decryptData(sKey, encriptData);
        
        //Informacio per pantalla (encriptat i desencriptat)
        String en;
        en =  new String(encriptData);
	System.out.println("Paraula clau encriptada: " + en);
        
	String desen;
        desen = new String(decryptData);
	System.out.println("Paraula clau desencriptada: " + desen);
        
        String[] Pruta;
        Pruta = fitxer.split("\\.");
        String p1;
        String p2;
        p1 = Pruta[0];
        p2 = Pruta[1];
        
        //Creem el fitxer encriptar
            File file = new File(p1 + "_X." + p2);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(en);
            bw.close();
            System.out.println("Informació: " + file);
        
        //Creem el fitxer desencriptar
            File file1 = new File(p1 + "_Y." + p2);
            FileWriter fw1 = new FileWriter(file1);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write(desen);
            bw1.close();
            System.out.println("Informació" + file1);
    }    
    
    public static SecretKey passwordKeyGeneration(String text, int keySize) {
	SecretKeySpec sKey = null;
        if ((keySize == 128)|| (keySize==192)||(keySize==256)) {
            try {
                byte[] data = text.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte [] hash = md.digest(data);
                byte [] key = Arrays.copyOf(hash, keySize/8);
                sKey = new SecretKeySpec(key, "AES");
            }catch(UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                System.err.println("Error al generar la clau."+ ex);
            }
        } return sKey;
    }
    //Encriptar
    public static byte[] encryptData(SecretKey sKey, byte[] data) {
	byte[] encryptedData = null;
	try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error: " + ex);
	} return encryptedData;
    }
    //Desencriptar
    public static byte[] decryptData(SecretKey sKey1, byte[] data) {
        byte[] desencripData = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKey1);
            desencripData = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error: " + ex);
        } return desencripData;
    }
}

