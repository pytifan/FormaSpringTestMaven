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
<h1>
Downloads:</h1><p>
Click the download links below:</p>
<a href="${pageContext.request.contextPath}/report/xls">Download Excel</a><p>
</p>
<a href="${pageContext.request.contextPath}/report/pdf">Download PDF</a><p>
</p>
<a href="${pageContext.request.contextPath}/report/csv">Download CSV</a><p>
</p>
<a href="${pageContext.request.contextPath}/report/html">Download HTML</a>
    </body>
</html>
