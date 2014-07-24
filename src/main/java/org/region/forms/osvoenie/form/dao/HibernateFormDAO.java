/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.form.dao;

import java.sql.SQLException;
import java.util.List;
import org.region.forms.osvoenie.form.data.CalculationsData;
import org.region.forms.osvoenie.form.data.Forma;

/**
 *
 * @author alexey
 */
public interface HibernateFormDAO {

    /**
     * Create new form in database
     * @param newforma
     */
    public void create(Forma newforma);
    
    public void saveCalculations(CalculationsData calculationsData);

    public Forma getForm(long id);
    
    /**
     * Update existed forma
     *
     * @param formaToUpdate - the new form or form - changed form object
     * //@return true, if changing was successful, false, if it fails
     * @throws SQLException
     */
    public void update(Forma formaToUpdate) throws SQLException;

    /**
     * Find all forms in the database
     *
     * @return List<Forma> - List of all forms object in the database or null if connection fails
     */
    public List<Forma> getAllforms();

    /**
     * Remove form from database
     *
     * @param form - form to remove
     * @return - true, if form was removed, false, if removing fails or there is no such form in the database
     */
    public void remove(long id);
    
    public List<Forma> testJReport();
}
