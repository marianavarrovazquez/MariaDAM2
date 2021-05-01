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
    static String cadena = "";
    static int numClient = 1;
    String name;
            
    Socket[] clientSocket;

    public ServerChat(Socket client, ServerSocket server, Socket[] clientSocket) {
        this.client = client;
        this.server = server;
        this.numClients++;
        this.clientSocket = clientSocket;
    }
    	
    public static void main (String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int port = 60000;
    
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.print("Introdueix el numero de clients que pots atendre: ");
        int numClients = scan.nextInt();

        ServerChat[] arrayRunnable = new ServerChat[numClients];
        Thread[] arrayThread = new Thread[numClients];
        Socket[] clientSocket = new Socket[numClients];
        
        for (int i = 0; i < arrayRunnable.length; i++) {
            boolean bolean = true;
            boolean desconectar = false;
            Socket client2 = null;
            
            try{
                client2 = serverSocket.accept();
                numClient = i;
            } catch (SocketException e) {
                bolean = false;
            }
            
            for (int j = 0; j < clientSocket.length; j++) {
                if (clientSocket[i] == null && desconectar == false) {
                    clientSocket[i] = client2;
                    desconectar = true;
                }
            }
            
            if(bolean) {
                arrayRunnable[i] = new ServerChat(client2, serverSocket, clientSocket);
                arrayThread[i] = new Thread(arrayRunnable[i]);
                arrayThread[i].start();
            }
        }
        
        serverSocket.close();
    }

    @Override
    public void run() {
        boolean desconectar = false;
        String cadenaName = cadena.substring(7, cadena.length()).toString();
        
        while (!desconectar) {
            try {           
                PrintWriter fsortida = null;
                BufferedReader fentrada = null;
                System.out.println("Client " + numClient + " connectat... ");
                try {
                    fsortida = new PrintWriter(client.getOutputStream(), true);
                    fentrada = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
                    fsortida.println("Connexio client " + numClient + " feta...");
                    if ((cadena = fentrada.readLine()) != null && cadena.startsWith("//name ")) {
                        String auxName = cadena.replace("//name", "");
                        for (int i = 1; i < clientSocket.length; i++) {
                            if (numClient != i) {
                                if (name == null || !name.equals(auxName)) {
                                    name = auxName;
                                }
                            }
                        }
                        
                        if (clientSocket.length <= 1){
                            name = auxName;
                        }
                        
                        System.out.println("Nom Client (" + numClient + "): " + cadenaName);
                    }
                } catch (SocketException e) { 
                    desconectar = true;
                }
                
                while(!desconectar) {
                    try {
                        cadena = fentrada.readLine();
                    } catch (SocketException e) { 
                        desconectar = true;
                    }
                    
                    if (cadena == null && cadena.equals("//sortir")){
                        System.out.println("Connexió " + name + " client tancada... ");
                        desconectar = true;
                    }
                    
                    if (!desconectar) {
                        fsortida.println(cadena);

                        if (cadena != null) {
                            for (int i = 0; i < clientSocket.length; i++) {
                                if (clientSocket[i] != null) {
                                    fsortida = new PrintWriter(this.clientSocket[i].getOutputStream(), true);
                                    fsortida.println(cadena);
                                }
                            }
                            System.out.println("Rebent: " + cadena);
                        }
                    }
                    
                }

//                while ((cadena = fentrada.readLine()) != "") {                
//                    if (cadena.startsWith("//name ")) {
//                        this.registre = cadena.substring(7, cadena.length()).toString();
//                        System.out.println("Client " + this.registre + " connectat... ");                    
//                    } else if (!cadena.equals("//sortir")) {
//    //                    fsortida.println(cadena);
//                        System.out.println("Rebent: " + cadena);
//                        //Retornem missatges
//                        fsortida.println(this.registre + ": " + cadena);
//                    } else if (cadena.equals("//sortir")){
//                        System.out.println("Connexió " + this.registre + " client tancada... ");
//                        break;
//                    }
//                }
                 try {
                    fentrada.close();
                    fsortida.close();
                } catch (NullPointerException e) {
                    // TODO: handle exception
                }

                this.client.close();
                this.server.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
