/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * @author maria e ivan
 */

public class M9_Activitat4_IvanCasal_MariaNavarro {
    
    static class Caja implements Runnable {
        //Numero de cliente y tiempo que puede tardar cada producto
        private int[] tiempo = {2, 3, 4, 5, 6, 7, 8};
        private int numClientes;
        
        //Numero de productos aleatorios
        private int productos = (int) (Math.random() * (5 - 1 + 1)) + 1;
        
        //tiempo que tardara cada producto
        private int tiempoR = (int) (Math.random() * (6 - 0 + 1));
        
        
        
        public Caja(int numClientes) {
            this.numClientes = numClientes;
            //creamos los clientes y le indicamos los productos y el tiempo de cada uno
            System.out.print("Creat Client " + numClientes + " amb " + productos + " articles (");
                for (int k = 0; k < productos; k++){
                    System.out.print(tiempo[tiempoR] + ", ");
                }
                System.out.print(")\n");
        }
        
        @Override
        public void run() {
            System.out.println("Client " + numClientes + " passa per caixa...");
            
            for (int j = 1; j < productos + 1; j++) {
                try {
                    //Tiempo que parara
                    Thread.sleep(tiempo[tiempoR] * 1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (j == productos) {
                    //Si el cliente tiene todos los productos se va
                    System.out.println("Client " + numClientes + " article " + j + "/" + productos + " (" + tiempo[tiempoR] + " segons)... FINALITZAT");
                }else{
                    //Si no los tiene sigue
                    System.out.println("Client " + numClientes + " article " + j + "/" + productos + " (" + tiempo[tiempoR] + " segons)...");
                }
            }
        }
        
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {        
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool (20);
       
        //Numero de clientes
        for (int i = 1; i <= 2; i++) {
            Caja caja = new Caja(i);
            executor.execute(caja);
            
           //SI PONEMOS ESTA LINEA I LA SIGUIENTE LOS CLIENTES SALEN EN ORDEN DESCENDIENTE  
           //executor.scheduleWithFixedDelay(caja, 0 , 3, TimeUnit.SECONDS);
        }
      //executor.awaitTermination(20, TimeUnit.SECONDS);
        executor.shutdown();
    }
}