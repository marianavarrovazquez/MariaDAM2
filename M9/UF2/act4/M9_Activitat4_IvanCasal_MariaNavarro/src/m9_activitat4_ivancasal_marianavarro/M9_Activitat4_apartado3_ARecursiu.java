/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

/**
 *
 * @author maria e ivan
 */
public class M9_Activitat4_apartado3_ARecursiu {
    
    
    public static void main(String[] args) {
        System.out.println(calculaValor(2,4));
    }

    private static int calculaValor(int n, int x) {
        if(n == 0) {
            return 1;
        } else {
            return calculaValor(n-1, x)*x;
        }
    }
    
}