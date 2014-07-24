<%-- 
    Document   : result
    Created on : 22.07.2014, 15:16:01
    Author     : alexey
--%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                <table>
            <tr>
                <td>Field Name :</td>
                <td>${forma.fieldname}</td>
            </tr>
            <tr>
                <td>Well Name :</td>
                <td>${forma.wellName}</td>
            </tr>
            <tr>
                <td>Desired Job Date:</td>
                <td>${forma.desiredJobDate}</td>
            </tr>
            <tr>
                <td>Formation Name :</td>
                <td>${forma.formationName}</td>
            </tr>
            <tr>
                <td> Calculations message:</td>
                <td>${calcMess}</td>
            </tr>
        </table>
    </body>
</html>
