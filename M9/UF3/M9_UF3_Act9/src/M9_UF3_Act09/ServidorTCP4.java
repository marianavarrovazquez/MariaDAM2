package M9_UF3_Act09;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author maria i ivan
 */

public class ServidorTCP4 implements Runnable {
    
    Socket client;
    ServerSocket server;
    static int num;
    String cadena = "";

    public ServidorTCP4(Socket client, ServerSocket server) {
        this.client = client;
        this.server = server;
        this.num++;
    }
    	
    public static void main (String[] args) throws Exception {
        int port = 60000;
        ServerSocket servidor = new ServerSocket(port);
        Scanner scan = new Scanner(System.in);

        System.out.print("Introdueix el numero de clients: ");
        int clients = scan.nextInt();

        Runnable[] arrayRunnable = new Runnable[num];
        Thread[] arrayThread = new Thread[num];
        
        for (int i = 0; i < arrayRunnable.length; i++){
            Socket client2 = servidor.accept();
            arrayRunnable[i] = new ServidorTCP4(client2, servidor);
            arrayThread[i] = new Thread(arrayRunnable[i]);
            arrayThread[i].start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Esperant connexió... ");
            System.out.println("Client " + this.num + " connectat");

            PrintWriter fsortida = new PrintWriter(this.client.getOutputStream(), true);

            BufferedReader fentrada = new BufferedReader(new InputStreamReader(this.client.getInputStream()));

            while ((cadena = fentrada.readLine()) != null) {
                fsortida.println(cadena);
                System.out.println("Rebent: " + cadena);
                if (cadena.equals("*")) break;
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
