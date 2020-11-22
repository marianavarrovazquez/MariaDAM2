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
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continua = true;
        
        //camp per propietari i vehicles
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        //camps propietari
        String nom;
        String dNaixement; //el transformare en data mes endavant
        int tlf;
        boolean minusvalidesa;
        
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
        
        
        
    }
}
