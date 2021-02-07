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
public class M9_Activitat4_apartado3_CRecursiu {

    static int CalculaValor(int i) {
        int resultado = 0;

        if (i <= 1) {
            return 1;
        }

        for (int j = 0; j < i; j++) {
            resultado += CalculaValor(j) * CalculaValor(i - j - 1);
        }
        return resultado;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(CalculaValor(i) + " ");
        }
        System.out.println("\n");
    }
}
