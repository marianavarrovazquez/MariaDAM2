package cotxes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;


public class LlegirFitxerCotxes {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Camp variable tipus Cotxes
        Cotxes cotxes;
        int op=0;
        
        Scanner scan = new Scanner (System.in); //Creación de un objeto Scanner
        
        //Declaració del fitxer
        File fitxer = new File("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M6\\UF1\\exercici2\\fitxerCotxes.txt");       
        
        //Crea el flux d'entrada
	FileInputStream fileEntrada = new FileInputStream(fitxer);
        
	//Connectar el flux de bytes al flux de dades
	ObjectInputStream dataInCotxes = new ObjectInputStream(fileEntrada);
       
        

        System.out.println("Llegir tots els cotxes 1");
        System.out.println("Llegir segons el camp 2");
        System.out.println("Sortir 3");
        op = scan.nextInt();
       
        if(op == 1){
            try {
                while (true){//Llegeix el fitxer
                    //Llegeix la comarca
                    cotxes = (Cotxes) dataInCotxes.readObject();
                    System.out.println("Marca: " +cotxes.getMarca()+ " Model: "+ cotxes.getModel()+ " Matricula: " + cotxes.getMatricula() + " Any: " + cotxes.getAny());
                }
            } catch (EOFException eo) {}
            
        } else if(op == 2){
        //camps variables per demanar per teclat
        String opSting ="";
        int anyL = 0;
        int opcions=0;
        int x=0;
        
            System.out.println("Si vols cercar un cotxe introdueixi 2 si no introdueix 1."); 
            x = scan.nextInt();
            
            System.out.println("TRIA UNA OPCIÓ \n" + "1. Cercar per marca \n" + "2. Cercar per model \n" + "3. Cercar per matricula \n" + "4. Cercar per any de fabricació");
            opcions = scan.nextInt();
                if (opcions == 1){
                    System.out.println("Introdueix la marca del cotxe a cercar:"); 
                    opSting = scan.next();
                        try {
                            while (true){//Llegeix el fitxer
                                cotxes = (Cotxes) dataInCotxes.readObject();
                                if(opSting.equalsIgnoreCase(cotxes.getMarca())){

                                    System.out.println("Marca: " +cotxes.getMarca()+ " Model: "+ cotxes.getModel()+ " Matricula: " + cotxes.getMatricula() + " Any: " + cotxes.getAny());
                                }
                            }
                        } catch (EOFException eo) {}
                }
                else if (opcions == 2){
                    System.out.println("Introdueix el model del cotxe a cercar:"); 
                    opSting = scan.next();
                        try {
                            while (true){//Llegeix el fitxer
                                cotxes = (Cotxes) dataInCotxes.readObject();
                                if(opSting.equalsIgnoreCase(cotxes.getModel())){

                                    System.out.println("Marca: " +cotxes.getMarca()+ " Model: "+ cotxes.getModel()+ " Matricula: " + cotxes.getMatricula() + " Any: " + cotxes.getAny());
                                }
                            }
                        } catch (EOFException eo) {}
                }
                else if (opcions == 3){
                    System.out.println("Introdueix el matricula del cotxe a cercar:"); 
                    opSting = scan.next();
                        try {
                            while (true){//Llegeix el fitxer
                                cotxes = (Cotxes) dataInCotxes.readObject();
                                if(opSting.equalsIgnoreCase(cotxes.getMatricula())){

                                    System.out.println("Marca: " +cotxes.getMarca()+ " Model: "+ cotxes.getModel()+ " Matricula: " + cotxes.getMatricula() + " Any: " + cotxes.getAny());
                                }
                            }
                        } catch (EOFException eo) {}
                }
                else if(opcions == 4){
                            System.out.println("Quin any vols cercar?");
                            anyL = scan.nextInt();
                            try {
                            while (true){//Llegeix el fitxer
                                    //Llegeix la comarca
                                    cotxes = (Cotxes) dataInCotxes.readObject();
                                    if(anyL == cotxes.getAny()){
                                        System.out.println("Marca: " +cotxes.getMarca()+ "   Model: "+ cotxes.getModel()+"  Any: " + cotxes.getAny() + "  Matricula: " + cotxes.getMatricula());
                                    }
                            }
                        } catch (EOFException eo) {}
                }
            

      }  
	dataInCotxes.close();//Tanca el stream d'entrada
        scan.close();
    }
}
