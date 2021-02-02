/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author maria e ivan
 */
public class M9_act4_apartado2 {

    
    static class Bombolla implements Runnable{
        //variables para ordenar en metodo burbuja
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
            for (int i = 0; i < arrayBombolla.length; i++){
                for (int j = 0; j < arrayBombolla.length - i; j++){
                    if(arrayBombolla[j] > arrayBombolla[j+1]){
                        arrayBombolla2 = arrayBombolla.clone();
                        parts2 = arrayBombolla[j];
                        arrayBombolla[j] = arrayBombolla[j+1];
                        arrayBombolla[j+1] = parts2;
                        System.out.println("Parte " + (parts + 1) + " era " + Arrays.toString(arrayBombolla2) + " ahora es " + Arrays.toString(arrayBombolla));
                    }
                }
            }
            
            System.out.println("Partes ordenadas: "+Arrays.toString(arrayBombolla));
        }
        
    }
       
    static int[] arrayParts = {0, 0, 0, 0};
    
    static int menorQue(int num, int n2, int n3, int n4){
        //Variables para calcular la posicion minima
        int minimo = num;
        int posicion = 0;
        boolean bolean = false;
        
        int[] test = {num, n2, n3, n4};
        for (int i = 0; i < test.length; i++){
            if (arrayParts[i] < 4){
                if (test[i] <= minimo ){
                    minimo = test[i];
                    posicion = i;
                    bolean = true;
                }
            }
        }
        
        if (bolean){
            arrayParts[posicion]++;
        }
        return minimo;
    }
    
    public static void main(String[] args) {
        //Creamos el array para asignar los numeros aleatorios
        int[] aleatorio = new int[20];
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        
        //Llamamos a la funcion Bombolla y creamos el array de 4 partes
        Bombolla[] partesBombolla = new Bombolla[4];
        
        //Generamos los numeros aleatorios
        for (int i = 0; i < aleatorio.length; i++){
            aleatorio[i] = (int)(Math.random() * 20)+ 1;
        }
        
        System.out.println(Arrays.toString(aleatorio));
        
        int cont = 0;
        //Asignamos los numeros aleatorios creados en las posiciones
        for (int j = 0; j < partesBombolla.length; j++){
            int[] arrayTemporal = new int[aleatorio.length / 4];
            for (int k = 0; k < arrayTemporal.length; k++) {
                arrayTemporal[k] = aleatorio[cont];
                cont++;
            }
            Bombolla bombolla = new Bombolla(arrayTemporal, j);
            partesBombolla[j] = bombolla;
            executor.execute(partesBombolla[j]);
        }
        executor.shutdown();
        
        int[] ordenar = new int[20];
        //Ordenamos el array
        for (int l = 0; l<ordenar.length; l++){
            int temporal = menorQue(
                partesBombolla[0].arrayBombolla[arrayParts[0]],
                partesBombolla[1].arrayBombolla[arrayParts[1]],
                partesBombolla[2].arrayBombolla[arrayParts[2]],
                partesBombolla[3].arrayBombolla[arrayParts[3]]);
            temporal = partesBombolla[3].arrayBombolla[arrayParts[4]];
            ordenar[l] = temporal;
        }
        //Imprime por pantalla el array ordenado
        System.out.println("Ordenado: " + Arrays.toString(arrayParts));
    }
}
