<%-- 
    Document   : RecipientSuccess
    Created on : Sep 19, 2013, 4:45:10 PM
    Author     : alex
--%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <script type="text/javascript" src="webjars/jquery/2.0.3/jquery.js"></script>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Forma Page</title>
        <script type="text/javascript">
                    function doSubmit(form) {
                    form.action = "${pageContext.request.contextPath}/RecepientSuccess/Calculate";
            }
        </script>
    </head>
    <body>
        <script>
            $(document).ready(function() {
            $("#fig").click(function() { 
                        // draw(7000, 150, 100);
                                               draw(${forma.fieldname}, ${forma.wellName}, ${forma.formationName});
            });});
                function draw(L, IDcs, OD) {
                    var c = document.getElementById("myCanvas");
                            alert("L=" + L + ", IDcs=" + IDcs + ", OD=" + OD + ", (IDcs-OD)/2=" + (IDcs - OD) / 2 + ", (IDcs+OD)/2=" + (parseInt(IDcs) + parseInt(OD)) / 2);
                            var ctx = c.getContext("2d");
//                            c.width = 700;
//                            c.hight = 700;
                            ctx.lineWidth = "3";
                            ctx.beginPath();
                            ctx.strokeStyle = "purple"; // Purple path
                            ctx.moveTo((parseInt(IDcs) - parseInt(OD)) / 2, 0);
                            ctx.lineTo((parseInt(IDcs) - parseInt(OD)) / 2, L / 20); // 400-высота canvas-блока делим на 8000m=Lmax = 1/20
                            ctx.lineTo((parseInt(IDcs) + parseInt(OD)) / 2, L / 20);
                            ctx.lineTo((parseInt(IDcs) + parseInt(OD)) / 2, 0);
                            ctx.font = "17px Arial";
                            // Show the different textAlign values
                            ctx.textAlign = "right";
                            ctx.fillText("L =" + L + " m", parseInt(IDcs), parseInt(L / 20) + parseInt(20));
                            ctx.stroke();
                            ctx.lineWidth = "3";
                            ctx.beginPath();
                            ctx.strokeStyle = "green"; // Green path
                            ctx.moveTo(0, 0); // 400-высота canvas-блока делим на 8000m=Lmax = 1/20
                            ctx.lineTo(0, L / 20);
                            ctx.lineTo(IDcs, L / 20);
                            ctx.lineTo(IDcs, 0);
                            ctx.stroke();
                            ctx.fillStyle = "#FF0000";
                            ctx.fillRect((parseInt(IDcs) - parseInt(OD)) / 2, L / 40, ((parseInt(IDcs) + parseInt(OD)) / 2) - ((parseInt(IDcs) - parseInt(OD)) / 2), 50);
                    }
        </script>
        <div id='d2' style="position:absolute; top:70px; left:1050px; z-index:2">  
            <canvas id="myCanvas" width="500" height="500" style="border:1px solid #000000;"></canvas>
            <button id="fig" type="button" style="position: absolute; top:500px; left:0px; z-index:2">Draw a scheme of the well!</button>
        </div>
        <h2>Forma</h2>
    <form:form method="POST" commandName="RecipientSuccess">
        <tr><td>
        <form:label path="Rho">Rho </form:label>
        <form:input path="Rho" id="Rho" type="text" value="1020.0" name="Rho" size="25"/>
        </td></tr>
        <tr><td>
        <form:label path="g">g </form:label>
        <form:input path="g" id="g" type="text" value="9.81" name="g" size="25"/>
        </td></tr>
        <tr><td>
        <input type="submit" name="Calculate" onclick="doSubmit(form);" value="Calculate"/>
        </td></tr>
    </form:form>            
            <spring:message code="start" /> 
    </body>
</html>
