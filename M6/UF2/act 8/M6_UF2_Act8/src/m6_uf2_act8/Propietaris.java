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
class Propietaris implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nom;
    private Date dataN;
    private int tlf;
    private boolean minusvalid;
    
    @Id @GeneratedValue
    private long id;

    public Propietaris(String nom, Date dataN, int tlf, boolean minusvalid) {
        this.nom = nom;
        this.dataN = dataN;
        this.tlf = tlf;
        this.minusvalid = minusvalid;
    }
    
    public Propietaris() { 
        
    }

    
}
