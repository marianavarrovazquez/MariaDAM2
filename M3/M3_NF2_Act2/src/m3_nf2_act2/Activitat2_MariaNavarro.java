/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3_nf2_act2;

/**
 *
 * @author maria
 */
public class Activitat2_MariaNavarro {
    
    
    private static void calcula(int fila, int pedres) {
        if(fila == pedres) {
            System.out.println("Estem a la fila " + fila + " i queden" + pedres + "pedres");
        } else if (fila > pedres) {
            fila = fila - 1;
            System.out.println("Estem a la fila " + fila + " i queden" + pedres + "pedres");
        } else {
            fila = fila + 1;
            pedres = pedres - fila;
            calcula(fila, pedres);
            System.out.println("Estem a la fila " + fila + " i queden" + pedres + "pedres");
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int fila, pedres = 5;
        
        calcula(1, pedres);
        
    }
    
}
