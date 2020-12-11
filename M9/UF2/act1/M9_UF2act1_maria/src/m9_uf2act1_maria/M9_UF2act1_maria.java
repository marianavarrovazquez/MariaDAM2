package m9_uf2act1_maria;

import java.util.*;
import java.util.concurrent.*;

public class M9_UF2act1_maria {
    static class Suma implements Callable<Integer> {
        private int operador1;
        private int operador2;

        public Suma(int operador1, int operador2) {
                this.operador1 = operador1;
                this.operador2 = operador2;
        }

        @Override
        public Integer call() throws Exception {
                return operador1 + operador2;
        }
    }

    public static void main(String[] args) throws
        InterruptedException, ExecutionException {
            //Creem 5 fils
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            
            //Crearem una llista que contindrà objectes tipus Suma que implementara Callable i te el metode call()
            List<Suma> llistaTasques= new ArrayList<Suma>();
            for (int i = 0; i < 25; i++) {
                //creem dos numeros entre 1 y 10
                Suma calcula = new Suma((int)(Math.random()*10), (int)(Math.random()*10));
                llistaTasques.add(calcula);
            }
            //Guardara els resultats de l'execució de fils de les crides del metode call() en una llista
            List <Future<Integer>> llistaResultats;
            
            //Llança tots els fils executats
            llistaResultats = executor.invokeAll(llistaTasques);
            
            //Acaba d’executar els fils pendents i no accepta més
            executor.shutdown();

            for (int i = 0; i < llistaResultats.size(); i++) {
                //Guarda els resultats de llistaResltats a una variable de tipus Future<Integer> que la treurem per pantalla
                Future<Integer> resultat = llistaResultats.get(i);
                try {
                    System.out.println("Resultat tasca "+i+ " és:" +
                    resultat.get());
                }
                catch (InterruptedException | ExecutionException e) {}
            }
    }
}