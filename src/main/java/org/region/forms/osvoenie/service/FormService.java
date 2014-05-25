/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.region.forms.osvoenie.service;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.region.forms.osvoenie.form.Forma;
import org.springframework.stereotype.Service;

/**
 *
 * @author alex
 */
@Service("FormService")
@Transactional
public class FormService {
    protected static Logger logger = Logger.getLogger("service");
    
 //@Resource(name="sessionFactory")
 private SessionFactory sessionFactory;
 
  public List<Forma> getAll() {
  logger.debug("Retrieving all persons");
   
  // Retrieve session from Hibernate
  //Session session = sessionFactory.getCurrentSession();
  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
   
  // Create a Hibernate query (HQL)
  Query query = session.createQuery("FROM  Person");
   
  // Retrieve all
  return  query.list();
 }
  /**
  * Retrieves a single person
  */
 public Forma get(Integer id ) {
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Retrieve existing person first
  Forma forma = (Forma) session.get(Forma.class, id);
   
  return forma;
 }
 /**
  * Adds a new person
  */
 public void add(Forma forma) {
  logger.debug("Adding new person");
   
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Save
  session.save(forma);
 }
  
 /**
  * Deletes an existing person
  * @param id the id of the existing person
  */
 public void delete(Integer id) {
  logger.debug("Deleting existing person");
   
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Retrieve existing person first
  Forma forma = (Forma) session.get(Forma.class, id);
   
  // Delete 
  session.delete(forma);
 }
  
 /**
  * Edits an existing person
  */
 public void edit(Forma Forma) {
  logger.debug("Editing existing person");
   
  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();
   
  // Retrieve existing person via id
  Forma existingForma = (Forma) session.get(Forma.class, Forma.getId());
   
  // Assign updated values to this person
  existingForma.setFieldName(Forma.getFieldName());
  existingForma.setWellName(existingForma.getWellName());
  existingForma.setWellLocation(existingForma.getWellLocation());
  existingForma.setFormationName(existingForma.getFormationName());
  existingForma.setWellType(existingForma.getWellType());
  existingForma.setDesiredJobDate(existingForma.getDesiredJobDate());
 
  // Save updates
  session.save(existingForma);
 }
}
