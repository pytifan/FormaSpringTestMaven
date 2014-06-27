package org.region.forms.osvoenie.spring.controller;

import freemarker.template.TemplateModelException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import net.sf.jooreports.templates.image.ImageSource;
import net.sf.jooreports.templates.image.RenderedImageSource;
import org.apache.commons.io.output.ByteArrayOutputStream;

public class ReportGenerator extends AbstractDocumentGenerator {

    @Override
    protected Object getModel(HttpServletRequest request) throws UnsupportedEncodingException, TemplateModelException {
        Map <String, Object> model = new HashMap <>();
        model.put("L", request.getParameter("wellDepth"));
        System.out.println("L:  " + request.getParameter("wellDepth"));
       // model.put("Width", request.getParameter("internalDiamCasing1"));
        model.put("chart1", getImageProvider(request));
    Map <String, ArrayList<String>> mapListList = new LinkedHashMap <>();
        for (Enumeration <String> enumeration = request.getParameterNames(); enumeration.hasMoreElements();) {
            String key = enumeration.nextElement();
            model.put(key, request.getParameter(key));
            String splitStr[] = key.split("\\.");
            if (splitStr.length > 1) {
                String keyFormap = splitStr[0].concat(".").concat(splitStr[2]);
                    if (splitStr[0].equals("T1")) { 
                         System.out.println("keyFormap "+keyFormap);
                         System.out.println("splitStr[0] "+splitStr[0]);
                        if (mapListList.containsKey(keyFormap)) {
                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);                   
                        } else {
                            ArrayList row = new ArrayList();
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);
                        }
                    }
                    if (splitStr[0].equals("T2")) {
//                        System.out.println("keyFormap "+keyFormap);
//                        System.out.println("splitStr[0] "+splitStr[0]);
                        if (mapListList.containsKey(keyFormap)) {
                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);                   
                        } else {
                            ArrayList row = new ArrayList();
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);
                        }
                    }
                    if (splitStr[0].equals("T3")) {
//                        System.out.println("keyFormap "+keyFormap);
//                        System.out.println("splitStr[0] "+splitStr[0]);
                        if (mapListList.containsKey(keyFormap)) {
                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);                   
                        } else {
                            ArrayList row = new ArrayList();
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);
                        }
                    }
                    if (splitStr[0].equals("T4")) {
//                        System.out.println("keyFormap "+keyFormap);
//                        System.out.println("splitStr[0] "+splitStr[0]);
                        if (mapListList.containsKey(keyFormap)) {
                            ArrayList row = (ArrayList)mapListList.get(keyFormap);
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);                   
                        } else {
                            ArrayList row = new ArrayList();
                            row.add(request.getParameter(key));
                            mapListList.put(keyFormap, row);
                        }
                    }
            }
        }
        List table1 = new ArrayList();List table2 = new ArrayList();List table3 = new ArrayList();List table4 = new ArrayList();
        for (Iterator it = mapListList.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
            if (entry.getKey().matches("T1.*")) {
                table1.add(entry.getValue());
                System.out.println("table1 "+table1);
            }
            if (entry.getKey().matches("T2.*")) {
                table2.add(entry.getValue());
                System.out.println("table2 "+table2);
            }
            if (entry.getKey().matches("T3.*")) {
                table3.add(entry.getValue());
                System.out.println("table3 "+table3);
            }
            if (entry.getKey().matches("T4.*")) {
                table4.add(entry.getValue());
                System.out.println("table4 "+table4);
            }
        }
        model.put("T1", table1);model.put("T2", table2);model.put("T3", table3);model.put("T4", table4);
        
//     HttpRequestParametersHashModel test = new HttpRequestParametersHashModel(request);
//          try {
//              for (TemplateModelIterator it = test.keys().iterator(); it.hasNext(); test.size()) {
//                  String key1 = it.next().toString();
//                  model.put(key1, test.get(key1));
//                  System.out.println(key1 + " : " + test.get(key1));
//                  }
//              } catch (TemplateModelException ex) {
//                  Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
//              }  return new HttpRequestParametersHashModel(request);   
        return model;
    }
    
    protected ImageSource getImageProvider(HttpServletRequest request) {
        RenderedImageSource imageProvider = new RenderedImageSource(createMyChart(request));
        return imageProvider;
    }

    private RenderedImage createMyChart(HttpServletRequest request) {
        BufferedImage image = new BufferedImage(300, 400, BufferedImage.TYPE_INT_ARGB);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", outputStream);
        } catch (IOException ioException) {
            throw new RuntimeException("should never happen: " + ioException.getMessage());
        }
        Graphics2D g = image.createGraphics();
        int L = 0;
        int W = 0;
        int L000 = 0;
        int Win = 0;
        try {
        L = (int) (Integer.parseInt(request.getParameter("wellDepth")) * 0.053333333);
        L000 = Integer.parseInt(request.getParameter("wellDepth"));
        W = Integer.parseInt(request.getParameter("T1.internalDiamCasing.1"));
        Win = Integer.parseInt(request.getParameter("T2.outerDiamSurface.1"));
        } catch (NumberFormatException e) {
            L = 0;
            W = 0;
            L000 = 0;
        }
        int x0 = 150 - W / 2;
        int y0 = (int) (200 - L / 2);
        g.setColor(Color.red);
        g.drawLine(x0, y0, x0, L + y0);
        g.drawLine(x0, L + y0, x0 + W, L + y0);
        g.drawLine(x0 + W, L + y0, x0 + W, y0);
        g.drawString("L = " + String.valueOf(L000) + " m", x0 - 20, L + y0 + 20);
        g.setColor(Color.GREEN);
        //int Win = Integer.parseInt(request.getParameter("outerDiamSurface1"));
        int x0in = 150 - Win / 2;
        int y0in = (int) (200 - L / 2);
        g.drawLine(x0in, y0in, x0in, L + y0);
        //g.drawLine(x0in, L+y0, x0in+Win, L+y0);
        g.drawLine(x0in + Win, L + y0, x0in + Win, y0);
        return image;
    }
}
