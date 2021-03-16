/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf3_act2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author maria y ivan
 */
public class M9_UF3_Act2 {
	
    public static void main (String[] args) {
        String urlTeclado;
        int port;
        URL url = null;
        Scanner scan = new Scanner(System.in);

        try {
            //Demana per pantalla la url i el llegeix
            System.out.println("Escriu la url: ");
            urlTeclado = scan.nextLine();

            //Demana per pantalla el port i el llegeix
            System.out.println("Escriu el port: ");
            port = scan.nextInt();

            //Llegim l'url i el port
            url = new URL("http", urlTeclado, port, "");
        } catch (MalformedURLException e) {e.printStackTrace(); }

        BufferedReader in;

        try{
            //Treiem per pantalla l'informacio de l'url creada anteriorment
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
            in.close();

        } catch (IOException e) {e.printStackTrace(); }
    }
}