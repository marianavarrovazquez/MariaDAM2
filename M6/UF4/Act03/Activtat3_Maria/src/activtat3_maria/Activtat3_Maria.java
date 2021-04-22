/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activtat3_maria;

import ElsMeusBeans.BaseDades;
import ElsMeusBeans.Comanda;
import ElsMeusBeans.Producte;
import ElsMeusBeans.Venda;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Activtat3_Maria {
    public static void main(String[] args) {
        //*     MYSQL*/
        String urldb = "jdbc:mysql://localhost/basedades";
        String usuari = "";
        String contrasenya = "";
        String driver = "com.mysql.jdbc.Driver";
        
        //Es crear un objecte BaseDades
        BaseDades bd = new BaseDades(urldb, usuari, contrasenya, driver);
        bd.setCrearConnexio(); //Es crea la connexió a la base de dades
        
        if (bd.getCrearConnexio()) {
            System.out.println("Connectat");
            
            System.out.println("======================================");
            System.out.println("LLISTA INICIAL DE PRODUCTES");
            VeureProductes(bd);
            
            //Crea una venda
            System.out.println("======================================");
            System.out.println("ES CREA VENDA DE ID 3 AMB QUANTITAT 2");
            CrearVenda(bd, 3, 2);//Si no hi ha estoc no es crea venda
            
            System.out.println("======================================");
            System.out.println("LLISTA DE PRODUCTES DESPRÉS DE CREAR VENDA");
            VeureProductes(bd);
            
            System.out.println("======================================");
            System.out.println("LLISTA DE VENDES");
            VeureVendes(bd);
            
            System.out.println("======================================");
            System.out.println("LLISTA DE COMANDES");
            VeureComandes(bd);
        } else System.out.println("NO connectat");
        //Tancar connexio
        bd.tancarConnexio();
        
    }//Fi main

    private static void VeureProductes(BaseDades bd) {
        ArrayList <Producte> llista = new ArrayList <Producte>();
        llista = bd.consultaPro("SELECT * FROM PRODUCTE");
        if (llista != null)
            for (int i = 0; i<llista.size(); i++) {
                Producte p = (Producte) llista.get(i);
                System.out.println((i++) + "ID=>  " + p.getDescripcio()
                    + " *ESTOC.ACT: " + p.getStockactual() + " *PVP: " + p.getPvp() +
                    " *ESTOC.MIN: " + p.getStockminim());
            }
    }//Fi VeureProductes

    private static void CrearVenda(BaseDades bd, int idproducte, int quantitat) {
        Producte prod = bd.consultarUnProducte(idproducte);
        java.sql.Date dataActual = getCurrentDate();//Data SQL
        if (prod != null) {
            if (bd.actualitzarStock(prod, quantitat, dataActual)>0) {
                String taula = "VENDES";
                int idvenda = bd.obtenirUltimID(taula);
                Venda ven = new 
                    Venda(idvenda, prod.getIdproducte(), dataActual, quantitat);
            
                if(bd.inserirVenda(ven)>0)
                    System.out.println("VENDA INSERIDA... ");
            
            } else
                System.out.println("NO ES POT FER LA VENDA, NO HI HA ESTOC...");
        } else {
            System.out.println("NO HI HA EL PRODUCTE");
        }
    }//Fi CrearVenda

    private static void VeureComandes(BaseDades bd) {
        ArrayList <Comanda> llista = new ArrayList<Comanda>();
        llista = bd.consultaCom("SELECT * FROM COMANDES");
        if (llista != null) {
            for (int i = 0; i<llista.size(); i++) {
                Comanda c = (Comanda) llista.get(i);
                Producte prod = bd.consultarUnProducte(c.getIdproducte());
                System.out.println("ID Comanda=>" + c.getNumcomanda()
                + "* Producte:" + prod.getDescripcio() + "* Quantitat: "
                + c.getQuantitat() + "* Data: " + c.getData());
            }
        }    
    }//Fi VeureComandes

    private static void VeureVendes(BaseDades bd) {
        ArrayList <Venda> llista = new ArrayList<Venda>();
        llista = bd.consultaVen("SELECT * FROM VENDES");
        if (llista != null) {
            for (int i = 0; i<llista.size(); i++) {
                Venda c = (Venda) llista.get(i);
                Producte prod = bd.consultarUnProducte(c.getIdproducte());
                System.out.println("ID Comanda=>" + c.getNumvenda()
                + "* Producte:" + prod.getDescripcio() + "* Quantitat: "
                + c.getQuantitat() + "* Data: " + c.getDatavenda());
            }
        }   
    }
    
    
    
}
