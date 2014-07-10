///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package org.region.forms.osvoenie.form.dao;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
///**
// * Hibernate Utility class with a convenient method to get Session Factory
// * object.
// *
// * @author alexey
// */
//public class HibernateUtil {
//
//    private static SessionFactory sessionFactory;
//    private static ServiceRegistry serviceRegistry;
//    
//       private static SessionFactory configureSessionFactory() throws HibernateException {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        return sessionFactory;
//    }
//    
////    static {
////        try {
////            // Create the SessionFactory from standard (hibernate.cfg.xml) config file.
////            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
////        } catch (Throwable ex) {
////            // Log the exception. 
////            System.err.println("Initial SessionFactory creation failed." + ex);
////            throw new ExceptionInInitializerError(ex);
////        }
////    }
//    
////    public static SessionFactory getSessionFactory() {
////        return sessionFactory;
////    }
//    public static SessionFactory getSessionFactory() {
//        return configureSessionFactory();
//    }
//}
