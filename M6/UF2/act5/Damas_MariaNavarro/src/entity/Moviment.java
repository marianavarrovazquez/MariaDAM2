package entity;
// Generated 02-feb-2021 23:54:41 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Moviment generated by hbm2java
 */

@Entity
@Table(name="movimient", schema="damas")
public class Moviment  implements java.io.Serializable {


     private Integer idM;
     private Partida idP;
     private int filaOrigen;
     private int columnaOrigen;
     private int filaValida;
     private int columnaValida;

    public Moviment() {
    }

    public Moviment(Partida idP, int filaOrigen, int columnaOrigen, int filaValida, int columnaValida) {
       this.idP = idP;
       this.filaOrigen = filaOrigen;
       this.columnaOrigen = columnaOrigen;
       this.filaValida = filaValida;
       this.columnaValida = columnaValida;
    }
   
    @Id
    @GeneratedValue
    @Column(name="idM")
    public int getIdM() {
        return this.idM;
    }
    
    public void setIdM(Integer idM) {
        this.idM = idM;
    }
    
    @Column(name="idP")
    public Partida getIdP() {
        return this.idP;
    }
    
    public void setIdP(Partida idP) {
        this.idP = idP;
    }
    
    @Column(name="filaOrigen")
    public int getFilaOrigen() {
        return this.filaOrigen;
    }
    
    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }
    
    @Column(name="columnaOrigen")
    public int getColumnaOrigen() {
        return this.columnaOrigen;
    }
    
    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }
    
    @Column(name="filaValida")
    public int getFilaValida() {
        return this.filaValida;
    }
    
    public void setFilaValida(int filaValida) {
        this.filaValida = filaValida;
    }
    
    @Column(name="columnaValida")
    public int getColumnaValida() {
        return this.columnaValida;
    }
    
    public void setColumnaValida(int columnaValida) {
        this.columnaValida = columnaValida;
    }
}


