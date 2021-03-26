/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3_excepcions_1;

import java.util.Scanner;

/**
 *
 * @author maria
 */
public class DivisionTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String numerator = null;
        String divisor = null;
        int num1 = 0;
        int num2 = 0;
        int div = 0;
        boolean acaba = true;
        
        while (acaba) {
            
            try {
                
                System.out.println("Enter the numerator: ");
                numerator = sc.nextLine();

                if(numerator.equalsIgnoreCase("q")){
                    acaba = false;
                } else {
                    num1 = Integer.parseInt(numerator);

                    System.out.println("Enter the divisor: ");
                    divisor = sc.nextLine();   

                    num2 = Integer.parseInt(divisor);

                    div = num1 / num2;

                    System.out.println(num1 + " / " + num2 + " is " + div );
                }

            } catch (ArithmeticException a) {
                System.out.println("You can't divide " + num1 + " by " + div);
            } catch (NumberFormatException n) {
                System.out.println("You entered bad data.");
                System.out.println("Please try again.");
            }
        }
    }
    
}
