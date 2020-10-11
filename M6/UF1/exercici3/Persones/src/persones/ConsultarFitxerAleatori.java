package persones;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ConsultarFitxerAleatori {
     public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner (System.in);
        
        File fitxer = new File("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M6\\UF1\\exercici3\\fitxasPersones.txt");
	
        //Crea un flux (stream) d'arxiu d'accés aleatori només lectura
	RandomAccessFile FitxesPAleatori = new RandomAccessFile(fitxer, "r");

        //Apuntador s'inicialitza apuntant a l'inici del fitxer
	int apuntador = 0, telefon, edat, id, op;
	char nom[] = new char[15], cognom[] = new char[25], dni[] = new char[9], aux;

        //Demana a l'usuari que seleccioni la persona pel seu identificador
	System.out.print("Introdueixi el ID la persona a consultar:");
	op = scan.nextInt();
        //para que pase de persona en persona. 110 son los bytes que ocupan cada persona
        apuntador=(op-1)*110;
        
        if (apuntador >= FitxesPAleatori.length()) {
			System.out.println("ERROR: ID incorrecte, no existeix aquesta persona");
		} else {//Apuntar a l'inici de la persona seleccionada al fitxer
			FitxesPAleatori.seek(apuntador);
			id = FitxesPAleatori.readInt();//Llegeix ID
			for(int i = 0; i<nom.length; i++) {//Llegeix nom
				aux = FitxesPAleatori.readChar();
				nom[i] = aux;
			}
			String noms = new String(nom);
			//Llegeix cognom
			for(int i = 0; i<cognom.length; i++) {
				aux = FitxesPAleatori.readChar();
				cognom[i] = aux;
			}
			String cognoms = new String(cognom);
			//Llegeix dni
			for(int i = 0; i<dni.length; i++) {
                            aux = FitxesPAleatori.readChar();
                            dni[i] = aux;
                        }
                        String dniP = new String(dni);
                        //Llegeix telefon
                        telefon = FitxesPAleatori.readInt();
                        //Llegeix edat
                        edat = FitxesPAleatori.readInt();
			//Sortida de les dades de cada persones
                        System.out.println("ID: "+id+"\nNom: "+noms+"\nCognom: "+cognoms+"\nDni: "+dniP+"\nTelefon: "+telefon+"\nEdat: "+edat+"\n\n");
		}
		FitxesPAleatori.close();//Tancar el fitxer


     }
}
