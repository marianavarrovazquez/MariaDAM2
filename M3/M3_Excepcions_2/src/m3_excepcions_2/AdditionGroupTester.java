package m3_excepcions_2;

import java.io.*;

/**
 *
 * @author maria
 */
public class AdditionGroupTester {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String lista;
        int num = 0;
        int cont = 0;
        
        FileReader fileReader = new FileReader("dades.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((lista = bufferedReader.readLine()) != null) {
            try {
                num = Integer.valueOf(lista);
                cont = cont + num;
            } catch (Exception e) {
                if (num != 0) {
                    System.out.println("Sum = " + cont);
                }                
                cont = 0;
                System.out.println(lista);
            }
        }
        System.out.println("Sum = " + cont);
        bufferedReader.close();
    }
}
