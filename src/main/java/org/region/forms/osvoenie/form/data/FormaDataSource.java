///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package org.region.forms.osvoenie.form.data;
//
//import java.util.*;
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
//import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//
///**
// *
// * @author alexey
// */
//public class FormaDataSource extends JRAbstractBeanDataSourceProvider {
//
//    @Override
//    public JRDataSource create(JasperReport report) throws JRException {
//            Map <String, ArrayList<String>> mapListList = new LinkedHashMap <>();
//        for (Enumeration <String> enumeration = request.getParameterNames(); enumeration.hasMoreElements();) {
//            String key = enumeration.nextElement();
//            parameterMap.put(key, request.getParameter(key));
//            String splitStr[] = key.split("\\.");
//            if (splitStr.length > 1) {
//                String keyFormap = splitStr[0].concat(".").concat(splitStr[2]);
//                    if (splitStr[0].equals("T1")) { 
//                         System.out.println("keyFormap "+keyFormap);
//                         System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//                    if (splitStr[0].equals("T2")) {
////                        System.out.println("keyFormap "+keyFormap);
////                        System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//                    if (splitStr[0].equals("T3")) {
////                        System.out.println("keyFormap "+keyFormap);
////                        System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//                    if (splitStr[0].equals("T4")) {
////                        System.out.println("keyFormap "+keyFormap);
////                        System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//            }
//        }/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package org.region.forms.osvoenie.form.data;
//
//import java.util.*;
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
//import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//
///**
// *
// * @author alexey
// */
//public class FormaDataSource extends JRAbstractBeanDataSourceProvider {
//
//    @Override
//    public JRDataSource create(JasperReport report) throws JRException {
//            Map <String, ArrayList<String>> mapListList = new LinkedHashMap <>();
//        for (Enumeration <String> enumeration = request.getParameterNames(); enumeration.hasMoreElements();) {
//            String key = enumeration.nextElement();
//            parameterMap.put(key, request.getParameter(key));
//            String splitStr[] = key.split("\\.");
//            if (splitStr.length > 1) {
//                String keyFormap = splitStr[0].concat(".").concat(splitStr[2]);
//                    if (splitStr[0].equals("T1")) { 
//                         System.out.println("keyFormap "+keyFormap);
//                         System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//                    if (splitStr[0].equals("T2")) {
////                        System.out.println("keyFormap "+keyFormap);
////                        System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//                    if (splitStr[0].equals("T3")) {
////                        System.out.println("keyFormap "+keyFormap);
////                        System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//                    if (splitStr[0].equals("T4")) {
////                        System.out.println("keyFormap "+keyFormap);
////                        System.out.println("splitStr[0] "+splitStr[0]);
//                        if (mapListList.containsKey(keyFormap)) {
//                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);                   
//                        } else {
//                            ArrayList row = new ArrayList();
//                            row.add(request.getParameter(key));
//                            mapListList.put(keyFormap, row);
//                        }
//                    }
//            }
//        }
//        List table1 = new ArrayList();List table2 = new ArrayList();List table3 = new ArrayList();List table4 = new ArrayList();
//        for (Iterator it = mapListList.entrySet().iterator(); it.hasNext();) {
//            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
//            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
//            if (entry.getKey().matches("T1.*")) {
//                table1.add(entry.getValue());
//                System.out.println("table1 "+table1);
//            }
//            if (entry.getKey().matches("T2.*")) {
//                table2.add(entry.getValue());
//                System.out.println("table2 "+table2);
//            }
//            if (entry.getKey().matches("T3.*")) {
//                table3.add(entry.getValue());
//                System.out.println("table3 "+table3);
//            }
//            if (entry.getKey().matches("T4.*")) {
//                table4.add(entry.getValue());
//                System.out.println("table4 "+table4);
//            }
//        }
//        List items = new ArrayList();
//        
//        items.add(table1);items.add(table2);items.add(table3);items.add(table4);
//        return new JRBeanCollectionDataSource(items);
//        
//    }
//
//    @Override
//    public void dispose(JRDataSource dataSource) throws JRException {
//        
//    }
//    
//}

//        List table1 = new ArrayList();List table2 = new ArrayList();List table3 = new ArrayList();List table4 = new ArrayList();
//        for (Iterator it = mapListList.entrySet().iterator(); it.hasNext();) {
//            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
//            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
//            if (entry.getKey().matches("T1.*")) {
//                table1.add(entry.getValue());
//                System.out.println("table1 "+table1);
//            }
//            if (entry.getKey().matches("T2.*")) {
//                table2.add(entry.getValue());
//                System.out.println("table2 "+table2);
//            }
//            if (entry.getKey().matches("T3.*")) {
//                table3.add(entry.getValue());
//                System.out.println("table3 "+table3);
//            }
//            if (entry.getKey().matches("T4.*")) {
//                table4.add(entry.getValue());
//                System.out.println("table4 "+table4);
//            }
//        }
//        List items = new ArrayList();
//        
//        items.add(table1);items.add(table2);items.add(table3);items.add(table4);
//        return new JRBeanCollectionDataSource(items);
//        
//    }
//
//    @Override
//    public void dispose(JRDataSource dataSource) throws JRException {
//        
//    }
//    
//}
