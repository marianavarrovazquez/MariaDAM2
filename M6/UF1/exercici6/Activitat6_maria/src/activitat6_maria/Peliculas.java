package activitat6_maria;

import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author maria
 */
@XmlRootElement
class Peliculas {
    private Pelicula[] pelicula;
    
    public Pelicula[] getPelicula() {
        return pelicula;
    }
    
    public void setPeliculas(Pelicula[] pelicula) {
        this.pelicula = pelicula;
    }
    
}
