package act01_maria;

import ElsMeusBeans.Comanda;
import ElsMeusBeans.Producte;

/**
 *
 * @author maria
 */
public class Act01_Maria {
    
    public static void main(String[] args) {
        //Creo un array de 10 productes
        Producte[] producte = new Producte[10];
        producte[0] = new Producte(1, "Animal Crossing: New Horizons (Nintendo Switch)", 10, 3, 60);
        producte[1] = new Producte(2, "Just Dance 2021 (Nintendo Switch)", 9, 2, 40);
        producte[2] = new Producte(3, "FIFA 21 Legacy Edition (Nintendo Switch)", 7, 3, 55);
        producte[3] = new Producte(4, "Ring Fit Adventure (Nintendo Switch)", 5, 2, 80);
        producte[4] = new Producte(5, "The Legend of Zelda: Skyward Sword HD (Nintendo Switch)", 10, 3, 60);
        producte[5] = new Producte(6, "The Legend Of Zelda: Breath Of The Wild (Nintendo Switch)", 8, 5, 70);
        producte[6] = new Producte(7, "Luigi's Mansion 3 (Nintendo Switch)", 6, 6, 60);
        producte[7] = new Producte(8, "New Super Mario Bros. U Deluxe (Nintendo Switch)", 6, 2, 60);
        producte[8] = new Producte(9, "Pokémon: Espada (Nintendo Switch)", 9, 1, 56);
        producte[9] = new Producte(10, "Super Mario Party (Nintendo Switch)", 7, 6, 60);
        
        //Creo un objecte de la clase Comanda
        Comanda comanda = new Comanda();
        
        for (int i = 0; i < producte.length; i++) {
            producte[i].addPropertyChangeListener(comanda);
            producte[i].setStockactual(2);
            if(comanda.isDemana()) {
                System.out.println("Fer comanda en producte: " + producte[i].getDescripcio());
            } else {
                System.out.println("No és necessari fer la comanda en producte: " + producte[i].getDescripcio());
            }
        }        
    }    
}
