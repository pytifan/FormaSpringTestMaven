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
    private long id;
    
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
    @Column(name = "headChristmasTree")
    private String headChristmasTree;
    @Column(name = "packer")
    private String packer;
    @Column(name = "wellDepth")
    private String wellDepth;
    @Column(name = "PBTHdepth")
    private String PBTHdepth;
    @Column(name = "perforationInterval")
    private String perforationInterval;
    @Column(name = "fluidLevelDensity")
    private String fluidLevelDensity;
    @Column(name = "formationPressure")
    private String formationPressure;
    @Column(name = "formationTemperature")
    private String formationTemperature;
    @Column(name = "isFlarePit")
    private String isFlarePit;
    @Column(name = "consumedVolume")
    private String consumedVolume;
    /* 2.1. Параметры обсадной колонны – Casing parameters*/
    @Column(name = "topDepthCasing1")
    private String topDepthCasing1;
    @Column(name = "botomDepthCasing1")
    private String botomDepthCasing1;
    @Column(name = "casing1")
    private String casing1;
    @Column(name = "casingTip1")
    private String casingTip1;
    @Column(name = "maxPressureCasing1")
    private String maxPressureCasing1;
    @Column(name = "outerDiamCasing1")
    private String outerDiamCasing1;
    @Column(name = "weightCasing1")
    private String weightCasing1;
    @Column(name = "IDcas1")
    private String IDcas1;
    @Column(name = "steelCasing1")
    private String steelCasing1;
    @Column(name = "topDepthCasing2")
    private String topDepthCasing2;
    @Column(name = "botomDepthCasing2")
    private String botomDepthCasing2;
    @Column(name = "casing2")
    private String casing2;
    @Column(name = "casingTip2")
    private String casingTip2;
    @Column(name = "maxPressureCasing2")
    private String maxPressureCasing2;
    @Column(name = "outerDiamCasing2")
    private String outerDiamCasing2;
    @Column(name = "weightCasing2")
    private String weightCasing2;
    @Column(name = "IDcas2")
    private String IDcas2;
    @Column(name = "steelCasing2")
    private String steelCasing2;
    @Column(name = "topDepthCasing3")
    private String topDepthCasing3;
    @Column(name = "botomDepthCasing3")
    private String botomDepthCasing3;
    @Column(name = "casing3")
    private String casing3;
    @Column(name = "casingTip3")
    private String casingTip3;
    @Column(name = "maxPressureCasing3")
    private String maxPressureCasing3;
    @Column(name = "outerDiamCasing3")
    private String outerDiamCasing3;
    @Column(name = "weightCasing3")
    private String weightCasing3;
    @Column(name = "IDcas3")
    private String IDcas3;
    @Column(name = "steelCasing3")
    private String steelCasing3;
    @Column(name = "topDepthCasing4")
    private String topDepthCasing4;
    @Column(name = "botomDepthCasing4")
    private String botomDepthCasing4;
    @Column(name = "casing4")
    private String casing4;
    @Column(name = "casingTip4")
    private String casingTip4;
    @Column(name = "maxPressureCasing4")
    private String maxPressureCasing4;
    @Column(name = "outerDiamCasing4")
    private String outerDiamCasing4;
    @Column(name = "weightCasing4")
    private String weightCasing4;
    @Column(name = "IDcas4")
    private String IDcas4;
    @Column(name = "steelCasing4")
    private String steelCasing4;
    @Column(name = "topDepthCasing5")
    private String topDepthCasing5;
    @Column(name = "botomDepthCasing5")
    private String botomDepthCasing5;
    @Column(name = "casing5")
    private String casing5;
    @Column(name = "casingTip5")
    private String casingTip5;
    @Column(name = "maxPressureCasing5")
    private String maxPressureCasing5;
    @Column(name = "outerDiamCasing5")
    private String outerDiamCasing5;
    @Column(name = "weightCasing5")
    private String weightCasing5;
    @Column(name = "IDcas5")
    private String IDcas5;
    @Column(name = "steelCasing5")
    private String steelCasing5;
    
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
  
