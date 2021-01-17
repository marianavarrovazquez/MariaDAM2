package activitat4_ivancasal_marianavarro;

/**
 *
 * @author maria y ivan
 */
public class Activitat4_IvanCasal_MariaNavarro {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(calculaFibonacci(34));
    }
    
    public static long calculaFibonacci(long numero) {
        double calcul = java.lang.Math.cos(54879854);
        if (numero==0) { return 0; }
            else if (numero==1) { return 1; }
        else {
            return (calculaFibonacci(numero-2) + calculaFibonacci(numero-1));
        }
    }
}
