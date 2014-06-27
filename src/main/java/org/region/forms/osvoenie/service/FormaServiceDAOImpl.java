/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.region.forms.osvoenie.service;

import java.sql.SQLException;
import java.util.List;
import javax.transaction.Transactional;
import org.region.forms.osvoenie.form.dao.HibernateFormDAO;
import org.region.forms.osvoenie.form.data.Forma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexey
 */
@Service
public class FormaServiceDAOImpl implements FormaServiceDAO {
    
    @Autowired
    private HibernateFormDAO formadao;

    @Override
    //@Transactional
    public void create(Forma newforma) {
       formadao.create(newforma);
    }

    @Override
    @Transactional
    public void update(Forma formaToUpdate) throws SQLException {
        formadao.update(formaToUpdate);
    }

    @Override
    @Transactional
    public List<Forma> getAll() {
        return formadao.getAllforms();
    }

    @Override
    @Transactional
    public Forma findByFieldName(String fieldName) {
        return formadao.findByFieldName(fieldName);
    }

    @Override
    @Transactional
    public boolean remove(Forma form) {
        return formadao.remove(form);
    }

    @Override
    public Forma getForm(long id) {
       return formadao.getForm(id);
    }   
}
