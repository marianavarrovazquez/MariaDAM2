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
public class M9_act2 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte [] encoded=keygenKeyGeneration(128).getEncoded();
        for (int i=0; i<encoded.length; i++) {
            System.out.println(Integer.toBinaryString(encoded[i] & 0xFF).replace(' ', '0')+ "-"+ encoded[i] );
        }
        System.out.println("\nAlgoritme 2:");
        byte [] encoded2=keygenKeyGeneration2(56).getEncoded();
        for (int j=0; j<encoded2.length; j++) {
            System.out.println(Integer.toBinaryString(encoded2[j] & 0xFF).replace(' ', '0')+ "-"+ encoded2[j] );
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
		System.err.println("Generador no disponible" );
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
}
