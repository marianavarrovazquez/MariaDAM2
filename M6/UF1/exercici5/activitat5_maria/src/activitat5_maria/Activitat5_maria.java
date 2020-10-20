
package activitat5_maria;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import static org.jcp.xml.dsig.internal.dom.DOMUtils.createElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
*File: PersistenciFitxers.java
*Author: Maria Navarro
*Date: 20-10-2020
*Description: Activitat 5 Practica UF1
*/

public class Activitat5_maria {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

    // per a carregar en memòria un arxiu xml
        File arxiu = new File("alumnes.xml");
        // Creo una instancia de DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // Creo un documentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        // Obtengo el documento, a partir del XML
        Document doc = dBuilder.parse(arxiu);

        //per obtenir el node arrel
        Element element = doc.getDocumentElement();
        
        //Per obtenir els nodes fill d’un node useu el mètode getChildNodes()
        NodeList nodeChild =  doc.getChildNodes();        
        
        Scanner scan = new Scanner (System.in);
       
        

    }
    
}
