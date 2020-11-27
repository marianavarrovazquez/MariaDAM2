package m9_act6_maria;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/*
*File: Generacio.java
*Author: Maria Navarro
*Date: 8-11-2020
*Description: Activitat 6 Practica UF1 M9
*/

public class Encriptacio {
    
    public static void main(String args[]) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, NoSuchPaddingException{
        Scanner scan = new Scanner(System.in);
        
        String nom, missatge;
        
        //DEMANA EL NOM DE L'ARXIU
        System.out.println("Introdueix el nom del arxiu de la clau publica: ");
        nom = scan.nextLine();
        byte[] bytesNom = Files.readAllBytes(Paths.get(nom));
        
        //DEMANAR EL TEXT A ENCRIPTAR
        System.out.println("Introdueix el text per a encriptar:");
        missatge = scan.nextLine();
        //transformem el text a bytes
        byte[] textBytes = missatge.getBytes();
        
        KeyFactory keyfactory = KeyFactory.getInstance("RSA");
        String publicKeyContent = new String(bytesNom);
        publicKeyContent = publicKeyContent
        .replace("-----BEGIN PUBLIC KEY-----", "")
        .replace("-----END PUBLIC KEY-----", "");
        byte[] publicKeyDecoded = Base64.getDecoder().decode(publicKeyContent);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyDecoded);
        PublicKey clauPublica = keyfactory.generatePublic(publicKeySpec);
        
        SecretKey clauS = keyGenerator();
        byte[] bytesSimetrica = clauS.getEncoded(); 
        
        byte[] encriptedtextBytes = encryptData(clauS, textBytes);
        byte[] clauSEncripted = encryptData(bytesSimetrica, clauPublica);
        
        arxiuClauEnc(clauSEncripted);
        arxiuMissatgeEnc(encriptedtextBytes);
    }
    
    //Generem la clau simetrica de un sol us
    public static SecretKey keyGenerator(){
        SecretKey clau = null;
        int kSize = 256;
        try{
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(kSize);
            clau = kgen.generateKey();
        }catch (Exception ex){
            System.out.println("Generador no disponible");
        }
        return clau;
    }

    public static byte[] encryptData(SecretKey clau, byte[] data) throws NoSuchPaddingException {
        byte[] encryptedData = null;
        
	try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, clau);
            encryptedData = cipher.doFinal(data);
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error xifrant les dades: " + ex);
	}
        
	return encryptedData;
    }
    
    public static byte[] encryptData(byte[] data, PublicKey clauPublica) {
            byte[] encryptedData = null;
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, clauPublica);
                encryptedData = cipher.doFinal(data);
            }catch (Exception ex) {
                System.err.println("Error xifrant les dades: " + ex);
            }
            return encryptedData;
    }
    
     public static void arxiuClauEnc (byte[] data){
        try{
            BufferedOutputStream bos = new BufferedOutputStream
            (new FileOutputStream("ZZZ_clau_encriptada"));
            bos.write(data);
            bos.flush();
        } catch (Exception ex) {
            System.err.println("Error!!!");
        }
    }
    
    public static void arxiuMissatgeEnc(byte[] data){
        try{
            BufferedOutputStream bos = new BufferedOutputStream
            (new FileOutputStream("ZZZ_missatge_encriptat"));
            bos.write(data);
            bos.flush();
        } catch (Exception ex) {
            System.err.println("Error!!!");
        }
    }
    
}
