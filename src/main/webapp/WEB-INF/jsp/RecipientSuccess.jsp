<%-- 
    Document   : RecipientSuccess
    Created on : Sep 19, 2013, 4:45:10 PM
    Author     : alex
--%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Forma Page</title>
    </head>
    <body>
        <h2>Forma</h2>
        <table>
            <tr>
                <td>Field Name :</td>
                <td>${forma.fieldName}</td>
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
                <td> Comments:</td>
                <td>${forma.comments}</td>
            </tr>
            <tr>
<%--            <td> Average diametr casing:</td>
                <td>${forma.avdiamcas}</td>--%>
            </tr>
            <tr>
                <td> Test Rig:</td>
                <td>${forma.rig}</td>
            </tr>
        </table>
    </body>
</html>
