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
    static String registre = "";

    public ServerChat(Socket client, ServerSocket server, String registre) {
        this.client = client;
        this.server = server;
        this.numClients++;
        this.registre = registre;
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
            arrayRunnable[i] = new ServerChat(client2, servidor, registre);
            arrayThread[i] = new Thread(arrayRunnable[i]);
            arrayThread[i].start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Esperant connexió... ");

            PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

            BufferedReader fentrada = new BufferedReader(new InputStreamReader(this.client.getInputStream()));

            while ((cadena = fentrada.readLine()) != "") {                
                if (cadena.startsWith("//name ")) {
                    this.registre = cadena.substring(7, cadena.length()).toString();
                    System.out.println("Client " + this.registre + " connectat... ");
                } else if (!cadena.equals("//sortir")) {
//                    fsortida.println(cadena);
                    System.out.println("Rebent: " + cadena);
                    //Retornem missatges
                    fsortida.println("Missatge de " + this.registre + ": " + cadena);
                } else if (cadena.equals("//sortir")){
                    System.out.println("Connexió " + this.registre + " client tancada... ");
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

