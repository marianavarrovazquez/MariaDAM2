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
        
    public static void main(String[] args) throws XMLDBException {
        // TODO code application logic here
        
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

        System.out.println("1. Insereix");
        System.out.println("2. Elimina"); 
        System.out.println("3. Modifica"); 
        
        int numero = 0;
        numero = sc.nextInt();
        
        if(numero == 1) {
            insereixdep();
        } else if(numero == 2) {
            
        } else if (numero == 3) {
        
        }else {}
            col.close(); 
        
    } 
    
    public static void insereixdep() throws XMLDBException {
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
 
        ResourceSet result2 = servei.query("for $dep in /departamentos/DEP_ROW[DEPT_NO = " +(Integer) num + "] return $dep");
        
        ResourceIterator i;
        i = result2.getIterator();
        if (!i.hasMoreResources()){
           result = servei.query("update insert <DEP_ROW><DEPT_NO>"+(Integer) num + "</DEPT_NO><DNOMBRE>" + nom + "</DNOMBRE><LOC>"+ localitat + "</LOC></DEP_ROW> into /departamentos");
        } else { 
            System.out.println("la consulta no retorna res");
        }    
        while (i.hasMoreResources()) {
            
        }
    }
    
}