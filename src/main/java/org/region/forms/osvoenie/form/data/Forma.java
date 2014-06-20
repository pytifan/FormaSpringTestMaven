/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.form.data;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 *
 * @author alex
 */
@Entity
@Table(name = "FORMS")
public class Forma implements Serializable {
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "IDFORM")
    private Long id;
    
    /*Общие данные – General data*/
    @Column(name = "FIELDNAME")
    private String fieldName;
    @Column(name = "WELLNAME")
    private String wellName;
    @Column(name = "WELLLOCATION")
    private String wellLocation;
    @Column(name = "FORMATIONNAME")
    private String formationName;
    @Column(name = "WELLTYPE")
    private String wellType;
    @Column(name = "DESIREDJOBDATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date desiredJobDate;
    @Column(name = "SLABBEDWELLSITE")
    private String slabbedWellSite;
    @Column(name = "ELECTRICITY")
    private String electricity;
    @Column(name = "RIG")
    private String rig;
    @Column(name = "COMPANYNAME")
    private String companyName;
    @Column(name = "COMPANYREPRESENTATIVE")
    private String companyRepresentative;
    @Column(name = "COMMENTS")
    private String comments;

    /*Данные по скважине – Well data*/
//    private String ;
//    private double internalDiamCasing1;
//    private double internalDiamCasing2;
//    private double internalDiamCasing3;
//    private double internalDiamCasing4;
//    private double internalDiamCasing5;
//    private double avdiamcas;
   
//    private double botomDepthCasing1;
//    private double topDepthCasing1;
//    /*Параметры наземной линии/НКТ – Surface line/Tubing parameters*/
//    private double topDepthSurface1;
//    private double botomDepthSurface1;       
//    private double outerDiamSurface1; 
//    private double internalDiamSurface1;
    
    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return the wellName
     */
    public String getWellName() {
        return wellName;
    }

    /**
     * @param wellName the wellName to set
     */
    public void setWellName(String wellName) {
        this.wellName = wellName;
    }

    /**
     * @return the wellLocation
     */
    public String getWellLocation() {
        return wellLocation;
    }

    /**
     * @param wellLocation the wellLocation to set
     */
    public void setWellLocation(String wellLocation) {
        this.wellLocation = wellLocation;
    }

    /**
     * @return the formationName
     */
    public String getFormationName() {
        return formationName;
    }

    /**
     * @param formationName the formationName to set
     */
    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    /**
     * @return the wellType
     */
    public String getWellType() {
        return wellType;
    }

    /**
     * @param wellType the wellType to set
     */
    public void setWellType(String wellType) {
        this.wellType = wellType;
    }

    /**
     * @return the desiredJobDate
     */
    public Date getDesiredJobDate() {
        return desiredJobDate;
    }

    /**
     * @param desiredJobDate the desiredJobDate to set
     */
    public void setDesiredJobDate(Date desiredJobDate) {
        this.desiredJobDate = desiredJobDate;
    }

    /**
     * @return the slabbedWellSite
     */
    public String getSlabbedWellSite() {
        return slabbedWellSite;
    }

    /**
     * @param slabbedWellSite the slabbedWellSite to set
     */
    public void setSlabbedWellSite(String slabbedWellSite) {
        this.slabbedWellSite = slabbedWellSite;
    }

    /**
     * @return the electricity
     */
    public String getElectricity() {
        return electricity;
    }

    /**
     * @param electricity the electricity to set
     */
    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    /**
     * @return the rig
     */
    public String getRig() {
        return rig;
    }

    /**
     * @param rig the rig to set
     */
    public void setRig(String rig) {
        this.rig = rig;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyRepresentative
     */
    public String getCompanyRepresentative() {
        return companyRepresentative;
    }

    /**
     * @param companyRepresentative the companyRepresentative to set
     */
    public void setCompanyRepresentative(String companyRepresentative) {
        this.companyRepresentative = companyRepresentative;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }    

    /**
     * @return the internalDiamCasing1
     */
//    public double getInternalDiamCasing1() {
//        return internalDiamCasing1;
//    }

    /**
     * @param internalDiamCasing1 the internalDiamCasing1 to set
     */
//    public void setInternalDiamCasing1(double internalDiamCasing1) {
//        this.internalDiamCasing1 = internalDiamCasing1;
//    }

    /**
     * @return the internalDiamCasiat org.region.forms.osvoenie.spring.controller.FormController.add(FormController.java:90)ng2
     */
//    public double getInternalDiamCasing2() {
//        return internalDiamCasing2;
//    }

    /**
     * @param internalDiamCasing2 the internalDiamCasing2 to set
     */
//    public void setInternalDiamCasing2(double internalDiamCasing2) {
//        this.internalDiamCasing2 = internalDiamCasing2;
//    }

    /**
     * @return the avdiamcas
     */
//    public double getAvdiamcas() {
//        return avdiamcas;
//    }

    /**
     * @param avdiamcas the avdiamcas to set
     */
//    public void setAvdiamcas(double avdiamcas) {
//        this.avdiamcas = avdiamcas;
//    }

    /**
     * @return the internalDiamCasing3
     */
//    public double getInternalDiamCasing3() {
//        return internalDiamCasing3;
//    }

    /**
     * @param internalDiamCasing3 the internalDiamCasing3 to set
     */
//    public void setInternalDiamCasing3(double internalDiamCasing3) {
//        this.internalDiamCasing3 = internalDiamCasing3;
//    }

    /**
     * @return the internalDiamCasing4
     */
//    public double getInternalDiamCasing4() {
//        return internalDiamCasing4;
//    }

    /**
     * @param internalDiamCasing4 the internalDiamCasing4 to set
     */
//    public void setInternalDiamCasing4(double internalDiamCasing4) {
//        this.internalDiamCasing4 = internalDiamCasing4;
//    }

    /**
     * @return the internalDiamCasing5
     */
//    public double getInternalDiamCasing5() {
//        return internalDiamCasing5;
//    }

    /**
     * @param internalDiamCasing5 the internalDiamCasing5 to set
     */
//    public void setInternalDiamCasing5(double internalDiamCasing5) {
//        this.internalDiamCasing5 = internalDiamCasing5;
//    }
//
//    /**
//     * @return the outerDiamSurface1
//     */
//    public double getOuterDiamSurface1() {
//        return outerDiamSurface1;
//    }
//
//    /**
//     * @param outerDiamSurface1 the outerDiamSurface1 to set
//     */
//    public void setOuterDiamSurface1(double outerDiamSurface1) {
//        this.outerDiamSurface1 = outerDiamSurface1;
//    }
//
//    /**
//     * @return the internalDiamSurface1
//     */
//    public double getInternalDiamSurface1() {
//        return internalDiamSurface1;
//    }
//
//    /**
//     * @param internalDiamSurface1 the internalDiamSurface1 to set
//     */
//    public void setInternalDiamSurface1(double internalDiamSurface1) {
//        this.internalDiamSurface1 = internalDiamSurface1;
//    }
//
//    /**
//     * @return the topDepthSurface1
//     */
//    public double getTopDepthSurface1() {
//        return topDepthSurface1;
//    }
//
//    /**
//     * @param topDepthSurface1 the topDepthSurface1 to set
//     */
//    public void setTopDepthSurface1(double topDepthSurface1) {
//        this.topDepthSurface1 = topDepthSurface1;
//    }
//
//    /**
//     * @return the botomDepthSurface1
//     */
//    public double getBotomDepthSurface1() {
//        return botomDepthSurface1;
//    }
//
//    /**
//     * @param botomDepthSurface1 the botomDepthSurface1 to set
//     */
//    public void setBotomDepthSurface1(double botomDepthSurface1) {
//        this.botomDepthSurface1 = botomDepthSurface1;
//    }
//
//    /**
//     * @return the botomDepthCasing1
//     */
//    public double getBotomDepthCasing1() {
//        return botomDepthCasing1;
//    }
//
//    /**
//     * @param botomDepthCasing1 the botomDepthCasing1 to set
//     */
//    public void setBotomDepthCasing1(double botomDepthCasing1) {
//        this.botomDepthCasing1 = botomDepthCasing1;
//    }
//
//    /**
//     * @return the topDepthCasing1
//     */
//    public double getTopDepthCasing1() {
//        return topDepthCasing1;
//    }
//
//    /**
//     * @param topDepthCasing1 the topDepthCasing1 to set
//     */
//    public void setTopDepthCasing1(double topDepthCasing1) {
//        this.topDepthCasing1 = topDepthCasing1;
//    }
    
//    public Long assignId() {
//            this.setId(idSequence.incrementAndGet());
//		return getId();
//	}
//    private static final AtomicLong idSequence = new AtomicLong();           

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
