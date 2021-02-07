/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_activitat4_ivancasal_marianavarro;

/**
 *
 * @author maria
 */
public class M9_Activitat4_apartado3_BRecursiu {
    public static int CalculaValor(int n1, int n2){
        if (n2 == 0) {
            return n1;
        } else {
            return CalculaValor(n2, n1 % n2);
        }
    }
    
    public static void main(String[] args) {
        int n1 = 6;
        int n2 = 7;
        int resultat;
        
        resultat = CalculaValor(n1, n2);
        
        System.out.println("Maxim comu divisor : " + n1 + ", " + n2 + " = "+ resultat);
    }
}
