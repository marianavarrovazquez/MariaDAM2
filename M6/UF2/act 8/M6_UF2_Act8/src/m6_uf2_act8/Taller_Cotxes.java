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
        
        //variable per llistar
        int opcio;
        
        //boolean per continuar els bucles
        boolean continua = true;
        
        //contador per continuar el bucle
        int contador;
                
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
            
            System.out.println("Data de naixement del propietari \"dd/MM/yyyy\" : ");
            dNaixement = scan.next();
            //convertim el string a date
            Date dataN = sdf.parse(dNaixement);
            
            System.out.println("Telefon de contacte del propietari: ");
            tlf = scan.nextInt();
            
            System.out.println("Si el propietari pateix alguna minusvalidesa introdueix true || si no te cap introdueix false");
            minusvalid = scan.nextBoolean();
            
            //creem la classe propietaris i indiquem els camps que te
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
            scan.nextLine();
            
            System.out.println("Data de fabricació del vehicle \"dd/MM/yyyy\": ");
            dFabricacio = scan.next();
            //convertim el string a date
            Date dataF = sdf.parse(dFabricacio);
            
            System.out.println("Numero de portes del vehicle: ");
            portes = scan.nextInt();
            
            System.out.println("Si el vehicle consumeix diesel introdueix true || introdueix false en el cas de que utilitzi gasolina");
            diesel = scan.nextBoolean();
            
            //creem la classe vehicles i indiquem els camps que te
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
        //tanquem la bdoo
        em.getTransaction().commit();
        continua = true;
        
        //llistar les dades dels vehicles i dels propietaris de la bdoo
        while(continua == true) {
            System.out.println("1 = Si vols llistar per propietaris || 2 = Si vols llistar per vehicles ");
            opcio = scan.nextInt();
            
            if(opcio == 1) {
                //consulta a la bdoo
                TypedQuery<Propietaris> query = em.createQuery("SELECT propietari FROM Propietaris propietari", Propietaris.class);
                List<Propietaris> resultat = query.getResultList();
                for (Propietaris propietari : resultat) {
                    //mostrem la consulta per pantalla
                    System.out.println(propietari);
                }
            } else {
                //consulta a la bdoo
                TypedQuery<Vehicles> query = em.createQuery("SELECT vehicle FROM Vehicles vehicle", Vehicles.class);
                List<Vehicles> resultat = query.getResultList();
                for (Vehicles vehicle : resultat) {
                    //mostrem la consulta per pantalla
                    System.out.println(vehicle);
                }
            }
            
            System.out.println("Vols continuar? SI:1 / NO:0");
            contador = scan.nextInt();
            
            if (contador == 1) {
                continua = true;
            } else {
                continua = false;
            }  
        }
    }
}
