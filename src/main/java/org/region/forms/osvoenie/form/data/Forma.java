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
import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * @author alex
 */
@Entity
@Table (name = "FORMS")
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
    @DateTimeFormat (pattern = "dd-mm-yy")
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
    /*2.2. Параметры наземной линии/НКТ – Surface line/Tubing parameters*/
    @Column(name = "topDepthSurface1")
    private String topDepthSurface1;
    @Column(name = "botomDepthSurface1")
    private String botomDepthSurface1;
    @Column(name = "surfaceLineTubig1")
    private String surfaceLineTubig1;
    @Column(name = "maxPressureSurface1")
    private String maxPressureSurface1;
    @Column(name = "OD1")
    private String OD1;
    @Column(name = "weightSurface1")
    private String weightSurface1;
    @Column(name = "internalDiamSurface1")
    private String internalDiamSurface1;
    @Column(name = "steelSurface1")
    private String steelSurface1;
    
    @Column(name = "topDepthSurface2")
    private String topDepthSurface2;
    @Column(name = "botomDepthSurface2")
    private String botomDepthSurface2;
    @Column(name = "surfaceLineTubig2")
    private String surfaceLineTubig2;
    @Column(name = "maxPressureSurface2")
    private String maxPressureSurface2;
    @Column(name = "OD2")
    private String OD2;
    @Column(name = "weightSurface2")
    private String weightSurface2;
    @Column(name = "internalDiamSurface2")
    private String internalDiamSurface2;
    @Column(name = "steelSurface2")
    private String steelSurface2;
    
    @Column(name = "topDepthSurface3")
    private String topDepthSurface3;
    @Column(name = "botomDepthSurface3")
    private String botomDepthSurface3;
    @Column(name = "surfaceLineTubig3")
    private String surfaceLineTubig3;
    @Column(name = "maxPressureSurface3")
    private String maxPressureSurface3;
    @Column(name = "OD3")
    private String OD3;
    @Column(name = "weightSurface3")
    private String weightSurface3;
    @Column(name = "internalDiamSurface3")
    private String internalDiamSurface3;
    @Column(name = "steelSurface3")
    private String steelSurface3;
    
    @Column(name = "topDepthSurface4")
    private String topDepthSurface4;
    @Column(name = "botomDepthSurface4")
    private String botomDepthSurface4;
    @Column(name = "surfaceLineTubig4")
    private String surfaceLineTubig4;
    @Column(name = "maxPressureSurface4")
    private String maxPressureSurface4;
    @Column(name = "OD4")
    private String OD4;
    @Column(name = "weightSurface4")
    private String weightSurface4;
    @Column(name = "internalDiamSurface4")
    private String internalDiamSurface4;
    @Column(name = "steelSurface4")
    private String steelSurface4;
    
    @Column(name = "topDepthSurface5")
    private String topDepthSurface5;
    @Column(name = "botomDepthSurface5")
    private String botomDepthSurface5;
    @Column(name = "surfaceLineTubig5")
    private String surfaceLineTubig5;
    @Column(name = "maxPressureSurface5")
    private String maxPressureSurface5;
    @Column(name = "OD5")
    private String OD5;
    @Column(name = "weightSurface5")
    private String weightSurface5;
    @Column(name = "internalDiamSurface5")
    private String internalDiamSurface5;
    @Column(name = "steelSurface5")
    private String steelSurface5;
    
    
    @Column(name = "DownholeDepth1")
    private String DownholeDepth1;
    @Column(name = "DownholeEquipType1")
    private String DownholeEquipType1;
    @Column(name = "DownholeMaxPress1")
    private String DownholeMaxPress1;
    @Column(name = "DownholeOutDiam1")
    private String DownholeOutDiam1;
    @Column(name = "DownholeInterDiam1")
    private String DownholeInterDiam1;
    @Column(name = "DownholeDepth2")
    private String DownholeDepth2;
    @Column(name = "DownholeEquipType2")
    private String DownholeEquipType2;
    @Column(name = "DownholeMaxPress2")
    private String DownholeMaxPress2;
    @Column(name = "DownholeOutDiam2")
    private String DownholeOutDiam2;
    @Column(name = "DownholeInterDiam2")
    private String DownholeInterDiam2;
    @Column(name = "DownholeDepth3")
    private String DownholeDepth3;
    @Column(name = "DownholeEquipType3")
    private String DownholeEquipType3;
    @Column(name = "DownholeMaxPress3")
    private String DownholeMaxPress3;
    @Column(name = "DownholeOutDiam3")
    private String DownholeOutDiam3;
    
    @Column(name = "DownholeInterDiam3")
    private String DownholeInterDiam3;
    @Column(name = "DownholeDepth4")
    private String DownholeDepth4;
    @Column(name = "DownholeEquipType4")
    private String DownholeEquipType4;
    @Column(name = "DownholeMaxPress4")
    private String DownholeMaxPress4;
    @Column(name = "DownholeOutDiam4")
    private String DownholeOutDiam4;
    @Column(name = "DownholeInterDiam4")
    private String DownholeInterDiam4;
    /* 2.4. Инклинометрия – Directional Survey
    1.2. Данные по скважине – Well data (или приложить полные данные по инклинометрии):
        Input mentioned data to the table (or attach full directional survey data):*/
    
    @Column(name = "WellDepth1")
    private String WellDepth1;
    @Column(name = "WellDegree1")
    private String WellDegree1;
    @Column(name = "WellAzimuth1")
    private String WellAzimuth1;
    
    @Column(name = "WellDepth2")
    private String WellDepth2;
    @Column(name = "WellDegree2")
    private String WellDegree2;
    @Column(name = "WellAzimuth2")
    private String WellAzimuth2;
    
    @Column(name = "WellDepth3")
    private String WellDepth3;
    @Column(name = "WellDegree3")
    private String WellDegree3;
    @Column(name = "WellAzimuth3")
    private String WellAzimuth3;
    
    @Column(name = "WellDepth4")
    private String WellDepth4;
    @Column(name = "WellDegree4")
    private String WellDegree4;
    @Column(name = "WellAzimuth4")
    private String WellAzimuth4;
    
    @Column(name = "WellDepth5")
    private String WellDepth5;
    @Column(name = "WellDegree5")
    private String WellDegree5;
    @Column(name = "WellAzimuth5")
    private String WellAzimuth5;
  
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

    /**
     * @return the topDepthSurface1
     */
    public String getTopDepthSurface1() {
        return topDepthSurface1;
    }

    /**
     * @param topDepthSurface1 the topDepthSurface1 to set
     */
    public void setTopDepthSurface1(String topDepthSurface1) {
        this.topDepthSurface1 = topDepthSurface1;
    }

    /**
     * @return the botomDepthSurface1
     */
    public String getBotomDepthSurface1() {
        return botomDepthSurface1;
    }

    /**
     * @param botomDepthSurface1 the botomDepthSurface1 to set
     */
    public void setBotomDepthSurface1(String botomDepthSurface1) {
        this.botomDepthSurface1 = botomDepthSurface1;
    }

    /**
     * @return the surfaceLineTubig1
     */
    public String getSurfaceLineTubig1() {
        return surfaceLineTubig1;
    }

    /**
     * @param surfaceLineTubig1 the surfaceLineTubig1 to set
     */
    public void setSurfaceLineTubig1(String surfaceLineTubig1) {
        this.surfaceLineTubig1 = surfaceLineTubig1;
    }

    /**
     * @return the maxPressureSurface1
     */
    public String getMaxPressureSurface1() {
        return maxPressureSurface1;
    }

    /**
     * @param maxPressureSurface1 the maxPressureSurface1 to set
     */
    public void setMaxPressureSurface1(String maxPressureSurface1) {
        this.maxPressureSurface1 = maxPressureSurface1;
    }

    /**
     * @return the OD1
     */
    public String getOD1() {
        return OD1;
    }

    /**
     * @param OD1 the OD1 to set
     */
    public void setOD1(String OD1) {
        this.OD1 = OD1;
    }

    /**
     * @return the weightSurface1
     */
    public String getWeightSurface1() {
        return weightSurface1;
    }

    /**
     * @param weightSurface1 the weightSurface1 to set
     */
    public void setWeightSurface1(String weightSurface1) {
        this.weightSurface1 = weightSurface1;
    }

    /**
     * @return the internalDiamSurface1
     */
    public String getInternalDiamSurface1() {
        return internalDiamSurface1;
    }

    /**
     * @param internalDiamSurface1 the internalDiamSurface1 to set
     */
    public void setInternalDiamSurface1(String internalDiamSurface1) {
        this.internalDiamSurface1 = internalDiamSurface1;
    }

    /**
     * @return the steelSurface1
     */
    public String getSteelSurface1() {
        return steelSurface1;
    }

    /**
     * @param steelSurface1 the steelSurface1 to set
     */
    public void setSteelSurface1(String steelSurface1) {
        this.steelSurface1 = steelSurface1;
    }

    /**
     * @return the topDepthSurface2
     */
    public String getTopDepthSurface2() {
        return topDepthSurface2;
    }

    /**
     * @param topDepthSurface2 the topDepthSurface2 to set
     */
    public void setTopDepthSurface2(String topDepthSurface2) {
        this.topDepthSurface2 = topDepthSurface2;
    }

    /**
     * @return the botomDepthSurface2
     */
    public String getBotomDepthSurface2() {
        return botomDepthSurface2;
    }

    /**
     * @param botomDepthSurface2 the botomDepthSurface2 to set
     */
    public void setBotomDepthSurface2(String botomDepthSurface2) {
        this.botomDepthSurface2 = botomDepthSurface2;
    }

    /**
     * @return the surfaceLineTubig2
     */
    public String getSurfaceLineTubig2() {
        return surfaceLineTubig2;
    }

    /**
     * @param surfaceLineTubig2 the surfaceLineTubig2 to set
     */
    public void setSurfaceLineTubig2(String surfaceLineTubig2) {
        this.surfaceLineTubig2 = surfaceLineTubig2;
    }

    /**
     * @return the maxPressureSurface2
     */
    public String getMaxPressureSurface2() {
        return maxPressureSurface2;
    }

    /**
     * @param maxPressureSurface2 the maxPressureSurface2 to set
     */
    public void setMaxPressureSurface2(String maxPressureSurface2) {
        this.maxPressureSurface2 = maxPressureSurface2;
    }

    /**
     * @return the OD2
     */
    public String getOD2() {
        return OD2;
    }

    /**
     * @param OD2 the OD2 to set
     */
    public void setOD2(String OD2) {
        this.OD2 = OD2;
    }

    /**
     * @return the weightSurface2
     */
    public String getWeightSurface2() {
        return weightSurface2;
    }

    /**
     * @param weightSurface2 the weightSurface2 to set
     */
    public void setWeightSurface2(String weightSurface2) {
        this.weightSurface2 = weightSurface2;
    }

    /**
     * @return the internalDiamSurface2
     */
    public String getInternalDiamSurface2() {
        return internalDiamSurface2;
    }

    /**
     * @param internalDiamSurface2 the internalDiamSurface2 to set
     */
    public void setInternalDiamSurface2(String internalDiamSurface2) {
        this.internalDiamSurface2 = internalDiamSurface2;
    }

    /**
     * @return the steelSurface2
     */
    public String getSteelSurface2() {
        return steelSurface2;
    }

    /**
     * @param steelSurface2 the steelSurface2 to set
     */
    public void setSteelSurface2(String steelSurface2) {
        this.steelSurface2 = steelSurface2;
    }

    /**
     * @return the topDepthSurface3
     */
    public String getTopDepthSurface3() {
        return topDepthSurface3;
    }

    /**
     * @param topDepthSurface3 the topDepthSurface3 to set
     */
    public void setTopDepthSurface3(String topDepthSurface3) {
        this.topDepthSurface3 = topDepthSurface3;
    }

    /**
     * @return the botomDepthSurface3
     */
    public String getBotomDepthSurface3() {
        return botomDepthSurface3;
    }

    /**
     * @param botomDepthSurface3 the botomDepthSurface3 to set
     */
    public void setBotomDepthSurface3(String botomDepthSurface3) {
        this.botomDepthSurface3 = botomDepthSurface3;
    }

    /**
     * @return the surfaceLineTubig3
     */
    public String getSurfaceLineTubig3() {
        return surfaceLineTubig3;
    }

    /**
     * @param surfaceLineTubig3 the surfaceLineTubig3 to set
     */
    public void setSurfaceLineTubig3(String surfaceLineTubig3) {
        this.surfaceLineTubig3 = surfaceLineTubig3;
    }

    /**
     * @return the maxPressureSurface3
     */
    public String getMaxPressureSurface3() {
        return maxPressureSurface3;
    }

    /**
     * @param maxPressureSurface3 the maxPressureSurface3 to set
     */
    public void setMaxPressureSurface3(String maxPressureSurface3) {
        this.maxPressureSurface3 = maxPressureSurface3;
    }

    /**
     * @return the OD3
     */
    public String getOD3() {
        return OD3;
    }

    /**
     * @param OD3 the OD3 to set
     */
    public void setOD3(String OD3) {
        this.OD3 = OD3;
    }

    /**
     * @return the weightSurface3
     */
    public String getWeightSurface3() {
        return weightSurface3;
    }

    /**
     * @param weightSurface3 the weightSurface3 to set
     */
    public void setWeightSurface3(String weightSurface3) {
        this.weightSurface3 = weightSurface3;
    }

    /**
     * @return the internalDiamSurface3
     */
    public String getInternalDiamSurface3() {
        return internalDiamSurface3;
    }

    /**
     * @param internalDiamSurface3 the internalDiamSurface3 to set
     */
    public void setInternalDiamSurface3(String internalDiamSurface3) {
        this.internalDiamSurface3 = internalDiamSurface3;
    }

    /**
     * @return the steelSurface3
     */
    public String getSteelSurface3() {
        return steelSurface3;
    }

    /**
     * @param steelSurface3 the steelSurface3 to set
     */
    public void setSteelSurface3(String steelSurface3) {
        this.steelSurface3 = steelSurface3;
    }

    /**
     * @return the botomDepthSurface4
     */
    public String getBotomDepthSurface4() {
        return botomDepthSurface4;
    }

    /**
     * @param botomDepthSurface4 the botomDepthSurface4 to set
     */
    public void setBotomDepthSurface4(String botomDepthSurface4) {
        this.botomDepthSurface4 = botomDepthSurface4;
    }

    /**
     * @return the surfaceLineTubig4
     */
    public String getSurfaceLineTubig4() {
        return surfaceLineTubig4;
    }

    /**
     * @param surfaceLineTubig4 the surfaceLineTubig4 to set
     */
    public void setSurfaceLineTubig4(String surfaceLineTubig4) {
        this.surfaceLineTubig4 = surfaceLineTubig4;
    }

    /**
     * @return the maxPressureSurface4
     */
    public String getMaxPressureSurface4() {
        return maxPressureSurface4;
    }

    /**
     * @param maxPressureSurface4 the maxPressureSurface4 to set
     */
    public void setMaxPressureSurface4(String maxPressureSurface4) {
        this.maxPressureSurface4 = maxPressureSurface4;
    }

    /**
     * @return the OD4
     */
    public String getOD4() {
        return OD4;
    }

    /**
     * @param OD4 the OD4 to set
     */
    public void setOD4(String OD4) {
        this.OD4 = OD4;
    }

    /**
     * @return the weightSurface4
     */
    public String getWeightSurface4() {
        return weightSurface4;
    }

    /**
     * @param weightSurface4 the weightSurface4 to set
     */
    public void setWeightSurface4(String weightSurface4) {
        this.weightSurface4 = weightSurface4;
    }

    /**
     * @return the internalDiamSurface4
     */
    public String getInternalDiamSurface4() {
        return internalDiamSurface4;
    }

    /**
     * @param internalDiamSurface4 the internalDiamSurface4 to set
     */
    public void setInternalDiamSurface4(String internalDiamSurface4) {
        this.internalDiamSurface4 = internalDiamSurface4;
    }

    /**
     * @return the steelSurface4
     */
    public String getSteelSurface4() {
        return steelSurface4;
    }

    /**
     * @param steelSurface4 the steelSurface4 to set
     */
    public void setSteelSurface4(String steelSurface4) {
        this.steelSurface4 = steelSurface4;
    }

    /**
     * @return the topDepthSurface5
     */
    public String getTopDepthSurface5() {
        return topDepthSurface5;
    }

    /**
     * @param topDepthSurface5 the topDepthSurface5 to set
     */
    public void setTopDepthSurface5(String topDepthSurface5) {
        this.topDepthSurface5 = topDepthSurface5;
    }

    /**
     * @return the botomDepthSurface5
     */
    public String getBotomDepthSurface5() {
        return botomDepthSurface5;
    }

    /**
     * @param botomDepthSurface5 the botomDepthSurface5 to set
     */
    public void setBotomDepthSurface5(String botomDepthSurface5) {
        this.botomDepthSurface5 = botomDepthSurface5;
    }

    /**
     * @return the surfaceLineTubig5
     */
    public String getSurfaceLineTubig5() {
        return surfaceLineTubig5;
    }

    /**
     * @param surfaceLineTubig5 the surfaceLineTubig5 to set
     */
    public void setSurfaceLineTubig5(String surfaceLineTubig5) {
        this.surfaceLineTubig5 = surfaceLineTubig5;
    }

    /**
     * @return the maxPressureSurface5
     */
    public String getMaxPressureSurface5() {
        return maxPressureSurface5;
    }

    /**
     * @param maxPressureSurface5 the maxPressureSurface5 to set
     */
    public void setMaxPressureSurface5(String maxPressureSurface5) {
        this.maxPressureSurface5 = maxPressureSurface5;
    }

    /**
     * @return the OD5
     */
    public String getOD5() {
        return OD5;
    }

    /**
     * @param OD5 the OD5 to set
     */
    public void setOD5(String OD5) {
        this.OD5 = OD5;
    }

    /**
     * @return the weightSurface5
     */
    public String getWeightSurface5() {
        return weightSurface5;
    }

    /**
     * @param weightSurface5 the weightSurface5 to set
     */
    public void setWeightSurface5(String weightSurface5) {
        this.weightSurface5 = weightSurface5;
    }

    /**
     * @return the internalDiamSurface5
     */
    public String getInternalDiamSurface5() {
        return internalDiamSurface5;
    }

    /**
     * @param internalDiamSurface5 the internalDiamSurface5 to set
     */
    public void setInternalDiamSurface5(String internalDiamSurface5) {
        this.internalDiamSurface5 = internalDiamSurface5;
    }

    /**
     * @return the steelSurface5
     */
    public String getSteelSurface5() {
        return steelSurface5;
    }

    /**
     * @param steelSurface5 the steelSurface5 to set
     */
    public void setSteelSurface5(String steelSurface5) {
        this.steelSurface5 = steelSurface5;
    }

    /**
     * @return the topDepthSurface4
     */
    public String getTopDepthSurface4() {
        return topDepthSurface4;
    }

    /**
     * @param topDepthSurface4 the topDepthSurface4 to set
     */
    public void setTopDepthSurface4(String topDepthSurface4) {
        this.topDepthSurface4 = topDepthSurface4;
    }

    /**
     * @return the DownholeDepth1
     */
    public String getDownholeDepth1() {
        return DownholeDepth1;
    }

    /**
     * @param DownholeDepth1 the DownholeDepth1 to set
     */
    public void setDownholeDepth1(String DownholeDepth1) {
        this.DownholeDepth1 = DownholeDepth1;
    }

    /**
     * @return the DownholeEquipType1
     */
    public String getDownholeEquipType1() {
        return DownholeEquipType1;
    }

    /**
     * @param DownholeEquipType1 the DownholeEquipType1 to set
     */
    public void setDownholeEquipType1(String DownholeEquipType1) {
        this.DownholeEquipType1 = DownholeEquipType1;
    }

    /**
     * @return the DownholeMaxPress1
     */
    public String getDownholeMaxPress1() {
        return DownholeMaxPress1;
    }

    /**
     * @param DownholeMaxPress1 the DownholeMaxPress1 to set
     */
    public void setDownholeMaxPress1(String DownholeMaxPress1) {
        this.DownholeMaxPress1 = DownholeMaxPress1;
    }

    /**
     * @return the DownholeOutDiam1
     */
    public String getDownholeOutDiam1() {
        return DownholeOutDiam1;
    }

    /**
     * @param DownholeOutDiam1 the DownholeOutDiam1 to set
     */
    public void setDownholeOutDiam1(String DownholeOutDiam1) {
        this.DownholeOutDiam1 = DownholeOutDiam1;
    }

    /**
     * @return the DownholeInterDiam1
     */
    public String getDownholeInterDiam1() {
        return DownholeInterDiam1;
    }

    /**
     * @param DownholeInterDiam1 the DownholeInterDiam1 to set
     */
    public void setDownholeInterDiam1(String DownholeInterDiam1) {
        this.DownholeInterDiam1 = DownholeInterDiam1;
    }

    /**
     * @return the DownholeDepth2
     */
    public String getDownholeDepth2() {
        return DownholeDepth2;
    }

    /**
     * @param DownholeDepth2 the DownholeDepth2 to set
     */
    public void setDownholeDepth2(String DownholeDepth2) {
        this.DownholeDepth2 = DownholeDepth2;
    }

    /**
     * @return the DownholeEquipType2
     */
    public String getDownholeEquipType2() {
        return DownholeEquipType2;
    }

    /**
     * @param DownholeEquipType2 the DownholeEquipType2 to set
     */
    public void setDownholeEquipType2(String DownholeEquipType2) {
        this.DownholeEquipType2 = DownholeEquipType2;
    }

    /**
     * @return the DownholeMaxPress2
     */
    public String getDownholeMaxPress2() {
        return DownholeMaxPress2;
    }

    /**
     * @param DownholeMaxPress2 the DownholeMaxPress2 to set
     */
    public void setDownholeMaxPress2(String DownholeMaxPress2) {
        this.DownholeMaxPress2 = DownholeMaxPress2;
    }

    /**
     * @return the DownholeOutDiam2
     */
    public String getDownholeOutDiam2() {
        return DownholeOutDiam2;
    }

    /**
     * @param DownholeOutDiam2 the DownholeOutDiam2 to set
     */
    public void setDownholeOutDiam2(String DownholeOutDiam2) {
        this.DownholeOutDiam2 = DownholeOutDiam2;
    }

    /**
     * @return the DownholeInterDiam2
     */
    public String getDownholeInterDiam2() {
        return DownholeInterDiam2;
    }

    /**
     * @param DownholeInterDiam2 the DownholeInterDiam2 to set
     */
    public void setDownholeInterDiam2(String DownholeInterDiam2) {
        this.DownholeInterDiam2 = DownholeInterDiam2;
    }

    /**
     * @return the DownholeDepth3
     */
    public String getDownholeDepth3() {
        return DownholeDepth3;
    }

    /**
     * @param DownholeDepth3 the DownholeDepth3 to set
     */
    public void setDownholeDepth3(String DownholeDepth3) {
        this.DownholeDepth3 = DownholeDepth3;
    }

    /**
     * @return the DownholeEquipType3
     */
    public String getDownholeEquipType3() {
        return DownholeEquipType3;
    }

    /**
     * @param DownholeEquipType3 the DownholeEquipType3 to set
     */
    public void setDownholeEquipType3(String DownholeEquipType3) {
        this.DownholeEquipType3 = DownholeEquipType3;
    }

    /**
     * @return the DownholeMaxPress3
     */
    public String getDownholeMaxPress3() {
        return DownholeMaxPress3;
    }

    /**
     * @param DownholeMaxPress3 the DownholeMaxPress3 to set
     */
    public void setDownholeMaxPress3(String DownholeMaxPress3) {
        this.DownholeMaxPress3 = DownholeMaxPress3;
    }

    /**
     * @return the DownholeOutDiam3
     */
    public String getDownholeOutDiam3() {
        return DownholeOutDiam3;
    }

    /**
     * @param DownholeOutDiam3 the DownholeOutDiam3 to set
     */
    public void setDownholeOutDiam3(String DownholeOutDiam3) {
        this.DownholeOutDiam3 = DownholeOutDiam3;
    }

    /**
     * @return the DownholeInterDiam3
     */
    public String getDownholeInterDiam3() {
        return DownholeInterDiam3;
    }

    /**
     * @param DownholeInterDiam3 the DownholeInterDiam3 to set
     */
    public void setDownholeInterDiam3(String DownholeInterDiam3) {
        this.DownholeInterDiam3 = DownholeInterDiam3;
    }

    /**
     * @return the DownholeDepth4
     */
    public String getDownholeDepth4() {
        return DownholeDepth4;
    }

    /**
     * @param DownholeDepth4 the DownholeDepth4 to set
     */
    public void setDownholeDepth4(String DownholeDepth4) {
        this.DownholeDepth4 = DownholeDepth4;
    }

    /**
     * @return the DownholeEquipType4
     */
    public String getDownholeEquipType4() {
        return DownholeEquipType4;
    }

    /**
     * @param DownholeEquipType4 the DownholeEquipType4 to set
     */
    public void setDownholeEquipType4(String DownholeEquipType4) {
        this.DownholeEquipType4 = DownholeEquipType4;
    }

    /**
     * @return the DownholeMaxPress4
     */
    public String getDownholeMaxPress4() {
        return DownholeMaxPress4;
    }

    /**
     * @param DownholeMaxPress4 the DownholeMaxPress4 to set
     */
    public void setDownholeMaxPress4(String DownholeMaxPress4) {
        this.DownholeMaxPress4 = DownholeMaxPress4;
    }

    /**
     * @return the DownholeOutDiam4
     */
    public String getDownholeOutDiam4() {
        return DownholeOutDiam4;
    }

    /**
     * @param DownholeOutDiam4 the DownholeOutDiam4 to set
     */
    public void setDownholeOutDiam4(String DownholeOutDiam4) {
        this.DownholeOutDiam4 = DownholeOutDiam4;
    }

    /**
     * @return the DownholeInterDiam4
     */
    public String getDownholeInterDiam4() {
        return DownholeInterDiam4;
    }

    /**
     * @param DownholeInterDiam4 the DownholeInterDiam4 to set
     */
    public void setDownholeInterDiam4(String DownholeInterDiam4) {
        this.DownholeInterDiam4 = DownholeInterDiam4;
    }

    /**
     * @return the WellDepth1
     */
    public String getWellDepth1() {
        return WellDepth1;
    }

    /**
     * @param WellDepth1 the WellDepth1 to set
     */
    public void setWellDepth1(String WellDepth1) {
        this.WellDepth1 = WellDepth1;
    }

    /**
     * @return the WellDegree1
     */
    public String getWellDegree1() {
        return WellDegree1;
    }

    /**
     * @param WellDegree1 the WellDegree1 to set
     */
    public void setWellDegree1(String WellDegree1) {
        this.WellDegree1 = WellDegree1;
    }

    /**
     * @return the WellAzimuth1
     */
    public String getWellAzimuth1() {
        return WellAzimuth1;
    }

    /**
     * @param WellAzimuth1 the WellAzimuth1 to set
     */
    public void setWellAzimuth1(String WellAzimuth1) {
        this.WellAzimuth1 = WellAzimuth1;
    }

    /**
     * @return the WellDepth2
     */
    public String getWellDepth2() {
        return WellDepth2;
    }

    /**
     * @param WellDepth2 the WellDepth2 to set
     */
    public void setWellDepth2(String WellDepth2) {
        this.WellDepth2 = WellDepth2;
    }

    /**
     * @return the WellDegree2
     */
    public String getWellDegree2() {
        return WellDegree2;
    }

    /**
     * @param WellDegree2 the WellDegree2 to set
     */
    public void setWellDegree2(String WellDegree2) {
        this.WellDegree2 = WellDegree2;
    }

    /**
     * @return the WellAzimuth2
     */
    public String getWellAzimuth2() {
        return WellAzimuth2;
    }

    /**
     * @param WellAzimuth2 the WellAzimuth2 to set
     */
    public void setWellAzimuth2(String WellAzimuth2) {
        this.WellAzimuth2 = WellAzimuth2;
    }

    /**
     * @return the WellDepth3
     */
    public String getWellDepth3() {
        return WellDepth3;
    }

    /**
     * @param WellDepth3 the WellDepth3 to set
     */
    public void setWellDepth3(String WellDepth3) {
        this.WellDepth3 = WellDepth3;
    }

    /**
     * @return the WellDegree3
     */
    public String getWellDegree3() {
        return WellDegree3;
    }

    /**
     * @param WellDegree3 the WellDegree3 to set
     */
    public void setWellDegree3(String WellDegree3) {
        this.WellDegree3 = WellDegree3;
    }

    /**
     * @return the WellAzimuth3
     */
    public String getWellAzimuth3() {
        return WellAzimuth3;
    }

    /**
     * @param WellAzimuth3 the WellAzimuth3 to set
     */
    public void setWellAzimuth3(String WellAzimuth3) {
        this.WellAzimuth3 = WellAzimuth3;
    }

    /**
     * @return the WellDepth4
     */
    public String getWellDepth4() {
        return WellDepth4;
    }

    /**
     * @param WellDepth4 the WellDepth4 to set
     */
    public void setWellDepth4(String WellDepth4) {
        this.WellDepth4 = WellDepth4;
    }

    /**
     * @return the WellDegree4
     */
    public String getWellDegree4() {
        return WellDegree4;
    }

    /**
     * @param WellDegree4 the WellDegree4 to set
     */
    public void setWellDegree4(String WellDegree4) {
        this.WellDegree4 = WellDegree4;
    }

    /**
     * @return the WellAzimuth4
     */
    public String getWellAzimuth4() {
        return WellAzimuth4;
    }

    /**
     * @param WellAzimuth4 the WellAzimuth4 to set
     */
    public void setWellAzimuth4(String WellAzimuth4) {
        this.WellAzimuth4 = WellAzimuth4;
    }

    /**
     * @return the WellDepth5
     */
    public String getWellDepth5() {
        return WellDepth5;
    }

    /**
     * @param WellDepth5 the WellDepth5 to set
     */
    public void setWellDepth5(String WellDepth5) {
        this.WellDepth5 = WellDepth5;
    }

    /**
     * @return the WellDegree5
     */
    public String getWellDegree5() {
        return WellDegree5;
    }

    /**
     * @param WellDegree5 the WellDegree5 to set
     */
    public void setWellDegree5(String WellDegree5) {
        this.WellDegree5 = WellDegree5;
    }

    /**
     * @return the WellAzimuth5
     */
    public String getWellAzimuth5() {
        return WellAzimuth5;
    }

    /**
     * @param WellAzimuth5 the WellAzimuth5 to set
     */
    public void setWellAzimuth5(String WellAzimuth5) {
        this.WellAzimuth5 = WellAzimuth5;
    }
}
