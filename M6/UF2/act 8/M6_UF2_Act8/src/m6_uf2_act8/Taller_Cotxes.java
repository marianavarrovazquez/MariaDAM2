package m6_uf2_act8;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import javax.persistence.*;
import java.util.*;
/**
 *
 * @author maria
 */
public class Taller_Cotxes {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        
        //boolean per continuar els bucles
        boolean continua = true;
        //contador per continuar el bucle
        int contador = 0;
                
        //camp per propietari i vehicles
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        //camps propietari
        String nom;
        String dNaixement; //el transformare en data mes endavant
        int tlf;
        boolean minusvalid;
        
        //camps vehicles
        String marca;
        String dFabricacio; //el transformare en data mes endavant
        int portes;
        boolean diesel;
        
        //creo una bdoo
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/taller_Cotxes.odb");
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Introdueix el/s propietari/s");
        //comença a guardar informació a la bdoo
        em.getTransaction().begin();
        
        while(continua == true) {
            System.out.println("Nom del propietari: ");
            nom = scan.nextLine();
            
            System.out.println("Data de naixement del propietari: ");
            dNaixement = scan.next();
            //convertim el string a date
            Date dataN = sdf.parse(dNaixement);
            
            System.out.println("Telefon de contacte del propietari: ");
            tlf = scan.nextInt();
            
            System.out.println("Si el propietari pateix alguna minusvalidesa introdueix SI || si no te cap introdueix NO");
            minusvalid = scan.nextBoolean();
            
            //creem la clae propietaris i indiquem els camps que te
            Propietaris propietari;
            propietari = new Propietaris(nom, dataN, tlf, minusvalid);
            
            em.persist(propietari);
            
            System.out.println("Vols introduir un altre propietari? \n 1 = SI || 2 = NO");
            contador = scan.nextInt();
            
            if (contador == 1) {
                continua = true;
            } else {
                continua = false;
            }            
        }
        continua = true;
        
        System.out.println("Introdueix el/s vehicle/s");        
        while(continua == true) {
            System.out.println("Marca del vehicle: ");
            marca = scan.nextLine();
            
            System.out.println("Data de fabricació del vehicle: ");
            dFabricacio = scan.next();
            //convertim el string a date
            Date dataF = sdf.parse(dFabricacio);
            
            System.out.println("Numero de portes del vehicle: ");
            portes = scan.nextInt();
            
            System.out.println("Si el vehicle consumeix diesel introdueix SI || introdueix NO en el cas de que utilitzi gasolina");
            diesel = scan.nextBoolean();
            
            //creem la clae propietaris i indiquem els camps que te
            Vehicles vehicle;
            vehicle = new Vehicles(marca, dataF, portes, diesel);
            
            em.persist(vehicle);
            
            System.out.println("Vols introduir un altre vehicle? \n 1 = SI || 2 = NO");
            contador = scan.nextInt();
            
            if (contador == 1) {
                continua = true;
            } else {
                continua = false;
            }            
        }
        
        em.getTransaction().commit();
        continua = true;
        
        
    }
}
