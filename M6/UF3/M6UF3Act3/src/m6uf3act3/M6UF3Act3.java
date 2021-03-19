package m6uf3act3;

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
public class M6UF3Act3 {
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
        
        while (numero!=3){
            System.out.println("Fica 0 per inserir");
            System.out.println("Fica 1 per eliminar"); 
            System.out.println("Fica 2 per modificar"); 
            System.out.println("Fica 3 si no vols fer res"); 

            numero = sc.nextInt();

            if(numero == 0) {
                insereix();
            } else if(numero == 1) {
                eliminar();
            } else if (numero == 2) {
                modificar();
            } else {
                
            } 
        }
        col.close(); 
    } 
    
    public static void insereix() throws XMLDBException {
        int num = 0;
        String localitat = null;
        String nom = null;
        ResourceSet result;
        
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introdueix el numero de departament: ");
            num = sc.nextInt();
            
            System.out.println("Introdueix el nom: ");
            nom = in.readLine();
            
            System.out.println("Introdueix la localitat: ");
            localitat = in.readLine();
            
        } catch (IOException e) {
            System.out.println("Error en llegir");
            e.printStackTrace();
        }
 
        ResourceSet result2 = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO = " + num + "] return $dep");
        
        ResourceIterator i;
        i = result2.getIterator();        
        if (!i.hasMoreResources()){
           result = servei.query("update insert <DEP_ROW><DEPT_NO>"+ num + "</DEPT_NO><DNOMBRE>" + nom + "</DNOMBRE><LOC>"+ localitat + "</LOC></DEP_ROW> into /departamentos");
        } else { 
           System.out.println("la consulta no retorna res perque ja existeix el departament");
        }
    }

    private static void eliminar() throws XMLDBException {
        int num = 0;
        ResourceSet result;
        
        System.out.println("Introdueix el numero de departament: ");
        num = sc.nextInt();
        
        result = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO = " + num + "] return $dep");
        
        ResourceIterator i;
        i = result.getIterator();
        if (i.hasMoreResources()){
           result = servei.query("update delete /departamentos/DEP_ROW[DEPT_NO = " + num + "]");
        } else { 
           System.out.println("la consulta no retorna res perque no existeix el departament");
        }    
    }

    private static void modificar() throws XMLDBException {
        int num = 0;
        String localitat = null;
        String nom = null;
        ResourceSet result;
        ResourceSet result2;
        ResourceSet result3;
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introdueix el numero de departament: ");
            num = sc.nextInt();
            
            System.out.println("Introdueix el nou nom del departament: ");
            nom = in.readLine();
            
            System.out.println("Introdueix la nova localitat del departament: ");
            localitat = in.readLine();
            
        } catch (IOException e) {
            System.out.println("Error en llegir");
            e.printStackTrace();
        }
        
        result = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO = " + num + "] return $dep");
        
        ResourceIterator i;
        i = result.getIterator();
        if (i.hasMoreResources()){
            result2 = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO = " + num + "] return $dep");
            
            i = result2.getIterator();            
            while (i.hasMoreResources()) {
                Resource resource = i.nextResource();
                result = servei.query("update replace /departamentos/DEP_ROW[DEPT_NO = " + num + "]/DNOMBRE with <DNOMBRE>" + nom + "</DNOMBRE>");
                result3 = servei.query("update replace /departamentos/DEP_ROW[DEPT_NO = " + num + "]/LOC with <LOC>" + localitat + "</LOC>");
            }   
        } else { 
            System.out.println("la consulta no retorna res perque no existeix el departament");
        }            
    }
}