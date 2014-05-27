<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
      <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
        <!--   <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
                <p><i>To display a different welcome page for this project, modify</i>
                    <tt>index.jsp</tt> <i>, or create your own welcome page then change
                        the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                        welcome page and also update the welcome-file setting in</i>
                    <tt>web.xml</tt>.</p>-->
        <h1>Бланки:</h1>
        <p><br></p>
<!--        <ul>
                  <li><a href="letter.html">Letter Form</a></li>
                       </li><a href="order.html">Order Form</a></li>
                       <li><a href="report.html">Report Form</a></li>
            <li><a href="Forma-Osvoenie.html">Бланк исходных данных для плана работ по освоению скважины</a></li>
        </ul>
        <p><br></p>
        <ul>
            <li><a href="Forma-OsvoenieX.xhtml">Бланк исходных данных ... .xhtml</a></li>        
        </ul>-->
        <p><br></p>
        <ul>
            <li style="width: 200px;">
                <a href="Forma-OsvoenieX.htm">Form</a>
            </li>
        </ul>
<!--        <ul>
            <li style="width: 100px;">
                <a href='<spring:url value="/jsp/Forma-Osvoenie.html" htmlEscape="true"/>'>FormA HTML</a>
            </li>
        </ul>
        <ul>
            <li style="width: 100px;">
                <a href="/letterForm">letterForm2</a></li>
        </ul>-->
    </body>
</html>
