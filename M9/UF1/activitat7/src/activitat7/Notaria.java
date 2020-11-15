package activitat7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/*
*File: Signatura.java
*Author: Maria Navarro
*Date: 15-11-2020
*Description: Activitat 7 Practica UF1 M9
 */

public class Notaria {
    public static void main(String[] args) throws IOException{
        boolean validar;
        byte[] textBytes;
        byte[] signatura;
        String clau = "clauPublica";
        PublicKey clauPublica = null;
        boolean validat;
        
        clauPublica = recuperarCP(clauPublica);
        
        textBytes = Files.readAllBytes(Paths.get("missatge"));
        signatura = Files.readAllBytes(Paths.get("firma"));
        
        validar = validateSignature(textBytes, signatura, clauPublica);
        
        validat = validarText(validar);
    }
     
    public static boolean validateSignature(byte[] data, byte[] signature, PublicKey pub) {
        boolean isValid = false;
        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initVerify(pub);
            signer.update(data);
            isValid = signer.verify(signature);
        }
        catch (Exception ex) {
            System.err.println("Error validant les dades: " + ex);
        }
        return isValid;
    }
    
    public static PublicKey recuperarCP (PublicKey clauPublica) {
        try {
            File filePublicKey = new File("clauPublica");
            FileInputStream fis = new FileInputStream("clauPublica");
            byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
            fis.read(encodedPublicKey);
            fis.close();
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
            clauPublica = keyFactory.generatePublic(publicKeySpec);            
        } catch (Exception ex){ 
            System.err.println("ERROR guardant clau publica...");
        }
        
        return clauPublica;
    }

    public static boolean validarText(boolean validar) {
        if(validar){
            System.out.println("Comprovant signatura de l’arxiu missatge...OK");
        }else{
            System.out.println("Comprovant signatura de l’arxiu missatge...Error");
        }
        return validar;
    }
}
