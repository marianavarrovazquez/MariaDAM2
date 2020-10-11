package persones;

import java.io.*;

public class LleguirFitxerPersones {
     public static void main(String[] args) throws IOException {
         
        File fitxer = new File("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M6\\UF1\\exercici3\\fitxasPersones.txt");
	
        //Crea un flux (stream) d'arxiu d'accés aleatori només lectura
	RandomAccessFile FitxesPAleatori = new RandomAccessFile(fitxer, "r");

        //Apuntador s'inicialitza apuntant a l'inici del fitxer
	int apuntador = 0, telefon, edat, id;
	char nom[] = new char[15], cognom[] = new char[25], dni[] = new char[9], aux;

        //Recorrer el fitxer llibres
            for (;;) {
		FitxesPAleatori.seek(apuntador);//Apuntar a l'inici de cada persona al fitxer
		//Llegeix ID
		id = FitxesPAleatori.readInt();
		//Llegeix nom
                for(int i = 0; i<nom.length; i++) {
                    aux = FitxesPAleatori.readChar();
                    nom[i] = aux;
                }
                String noms = new String(nom);
                //Llegeix cognoms
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
		//Sortida de les dades de cada persona
		System.out.println("ID: "+id+"\nNom: "+noms+"\nCognom: "+cognoms+"\nDni: "+dniP+"\nTelefon: "+telefon+"\nEdat: "+edat+"\n\n");
		//S'ha de posicionar l'apuntador la següent persona
		apuntador += 110;
		//Si coincideix on s'està apuntat amb el final del fitxer, sortim
		if(FitxesPAleatori.getFilePointer()==FitxesPAleatori.length()) break;
            }
		FitxesPAleatori.close();//Tancar el fitxer
     }
}
