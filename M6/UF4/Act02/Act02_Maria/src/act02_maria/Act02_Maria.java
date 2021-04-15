package act02_maria;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import ElsMeusBeans.Producte;
import ElsMeusBeans.Comanda;
import ElsMeusBeans.Venda;
import java.math.BigDecimal;
import java.util.Scanner;
import org.neodatis.odb.Objects;

/**
 *
 * @author maria
 */
public class Act02_Maria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int idproducte = 0;
        int quantitat = 0;
        
        //Creo un array de 10 productes
        Producte[] pro = new Producte[10];
        pro[0] = new Producte(1, "Animal Crossing: New Horizons (Nintendo Switch)", 10, 3, 60);
        pro[1] = new Producte(2, "Just Dance 2021 (Nintendo Switch)", 9, 2, 40);
        pro[2] = new Producte(3, "FIFA 21 Legacy Edition (Nintendo Switch)", 7, 3, 55);
        pro[3] = new Producte(4, "Ring Fit Adventure (Nintendo Switch)", 5, 2, 80);
        pro[4] = new Producte(5, "The Legend of Zelda: Skyward Sword HD (Nintendo Switch)", 10, 3, 60);
        pro[5] = new Producte(6, "The Legend Of Zelda: Breath Of The Wild (Nintendo Switch)", 8, 5, 70);
        pro[6] = new Producte(7, "Luigi's Mansion 3 (Nintendo Switch)", 6, 6, 60);
        pro[7] = new Producte(8, "New Super Mario Bros. U Deluxe (Nintendo Switch)", 6, 2, 60);
        pro[8] = new Producte(9, "Pokémon: Espada (Nintendo Switch)", 9, 1, 56);
        pro[9] = new Producte(10, "Super Mario Party (Nintendo Switch)", 7, 6, 60);
       
        System.out.println("Introdueix el id del producte: ");
        idproducte = scan.nextInt();
        System.out.println("Introdueix la quantitat de productes que vols comprar: ");
            quantitat = scan.nextInt();
        
        ODB odb = ODBFactory.open("Producte_com.BD");
        IQuery query = new CriteriaQuery(Producte.class,
                Where.equal("idproducte",idproducte));
        Objects<Producte> objectes = odb.getObjects(query);
               
        try{
            for (int i = 0; i < pro.length; i++) {
                
                if (pro[i].getIdproducte() == idproducte) { 
                    System.out.println(i);
                    pro[i] = (Producte) objectes.getFirst();
                    System.out.println("ID=>" + idproducte + ": " + pro[i].getDescripcio() +
                        "*ESTOC.ACT: " + pro[i].getStockactual() + "*PVP: " + pro[i].getPvp() +
                        "*ESTOC.MIN: " + pro[i].getStockminim());
            
                       
//                    if(quantitat>0) {
//                        java.sql.Date dataActual = getCurrentDate();
//                        System.out.println("Quantitat a vendre: " + quantitat);
//
//                        if(actualitzaEstoc(pro[i],odb,quantitat)){
//                            int numVenda = obtenirNumVenda(odb);
//                            Venda ven =
//                                    new Venda(numVenda, idproducte, dataActual, quantitat);
//                            odb.store(ven);
//                            System.out.println("VENDA: " + numVenda + "INSERTA...");
//                        } else
//                            System.out.println("VENDA NO INSERTADA . NO HI HA ESTOC...");
//                    } else {
//                        System.out.println("LA QUANTITAT HA DE SER MAJOR DE " + quantitat);
//                    } 
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NO EXISTEIX EL PRODUCTE " + e.getMessage());
        } finally {
            odb.close();
        }
    }
   
   
    private static boolean actualitzaEstoc (Producte producte, ODB odb, int quantitat) {
        Comanda comanda = new Comanda();
        java.sql.Date dataActual = getCurrentDate();
        producte.addPropertyChangeListener(comanda);
        int nouEstoc = producte.getStockactual() - quantitat;
       
        boolean actualitzar = false;
        producte.setStockactual(nouEstoc);
       
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
            odb.store(producte);
            System.out.println("ESTOC ACTUALITZAT");
            actualitzar = true;
        }
        return actualitzar;
    }
   
    private static int obtenirNumComanda(ODB odb) {
        Values val4 = odb.getValues(new
                    ValuesCriteriaQuery(Comanda.class).max("numComanda", "com_max"));
        ObjectValues ov4 = val4.nextValues();
        BigDecimal maxim = (BigDecimal) ov4.getByAlias("com_max");
       
        return maxim.intValue()+1;
       
    }
   
    private static int obtenirNumVenda(ODB odb) {
        Values val4 = odb.getValues(new
                    ValuesCriteriaQuery(Venda.class).max("numVenda", "ven_max"));
        ObjectValues ov4 = val4.nextValues();
        BigDecimal maxim = (BigDecimal) ov4.getByAlias("ven_max");
       
        return maxim.intValue()+1;
       
    }
   
    private static java.sql.Date getCurrentDate(){
        java.util.Date avui = new java.util.Date();
        return new java.sql.Date(avui.getTime());
    }
   
}