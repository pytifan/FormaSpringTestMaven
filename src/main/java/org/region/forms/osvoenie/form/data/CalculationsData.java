/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.region.forms.osvoenie.form.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author alexey
 */
@Entity
@Table (name = "calculationsData")
public class CalculationsData implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "calcID")
    private long id;
    
    private Double Rho;
    private Double g;
    
    private String calcMess;
    

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the Rho
     */
    public Double getRho() {
        return Rho;
    }

    /**
     * @param Rho the Rho to set
     */
    public void setRho(Double Rho) {
        this.Rho = Rho;
    }

    /**
     * @return the g
     */
    public Double getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(Double g) {
        this.g = g;
    }

    /**
     * @return the calcMess
     */
    public String getCalcMess() {
        return calcMess;
    }

    /**
     * @param calcMess the calcMess to set
     */
    public void setCalcMess(String calcMess) {
        this.calcMess = calcMess;
    }
    
}
