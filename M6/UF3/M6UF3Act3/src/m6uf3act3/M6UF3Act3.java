/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * @param args the command line arguments
     */
    
    static XPathQueryService servei;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws XMLDBException {
        // TODO code application logic here
        String driver = "org.exist.xmldb.DatabaseImpl";
        Collection col = null;
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db";
        String usu = "admin";
        String usuPass = "alumne";
        
       
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);
        } catch(Exception e) {
            System.out.println("Error en iniciar eXistdb" + e);
        }
        
        System.out.println("Escriu un departament");
        String s = null;
        
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
        } catch (IOException e) {
            System.out.println("Error en llegir");
            e.printStackTrace();
        }
        int dep = Integer.parseInt(s);
        
        insereixdep();
       
        col = DatabaseManager.getCollection(URI, usu, usuPass);
        if (col == null)
            System.out.println("la coleccio no existeix");
       
        servei =(XPathQueryService) col.getService("XPathQueryService", "1.0");
        ResourceSet result =
                servei.query("for $em in /EMPLEADOS/EMP_ROW[DEPT_NO=20] return $em");
       
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources())
            System.out.println("la consulta no retorna res");
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println("" + (String)r.getContent());
        }
        col.close();
    } 
    
    public static void insereixdep() throws XMLDBException {
        int num = 0;
        String localitat = null;
        String nom = null;
        ResourceSet result;
        
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introdueix el numero: ");
            num = sc.nextInt();
            
            System.out.println("Introdueix el nom: ");
            nom = in.readLine();
            
            System.out.println("Introdueix la localitat: ");
            localitat = in.readLine();
            
        } catch (IOException e) {
            System.out.println("Error en llegir");
            e.printStackTrace();
        }
 
        ResourceSet result2 = servei.query("for $em in /departamentos/DEP_ROW[DEPT_NO=" +(Integer) num + "] return $em");
        
        ResourceIterator i;
        i = result2.getIterator();
        if (!i.hasMoreResources()){
           result = servei.query("update insert <departament><DEP_ROW><DEPT_NO = "+ (Integer) num+">");
            
            System.out.println("la consulta no retorna res");
        }    
        while (i.hasMoreResources()) {
            
        }
    }
    
}