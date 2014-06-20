/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.form.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.region.forms.osvoenie.form.data.Forma;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexey
 */
@Repository
public class HibernateFormDAO implements FormDAO {

    private static final Logger LOG = Logger.getLogger(HibernateFormDAO.class);

    @Override
    public void create(Forma newforma) {
        Transaction txn = null;
        Session session = null;
        try {          
            session = HibernateUtil.getSessionFactory().openSession();
            txn = session.beginTransaction();
            session.save(newforma);
            txn.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            if (!txn.wasCommitted()) {
                txn.rollback();
            }
            session.flush();
            session.close();
        }
        // HibernateUtil.getSessionFactory().getCurrentSession().save(newforma);
//        long result = -1L;
//        Session session = null;
//        long testId = -1L;
//        String testFieldName = null;
//        if (newforma == null || newforma.getId() < 0) {
//            LOG.trace("Invalid parameter, form wasn't created");
//            return result;
//        }
//        List<Forma> forms = findAll();
//        for (Forma nf : forms) {
//            if (newforma.getId() == nf.getId()) {
//                testId = nf.getId();
//            }
//            if (newforma.getFieldName().equals(nf.getFieldName())) {
//                testFieldName = nf.getFieldName();
//            }
//        }
//        if (testId == -1L && testFieldName == null) {
//            try {
//                session = HibernateUtil.getSessionFactory().openSession();
//                session.beginTransaction();
//                session.save(newforma);
//                session.getTransaction().commit();
//                result = newforma.getId();
//            } finally {
//                if (session != null && session.isOpen()) {
//                    session.close();
//                }
//            }
//        }
//        return result;
    }

    @Override
    public List<Forma> getAll() {
		List<Forma> result = null;
		Session session = null;		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			result = session.createCriteria(Forma.class).list();
//			for (Forma f:result){
//				Hibernate.initialize(f.getId());
//			}
			session.getTransaction().commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
    }
    
//  public List<Forma> getAll() {
//  logger.debug("Retrieving all persons"); 
//  // Retrieve session from Hibernate
//  //Session session = sessionFactory.getCurrentSession();
//  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//  // Create a Hibernate query (HQL)
//  Query query = session.createQuery("FROM  FORMS");
//  // Retrieve all
//  return  query.list();
// }
    
    @Override
    public boolean update(Forma formaToUpdate) throws SQLException {
       		boolean result = false;
		Session session = null;
		long testId = -1L;
		String testFieldName = null;
		
		if (formaToUpdate == null || formaToUpdate.getId() < 0) {
			LOG.trace("Invalid parameter, form wasn't created");
			return result;
		}
		
		List<Forma> forms = getAll();
		for (Forma f:forms){
			if (formaToUpdate.getId() == f.getId()){
				testId = f.getId();
			}
			if (formaToUpdate.getFieldName().equals(f.getFieldName())) {
				testFieldName = f.getFieldName();
			}
		}
		
		if (testId != -1L && testFieldName == null){
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.update(formaToUpdate);
				session.getTransaction().commit();
				result = true;			
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		return result;
    }

    @Override
    public Forma findByFieldName(String fieldName) {
        Session session = null;
		Forma result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select forma from forma in class "
					+ " package org.region.forms.osvoenie.form.data.Forma where forma.fieldName=:fieldName");	
			query.setString("fieldName", fieldName);
			
			@SuppressWarnings("rawtypes")
			List resList = query.list();
			if (resList.size() > 0){
				result = (Forma) resList.get(0);
			//	Hibernate.initialize(result.getRoles());
			}		
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
    }

    @Override
    public boolean remove(Forma form) {
        	boolean result = false;
		Session session = null;		
		if (form == null) {
			LOG.trace("Invalid parameter, form wasn't created");
			return result;
		}		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			if (findByFieldName(form.getFieldName()) != null){
				session.delete(form);
				session.getTransaction().commit();
				result = true;
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
    }
}
