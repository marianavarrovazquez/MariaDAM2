/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf3_act3;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author maria
 */
public class M9_UF3_Act3 {

    @SuppressWarnings("rawtypes")
    public static void main (String[] args) {
        String url = args[0];
        int camps = Integer.parseInt(args[1]);
        String codi = args[2];        
        
    try {
        String cadena;
        
        URL urlSortida = new URL(url);
        URLConnection connexio = urlSortida.openConnection();

        System.out.println("===============================================================");
        System.out.println("ADREÇA, DARA I CONTINGUT");
        System.out.println("Adreça [getURL]: " + connexio.getURL());
        
        Date data = new Date(connexio.getLastModified());
        System.out.println("Data última modificació [getLastModified()]: " + data);
        System.out.println("Tipus de Contingut [getContentType()]" + connexio.getContentType());

        System.out.println("===============================================================");
        System.out.println("TOTS ELS CAMPS DE CAPÇALERA AMB getHeaderFields(): ");

        //Fem servir una estructura Map per a recuperar capçaleres
        Map campsCapçalera = connexio.getHeaderFields();
        Iterator it = campsCapçalera.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey() + ":" + map.getValue());
        }
       
        System.out.println("===============================================================");
        System.out.println("Camps "+ camps +" de Capçalera");
        for(int i = 0; i < camps; i++) {
            System.out.println("getHeaderField("+i+")=> " + connexio.getHeaderField(i));
        }
        System.out.println("===============================================================");

        System.out.println("Contingut de [url.getFile()]: " + urlSortida.getFile());
        BufferedReader pagina = new BufferedReader(new InputStreamReader(urlSortida.openStream()));
        
        while ((cadena = pagina.readLine()) != null) {
            if(cadena.contains(codi.subSequence(0, codi.length()-1))) {
                System.out.println(cadena);
            }
        }
    }
    catch (MalformedURLException e) { e.printStackTrace();}
    catch (IOException e) {e.printStackTrace();}

    }
}