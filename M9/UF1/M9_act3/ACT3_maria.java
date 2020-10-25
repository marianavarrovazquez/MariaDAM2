import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
*File: ACT3_maria.java
*Author: Maria Navarro
*Date: 25-10-2020
*Description: Activitat 3 Practica UF1 M9
*/

public class ACT3_maria {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String passw = null;
        
        System.out.println("Contrasenya:");
        passw = scan.nextLine();
        byte [] password = passwordKeyGeneration(passw,128).getEncoded();
        
        for (int i=0;i<password.length;i++) {
            System.out.println(String.format("%8s", Integer.toBinaryString(password[i]& 0xFF)).replace(' ', '0') + "-" + password[i]);
        }
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
            }catch(Exception ex) {
                System.err.println("Error al generar la clau."+ ex);
            }
        } return sKey;
    }
}
