package persistenciafitxers;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PersistenciaFitxers {

    public static void main(String[] args) throws ParserConfigurationException {
        // per a carregar en memòria un arxiu xml
        File file = new File("C:\\Users\\maria\\OneDrive\\Escritorio\\DAM2\\M6\\UF1\\exercici4\\exercici4.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        //per obtenir el node arrel
        Element nodeArrel = doc.getDocumentElement();

        //Per obtenir els nodes fill d’un node useu el mètode getChildNodes()
        //Per obtenir els atributs d’un node, useu el mètode getAttributes()
        //Per obtenir el nom, el tipus i el valor d’un node, cerqueu els mètodes apropiats.

    }
    
}
