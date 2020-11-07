package m9_act5;

import java.util.Scanner;

/**
 *
 * @author maria
 */
public class M9_Act5 {
    public static void main(String[] args) throws Exception {
        Scanner teclado= new Scanner (System.in);
	String text;
	String desxifrat;
	String secure;
	String fitxer_privat;
        String fitxer_public;
        
	//ENTRADA VARIABLES
	System.out.println("TEXT:");
	text=teclado.next();
	fitxer_privat = "rsa.pri.txt";
	fitxer_public = "rsa.pub.txt";
	RSA rsa = new RSA();
	rsa.genKeyPair(512);
	rsa.saveToDiskPrivateKey("rsa.pri.txt");
	rsa.saveToDiskPublicKey("rsa.pub.txt");
	
	//PROGRAMA
	secure = rsa.Encrypt(text);
	System.out.println("Text Xifrat : "+secure);
	
	//DESXIFRAT
	RSA rsa2 = new RSA();
	rsa2.openFromDiskPrivateKey("rsa.pri.txt");	
	rsa2.openFromDiskPublicKey("rsa.pub.txt");
	
        desxifrat = rsa2.Decrypt(secure);
	System.out.println("Desxifrat:"+desxifrat );
    }
    
}
