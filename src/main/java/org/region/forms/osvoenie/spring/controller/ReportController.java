/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.region.forms.osvoenie.spring.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.region.forms.osvoenie.form.data.Forma;
import org.region.forms.osvoenie.service.FormaServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexey
 */
@Controller
@RequestMapping("/report/")
public class ReportController {
 
    private static final Logger logger = Logger.getLogger(FormController.class);
 
    @Autowired
    private FormaServiceDAO formaServiceDAO;
 
    @RequestMapping(method = RequestMethod.GET , value = "pdf")
    public ModelAndView generatePdfReport(ModelAndView modelAndView, HttpServletRequest request){
        logger.debug("--------------generate PDF report----------");
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        List<Forma> formsList = formaServiceDAO.getAllforms();
        
//    Map <String, ArrayList<String>> mapListList = new LinkedHashMap <>();
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
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(formsList);
        //parameterMap.put("T1", table1);parameterMap.put("T2", table2);parameterMap.put("T3", table3);parameterMap.put("T4", table4);
        parameterMap.put("datasource", JRdataSource); 
        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);
        return modelAndView;
    }//generatePdfReport
 
    @RequestMapping(method = RequestMethod.GET , value = "xls")
    public ModelAndView generateXlsReport(ModelAndView modelAndView){
        logger.debug("--------------generate XLS report----------");
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        List<Forma> formsList = formaServiceDAO.getAllforms(); 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(formsList); 
        parameterMap.put("datasource", JRdataSource); 
        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("xlsReport", parameterMap);
        return modelAndView; 
    }//generatePdfReport
 
    @RequestMapping(method = RequestMethod.GET , value = "csv")
    public ModelAndView generateCsvReport(ModelAndView modelAndView){
        logger.debug("--------------generate CSV report----------");
        Map<String,Object> parameterMap = new HashMap<String,Object>(); 
        List<Forma> formsList = formaServiceDAO.getAllforms();
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(formsList);
        parameterMap.put("datasource", JRdataSource);
        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("csvReport", parameterMap);
        System.out.println("TETS");
        return modelAndView;
    }//generatePdfReport
 
    @RequestMapping(method = RequestMethod.GET , value = "html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView){ 
        logger.debug("--------------generate HTML report----------");
        Map<String,Object> parameterMap = new HashMap<String,Object>(); 
        List<Forma> formsList = formaServiceDAO.getAllforms(); 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(formsList); 
        parameterMap.put("datasource", JRdataSource); 
        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);
        return modelAndView;
    }
    }//generatePdfReport
 
 