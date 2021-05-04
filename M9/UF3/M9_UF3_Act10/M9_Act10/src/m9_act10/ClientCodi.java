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
    static String cadena = "";
    static String name = "";
    static String mensRebut = "";
    static boolean desconectar = false;

    public ClientCodi(Socket client) {
        this.client = client;
    }
        
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
        
        System.out.println("//name --> Per iniciar sessio \n "
                + "//message --> Per enviar missatges \n "
                + "//sortir --> Desconectarse \n");
        
        System.out.println("Introdueix el teu nom d'usuari: ");
        //Lectura teclat
        name = in.readLine();
        
        while (name == null || !name.startsWith("//name ")) {
            System.out.println("Nom d'usuari no valid...");
            name = in.readLine();
        }
        
        Runnable run = new ClientCodi(client);
        Thread server = new Thread(run);
        
        server.start();
        fsortida.println(name);
        
        name = name.subSequence(7, name.length()).toString();
        System.out.println("Connectat correctament... Hola " + name + "\n");
               
        System.out.println("//message --> Per enviar missatges \n "
                + "//sortir --> Desconectarse \n");
        
        cadena = in.readLine();
        while (cadena != null && !cadena.startsWith("//sortir")) {
            //Enviament cadena al servidor
            fsortida.println(name + ": " +cadena + "\n");
            //Rebuda cadena del servidor
            mensRebut = fentrada.readLine();
            if (!mensRebut.startsWith(name)) {
                System.out.println(mensRebut + "\n");
            }
            //Lectura del teclat
            cadena = in.readLine();
        }
        
        System.out.println("Finalització de l'enviament...");
        fsortida.println(cadena);
        fsortida.close();
        fentrada.close();
        in.close();
        client.close();
    }

    @Override
    public void run() {
        BufferedReader fentrada = null;
        try {
            //FLUX D'ENTRADA AL SERVIDOR
            fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (desconectar == false) {
                try {
                    mensRebut = fentrada.readLine();
                    
                    if (mensRebut == null) {
                        desconectar = true;
                    } else {
                        System.out.println(mensRebut);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ClientCodi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientCodi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fentrada.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientCodi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

