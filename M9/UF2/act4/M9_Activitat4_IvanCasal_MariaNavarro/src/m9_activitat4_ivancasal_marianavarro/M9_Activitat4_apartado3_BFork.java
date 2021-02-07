/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author maria e ivan
 */
public class M9_Activitat4_apartado3_BFork extends RecursiveTask<Long>{
    int n1, n2;

    public M9_Activitat4_apartado3_BFork(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
    
    public static void main(String[] args) { 
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new M9_Activitat4_apartado3_BFork(6,7)));
    }

    @Override
    protected Long compute() {
        if (n2 == 0) {
            return (long) n1;
        } else {
            M9_Activitat4_apartado3_BFork temporal = new M9_Activitat4_apartado3_BFork(n2, n1 % n2);
            temporal.fork();
            return temporal.join();
        }
    }
}
