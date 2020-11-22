/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf2_act8;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author maria
 */
@Entity
class Vehicles implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String marca;
    private Date dataF;
    private int portes;
    private boolean diesel;

    @Id @GeneratedValue
    private long id;

    public Vehicles(String marca, Date dataF, int portes, boolean diesel) {
        this.marca = marca;
        this.dataF = dataF;
        this.portes = portes;
        this.diesel = diesel;
    }
    
    public Vehicles() {
        
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataF() {
        return dataF;
    }

    public void setDataF(Date dataF) {
        this.dataF = dataF;
    }

    public int getPortes() {
        return portes;
    }

    public void setPortes(int portes) {
        this.portes = portes;
    }

    public boolean isDiesel() {
        return diesel;
    }

    public void setDiesel(boolean diesel) {
        this.diesel = diesel;
    }

    @Override
    public String toString() {
        return "Vehicles <-- " 
                + "\n Id = " + id 
                + "\n Marca = " + marca 
                + "\n Data de fabricació = " + dataF 
                + "\n Número de portes del vehicle = " + portes 
                + "\n diesel = " + diesel 
                + " -->";
    }
}