package codiencriptacio;

import java.util.Scanner;

public class CodiDesencriptacio {
    public static void main(String[] args){
        char abecedari[] = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 32}; //del 97 al 122 son letras y el 32 espacio
        String text = "";
        int pLletra = 0;
        int res=0;
       
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introdueix el text: ");
        text = scan.nextLine();
        
        System.out.println("Introdueix el numero de posicions que es moura: ");
        pLletra = scan.nextInt();
        
        for(int j = 0; j < text.length(); j++){
            for(int i = 0; i < abecedari.length; i++){
                if(abecedari[i] == text.charAt(j)){
                    if((i - pLletra) < 0){
                        res = pLletra - i;
                        
                        System.out.print(abecedari[abecedari.length - res]);
                    } else{
                        System.out.print(abecedari[i-pLletra]);
                    }
                }
            }
        }
        
         System.out.print("\n");
    }
}
