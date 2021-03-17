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
            pedres = pedres - fila;
            System.out.println("Si son iguals: ");
            System.out.println("Estem a la fila " + fila + " i queden " + pedres + " pedres\n");
        } else if (fila > pedres) {
            fila = fila - 1;
            System.out.println("Si fila es mes gran que pedres: ");
            System.out.println("Estem a la fila " + fila + " i queden " + pedres + " pedres\n");
        } else {
            pedres = pedres - fila;
            fila = fila + 1;
            calcula(fila, pedres);
        }
    }
   
    public static void main(String[] args) {
        // TODO code application logic here
        int fila, pedres = 10;
        
        calcula(1, pedres);
        
    }
    
}
