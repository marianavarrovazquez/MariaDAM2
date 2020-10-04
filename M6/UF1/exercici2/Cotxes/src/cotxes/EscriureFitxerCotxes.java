package cotxes;

import java.io.*;
import java.util.Scanner;

public class EscriureFitxerCotxes {
    public static void main(String[] args) throws IOException {
        //Camp variable tipus Cotxes
        Cotxes cotxes;

        Scanner scan = new Scanner (System.in); //Creación de un objeto Scanner

        //Declaració del fitxer
        File fitxer = new File("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M6\\UF1\\exercici2\\fitxerCotxes.txt");

        //Crea el flux de sortida
        FileOutputStream fileSortida = new FileOutputStream(fitxer);

        //Connectar el flux de bytes al flux de dades
        ObjectOutputStream dataOutCotxes = new ObjectOutputStream(fileSortida);

        //Les dades per generar els objectes Cotxes
        String marca[] = {"Mercedes", "Fiat", "Peugeot", "Volkswagen", "BMW", "Citroen", "Audi", "Mitchubishi", "Mini"};
        String model[] = {"Clase A", "500", "508", "Polo", "350d", "c3", "r8", "Lancer EVO", "Cooper S"};
        String matricula[] = {"3547NXR", "5690BBS", "9832JTH", "8219GIM", "9234AED", "1739KLN", "1527LAM", "7351MNV", "2456LJR"};
        int any[] = {2020, 2018, 2019, 2016, 2020, 2010, 2011, 2015, 2019};

        //Recorre els arrays
        for (int i=0; i<marca.length; i++){//Crea el cotxe
            cotxes = new Cotxes(marca[i], model[i], matricula[i], any[i]);
            dataOutCotxes.writeObject(cotxes);//L'escriu al fixer
        }
         
        
        //camps variables per demanar per teclat
        String marcaT = "";
        String modelT = "";
        String matriculaT = "";
        int anyT = 0;
        
        //contador
        int cont = 0;
    
        while(cont != 1){
            System.out.println("Si vols introduir un cotxe introdueixi 2 si no introdueix 1."); 
            cont = scan.nextInt(); 
            if(cont == 2){
               System.out.println("Introdueix la marca del cotxe:"); 
               marcaT = scan.next();
               System.out.println("Introdueix el model del cotxe:"); 
               modelT = scan.next();
               System.out.println("Introdueix la matricula del cotxe:"); 
               matriculaT = scan.next();
               System.out.println("Introdueix l'any de fabricació del cotxe:"); 
               anyT = scan.nextInt();
               
               cotxes = new Cotxes(marcaT, modelT, matriculaT, anyT);
               dataOutCotxes.writeObject(cotxes);//L'escriu al fixer
               
            }
           
        }
         
        dataOutCotxes.close();//Tanca el stream de sortida
	
        
    }
}
