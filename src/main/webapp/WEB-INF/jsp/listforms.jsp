<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMS LIST</title>
    </head>
    <body>
        <h1>List of forms</h1>
<p>Here you can see the list of the forms, edit them, remove or update.</p>

<table border="1px" cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th width="2%">id</th>
            <th width="15%">Field Name</th>
            <th width="15%">Well Name</th>
            <th width="10%">Desired Job Date</th>
            <th width="10%">actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${forms}" var="forma">
            <tr>
                <td align="center"><c:out value="${forma.id}"/></td>
                <td align="center"><c:out value="${forma.fieldname}"/></td>
                <td align="center"><c:out value="${forma.wellName}"/></td>
                <td align="center"><c:out value="${forma.desiredJobDate}"/></td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/edit/${forma.id}.html">Edit</a><br>
                    <a href="${pageContext.request.contextPath}/delete/${forma.id}.html">Delete</a><br>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/index.htm">Home page</a></p>
    </body>
</html>
