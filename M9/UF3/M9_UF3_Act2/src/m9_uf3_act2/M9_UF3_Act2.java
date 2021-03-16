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
			System.out.println("Escriu la url: ");
                        urlTeclado = scan.nextLine();
                        
                        System.out.println("Escriu el port: ");
                        port = scan.nextInt();
                        
			url = new URL("http", urlTeclado, port, "");
//			Visualitzar (url);
			
		} catch (MalformedURLException e) {e.printStackTrace(); }
                
                BufferedReader in;
                
                try{
                    InputStream inputStream = url.openStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			
			String inputLine;
			
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
			
		} catch (IOException e) {e.printStackTrace(); }

		
	}
	
//	private static void Visualitzar(URL url) {
//		
//		System.out.println("\tURL complerta: "+url.toString());
//		System.out.println("\tgetProtocol: "+url.getProtocol());
//		System.out.println("\tgetHost: "+url.getHost());
//		System.out.println("\tgetPort: "+url.getPort());
//		System.out.println("\tgetFile: "+url.getFile());
//		System.out.println("\tgetUserInfo: "+url.getUserInfo());
//		System.out.println("\tgetPath: "+url.getPath());
//		System.out.println("\tgetAuthority: "+url.getAuthority());
//		System.out.println("\tgetQuery: "+url.getQuery());
//		System.out.println("=====================================================");
//	}

}