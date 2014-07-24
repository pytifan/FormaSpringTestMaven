/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.service;

import java.sql.SQLException;
import java.util.List;
import org.region.forms.osvoenie.form.data.CalculationsData;
import org.region.forms.osvoenie.form.data.Forma;

/**
 *
 * @author alexey
 */
public interface FormaServiceDAO {

    public void create(Forma newforma);

    public void saveCalculations (CalculationsData calculationsData);
    
    public Forma getForm(long id);
    
    public void update(Forma formaToUpdate) throws SQLException;

    public List<Forma> getAllforms();

    public void remove(long id);
    
    public List<Forma> testJReport();
}
