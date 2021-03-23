/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenm6uf3_marianavarro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
/**
 *
 * @author maria
 */
public class ExamenM6UF3_MariaNavarro {

    static XPathQueryService servei;
    static Scanner sc = new Scanner(System.in);
    static String driver = "org.exist.xmldb.DatabaseImpl";
    static Collection col = null;
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db";
    static String usu = "admin";
    static String usuPass = "alumne";
    static int numero = 0; 
    
    public static void main(String[] args) throws XMLDBException {
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);
        } catch(Exception e) {
            System.out.println("Error en iniciar eXistdb" + e);
        }
        
        col = DatabaseManager.getCollection(URI, usu, usuPass);
        servei =(XPathQueryService) col.getService("XPathQueryService", "1.0");
        if (col == null){
            System.out.println("la coleccio no existeix");
        }
        
        while (numero!=7){
            System.out.println("Fica 1 per mostrar els dies emmagatzemats");
            System.out.println("Fica 2 per mostrar dia i quantitat en que s’ha produït el màxim de nous casos");
            System.out.println("Fica 3 per mostrar el dia i la quantitat en que s’ha produït el màxim de defuncions diàries");
            System.out.println("Fica 4 per mostrar la mitjana de nous casos i de defuncions de tot l’arxiu");
            System.out.println("Fica 5 per inserir"); 
            System.out.println("Fica 6 per esborrar"); 
            System.out.println("Fica 7 si no vols fer res"); 

            numero = sc.nextInt();

            switch(numero){
                case 1 :    mostrarDies();                            
                    break;
                case 2 :    mostrarMaxNous();
                    break;
                case 3 :    mostrarMaxDef();
                    break;
                case 4 :    mostrarMitjana();
                    break;
                case 5:     inserir();
                    break;
                case 6:     esborrar();
                    break;
            }
        }
        col.close(); 
    }   

    private static void inserir() throws XMLDBException {
        String data = "";
        int nous = 0;
        int defuncions = 0;
        int totalCasos = 0;
        int totalDef = 0;   
        ResourceSet result, result2;
        
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introdueix la data: ");
            data = in.readLine();
            
            System.out.println("Introdueix el numero de casos nous: ");
            nous = sc.nextInt();
                    
            System.out.println("Introdueix el numero de defuncions: ");
            defuncions = sc.nextInt();
            
            System.out.println("Introdueix el numero total de casos: ");
            totalCasos = sc.nextInt();
            
            System.out.println("Introdueix el numero total de defuncions: ");
            totalDef = sc.nextInt();
            
        } catch (IOException e) {
            System.out.println("Error en llegir");
            e.printStackTrace();
        }
        result2 = servei.query("for $casos in //row[data = '" + data + "'] return $casos");
        
        ResourceIterator i;
        i = result2.getIterator();        
        if (!i.hasMoreResources()){
           result = servei.query("update insert <row><data>"+ data + "</data><nous_casos_diaris_confirmats>" 
                   + nous + "</nous_casos_diaris_confirmats><defuncions_di_ries>"+ defuncions + 
                   "</defuncions_di_ries><total_de_casos_confirmats>"+ totalCasos +"</total_de_casos_confirmats>"
                   + "<total_de_defuncions>" + totalDef + "</total_de_defuncions></row> into /response/rows");
        } else { 
           System.out.println("la consulta no retorna res perque ja existeix casos registrats amb aquesta data");
        }
    }

    private static void esborrar() throws XMLDBException {
        String data = "";
        ResourceSet result;
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introdueix la data: ");
            data = in.readLine();
        } catch (IOException e) {
            System.out.println("Error en llegir");
            e.printStackTrace();
        }        
        
        result = servei.query("for $casos in //row[data = '" + data + "'] return $casos");
        
        ResourceIterator i;
        i = result.getIterator();
        if (i.hasMoreResources()){
           result = servei.query("update delete //row[data = '" + data + "']");
        } else { 
           System.out.println("la consulta no retorna res perque no existeix el departament");
        }    
    }

    private static void mostrarDies() throws XMLDBException {
        ResourceSet result;               
        
        
        result = servei.query("let $d := //row/data/text() \n" +
                              "return $d");
        
        ResourceIterator i;
        i = result.getIterator();
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("" + (String)r.getContent());
        }
    }

    private static void mostrarMaxNous() throws XMLDBException{
        ResourceSet result;        
        
        result = servei.query("let $n := //row[nous_casos_diaris_confirmats = max(nous_casos_diaris_confirmats)]/nous_casos_diaris_confirmats/text()\n" +
                              "let $d := //row[nous_casos_diaris_confirmats = max(nous_casos_diaris_confirmats)]//data\n" +
                              "return concat('Data: ',$d,' Numero de casos: ',$n)");
        
        ResourceIterator i;
        i = result.getIterator();
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("" + (String)r.getContent());
        }
    }

    private static void mostrarMaxDef() throws XMLDBException {
        ResourceSet result;        
        
        result = servei.query("let $n := //row[total_de_defuncions = max(total_de_defuncions)]/total_de_defuncions/text()\n" +
                              "let $d := //row[total_de_defuncions = max(total_de_defuncions)]//data\n" +
                              "return concat('Data: ',$d,' Numero de defuncions: ',$n)");
        
        ResourceIterator i;
        i = result.getIterator();
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("" + (String)r.getContent());
        }
    }

    private static void mostrarMitjana() throws XMLDBException {
        ResourceSet result;        
        
        result = servei.query("let $n := round(avg(//nous_casos_diaris_confirmats))\n" +
                              "let $d := round(avg(//defuncions_di_ries))\n" +
                              "return concat('Mitjana casos nous: ',$n,' Mitjana de defuncions: ',$d)");
        
        ResourceIterator i;
        i = result.getIterator();
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("" + (String)r.getContent());
        }
        
    }
    
    
}
