/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author maria e ivan
 */
public class M9_Activitat4_IvanCasal_MariaNavarro {
    
    static class Client implements Callable<Integer> {
        
        private int totalProductos;
        
        public Client(int productos) {
            totalProductos = productos;
        }
        
        @Override
        public Integer call() throws Exception {
            return 0;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int CLIENTS = 50;
        Client[] arrayC = new Client[CLIENTS];
        
        //Creem 50 clients
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);
       
        List<Client> llistaTasques = new ArrayList<Client>();
        //3 segundos
        //Thread.sleep(3000);
        
    }
}