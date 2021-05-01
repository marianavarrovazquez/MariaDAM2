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
    
    static Socket client;
    static ServerSocket server;
    static int numClients;
    String cadena = "";
    static int port = 60000;
    
    //Arrays globals
    static ServerChat[] arrayRunnable;
    static Thread[] arrayThread;
    static Socket[] clients;

    public ServerChat(Socket client, ServerSocket server, Socket[] clients) {
        this.client = client;
        this.server = server;
        this.numClients++;
        this.clients = clients;
    }
    	
    public static void main (String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        server = new ServerSocket(port);

        System.out.print("Introdueix el numero de clients que pots atendre: ");
        int numClients = scan.nextInt();

        arrayRunnable = new ServerChat[numClients];
        arrayThread = new Thread[numClients];
        clients = new Socket[numClients];
        
        for (int i = 0; i < arrayRunnable.length; i++) {
            boolean bolean = true;
            boolean desconectar = false;
            client = null;
            
            System.out.println("Esperant connexió... ");
            
            try{
                client = server.accept();
            } catch (SocketException e) {
                bolean = false;
            }
            
            for (int j = 0; j < clients.length; j++) {
                if (clients[i] == null && desconectar == false) {
                    clients[i] = client;
                    desconectar = true;
                }
            }
            
            if(bolean) {
                arrayRunnable[i] = new ServerChat(client, server, clients);
                arrayThread[i] = new Thread(arrayRunnable[i]);
                arrayThread[i].start();
            }
        }
    }

    @Override
    public void run() {
        boolean stop = false;
        PrintWriter fsortida = null;
        BufferedReader fentrada = null;
        
        while (!stop) {
            try {           
                System.out.println("Client " + this.numClients + " connectat... ");
                try {
                    fsortida = new PrintWriter(client.getOutputStream(), true);
                    fentrada = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
                    
                    if ((cadena = fentrada.readLine()) != null) {
                        System.out.println("Nom Client (" + this.numClients + "): " + cadena);
                    }
                } catch (SocketException e) { 
                    stop = true;
                }
                
                while(!stop) {
                    try {
                        cadena = fentrada.readLine();
                    } catch (SocketException e) { 
                        stop = true;
                    }
                    
                    if (cadena.equals("//sortir")){
//                        System.out.println("Connexió " + this.registre + " client tancada... ");
                        stop = true;
                    }
                }

                while ((cadena = fentrada.readLine()) != "") {                
                    if (cadena.startsWith("//name ")) {
                        this.registre = cadena.substring(7, cadena.length()).toString();
                        System.out.println("Client " + this.registre + " connectat... ");                    
                    } else if (!cadena.equals("//sortir")) {
    //                    fsortida.println(cadena);
                        System.out.println("Rebent: " + cadena);
                        //Retornem missatges
                        fsortida.println(this.registre + ": " + cadena);
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
}

