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
    
    public static Producte[] pro = new Producte[11];
    public static void main(String[] args) {
        ODB odb = ODBFactory.open("Producte_com.BD");
        //Creo un array de 10 productes
        
        pro[1] = new Producte(1, "Animal Crossing: New Horizons (Nintendo Switch)", 10, 3, 60);
        pro[2] = new Producte(2, "Just Dance 2021 (Nintendo Switch)", 9, 2, 40);
        pro[3] = new Producte(3, "FIFA 21 Legacy Edition (Nintendo Switch)", 7, 3, 55);
        pro[4] = new Producte(4, "Ring Fit Adventure (Nintendo Switch)", 5, 2, 80);
        pro[5] = new Producte(5, "The Legend of Zelda: Skyward Sword HD (Nintendo Switch)", 10, 3, 60);
        pro[6] = new Producte(6, "The Legend Of Zelda: Breath Of The Wild (Nintendo Switch)", 8, 5, 70);
        pro[7] = new Producte(7, "Luigi's Mansion 3 (Nintendo Switch)", 6, 6, 60);
        pro[8] = new Producte(8, "New Super Mario Bros. U Deluxe (Nintendo Switch)", 6, 2, 60);
        pro[9] = new Producte(9, "Pokémon: Espada (Nintendo Switch)", 1, 2, 56);
        pro[10] = new Producte(10, "Super Mario Party (Nintendo Switch)", 7, 6, 60);

        for (int i = 1; i < pro.length; i++) {
            odb.store(pro[i]);
        } 
        
        odb.close();
        
    }

    public static Producte[] getPro() {
        return pro;
    }

    public static void setPro(Producte[] pro) {
        OmplirProductes.pro = pro;
    }
    
    
    
}
