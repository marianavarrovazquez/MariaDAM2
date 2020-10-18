package persistenciafitxers;

/*
*File: PersistenciFitxers.java
*Author: Maria Navarro
*Date: 18-10-2020
*Description: Activitat 4 Practica UF1
*/

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersistenciaFitxers {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
      
        // per a carregar en memòria un arxiu xml
        File arxiu = new File("exercici4.xml");
        // Creo una instancia de DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // Creo un documentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        // Obtengo el documento, a partir del XML
        Document doc = dBuilder.parse(arxiu);

        //per obtenir el node arrel
        Element nodeArrel = doc.getDocumentElement();
        
        //Per obtenir els nodes fill d’un node useu el mètode getChildNodes()
        NodeList nodeChild =  doc.getChildNodes();
        
        for (int i = 0; i < nodeChild.getLength(); i++) {
            Node node = nodeChild.item(i);
            System.out.println("Node: " + node.getNodeName());
            
            System.out.println("fills: \n");
            // Recorro sus hijos
            for(int j = 0; j < node.getChildNodes().getLength(); j++){
                Node fills = node.getChildNodes().item(j);
                System.out.println("Node fill: " + fills.getNodeName() + " Valor: "+ fills.getTextContent());
            }
            
            System.out.println("atributs: \n");
            // Recorro sus atributos
            for(int k = 0; k < node.getAttributes().getLength() ;k++){
                Node atribut = node.getAttributes().item(k);
                System.out.println("Nom Atribut " + atribut.getNodeName() + " Valor: " + atribut.getTextContent());
            }
            
            System.out.println("\n");
        }        
    }
}