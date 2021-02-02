package entity;
// Generated 31-ene-2021 19:37:40 by Hibernate Tools 4.3.1



/**
 * Moviment generated by hbm2java
 */
public class Moviment  implements java.io.Serializable {


     private int idMovimiento;
     private int idPartida;
     private int filaOrigen;
     private int columnaOrigen;
     private int filaDestino;
     private int columnaDestino;

    public Moviment() {
    }

    public Moviment(int idMovimiento, int idPartida, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
       this.idMovimiento = idMovimiento;
       this.idPartida = idPartida;
       this.filaOrigen = filaOrigen;
       this.columnaOrigen = columnaOrigen;
       this.filaDestino = filaDestino;
       this.columnaDestino = columnaDestino;
    }
   
    public int getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public int getIdPartida() {
        return this.idPartida;
    }
    
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }
    public int getFilaOrigen() {
        return this.filaOrigen;
    }
    
    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }
    public int getColumnaOrigen() {
        return this.columnaOrigen;
    }
    
    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }
    public int getFilaDestino() {
        return this.filaDestino;
    }
    
    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }
    public int getColumnaDestino() {
        return this.columnaDestino;
    }
    
    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }




}

