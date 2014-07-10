// JOOReports - The Open Source Java/OpenOffice Report Engine
// Copyright (C) 2004-2006 - Mirko Nasato <mirko@artofsolving.com>
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
// http://www.gnu.org/copyleft/lesser.html //
package org.region.forms.osvoenie.spring.controller;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/**
 * Base class for predefined document generators.
 *
 * Predefined generators load a template with the same name as the request URI,
 * build a model from the request and generate the response document.
 */
public abstract class AbstractDocumentGenerator extends AbstractController {
//    Logger log = LoggerFactory.getLogger(AbstractDocumentGenerator.class);
//    public void startSOfficeService() throws InterruptedException, IOException {
//    	//First we need to check if the soffice process is running
//    	String commands = "pgrep soffice";
//    	Process process = Runtime.getRuntime().exec(commands);
//    	//Need to wait for this command to execute
//    	int code = process.waitFor();
//    	//If we get anything back from readLine, then we know the process is running
//    	BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//    	if (in.readLine() == null) {
//    		//Nothing back, then we should execute the process
//    		process = Runtime.getRuntime().exec("/etc/init.d/soffice.sh");
//    		code = process.waitFor();
//    		log.debug("soffice script started");
//    	} else {
//    		log.debug("soffice script is already running");
//    	}
//    	in.close();
//    }  
    protected abstract Object getModel(HttpServletRequest request) throws Exception;
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        renderDocument(getModel(request), request, response);
        return null;
    }

    private Resource getTemplateDirectory(String documentName) throws IOException {
        String directoryName = "WEB-INF/templates/" + documentName + "-template";
        return getApplicationContext().getResource(directoryName);
    }

    private Resource getTemplateFile(String documentName) throws IOException {
        String templateName = "WEB-INF/templates/" + documentName + "-template.odt";
        return getApplicationContext().getResource(templateName);
    }

    private void renderDocument(Object model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentConverter converter = (DocumentConverter) getApplicationContext().getBean("documentConverter");
        DocumentFormatRegistry formatRegistry = (DocumentFormatRegistry) getApplicationContext().getBean("documentFormatRegistry");
        String outputExtension = FilenameUtils.getExtension(request.getRequestURI());
        DocumentFormat outputFormat = formatRegistry.getFormatByFileExtension(outputExtension);
        if (outputFormat == null) {
            throw new ServletException("unsupported output format: " + outputExtension);
        }
        File templateFile = null;
        String documentName = FilenameUtils.getBaseName(request.getRequestURI());
        Resource templateDirectory = getTemplateDirectory(documentName);
        if (templateDirectory.exists()) {
            templateFile = templateDirectory.getFile();
        } else {
            templateFile = getTemplateFile(documentName).getFile();
            if (!templateFile.exists()) {
                throw new ServletException("template not found: " + documentName);
            }
        }

        DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
        DocumentTemplate template = documentTemplateFactory.getTemplate(templateFile);
//      Map configurations = template.getConfigurations();
//      configurations.put("process_jooscript_only", Boolean.FALSE);

        ByteArrayOutputStream odtOutputStream = new ByteArrayOutputStream();
        try {
            template.createDocument(model, odtOutputStream);
        } catch (DocumentTemplateException exception) {
            throw new ServletException(exception);
        }
    
        response.setContentType(outputFormat.getMimeType());
        response.setHeader("Content-Disposition", "inline; filename=" + documentName + "." + outputFormat.getFileExtension()); 

        if ("odt".equals(outputFormat.getFileExtension())) {
            // no need to convert
            response.getOutputStream().write(odtOutputStream.toByteArray());
        } else if ("txt".equals(outputFormat.getFileExtension())) {
            // no need to convert  
            //Get a text file writer (Can also pass a "File" object)
            request.setCharacterEncoding("UTF-8");
            final String path = request.getParameter("destination");
            final String fname = request.getParameter("fname");
            
            System.out.println("text-filename " + request.getParameter("text-filename"));
            System.out.println("fname " + request.getParameter("fname"));
            System.out.println("documentName " + documentName);
            System.out.println("ResourceUtils: " + ResourceUtils.getFile(documentName));
            System.out.println("rootPath " + request.getSession().getServletContext().getRealPath(path));
            response.setHeader("Content-Disposition", "inline; filename=" + documentName + "." + outputFormat.getFileExtension()); 
            
//            System.out.println("request.getContextPath() " + request.getPathTranslated());
//            JFileChooser chooser = new JFileChooser();
//            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//            int option = chooser.showSaveDialog(null);
//            if (option == JFileChooser.APPROVE_OPTION)
//            { // do soemthing }
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+ "/" + documentName + "." + outputFormat.getFileExtension()), "UTF-8"));
//            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "/" + fname), "UTF-8"));
            try (BufferedWriter bw = new BufferedWriter(out)) {
                Enumeration keys = request.getParameterNames();
                while (keys.hasMoreElements()) {
                    String key = (String) keys.nextElement();
                    //To retrieve a single value
                    String value = request.getParameter(key).trim();
                    // If the same key has multiple values (check boxes)
                    // Enumeration valueArray = request.getParameterNames();
                    bw.write(key + "=" + value + ",");
                }
            }   
        } else {
            ByteArrayInputStream odtInputStream = new ByteArrayInputStream(odtOutputStream.toByteArray());
            DocumentFormat inputFormat = formatRegistry.getFormatByFileExtension("odt");
            converter.convert(odtInputStream, inputFormat, response.getOutputStream(), outputFormat);
        }
    }
}
