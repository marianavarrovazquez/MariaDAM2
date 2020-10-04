
package codiencriptacio;

import java.util.Scanner;

public class CodiEncriptacio {

    public static void main(String[] args) {
        char abecedari[] = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 32}; //del 97 al 122 son letras y el 32 espacio
        String text = "";
        int pLletra = 0;
        int res=0;
       
        Scanner scan = new Scanner(System.in);
       
        System.out.print("Introdueix el text: ");
        text = scan.nextLine();
       
        System.out.print("Introdueix el numero de posicions que es moura: ");
        pLletra = scan.nextInt();
        
        for(int j = 0; j < text.length(); j++){
            for(int i = 0; i < abecedari.length; i++){
                if(abecedari[i] == text.charAt(j)){
                    if((i+pLletra) >= abecedari.length){
                        res = abecedari.length - i;
                        System.out.print(abecedari[pLletra - res]);
                    } else{
                       System.out.print(abecedari[i + pLletra]);
                    }
                }
            }
        }
       System.out.print("\n");
    }
    
}

