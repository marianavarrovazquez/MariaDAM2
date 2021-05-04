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
public class ServerChat implements Runnable {
    
    Socket clientsocket;
    ServerSocket serversocket;
    Socket[] arraysocket;
    static int numClients;
    String cadena = "";
    
    public ServerChat(Socket clientsocket, ServerSocket serversocket, Socket[] arraysocket) {
        this.clientsocket = clientsocket;
        this.serversocket = serversocket;
        this.arraysocket = arraysocket;
        numClients++;
    }
    	
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int port = 60000;
        int clientsteclat;
        ServerSocket serversocket2 = new ServerSocket(port);
        

        System.out.print("Introdueix el numero de clients: ");
        clientsteclat = sc.nextInt();

        Socket[] arraysocket2 = new Socket[clientsteclat];
        ServerChat[] arrayRunnable = new ServerChat[clientsteclat];
        Thread[] arrayThread = new Thread[clientsteclat];
        
        for (int i = 0; i < arrayRunnable.length; i++){
            Socket clientsocket = serversocket2.accept();
            boolean bolean = false;
            for (int j = 0; j < arraysocket2.length; j++) {
		if (arraysocket2[i] == null && bolean == false) {
                    arraysocket2[i] = clientsocket;
                    bolean = true;
		}
            }
            
            arrayRunnable[i] = new ServerChat(clientsocket, serversocket2, arraysocket2);
            arrayThread[i] = new Thread(arrayRunnable[i]);
            arrayThread[i].start();
        }
    }

    @Override
    public void run() {
        boolean desconectar = false;
        
	while (!desconectar) {
            try {
                System.out.println("Esperant connexió... ");
                PrintWriter fsortida = null;
                BufferedReader fentrada = null;
                System.out.println("Client " + this.numClients + " connectat... ");

                try {
                    fsortida = new PrintWriter(clientsocket.getOutputStream(), true);
                    fentrada = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

                    if ((cadena = fentrada.readLine()) != null) {
                        cadena = cadena.subSequence(7, cadena.length()).toString();
                        System.out.println("Client " + this.numClients + " es diu " + cadena);
                    }
                    
		} catch (Exception e) {
                    desconectar = true;
		}
                
                while (!desconectar) {
                    try {
                        cadena = fentrada.readLine();
                    } catch (SocketException e) {
                        desconectar = true;
                    }
                    
//                    fsortida.println(cadena);
                    if (cadena != null) {
                        
			for (int i = 0; i < arraysocket.length; i++) {
                            if (arraysocket[i] != null) {
                                fsortida = new PrintWriter(arraysocket[i].getOutputStream(), true);
                                fsortida.println(cadena);
                            }
			}
                        System.out.println("Rebent: " + cadena);
                    } else {
                        desconectar = true;
                    }
                    
                }
                
                fentrada.close();
                fsortida.close();
                this.clientsocket.close();
                this.serversocket.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}