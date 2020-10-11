/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_act2;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
/**
 *
 * @author maria
 */
public class m9_act2NoDual {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("\nAlgorisme AES:");
        byte [] encoded=keygenKeyGeneration(128).getEncoded();
        for (int i=0; i<encoded.length; i++) {
            System.out.println(Integer.toBinaryString(encoded[i] & 0xFF).replace(' ', '0')+ "-"+ encoded[i]);
	}                
	System.out.println("\nAlgorisme DES:");
        byte [] encoded2=keygenKeyGeneration2(56).getEncoded();
        for (int j=0; j<encoded2.length; j++) {
            System.out.println(Integer.toBinaryString(encoded2[j] & 0xFF).replace(' ', '0')+ "-"+ encoded2[j]);
	}
        System.out.println("\nAlgorisme DESede:");
        byte [] encoded3=keygenKeyGeneration3(168).getEncoded();
        for (int k=0; k<encoded3.length; k++) {
            System.out.println(Integer.toBinaryString(encoded3[k] & 0xFF).replace(' ', '0')+ "-"+ encoded3[k]);
	}
    }	
    public static  SecretKey keygenKeyGeneration(int keySize) {
        SecretKey sKey = null;
        if ((keySize == 128 )|| (keySize == 192)|| ( keySize == 256)) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(keySize);
                sKey= kgen.generateKey();
            }catch (NoSuchAlgorithmException ex) {
                System.err.println("Generador no disponible.");
            }
        }
        return sKey;
    } 
    public static  SecretKey keygenKeyGeneration2(int keySize) {
        SecretKey sKey = null;
        if ((keySize == 56 )|| (keySize == 192)|| ( keySize == 256)) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("DES");
                kgen.init(keySize);
                sKey= kgen.generateKey();
            }catch (NoSuchAlgorithmException ex) {
                System.err.println("Generador no disponible" );	
            }
        }
        return sKey;
    } 
    public static  SecretKey keygenKeyGeneration3(int keySize) {
        SecretKey sKey = null;
        if ((keySize == 112 )|| (keySize == 168)) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("DESede");
                kgen.init(keySize);
                sKey= kgen.generateKey();
            }catch (NoSuchAlgorithmException ex) {
                System.err.println("Generador no disponible" );	
            }
        }
        return sKey;
    }
}
