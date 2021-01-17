package activitat4_ivancasal_marianavarro;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author maria y ivan
 */

public class Activitat4_2aParte1_IvanCasal_MariaNavarro extends RecursiveTask<Long> {
    long numero;
    
    public Activitat4_2aParte1_IvanCasal_MariaNavarro(long numero){
        this.numero=numero;
    }    
    
    @Override
    protected Long compute() {
        // ATENCIO **1** 
        double calcul = java.lang.Math.cos(54879854);
        if(numero <= 1) return numero;
        Activitat4_2aParte1_IvanCasal_MariaNavarro fib1 = new Activitat4_2aParte1_IvanCasal_MariaNavarro(numero-1);
        //fib1.fork();
	Activitat4_2aParte1_IvanCasal_MariaNavarro fib2 = new Activitat4_2aParte1_IvanCasal_MariaNavarro(numero-2);
        fib2.fork();
	 return fib1.compute()+ fib2.join();
	 }
    
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Calculat:  " + pool.invoke(new Activitat4_2aParte1_IvanCasal_MariaNavarro(34)));    
    }
}