/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



/**
 *
 * @author maria e ivan
 */
public class M9_Activitat4_IvanCasal_MariaNavarro {
    
    static class Caja implements Runnable {
        //Num client i el temps del articles
        private int[] temps = {2, 3, 4, 5, 6, 7, 8};
        private int numClientes;
        
        public Caja(int productos) {
            numClientes = productos;
        }
        
        @Override
        public void run() {
            //Numero d'articles aleatori
            int articulos = (int) (Math.random() * (30 - 1 + 1)) + 1;
            int tempsR = (int) (Math.random() * (6 - 0 + 1));
            
            
                System.out.println("Creat Client " + numClientes + " amb " + articulos + " articles");
                System.out.println("Client " + numClientes + " passa per caixa...");

                for (int j = 1; j < articulos+1; j++) {

                    try {
                        //Temps parara
                        Thread.sleep(temps[tempsR] * 1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (j == articulos) {
                        //Si el client te tots els articles sen va
                        System.out.println("Client " + numClientes + " article " + j + "/" + articulos + " (" + temps[tempsR] + " segons)... FINALITZAT");
                    }else{
                        //Si no, segueix
                        System.out.println("Client " + numClientes + " article " + j + "/" + articulos + " (" + temps[tempsR] + " segons)...");
                    }
                }
            
        }
        
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {        
        
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool (20);
       
        //Numero de clients
        for (int i = 1; i <= 2; i++) {
            Caja task = new Caja(i);
            executor.scheduleWithFixedDelay(task, 0 , 3, TimeUnit.SECONDS);
        }
        executor.awaitTermination(20, TimeUnit.SECONDS);
        executor.shutdown();
    }
}