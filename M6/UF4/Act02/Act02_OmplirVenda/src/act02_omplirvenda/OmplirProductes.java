/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act02_omplirvenda;

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
        Producte p1 = new Producte(1, "Animal Crossing: New Horizons (Nintendo Switch)", 10, 3, 60);
        Producte p2 = new Producte(2, "Just Dance 2021 (Nintendo Switch)", 9, 2, 40);
        Producte p3 = new Producte(3, "FIFA 21 Legacy Edition (Nintendo Switch)", 7, 3, 55);
        Producte p4 = new Producte(4, "Ring Fit Adventure (Nintendo Switch)", 5, 2, 80);
        Producte p5 = new Producte(5, "The Legend of Zelda: Skyward Sword HD (Nintendo Switch)", 10, 3, 60);
        Producte p6 = new Producte(6, "The Legend Of Zelda: Breath Of The Wild (Nintendo Switch)", 8, 5, 70);  
        Producte p7 = new Producte(7, "Luigi's Mansion 3 (Nintendo Switch)", 6, 6, 60);
        Producte p8 = new Producte(8, "New Super Mario Bros. U Deluxe (Nintendo Switch)", 6, 2, 60);
        Producte p9 = new Producte(9, "Pokémon: Espada (Nintendo Switch)", 9, 2, 56);
        Producte p10 = new Producte(10, "Super Mario Party (Nintendo Switch)", 7, 6, 60);

        //S'emmagatzema els productes
        odb.store(p1);
        odb.store(p2);
        odb.store(p3);
        odb.store(p4);
        odb.store(p5);
        odb.store(p6);
        odb.store(p7);
        odb.store(p8);
        odb.store(p9);
        odb.store(p10);
        
        //Es tanca la base de dades
        odb.close();        
    }  
}