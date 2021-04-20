/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act02_maria;

import ElsMeusBeans.Producte;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author maria
 */
public class OmplirProductes {
    
    public static void main(String[] args) {
        //Obrir la base de dades
        ODB odb = ODBFactory.open("Producte_com.BD");
        
        //Creo un array de 10 productes
        Producte pro1 = new Producte(1, "Animal Crossing: New Horizons (Nintendo Switch)", 10, 3, 60);
        Producte pro2 = new Producte(2, "Just Dance 2021 (Nintendo Switch)", 9, 2, 40);
        Producte pro3 = new Producte(3, "FIFA 21 Legacy Edition (Nintendo Switch)", 7, 3, 55);
        Producte pro4 = new Producte(4, "Ring Fit Adventure (Nintendo Switch)", 5, 2, 80);
        Producte pro5 = new Producte(5, "The Legend of Zelda: Skyward Sword HD (Nintendo Switch)", 10, 3, 60);
        Producte pro6 = new Producte(6, "The Legend Of Zelda: Breath Of The Wild (Nintendo Switch)", 8, 5, 70);
        Producte pro7 = new Producte(7, "Luigi's Mansion 3 (Nintendo Switch)", 6, 6, 60);
        Producte pro8 = new Producte(8, "New Super Mario Bros. U Deluxe (Nintendo Switch)", 6, 2, 60);
        Producte pro9 = new Producte(9, "Pokémon: Espada (Nintendo Switch)", 1, 2, 56);
        Producte pro10 = new Producte(10, "Super Mario Party (Nintendo Switch)", 7, 6, 60);

        //S'emmagatzema els productes
        odb.store(pro1);
        odb.store(pro2);
        odb.store(pro3);
        odb.store(pro4);
        odb.store(pro5);
        odb.store(pro6);
        odb.store(pro7);
        odb.store(pro8);
        odb.store(pro9);
        odb.store(pro10);
        
        //Es tanca la base de dades
        odb.close();
        
    }  
}
