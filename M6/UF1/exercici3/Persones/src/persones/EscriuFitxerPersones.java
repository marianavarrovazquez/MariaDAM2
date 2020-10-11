package persones;

import java.io.*;
import java.util.Scanner;

public class EscriuFitxerPersones {

    public static void main(String[] args) throws IOException {
       
        Scanner scan = new Scanner (System.in);
        
        //Declaració del fitxer
        File fitxer = new File("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M6\\UF1\\exercici3\\fitxasPersones.txt");
	
        //Crea un flux (stream) d'arxiu d'accés aleatori per llegir
	RandomAccessFile FitxesPAleatori = new RandomAccessFile(fitxer, "rw");
	
        //Les dades per inserir
	String nom[] = new String[3];
       	String cognom[] = new String[3];
	String dni[] = new String[3];
	int telefon[] = new int[3];
	int edat[] = new int[3];
        
        //Construeix un buffer (memòria intermèdia) de strings
	StringBuffer buffer = null;
        
        for (int i=0; i<nom.length; i++) {
        	FitxesPAleatori.writeInt(i+1);//1 enter ocupa 4 bytes

                //15 caràcters a 2bytes/caràcter 30 bytes
                System.out.print("Nom de la persona:  ");
                nom[i] = scan.next();
		buffer = new StringBuffer (nom[i]);
		buffer.setLength(15);
		FitxesPAleatori.writeChars(buffer.toString());
		
		//25 caràcters a 2bytes/caràcter 50 bytes
                System.out.print("Cognom de la persona:  ");
                cognom[i] = scan.next();
                buffer = new StringBuffer (cognom[i]);
		buffer.setLength(25);
		FitxesPAleatori.writeChars(buffer.toString());
                
		//9 caràcters a 2bytes/caràcter 18 bytes
                System.out.print("Dni de la persona:  ");
                dni[i] = scan.next();
                buffer = new StringBuffer (dni[i]);
		buffer.setLength(9);
		FitxesPAleatori.writeChars(buffer.toString());

                //1 enter ocupa 4 bytes
                System.out.print("Telefon de la persona:  ");
                telefon[i] = scan.nextInt();
		FitxesPAleatori.writeInt(telefon[i]);
                
                //1 enter ocupa 4 bytes
                System.out.print("Edat de la persona:  ");
                edat[i] = scan.nextInt();
                FitxesPAleatori.writeInt(edat[i]);
              
		//Total 110 bytes
	}        
        FitxesPAleatori.close();
    }
    
}
