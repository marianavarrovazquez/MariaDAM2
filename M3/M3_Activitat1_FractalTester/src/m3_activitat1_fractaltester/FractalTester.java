/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3_activitat1_fractaltester;

import java.util.Scanner;

/**
 *
 * @author maria
 */
public class FractalTester {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalFinal = 0;
        int num;
        
        System.out.println("Escribe el numero: ");
        num = scan.nextInt();
        
        totalFinal = total(num);
        
        System.out.println(totalFinal);
    }

    private static int total(int num) {
        if (num == 1) {
            return 4;
        } else {
            return 4 * num + 4 * total(num / 2);
        }
    }
    
}
