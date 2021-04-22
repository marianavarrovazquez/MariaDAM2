/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act02_omplirvenda;

import java.math.BigDecimal;
import java.util.Scanner;
import org.neodatis.odb.*;

import java.math.BigDecimal;
import java.util.Scanner;

import ElsMeusBeans.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author maria
 */
public class Act02_OmplirVenda {
    public static void main(String[] args) {
        //Dades d'entrada per a la venda
        int idproducte;
        int quantitat;
        Scanner scan = new Scanner(System.in);
        
        if (args.length > 0) {
            idproducte = Integer.parseInt(args[0]);
            quantitat = Integer.parseInt(args[1]);
        } else {
            System.out.println("Introdueix el id del producte: ");            
            idproducte = scan.nextInt();
            
            System.out.println("Introdueix la quantitat del producte: ");            
            quantitat = scan.nextInt();            
        }
        
        //Obrir la base de dades
        ODB odb = ODBFactory.open("Producte_com.BD");
        //Es comprova si n'hi ha el producte
        IQuery query = new CriteriaQuery(Producte.class,
                            Where.equal("idproducte",idproducte));
        Objects<Producte> objectes = odb.getObjects(query);
       
        try{
            //Obté només el primer objecte trobat
            Producte pro = (Producte) objectes.getFirst();
            System.out.println("ID=>" + idproducte + ": " + pro.getDescripcio() +
                    "*ESTOC.ACT: " + pro.getStockactual() + "*PVP: " + pro.getPvp() +
                    "*ESTOC.MIN: " + pro.getStockminim());
            if(quantitat>0) {//Comprovar quantitat mes gran que 0
                java.sql.Date dataActual = getCurrentDate();//Obtenir data actual
                System.out.println("Quantitat a vendre: " + quantitat);
               
                if(actualitzaEstoc(pro,odb,quantitat)){
                    int numVenda = obtenirNumVenda(odb);
                    Venda ven =
                            new Venda(numVenda, idproducte, dataActual, quantitat);
                    odb.store(ven);//Emmagatzema la venda
                    System.out.println("VENDA: " + numVenda + " INSERTA...");
                } else
                    System.out.println("VENDA NO INSERTADA . NO HI HA ESTOC...");
            } else {
                System.out.println("LA QUANTITAT HA DE SER MAJOR DE 0");
            }  
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NO EXISTEIX EL PRODUCTE");
        } finally {
            odb.close();//Tancar la base de dades
        }
    }//Fi OmplirVenda (main)
      
    //Actualitzar estoc o Generar comanda
    private static boolean actualitzaEstoc (Producte producte, ODB odb, int quantitat) {
        Comanda comanda = new Comanda();
        java.sql.Date dataActual = getCurrentDate();
        producte.addPropertyChangeListener(comanda);//Afegir oient
        int nouEstoc = producte.getStockactual() - quantitat;//Càlcul d'estoc
       
        boolean actualitzar = false;
        
        producte.setStockactual(nouEstoc);//Es canvia l'estoc actual
       
        if (comanda.isDemana()) {
            System.out.println("FER COMANDA EN PRODUCTE: " +
                    producte.getDescripcio() + " QUANTITAT: " + quantitat);
            int numComanda = obtenirNumComanda(odb);
            comanda.setQuantitat(quantitat);
            comanda.setIdproducte(producte.getIdproducte());
            comanda.setNumcomanda(numComanda);
            comanda.setData(dataActual);
            odb.store(comanda);
            System.out.println("COMANDA " + numComanda + " GENERAT...");
        } else {
            odb.store(producte);//Actualitza l'estoc a la base de dades
            System.out.println("ESTOC ACTUALITZAT");
            actualitzar = true;
        }
        return actualitzar;
    }
   
    //Obtenir el núm. de comanda i inserir a la BD
    private static int obtenirNumComanda(ODB odb) {
        Values val4 = odb.getValues(new
                    ValuesCriteriaQuery(Comanda.class).max("numcomanda", "com_max"));
        ObjectValues ov4 = val4.nextValues();
        BigDecimal maxim = (BigDecimal) ov4.getByAlias("com_max");
       
        return maxim.intValue()+1;
    }//Fi d'obtenirNumComanda
   
    //Obtenir el núm. de venda i inserir a la BD
    private static int obtenirNumVenda(ODB odb) {
        Values val4 = odb.getValues(new
                    ValuesCriteriaQuery(Venda.class).max("numvenda", "ven_max"));
        ObjectValues ov4 = val4.nextValues();
        BigDecimal maxim = (BigDecimal) ov4.getByAlias("ven_max");
       
        return maxim.intValue()+1;       
    }//Fi d'obtenirNumVenda
   
    //Obtenir la data actual
    private static java.sql.Date getCurrentDate(){
        java.util.Date avui = new java.util.Date();
        return new java.sql.Date(avui.getTime());
    }//Fi de getCurrentDate
   
}//Fi de la classe