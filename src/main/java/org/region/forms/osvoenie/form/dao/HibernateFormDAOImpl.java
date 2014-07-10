/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.form.dao;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.region.forms.osvoenie.form.data.Forma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author alexey
 */
@Repository
public class HibernateFormDAOImpl implements HibernateFormDAO {

    private static final Logger LOG = Logger.getLogger(HibernateFormDAOImpl.class);

//@Resource(name = "sessionFactory")
@Autowired
 SessionFactory sessionFactory;
 
    @Override
    public void create(Forma newforma) {
        Transaction txn = null;
        Session session = null;
//        try {
            sessionFactory.getCurrentSession().save(newforma);
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            txn = session.beginTransaction();
//            session.save(newforma);
//            txn.commit();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (!txn.wasCommitted()) {
//                txn.rollback();
//            }
//            session.flush();
//            session.close();
//        }
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
    public List<Forma> getAllforms() {
        LOG.debug("Retrieving all forms");
//  // Retrieve session from Hibernate
//  // Create a Hibernate query (HQL)
//  Query query = session.createQuery("FROM  FORMS");
//  // Retrieve all
//  return  query.list();
		List<Forma> result = null;
		//Session session = null;		
		// try {
                Session session = sessionFactory.getCurrentSession();
		//	session = HibernateUtil.getSessionFactory().getCurrentSession();
		//	session.beginTransaction();
			result = session.createCriteria(Forma.class).list();
			for (Forma f:result){
				Hibernate.initialize(f.getId());
			}
		//	session.getTransaction().commit();
//		} finally {
//			if (session != null && session.isOpen()) {
//				session.close();
//			}
//		}
		return result;
    }
    
    /**
     * Retrieves a single form
     * @param id
     * @return 
     */
//      public Team getTeam(int id) {
//        Team team = (Team) getCurrentSession().get(Team.class, id);
//        return team;
//    }
    
    @Override
    public Forma getForm(long id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        // Retrieve existing form first
  //      session.beginTransaction();
        Forma forma = (Forma) session.get(Forma.class, id);
  //      session.getTransaction().commit();
        return forma;
    }  
    
    @Override
    public void update(Forma forma) throws SQLException {
//       		boolean result = false;
		Session session = null;
//		long testId = -1L;
//		String testFieldName = null;
//		
//		if (formaToUpdate == null || formaToUpdate.getId() < 0) {
//			LOG.trace("Invalid parameter, form wasn't created");
//			return result;
//		}
//		
//		List<Forma> forms = getAllforms();
//		for (Forma f:forms){
//			if (formaToUpdate.getId() == f.getId()){
//				testId = f.getId();
//			}
//			if (formaToUpdate.getFieldName().equals(f.getFieldName())) {
//				testFieldName = f.getFieldName();
//			}
//		}
//		
//		if (testId != -1L && testFieldName == null) {
//			try {
//				session = HibernateUtil.getSessionFactory().openSession();
//				session.beginTransaction();
//				session.update(formaToUpdate);
//				session.getTransaction().commit();
//				result = true;			
//			} finally {
//				if (session != null && session.isOpen()) {
//					session.close();
//				}
//			}
//		}
//		return result;
         session = sessionFactory.getCurrentSession();   
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
  //      session.beginTransaction();
        //Forma formaToUpdate = getForm(forma.getId());
        Forma formaToUpdate = (Forma) session.get(Forma.class, forma.getId());
        formaToUpdate.setFieldName(forma.getFieldName());
        formaToUpdate.setWellName(forma.getWellName());
        formaToUpdate.setDesiredJobDate(forma.getDesiredJobDate());
        session.update(formaToUpdate);
   //     session.getTransaction().commit();
    }

    @Override
    public void remove(long id) {
//        	boolean result = false;
		Session session = null;		
//		if (form == null) {
//			LOG.trace("Invalid parameter, form wasn't created");
//			return result;
//		}		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//			if (findByFieldName(form.getFieldName()) != null){
//				session.delete(form);
//				session.getTransaction().commit();
//				result = true;
//			}
//		} finally {
//			if (session != null && session.isOpen()) {
//				session.close();
//			}
//		}
//		return result;
                Forma forma = getForm(id);
        if (forma != null) {
            session = sessionFactory.getCurrentSession();
           // session = HibernateUtil.getSessionFactory().getCurrentSession();
        //    session.beginTransaction();
                session.delete(forma);
        //    session.getTransaction().commit();    
        }
    }
}
