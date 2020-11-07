package persistenciafitxers;

/*
*File: PersistenciFitxers.java
*Author: Maria Navarro
*Date: 18-10-2020
*Description: Activitat 4 Practica UF1
*/






//hadjek
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersistenciaFitxers {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
      
        // per a carregar en memòria un arxiu xml
        File arxiu = new File("alumnes.xml");
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
            /*
                // Recorro sus hijos
                if(node.hasChildNodes()){
                    NodeList fills = node.getChildNodes();
                    for(int k = 0; k < fills.getLength() ;k++){
                        if (node.getNodeType() == Node.ELEMENT_NODE){
                            System.out.println("Nom " + node.getNodeName() + " Valor: " + node.getTextContent());
                        }
                    }
                }
        
                System.out.println("atributs: \n");
                // Recorro sus atributos
                if(node.hasAttributes()){
                    NamedNodeMap attributes = node.getAttributes();
                    for(int k = 0; k < node.getAttributes().getLength() ;k++){
                        System.out.println("Nom Atribut " + attributes.item(k).getNodeName() + " Valor: " + attributes.item(k).getTextContent());
                    }
                }
            */
            System.out.println("\n");
        }        
    }
    
    
    
 /*   public static boolean mostraElements(Element node) {
        
        System.out.println("Node: [" + node.getNodeName() + "] : " + node.getTextContent());
        
        if(node.hasAttributes()){
            NamedNodeMap attributes = node.getAttributes();
            for(int k = 0; k < node.getAttributes().getLength() ;k++){
                System.out.println("Nom Atribut " + attributes.item(k).getNodeName() + " Valor: " + attributes.item(k).getTextContent());
            }
        }
        
        if(node.hasChildNodes()){
            NodeList fills = node.getChildNodes();
            for(int k = 0; k < fills.getLength() ;k++){
                Node nodo = fills.item(k);
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    mostraElements((Element)node);
                }
            }
        }
        
        return false;
        
    }*/

}