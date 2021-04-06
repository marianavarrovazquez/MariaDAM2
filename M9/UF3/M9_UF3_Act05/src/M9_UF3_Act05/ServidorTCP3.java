package M9_UF3_Act05;

import java.net.*;
import java.io.*;

/**
 *
 * @author maria
 */

public class ServidorTCP3 {

    public static void main (String[] args) throws Exception {
        int port = 60000;
        ServerSocket servidor = new ServerSocket(port);
        String cadena = "";

        System.out.println("3 clients com a maxim.");
        int numClients = 3;

        for (int i = 0; i < numClients; i++){
            System.out.println("Esperant connexió... ");
            Socket clientConnectat = servidor.accept();
            System.out.println("Client numero " + (i+1));
            System.out.println("Client connectat... ");

            PrintWriter fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);

            BufferedReader fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));

            while ((cadena = fentrada.readLine()) != null) {

                fsortida.println(cadena);
                System.out.println("Rebent: "+cadena);
                if (cadena.equals("*")) break;
            }

            fentrada.close();
            fsortida.close();
            clientConnectat.close();
        }

        System.out.println("Tancant connexió... ");
        servidor.close();
    }
}
