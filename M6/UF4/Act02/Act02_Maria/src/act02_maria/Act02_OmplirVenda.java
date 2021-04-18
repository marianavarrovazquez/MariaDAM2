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

import act02_maria.OmplirProductes;
/**
 *
 * @author maria
 */
public class Act02_OmplirVenda {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int idproducte = 0;
        int quantitat = 0;
        
        ODB odb = ODBFactory.open("Producte_com.BD");
        
        System.out.println("Introdueix el id del producte: ");
        idproducte = scan.nextInt();
        System.out.println("Introdueix la quantitat de productes que vols comprar: ");
        quantitat = scan.nextInt();
        
        
        IQuery query = new CriteriaQuery(Producte.class,
                Where.equal("idproducte",idproducte));
        Objects<Producte> objectes = odb.getObjects(query);
        
        try{
            for (int i = 1; i < OmplirProductes.getPro().length; i++) {
                if (OmplirProductes.getPro()[i].getIdproducte()
                        == idproducte) { 
                    
//                    pro[i] = (Producte) objectes.getFirst();
                                                               
                    if(OmplirProductes.getPro()[i].getStockactual() > OmplirProductes.getPro()[i].getStockminim()) {
                        
                        System.out.println("ID=>" + idproducte + ": " + OmplirProductes.getPro()[i].getDescripcio() +
                        "\nESTOC.ACT: " + OmplirProductes.getPro()[i].getStockactual() + 
                        "\nPVP: " + OmplirProductes.getPro()[i].getPvp() +
                        "\nESTOC.MIN: " + OmplirProductes.getPro()[i].getStockminim());
                                                
                        java.sql.Date dataActual = getCurrentDate();
                        System.out.println("Quantitat a vendre: " + quantitat);

                        if(actualitzaEstoc(OmplirProductes.getPro()[i],odb,quantitat)){
                            int numVenda = obtenirNumVenda(odb);
                            
                            Venda ven =
                                    new Venda(numVenda, idproducte, dataActual, quantitat);
                            odb.store(ven);
                            System.out.println("VENDA: " + numVenda + " INSERTA...");
                        } else {
                            System.out.println("VENDA NO INSERTADA. NO HI HA ESTOC...");
                        }    
                    } else {
//                        System.out.println("LA QUANTITAT HA DE SER MAJOR DE 0");
                        System.out.println("L'ESTOC ACTUAL ES INFERIOR AL ESTOC MINIM");
                    } 
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
                        producte.getDescripcio() + "\n QUANTITAT: " + quantitat);
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
                    ValuesCriteriaQuery(Comanda.class).max("numcomanda", "com_max"));
        ObjectValues ov4 = val4.nextValues();
        BigDecimal maxim = (BigDecimal) ov4.getByAlias("com_max");
       
        return maxim.intValue()+1;
       
    }
   
    private static int obtenirNumVenda(ODB odb) {
        Values val4 = odb.getValues(new
                    ValuesCriteriaQuery(Venda.class).max("numvenda", "ven_max"));
        ObjectValues ov4 = val4.nextValues();
        BigDecimal maxim = (BigDecimal) ov4.getByAlias("ven_max");
       
        return maxim.intValue()+1;
       
    }
   
    private static java.sql.Date getCurrentDate(){
        java.util.Date avui = new java.util.Date();
        return new java.sql.Date(avui.getTime());
    }
   
}