package m9_act5;

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
	String desxifrat;
	String secure;
	String fitxer_privat;
        String fitxer_public;
        
	//ENTRADA VARIABLES
	System.out.println("TEXT:");
	text = scan.next();
	fitxer_privat = "rsa_privat.txt";
	fitxer_public = "rsa_public.txt";
	RSA rsa = new RSA();
	rsa.genKeyPair(512);
	rsa.saveToDiskPrivateKey("rsa_privat.txt");
	rsa.saveToDiskPublicKey("rsa_public.txt");
	
	//PROGRAMA
	secure = rsa.Encrypt(text);
	System.out.println("Text Xifrat : " +secure);
	
	//DESXIFRAT
	RSA rsa2 = new RSA();
	rsa2.openFromDiskPrivateKey("rsa_privat.txt");	
	rsa2.openFromDiskPublicKey("rsa_public.txt");
	
        desxifrat = rsa2.Decrypt(secure);
	System.out.println("Desxifrat : " +desxifrat );
    }
    
}
