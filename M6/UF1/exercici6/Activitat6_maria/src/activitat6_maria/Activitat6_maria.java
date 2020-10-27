package activitat6_maria;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
		
		JAXBContext context = JAXBContext.newInstance(Peliculas.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Peliculas peliculas = omplePeliculas();
		
		//Mostrem el document XML generat por la sortida estandard
		//marshaller.marshal(peliculas, System.out);
		
		FileOutputStream fos = new FileOutputStream(PELICULAS_XML_FILE);
		//guardem l'objecte serializat en un document XML
		marshaller.marshal(peliculas, fos);
		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//Deserialitzem a partir de un document XML
		Peliculas peliculasAux = (Peliculas) unmarshaller.unmarshal(new File(PELICULAS_XML_FILE));
		System.out.println("********* Peliculas carregat desde fitxer XML***************");
		//Mostrem l'objeto Java obtingut
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
		
		for(int i=0; i<3; i++){
			ArrayPeliculas[i] = new Pelicula();
                        ArrayPeliculas[i].setTitulo(titulo[i]);
                        ArrayPeliculas[i].setDirector(director[i]);
                        ArrayPeliculas[i].setActor(actor[i]);
                        ArrayPeliculas[i].setFecha(fecha[i]);
                        ArrayPeliculas[i].setDuracion(duracion[i]);
                        ArrayPeliculas[i].setGenero(genero[i]);
			ArrayPeliculas[i].setId(i);			
		}
		
		Peliculas peliculas = new Peliculas();
		peliculas.setPeliculas(ArrayPeliculas);
		
		return peliculas;
	}
}
