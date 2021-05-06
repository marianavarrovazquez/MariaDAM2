/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_act10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class ClientCodi implements Runnable {
    static Socket client;
    static boolean desconectar = false;
    static String name = "";

    public ClientCodi(Socket client) {
        this.client = client;
    }
        
    public void run() {
        BufferedReader fentrada = null;
        String mensRebut = "";
        while (!desconectar) {
            try {
                //FLUX D'ENTRADA AL SERVIDOR
                fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
                mensRebut = fentrada.readLine();
                
                if (mensRebut == "//sortir") {
                    desconectar = true;
                } else if (!mensRebut.startsWith(name) || mensRebut == null) {
                    System.out.println(mensRebut);
                    
                }
            } catch (SocketException e) { 
                desconectar = true;
            } catch (IOException ex) {
                Logger.getLogger(ClientCodi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void main (String[] args) throws Exception {
        String host = "localhost";
        int port = 60000;//Port remot
        Socket client = new Socket(host, port);

        String mensRebut = "";
        String cadena = "";
        
        //FLUX DE SORTIDA AL SERVIDOR
        PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

        //FLUX D'ENTRADA AL SERVIDOR
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //FLUX PER A ENTRADA ESTÀNDARD
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("***** BENVINGUT AL CHAT *****\n"
                + "//name --> Per iniciar sessio\n "
                + "//message --> Per enviar missatges\n"
                + "//sortir --> Desconectarse\n");
        
        System.out.println("Introdueix el teu nom d'usuari: ");
        //Lectura teclat
        name = in.readLine();
        
        while (name == null || !name.startsWith("//name ")) {
            System.out.println("***** Nom d'usuari no valid... Torna a intentar-ho*****");
            name = in.readLine();
        }
        
        Runnable run = new ClientCodi(client);
        Thread server = new Thread(run);
        
        server.start();
        fsortida.println(name);
        
        name = name.subSequence(7, name.length()).toString();
        System.out.println("***** Connectat correctament... Hola " + name + " *****\n");
               
        System.out.println("***** Comença a xatejar: *****");   
        cadena = in.readLine();
        while (cadena != null && (!cadena.equals("//sortir"))) {
            //Enviament cadena al servidor
            if (!cadena.startsWith("//message ")) {
                System.out.println("***** ERROR!!! Torna a enviar el missatge *****");
                cadena = in.readLine();
                cadena = cadena.replace("//message ", "");
                fsortida.println(name + ": " + cadena);
            } else {
                cadena = cadena.replace("//message ", "");
                fsortida.println(name + ": " + cadena);
            }
            cadena = in.readLine();
        }
        //fsortida.println(cadena);
        System.out.println("***** Finalització de l'enviament... Sessió Tancada *****");
        
        fsortida.close();
        fentrada.close();
        in.close();
        client.close();
    }
}