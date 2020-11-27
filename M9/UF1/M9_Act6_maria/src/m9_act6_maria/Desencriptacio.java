/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_act6_maria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
*File: Generacio.java
*Author: Maria Navarro
*Date: 8-11-2020
*Description: Activitat 6 Practica UF1 M9
*/
public class Desencriptacio {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        byte[] bytesNom = Files.readAllBytes(Paths.get("clauPrivada"));
        
        KeyFactory keyfactory = KeyFactory.getInstance("RSA");
        String privateKeyContent = new String(bytesNom);
        privateKeyContent = privateKeyContent
        .replace("-----BEGIN PRIVATE  KEY-----", "")
        .replace("-----END PRIVATE  KEY-----", "")
        .replace("\n", "");
        byte[] privateKeyDecoded = Base64.getDecoder().decode(privateKeyContent);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyDecoded);
        PrivateKey clauPrivada = keyfactory.generatePrivate(privateKeySpec);

        byte[] arxiuEncriptat = Files.readAllBytes(Paths.get("ZZZ_missatge_encriptat"));

        byte[] SimetricaEncriptada = Files.readAllBytes(Paths.get("ZZZ_clau_encriptada"));

        byte[] decryptKey = decryptData(SimetricaEncriptada, clauPrivada);
        SecretKey secretKey = new SecretKeySpec(decryptKey, 0, decryptKey.length, "AES");

        byte[] dataResultado = decryptData(secretKey, arxiuEncriptat);

        String resultado = new String(dataResultado);

        System.out.println("La frase desencriptada es: " + resultado);
    }
     public static byte[] decryptData(SecretKey clau, byte[] data) throws InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
	byte[] decryptedData = null;
        
	try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, clau);
            decryptedData = cipher.doFinal(data);
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error xifrant les dades: " + ex);
	}
        
	return decryptedData;
    }
    
    public static byte[] decryptData(byte[] data, PrivateKey clauPrivada) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, clauPrivada);
            encryptedData = cipher.doFinal(data);
        }
        catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }
}
