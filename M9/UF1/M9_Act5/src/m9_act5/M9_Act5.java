package m9_act5;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;

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
        textEncr = Arrays.toString(arrayTextE);
        byte[] arrayTextD = decryptData(arrayTextE, clauPrivada);
        textDes = Arrays.toString(arrayTextD);
    }

    private static KeyPair randomGenerate(int i) {
        return null;
    }
    
}
