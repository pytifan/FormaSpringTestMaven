<%-- 
    Document   : home
    Created on : 27.06.2014, 11:02:48
    Author     : alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Home page</h1>  
<p>  
${message}<br>  
<a href="${pageContext.request.contextPath}/add.html">Add new form</a><br>  
<a href="${pageContext.request.contextPath}/listforms.html">Forms list</a><br>  
</p>  
    </body>
</html>
