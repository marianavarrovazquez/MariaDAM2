package persones;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class CercarCFitxerPersona {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner (System.in);
        
        File fitxer = new File("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M6\\UF1\\exercici3\\fitxasPersones.txt");
	
        //Crea un flux (stream) d'arxiu d'accés aleatori només lectura
	RandomAccessFile FitxesPAleatori = new RandomAccessFile(fitxer, "r");

        //Apuntador s'inicialitza apuntant a l'inici del fitxer
	int apuntador = 0, telefon, edat, id, op, num = 10;
	char nom[] = new char[15], cognom[] = new char[25], dni[] = new char[9], aux;
        String opS ="";

        //Demana a l'usuari que seleccioni la persona pel seu identificador
	System.out.print("\n OPCIONS: \n 1. Nom \n 2. Cognom \n 3. Dni \n 4. Telefon \n 5. Edat  \nIntrodueixi el numero a consultar: ");
	op = scan.nextInt();
        //para que pase de persona en persona. 110 son los bytes que ocupan cada persona
        apuntador=(op-1)*110;
        
        switch(op){ 
            case 0:
                System.out.println("0.Consultar ID:");
                num=scan.nextInt();                    
            break;
            case 1:
                System.out.println("1.Consultar el Nombre:"); 
                opS=scan.next();                    
            break;
            case 2:
                System.out.println("2.Consultar el Cognom:");  
                opS=scan.next();                    
            break;
            case 3:
                System.out.println("3.Consultar el Dni:");   
                opS=scan.next();                    
            break;
            case 4:
                System.out.println("4.Consultar el Telefon:");    
                num=scan.nextInt();                    
            break;
            case 5:
                System.out.println("5.Consultar la Edat");     
                num=scan.nextInt();                    
            break;        
        }   
        
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
                if(noms.trim().toLowerCase().equals(opS.trim().toLowerCase()) || cognoms.trim().toLowerCase().equals(opS.trim().toLowerCase()) || dniP.trim().toLowerCase().equals(opS.trim().toLowerCase()) || id == num || telefon == num || edat == num) {
                    //Sortida de les dades de cada persona
                    System.out.println("ID: "+id+"\nNom: "+noms+"\nCognom: "+cognoms+"\nDni: "+dniP+"\nTelefon: "+telefon+"\nEdat: "+edat+"\n\n"); 
                }
                //S'ha de posicionar l'apuntador la següent persona
		apuntador += 110;
		//Si coincideix on s'està apuntat amb el final del fitxer, sortim
		if(FitxesPAleatori.getFilePointer()==FitxesPAleatori.length()) break;
            }
		FitxesPAleatori.close();//Tancar el fitxer


     }
}
