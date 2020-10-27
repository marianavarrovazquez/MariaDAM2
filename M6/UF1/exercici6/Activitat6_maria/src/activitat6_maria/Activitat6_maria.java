package activitat6_maria;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/**
*File: Activitat6_maria.java
*Author: Maria Navarro
*Date: 27-10-2020
*Description: Activitat 6 Practica UF1 M6
 */
public class Activitat6_maria {

    private static final String PELICULAS_XML_FILE = "peliculas.xml";
 
    public static void main(String[] args) throws JAXBException, IOException {
       
        Peliculas peliculas2 =JAXB.unmarshal(new FileReader ("peliculas2.xml"), Peliculas.class);
        JAXB.marshal(peliculas2, System.out);
        
        JAXBContext context = JAXBContext.newInstance(Peliculas.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        Peliculas peliculas = omplePeliculas();
        
        FileOutputStream fos = new FileOutputStream(PELICULAS_XML_FILE);

	marshaller.marshal(peliculas, fos);
	fos.close();
	
	Unmarshaller unmarshaller = context.createUnmarshaller();
	
	Peliculas peliculasAux = (Peliculas) unmarshaller.unmarshal(new File(PELICULAS_XML_FILE));
	System.out.println("********* Peliculas carregat desde fitxer XML***************");
	
	marshaller.marshal(peliculasAux, System.out);
    }
	
    private static Peliculas omplePeliculas(){
        String titulo[] = {"Bright", "Corazones de acero", "Fast and Furious 6"};
        String director[] = {"David Ayer", "David Ayer", "Justin Lin"};
        String actor[] = {"Will Smith", "Brad Pitt", "Vin Diesel"};
        int fecha[] = {2017, 2014, 2013};
        int duracion[] = {117, 134, 130};
        String genero[] = {"accion", "belica", "accion"};
        Pelicula[] ArrayPeliculas = new Pelicula[3];
        
        for (int i = 0; i < 3; i++) {
            ArrayPeliculas[i] = new Pelicula();
            ArrayPeliculas[i].setTitulo(titulo[i]);
            ArrayPeliculas[i].setDirector(director[i]);
            ArrayPeliculas[i].setActor(actor[i]);
            ArrayPeliculas[i].setFecha(fecha[i]);
            ArrayPeliculas[i].setDuracion(duracion[i]);
            ArrayPeliculas[i].setGenero(genero[i]);
        }
        
        Peliculas peliculas = new Peliculas();
        peliculas.setPeliculas(ArrayPeliculas);
        
        return peliculas;
    }
}