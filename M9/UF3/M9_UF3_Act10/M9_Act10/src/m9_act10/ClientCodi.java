/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_act10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author maria
 */
public class ClientCodi {
    public static void main (String[] args) throws Exception {
        String host = "localhost";
        int port = 60000;//Port remot
        Socket client = new Socket(host, port);

        //FLUX DE SORTIDA AL SERVIDOR
        PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

        //FLUX D'ENTRADA AL SERVIDOR
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //FLUX PER A ENTRADA ESTÀNDARD
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String cadena, eco = "";
        System.out.println("Introdueix la cadena: ");
        //Lectura teclat
        cadena = in.readLine();

        while (cadena != null) {
            //Enviament cadena al servidor
            fsortida.println(cadena);
            //Rebuda cadena del servidor
            eco = fentrada.readLine();
            System.out.println("  =>ECO: "+eco);
            //Lectura del teclat
            cadena = in.readLine();
        }

        fsortida.close();
        fentrada.close();
        System.out.println("Finalització de l'enviament...");
        in.close();
        client.close();
    }
}

