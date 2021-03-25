/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf3_act4;

import java.net.*;
import java.io.*;

/**
 *
 * @author maria
 */

public class act04_cliente {
    
    public static void main (String[] args) throws Exception {		
        //FLUX PER A ENTRADA ESTÀNDARD
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        //Socket client
        DatagramSocket clientSocket = new DatagramSocket();

        byte[] enviats = new byte[1024];
        byte[] rebuts = new byte[1024];

        //DADES DEL SERVIDOR al qual s'envia el missatge
        InetAddress IPServidor = InetAddress.getLocalHost();
        int port = 9800;
        boolean acaba = true;
        String cadena;

        while (acaba){
            //INTRODUIR DADES PEL TECLAT
            System.out.print("Introdueix missatge: ");
            cadena = in.readLine();
            enviats = cadena.getBytes();

            //ENVIANT DATAGRAMA AL SERVIDOR
            System.out.println("Enviant "+enviats.length+"bytes al servidor.");
            DatagramPacket enviament = new DatagramPacket(enviats, enviats.length, IPServidor, port);
            clientSocket.send(enviament);

            //REBENT DATAGRAMA DEL SERVIDOR
            DatagramPacket rebut = new DatagramPacket(rebuts, rebuts.length);
            System.out.println("Esperant datagrama...");

            //TEMPS D'ESPERA 
            clientSocket.setSoTimeout(5000);

            try {
                //SERVIDOR REB L'INFORMACIÓ
                clientSocket.receive(rebut);
            } catch(SocketTimeoutException e) {
                //SI TRIGA MES DE 5 SEG RETORNEM FALSE AL BOOLEA I S'ACABA EL PROGRAMA
                acaba = false;
            }
            if (acaba == true) { 
                //ACONSEGUINT INFORMACIÓ DEL DIAGRAMA
                InetAddress IPOrigen = rebut.getAddress();
                int portOrigen = rebut.getPort();
                String majuscula = new String(rebut.getData());
                System.out.println("\tProcedent de: "+IPOrigen+":"+portOrigen);
                System.out.println("\tDades: "+majuscula.trim());
            }

            if(acaba == false) {
                //Tanca el socket
                clientSocket.close();    
            }
        }
    }

}
