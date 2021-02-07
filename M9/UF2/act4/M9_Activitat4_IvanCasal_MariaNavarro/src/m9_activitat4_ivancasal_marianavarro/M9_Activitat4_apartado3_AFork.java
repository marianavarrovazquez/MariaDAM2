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
public class M9_Activitat4_apartado3_AFork extends RecursiveTask<Long> {

    int n, x;

    public M9_Activitat4_apartado3_AFork(int n, int x) {
        this.n = n;
        this.x = x;
    }

    public static void main(String[] args) { 
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new M9_Activitat4_apartado3_AFork(15,55)));
    }
    
    private static int calculaValor(int n, int x) {
        if(n == 0) {
            return 1;
        } else {
            return calculaValor(n-1, x)*x;
        }
    }
    
    @Override
    protected Long compute() {
        if (n == 0) {
            return (long)1;
        } else {
            M9_Activitat4_apartado3_AFork temporal = new M9_Activitat4_apartado3_AFork(n-1, x);
            temporal.fork();
            return temporal.join() * x;
        }
    }
    
}
