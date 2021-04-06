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
        int clients = 3;
        
        System.out.println(clients + "clients");
        
        for (int i = 0; i < clients; i++){
            System.out.println("Esperant connexió... ");
            Socket clientConnectat = servidor.accept();
            System.out.println("Client " + (i+1));
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
