package activitat6_maria;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author maria
 */
class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private String actor;
    private int fecha;
    private int duracion;
    private String genero;
    
    @XmlAttribute(name="id")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @XmlAttribute(name="titulo")
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    @XmlAttribute(name="director")
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    @XmlAttribute(name="actor")
    public String getActor() {
        return actor;
    }
    
    public void setActor(String actor) {
        this.actor = actor;
    }

    @XmlAttribute(name="fecha")
    public int getFecha() {
        return fecha;
    }
    
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
    @XmlAttribute(name="duracion")
    public int getDuracion() {
        return duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    @XmlAttribute(name="genero")
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
