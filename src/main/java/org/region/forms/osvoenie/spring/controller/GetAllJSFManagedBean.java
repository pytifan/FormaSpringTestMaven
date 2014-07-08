/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.region.forms.osvoenie.spring.controller;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import org.region.forms.osvoenie.form.data.Forma;
import org.region.forms.osvoenie.service.FormaServiceDAO;
import org.region.forms.osvoenie.service.FormaServiceDAOImpl;

/**
 *
 * @author alexey
 */
@ManagedBean
@Named(value = "getAllJSFManagedBean")
@SessionScoped
public class GetAllJSFManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private final FormaServiceDAO formaServiceDAO;
    private DataModel forms;
    private int recordCount = 1000;
    private int pageSize = 10;
    private Forma current;

    /**
     * Creates a new instance of GetAllJSFManagedBean
     */
    public GetAllJSFManagedBean() {
        formaServiceDAO = new FormaServiceDAOImpl();
    }

    public DataModel getAllForms() {
        if (forms == null) {
            forms = new ListDataModel(formaServiceDAO.getAllforms());
        }
        return forms;
    }
    
    void recreateModel() {
        forms = null;
    }  
//    public boolean isHasNextPage() {
//        if (endId + pageSize <= recordCount) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isHasPreviousPage() {
//        if (startId-pageSize > 0) {
//            return true;
//        }
//        return false;
//    }
//
//    public String next() {
//        startId = endId+1;
//        endId = endId + pageSize;
//        recreateModel();
//        return "index";
//    }
//
//    public String previous() {
//        startId = startId - pageSize;
//        endId = endId - pageSize;
//        recreateModel();
//        return "index";
//    }
    
    public int getPageSize() {
        return pageSize;
    }

    public String prepareView(){
        current = (Forma) getAllForms().getRowData();
        return "browse";
    }
    public String prepareList(){
        recreateModel();
        return "index";
    }
}