//    public Long assignId() {
//            this.setId(idSequence.incrementAndGet());
//		return getId();
//	}
//    private static final AtomicLong idSequence = new AtomicLong();           

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
     * @return the headChristmasTree
     */
    public String getHeadChristmasTree() {
        return headChristmasTree;
    }

    /**
     * @param headChristmasTree the headChristmasTree to set
     */
    public void setHeadChristmasTree(String headChristmasTree) {
        this.headChristmasTree = headChristmasTree;
    }

    /**
     * @return the packer
     */
    public String getPacker() {
        return packer;
    }

    /**
     * @param packer the packer to set
     */
    public void setPacker(String packer) {
        this.packer = packer;
    }

    /**
     * @return the wellDepth
     */
    public String getWellDepth() {
        return wellDepth;
    }

    /**
     * @param wellDepth the wellDepth to set
     */
    public void setWellDepth(String wellDepth) {
        this.wellDepth = wellDepth;
    }

    /**
     * @return the PBTHdepth
     */
    public String getPBTHdepth() {
        return PBTHdepth;
    }

    /**
     * @param PBTHdepth the PBTHdepth to set
     */
    public void setPBTHdepth(String PBTHdepth) {
        this.PBTHdepth = PBTHdepth;
    }

    /**
     * @return the perforationInterval
     */
    public String getPerforationInterval() {
        return perforationInterval;
    }

    /**
     * @param perforationInterval the perforationInterval to set
     */
    public void setPerforationInterval(String perforationInterval) {
        this.perforationInterval = perforationInterval;
    }

    /**
     * @return the fluidLevelDensity
     */
    public String getFluidLevelDensity() {
        return fluidLevelDensity;
    }

    /**
     * @param fluidLevelDensity the fluidLevelDensity to set
     */
    public void setFluidLevelDensity(String fluidLevelDensity) {
        this.fluidLevelDensity = fluidLevelDensity;
    }

    /**
     * @return the formationPressure
     */
    public String getFormationPressure() {
        return formationPressure;
    }

    /**
     * @param formationPressure the formationPressure to set
     */
    public void setFormationPressure(String formationPressure) {
        this.formationPressure = formationPressure;
    }

    /**
     * @return the formationTemperature
     */
    public String getFormationTemperature() {
        return formationTemperature;
    }

    /**
     * @param formationTemperature the formationTemperature to set
     */
    public void setFormationTemperature(String formationTemperature) {
        this.formationTemperature = formationTemperature;
    }

    /**
     * @return the isFlarePit
     */
    public String getIsFlarePit() {
        return isFlarePit;
    }

    /**
     * @param isFlarePit the isFlarePit to set
     */
    public void setIsFlarePit(String isFlarePit) {
        this.isFlarePit = isFlarePit;
    }

    /**
     * @return the consumedVolume
     */
    public String getConsumedVolume() {
        return consumedVolume;
    }

    /**
     * @param consumedVolume the consumedVolume to set
     */
    public void setConsumedVolume(String consumedVolume) {
        this.consumedVolume = consumedVolume;
    }

    /**
     * @return the topDepthCasing1
     */
    public String getTopDepthCasing1() {
        return topDepthCasing1;
    }

    /**
     * @param topDepthCasing1 the topDepthCasing1 to set
     */
    public void setTopDepthCasing1(String topDepthCasing1) {
        this.topDepthCasing1 = topDepthCasing1;
    }

    /**
     * @return the botomDepthCasing1
     */
    public String getBotomDepthCasing1() {
        return botomDepthCasing1;
    }

    /**
     * @param botomDepthCasing1 the botomDepthCasing1 to set
     */
    public void setBotomDepthCasing1(String botomDepthCasing1) {
        this.botomDepthCasing1 = botomDepthCasing1;
    }

    /**
     * @return the casing1
     */
    public String getCasing1() {
        return casing1;
    }

    /**
     * @param casing1 the casing1 to set
     */
    public void setCasing1(String casing1) {
        this.casing1 = casing1;
    }

    /**
     * @return the casingTip1
     */
    public String getCasingTip1() {
        return casingTip1;
    }

    /**
     * @param casingTip1 the casingTip1 to set
     */
    public void setCasingTip1(String casingTip1) {
        this.casingTip1 = casingTip1;
    }

    /**
     * @return the maxPressureCasing1
     */
    public String getMaxPressureCasing1() {
        return maxPressureCasing1;
    }

    /**
     * @param maxPressureCasing1 the maxPressureCasing1 to set
     */
    public void setMaxPressureCasing1(String maxPressureCasing1) {
        this.maxPressureCasing1 = maxPressureCasing1;
    }

    /**
     * @return the outerDiamCasing1
     */
    public String getOuterDiamCasing1() {
        return outerDiamCasing1;
    }

    /**
     * @param outerDiamCasing1 the outerDiamCasing1 to set
     */
    public void setOuterDiamCasing1(String outerDiamCasing1) {
        this.outerDiamCasing1 = outerDiamCasing1;
    }

    /**
     * @return the weightCasing1
     */
    public String getWeightCasing1() {
        return weightCasing1;
    }

    /**
     * @param weightCasing1 the weightCasing1 to set
     */
    public void setWeightCasing1(String weightCasing1) {
        this.weightCasing1 = weightCasing1;
    }

    /**
     * @return the IDcas1
     */
    public String getIDcas1() {
        return IDcas1;
    }

    /**
     * @param IDcas1 the IDcas1 to set
     */
    public void setIDcas1(String IDcas1) {
        this.IDcas1 = IDcas1;
    }

    /**
     * @return the steelCasing1
     */
    public String getSteelCasing1() {
        return steelCasing1;
    }

    /**
     * @param steelCasing1 the steelCasing1 to set
     */
    public void setSteelCasing1(String steelCasing1) {
        this.steelCasing1 = steelCasing1;
    }

    /**
     * @return the topDepthCasing2
     */
    public String getTopDepthCasing2() {
        return topDepthCasing2;
    }

    /**
     * @param topDepthCasing2 the topDepthCasing2 to set
     */
    public void setTopDepthCasing2(String topDepthCasing2) {
        this.topDepthCasing2 = topDepthCasing2;
    }

    /**
     * @return the botomDepthCasing2
     */
    public String getBotomDepthCasing2() {
        return botomDepthCasing2;
    }

    /**
     * @param botomDepthCasing2 the botomDepthCasing2 to set
     */
    public void setBotomDepthCasing2(String botomDepthCasing2) {
        this.botomDepthCasing2 = botomDepthCasing2;
    }

    /**
     * @return the casing2
     */
    public String getCasing2() {
        return casing2;
    }

    /**
     * @param casing2 the casing2 to set
     */
    public void setCasing2(String casing2) {
        this.casing2 = casing2;
    }

    /**
     * @return the casingTip2
     */
    public String getCasingTip2() {
        return casingTip2;
    }

    /**
     * @param casingTip2 the casingTip2 to set
     */
    public void setCasingTip2(String casingTip2) {
        this.casingTip2 = casingTip2;
    }

    /**
     * @return the maxPressureCasing2
     */
    public String getMaxPressureCasing2() {
        return maxPressureCasing2;
    }

    /**
     * @param maxPressureCasing2 the maxPressureCasing2 to set
     */
    public void setMaxPressureCasing2(String maxPressureCasing2) {
        this.maxPressureCasing2 = maxPressureCasing2;
    }

    /**
     * @return the outerDiamCasing2
     */
    public String getOuterDiamCasing2() {
        return outerDiamCasing2;
    }

    /**
     * @param outerDiamCasing2 the outerDiamCasing2 to set
     */
    public void setOuterDiamCasing2(String outerDiamCasing2) {
        this.outerDiamCasing2 = outerDiamCasing2;
    }

    /**
     * @return the weightCasing2
     */
    public String getWeightCasing2() {
        return weightCasing2;
    }

    /**
     * @param weightCasing2 the weightCasing2 to set
     */
    public void setWeightCasing2(String weightCasing2) {
        this.weightCasing2 = weightCasing2;
    }

    /**
     * @return the IDcas2
     */
    public String getIDcas2() {
        return IDcas2;
    }

    /**
     * @param IDcas2 the IDcas2 to set
     */
    public void setIDcas2(String IDcas2) {
        this.IDcas2 = IDcas2;
    }

    /**
     * @return the steelCasing2
     */
    public String getSteelCasing2() {
        return steelCasing2;
    }

    /**
     * @param steelCasing2 the steelCasing2 to set
     */
    public void setSteelCasing2(String steelCasing2) {
        this.steelCasing2 = steelCasing2;
    }

    /**
     * @return the topDepthCasing3
     */
    public String getTopDepthCasing3() {
        return topDepthCasing3;
    }

    /**
     * @param topDepthCasing3 the topDepthCasing3 to set
     */
    public void setTopDepthCasing3(String topDepthCasing3) {
        this.topDepthCasing3 = topDepthCasing3;
    }

    /**
     * @return the botomDepthCasing3
     */
    public String getBotomDepthCasing3() {
        return botomDepthCasing3;
    }

    /**
     * @param botomDepthCasing3 the botomDepthCasing3 to set
     */
    public void setBotomDepthCasing3(String botomDepthCasing3) {
        this.botomDepthCasing3 = botomDepthCasing3;
    }

    /**
     * @return the casing3
     */
    public String getCasing3() {
        return casing3;
    }

    /**
     * @param casing3 the casing3 to set
     */
    public void setCasing3(String casing3) {
        this.casing3 = casing3;
    }

    /**
     * @return the casingTip3
     */
    public String getCasingTip3() {
        return casingTip3;
    }

    /**
     * @param casingTip3 the casingTip3 to set
     */
    public void setCasingTip3(String casingTip3) {
        this.casingTip3 = casingTip3;
    }

    /**
     * @return the maxPressureCasing3
     */
    public String getMaxPressureCasing3() {
        return maxPressureCasing3;
    }

    /**
     * @param maxPressureCasing3 the maxPressureCasing3 to set
     */
    public void setMaxPressureCasing3(String maxPressureCasing3) {
        this.maxPressureCasing3 = maxPressureCasing3;
    }

    /**
     * @return the outerDiamCasing3
     */
    public String getOuterDiamCasing3() {
        return outerDiamCasing3;
    }

    /**
     * @param outerDiamCasing3 the outerDiamCasing3 to set
     */
    public void setOuterDiamCasing3(String outerDiamCasing3) {
        this.outerDiamCasing3 = outerDiamCasing3;
    }

    /**
     * @return the weightCasing3
     */
    public String getWeightCasing3() {
        return weightCasing3;
    }

    /**
     * @param weightCasing3 the weightCasing3 to set
     */
    public void setWeightCasing3(String weightCasing3) {
        this.weightCasing3 = weightCasing3;
    }

    /**
     * @return the IDcas3
     */
    public String getIDcas3() {
        return IDcas3;
    }

    /**
     * @param IDcas3 the IDcas3 to set
     */
    public void setIDcas3(String IDcas3) {
        this.IDcas3 = IDcas3;
    }

    /**
     * @return the steelCasing3
     */
    public String getSteelCasing3() {
        return steelCasing3;
    }

    /**
     * @param steelCasing3 the steelCasing3 to set
     */
    public void setSteelCasing3(String steelCasing3) {
        this.steelCasing3 = steelCasing3;
    }

    /**
     * @return the topDepthCasing4
     */
    public String getTopDepthCasing4() {
        return topDepthCasing4;
    }

    /**
     * @param topDepthCasing4 the topDepthCasing4 to set
     */
    public void setTopDepthCasing4(String topDepthCasing4) {
        this.topDepthCasing4 = topDepthCasing4;
    }

    /**
     * @return the botomDepthCasing4
     */
    public String getBotomDepthCasing4() {
        return botomDepthCasing4;
    }

    /**
     * @param botomDepthCasing4 the botomDepthCasing4 to set
     */
    public void setBotomDepthCasing4(String botomDepthCasing4) {
        this.botomDepthCasing4 = botomDepthCasing4;
    }

    /**
     * @return the casing4
     */
    public String getCasing4() {
        return casing4;
    }

    /**
     * @param casing4 the casing4 to set
     */
    public void setCasing4(String casing4) {
        this.casing4 = casing4;
    }

    /**
     * @return the casingTip4
     */
    public String getCasingTip4() {
        return casingTip4;
    }

    /**
     * @param casingTip4 the casingTip4 to set
     */
    public void setCasingTip4(String casingTip4) {
        this.casingTip4 = casingTip4;
    }

    /**
     * @return the maxPressureCasing4
     */
    public String getMaxPressureCasing4() {
        return maxPressureCasing4;
    }

    /**
     * @param maxPressureCasing4 the maxPressureCasing4 to set
     */
    public void setMaxPressureCasing4(String maxPressureCasing4) {
        this.maxPressureCasing4 = maxPressureCasing4;
    }

    /**
     * @return the outerDiamCasing4
     */
    public String getOuterDiamCasing4() {
        return outerDiamCasing4;
    }

    /**
     * @param outerDiamCasing4 the outerDiamCasing4 to set
     */
    public void setOuterDiamCasing4(String outerDiamCasing4) {
        this.outerDiamCasing4 = outerDiamCasing4;
    }

    /**
     * @return the weightCasing4
     */
    public String getWeightCasing4() {
        return weightCasing4;
    }

    /**
     * @param weightCasing4 the weightCasing4 to set
     */
    public void setWeightCasing4(String weightCasing4) {
        this.weightCasing4 = weightCasing4;
    }

    /**
     * @return the IDcas4
     */
    public String getIDcas4() {
        return IDcas4;
    }

    /**
     * @param IDcas4 the IDcas4 to set
     */
    public void setIDcas4(String IDcas4) {
        this.IDcas4 = IDcas4;
    }

    /**
     * @return the steelCasing4
     */
    public String getSteelCasing4() {
        return steelCasing4;
    }

    /**
     * @param steelCasing4 the steelCasing4 to set
     */
    public void setSteelCasing4(String steelCasing4) {
        this.steelCasing4 = steelCasing4;
    }

    /**
     * @return the topDepthCasing5
     */
    public String getTopDepthCasing5() {
        return topDepthCasing5;
    }

    /**
     * @param topDepthCasing5 the topDepthCasing5 to set
     */
    public void setTopDepthCasing5(String topDepthCasing5) {
        this.topDepthCasing5 = topDepthCasing5;
    }

    /**
     * @return the botomDepthCasing5
     */
    public String getBotomDepthCasing5() {
        return botomDepthCasing5;
    }

    /**
     * @param botomDepthCasing5 the botomDepthCasing5 to set
     */
    public void setBotomDepthCasing5(String botomDepthCasing5) {
        this.botomDepthCasing5 = botomDepthCasing5;
    }

    /**
     * @return the casing5
     */
    public String getCasing5() {
        return casing5;
    }

    /**
     * @param casing5 the casing5 to set
     */
    public void setCasing5(String casing5) {
        this.casing5 = casing5;
    }

    /**
     * @return the casingTip5
     */
    public String getCasingTip5() {
        return casingTip5;
    }

    /**
     * @param casingTip5 the casingTip5 to set
     */
    public void setCasingTip5(String casingTip5) {
        this.casingTip5 = casingTip5;
    }

    /**
     * @return the maxPressureCasing5
     */
    public String getMaxPressureCasing5() {
        return maxPressureCasing5;
    }

    /**
     * @param maxPressureCasing5 the maxPressureCasing5 to set
     */
    public void setMaxPressureCasing5(String maxPressureCasing5) {
        this.maxPressureCasing5 = maxPressureCasing5;
    }

    /**
     * @return the outerDiamCasing5
     */
    public String getOuterDiamCasing5() {
        return outerDiamCasing5;
    }

    /**
     * @param outerDiamCasing5 the outerDiamCasing5 to set
     */
    public void setOuterDiamCasing5(String outerDiamCasing5) {
        this.outerDiamCasing5 = outerDiamCasing5;
    }

    /**
     * @return the weightCasing5
     */
    public String getWeightCasing5() {
        return weightCasing5;
    }

    /**
     * @param weightCasing5 the weightCasing5 to set
     */
    public void setWeightCasing5(String weightCasing5) {
        this.weightCasing5 = weightCasing5;
    }

    /**
     * @return the IDcas5
     */
    public String getIDcas5() {
        return IDcas5;
    }

    /**
     * @param IDcas5 the IDcas5 to set
     */
    public void setIDcas5(String IDcas5) {
        this.IDcas5 = IDcas5;
    }

    /**
     * @return the steelCasing5
     */
    public String getSteelCasing5() {
        return steelCasing5;
    }

    /**
     * @param steelCasing5 the steelCasing5 to set
     */
    public void setSteelCasing5(String steelCasing5) {
        this.steelCasing5 = steelCasing5;
    }
}
