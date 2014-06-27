/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.service;

import java.sql.SQLException;
import java.util.List;
import org.region.forms.osvoenie.form.data.Forma;

/**
 *
 * @author alexey
 */
public interface FormaServiceDAO {

    public void create(Forma newforma);

    public Forma getForm(long id);
    
    void update(Forma formaToUpdate) throws SQLException;

    List<Forma> getAll();

    Forma findByFieldName(String fieldName);

    boolean remove(Forma form);
}
