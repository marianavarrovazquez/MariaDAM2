/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

import java.util.Arrays;

/**
 *
 * @author maria e ivan
 */
public class M9_act4_apartado2 {
    
    static class Bombolla implements Runnable{
        int[] arrayBombolla;
        int parts;
       
        public Bombolla(int[] arrayBombolla, int parts) {
            this.arrayBombolla = arrayBombolla;
            this.parts = parts;
        }

        @Override
        public void run() {
            //variables temporales para guardar los numeros mientras hacemos el metodo burbuja
            int[] arrayBombolla2;
            int parts2;
            
            //Hacemos el metodo burbuja y enseñamos la parte, el numero que habia en esa parte y el numero que remplazamos al ordenarlo
            for (int i = 0; i < arrayBombolla.length; i++) {
                for (int j = 0; j < arrayBombolla.length; j++) {
                    if(arrayBombolla[j] > arrayBombolla[j+1]) {
                        arrayBombolla2 = arrayBombolla.clone();
                        parts2 = arrayBombolla[j];
                        arrayBombolla[j] = arrayBombolla[j+1];
                        arrayBombolla[j+1] = parts2;
                        System.out.println("Parte " + (this.parts + 1) + " era " + Arrays.toString(arrayBombolla2) + " ahora es " + Arrays.toString(arrayBombolla));
                    }
                }
            }
            
            System.out.println(Arrays.toString(arrayBombolla));
        }
        
    }
    
    static int[] arrayParts = {0, 0, 0, 0};
    
    public static void main(String[] args) {
    //    int random = (15 - 1) +1; 
        int[] aleatorio = new int[20];
        
        //Llamamos a la funcion Bombolla y creamos el array de 4 partes
        Bombolla[] partsBombolla = new Bombolla[4];
        
        //Generamos los numeros aleatorios
        for (int i = 0; i < aleatorio.length; i++) {
            aleatorio[i] = (int)(Math.random() * 20)+ 1;
        }
        
        System.out.println(Arrays.toString(aleatorio));
        
    }
}
