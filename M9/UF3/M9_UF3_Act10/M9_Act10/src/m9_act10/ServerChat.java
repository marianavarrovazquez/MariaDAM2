/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_act10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class ServerChat implements Runnable{
    
    Socket client;
    ServerSocket server;
    static int numClients;
    String cadena = "";
    static String registro="";

    public ServerChat(Socket client, ServerSocket server, String registro) {
        this.client = client;
        this.server = server;
        this.numClients++;
        this.registro = registro;
    }
    	
    public static void main (String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int port = 60000;
        ServerSocket servidor = new ServerSocket(port);
        String cadena = "";

        System.out.print("Introdueix el numero de clients que pots atendre: ");
        int numClients = scan.nextInt();

        Runnable[] arrayRunnable = new Runnable[numClients];
        Thread[] arrayThread = new Thread[numClients];
        
        
        
        for (int i = 0; i < arrayRunnable.length; i++) {
            Socket client2 = servidor.accept();
            arrayRunnable[i] = new ServerChat(client2, servidor, registro);
            arrayThread[i] = new Thread(arrayRunnable[i]);
            arrayThread[i].setName(registro);
            arrayThread[i].start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Esperant connexió... ");

            PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

            System.out.println("Client " + registro + " connectat... ");

            BufferedReader fentrada = new BufferedReader(new InputStreamReader(this.client.getInputStream()));

            while ((cadena = fentrada.readLine()) != null) {
                fsortida.println(registro);
                fsortida.println(cadena);
                System.out.println("Rebent: " + cadena);
                if (cadena.equals("*")){
                    System.out.println("Connexió client tancada... ");
                    break;
                }
            }
            
            fentrada.close();
            fsortida.close();
            this.client.close();
            this.server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

