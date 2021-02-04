package entity;
// Generated 03-feb-2021 17:56:06 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Movimiento generated by hbm2java
 */
@Entity
@Table(name="movimiento", schema="damas")
public class Movimiento  implements java.io.Serializable {

    @Id @GeneratedValue
     @Column(name="idMovimiento")
     private Integer idMovimiento;
    @Column(name="idPartida")
     private Partida partida;
    @Column(name="columnaOrigen")
     private int columnaOrigen;
    @Column(name="columnaValida")
     private int columnaValida;
    @Column(name="filaOrigen")
     private int filaOrigen;
    @Column(name="filaValida")
     private int filaValida;

    public Movimiento() {
    }

    public Movimiento(Partida partida, int columnaOrigen, int columnaValida, int filaOrigen, int filaValida) {
       this.partida = partida;
       this.columnaOrigen = columnaOrigen;
       this.columnaValida = columnaValida;
       this.filaOrigen = filaOrigen;
       this.filaValida = filaValida;
    }
   
    public Integer getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public Partida getPartida() {
        return this.partida;
    }
    
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    public int getColumnaOrigen() {
        return this.columnaOrigen;
    }
    
    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }
    public int getColumnaValida() {
        return this.columnaValida;
    }
    
    public void setColumnaValida(int columnaValida) {
        this.columnaValida = columnaValida;
    }
    public int getFilaOrigen() {
        return this.filaOrigen;
    }
    
    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }
    public int getFilaValida() {
        return this.filaValida;
    }
    
    public void setFilaValida(int filaValida) {
        this.filaValida = filaValida;
    }




}

