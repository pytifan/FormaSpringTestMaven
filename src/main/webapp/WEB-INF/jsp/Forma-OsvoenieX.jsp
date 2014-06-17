<%-- Document   : Forma-OsvoenieX
    Created on : 11.09.2013, 17:37:50
    Author     : alex --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <link type="text/css" href="resources/css/ui-darkness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
    <script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui-1.10.4.custom.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function($){
                  $("#desiredJobDate").datepicker({
                    showOn: "both",
                  //dateFormat: "dd/mm/yy",
                    buttonImage: 'resources/css/ui-darkness/images/calendar.gif', // 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif',                
                    buttonImageOnly: true
                  });
          });     
	</script>
        <link rel="shortcut icon" href="pict/favicon.ico" type="image/vnd.microsoft.icon"/>
<!--        <script type="text/javascript" src="<c:url value="/resources/jquery-1.4.min.js" /> "></script>-->
        <title>Бланк исходных данных для плана работ по освоению скважины</title>
        <script type="text/javascript" src="webjars/jquery/2.0.3/jquery.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                var cnt = 2; var cnt1 = 6; var cnt2 = 5; var cnt3 = 9;
                $("#add_1").click(function() {
                    $('#dataTable1 tr').last().after('<tr><td><input type="checkbox"/></td><td><input type="text" name="T1.topDepthCasingADD.' + cnt + '"</td>\n\
                    <td><input type="text" name="T1.botomDepthCasingADD.' + cnt + '"></td><td><select name="T1.casingADD.' + cnt + '" style="width:185px;">\n\
                    <option value="" selected="selected"></option><option value="Незацемент. обсадн. кол./Free casing">Незацемент. обсадн. кол./Free casing</option>\n\
                    <option value="Зацемент. обсадн. кол./Cemented casing">Зацемент. обсадн. кол./Cemented casing</option></select></td>\n\
                    <td><select name="T1.casingTipADD.' + cnt + '" style="width:150px;"><option value="" selected="selected"></option>\n\
                    <option value="Кондуктор">Кондуктор</option><option value="Техническая">Техническая</option>\n\
                    <option value="Эксплуатационная">Эксплуатационная</option><option value="Хвостовик">Хвостовик</option></select></td>\n\
                    <td><input type="text" name="T1.maxPressureCasingADD.' + cnt + '"/></td><td><input type="text" name="T1.outerDiamCasingADD.' + cnt + '"/></td>\n\
                    <td><input type="text" name="T1.weightCasingADD.' + cnt + '"/></td><td><input type="text" name="T1.internalDiamCasingADD.' + cnt + '" value="0.0"/></td>\n\
                    <td><input type="text" name="T1.steelCasingADD.' + cnt + '"/></td></tr>');
                    cnt++;
                });
                $("#add_2").click(function() {  
                    $('#dataTable2 tr').last().after('<tr><td><input type="checkbox"/></td><td><input type="text" name="T2.topDepthSurfaceADD.' + cnt1 + '"/></td>\n\
                        <td><input type="text" name="T2.botomDepthSurfaceADD.' + cnt1 + '"/></td><td><select name="T2.surfaceLineTubigADD.' + cnt1 + '" style="width:185px;">\n\
                        <option value="" selected="selected"></option><option value="НКТ/Tubing">НКТ/Tubing</option><option value="Бурильная колонна/Drill pipe">Бурильная колонна/Drill pipe</option>\n\
                        <option value="Пакер/Packer">Пакер/Packer</option><option value="Наземная линия/Surface line">Наземная линия/Surface line</option>\n\
                        <option value="Наземная ГНКТ/Surface CTU">Наземная ГНКТ/Surface CTU</option><option value="Переходник/Cross over">Переходник/Cross over</option>\n\
                        </select></td><td><input type="text" name="T2.maxPressureSurfaceADD.' + cnt1 + '"/></td><td><input type="text" name="T2.outerDiamSurfaceADD.' + cnt1 + '"/></td>\n\
                        <td><input type="text" name="T2.weightSurfaceADD.' + cnt1 + '"/></td><td><input type="text" name="T2.internalDiamSurfaceADD.' + cnt1 + '" value="0.0"/></td>\n\
                        <td><input type="text" name="T2.steelSurfaceADD.' + cnt1 + '"/></td></tr>');
                    cnt1++;
                });
                $("#add_3").click(function() {
                    $('#dataTable3 tr').last().after('<tr><td><input type="checkbox"/></td><td><input type="text" name="T3.DownholeDepthADD.' + cnt2 + '"/></td>\n\
                            <td><input type="text" name="T3.DownholeEquipTypeADD.' + cnt2 + '"/></td><td><input type="text" name="T3.DownholeMaxPressADD.' + cnt2 + '"/></td>\n\
                            <td><input type="text" name="T3.DownholeOutDiamADD.' + cnt2 + '"/></td><td><input type="text" name="T3.DownholeInterDiamADD.' + cnt2 + '"/></td></tr>');
                    cnt2++;
                });
                $("#add_4").click(function() {
                    $('#dataTable4 tr').last().after('<tr><td><input type="checkbox"/></td><td><input type="text" name="T4.WellDepthADD.' + cnt3 + '"/></td>\n\
                            <td><input type="text" name="T4.WellDegreeADD.' + cnt3 + '"/></td><td><input type="text" name="T4.WellAzimuthADD.' + cnt3 + '"/></td></tr>');
                    cnt3++;
                });
//                $("#rem_1").click(function() { $('#dataTable1 tr:last-child').remove(); });
            });

        //            function addRow(tableID) {
        //                var table = document.getElementById(tableID);
        //                var rowCount = table.rows.length;
        //                var row = table.insertRow(rowCount);
        //                var colCount = table.rows[0].cells.length;   
        //                for (var i = 0; i < colCount; i++) {
        //                    var newcell = row.insertCell(i);
        //                    newcell.innerHTML = table.rows[rowCount-1].cells[i].innerHTML;
        //                    newcell.setAttribute('name','newname');
        //                    //alert(newcell.childNodes);
        //                    switch (newcell.childNodes[0].type) {
        //                        case "text":
        //                            newcell.childNodes[0].value = "";
        //                            break;
        //                        case "checkbox":
        //                            newcell.childNodes[0].checked = false;
        //                            break;
        //                        case "select-one":
        //                            newcell.childNodes[0].selectedIndex = 0;
        //                            break;
        //                    }
        //                }
        //            }
            function deleteRow(tableID) {
                try {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    for (var i = 0; i < rowCount; i++) {
                        var row = table.rows[i]; var chkbox = row.cells[0].childNodes[0];
                        if (null != chkbox && true == chkbox.checked) {
                            if (rowCount <= 2) { alert("Cannot delete all the rows."); break; }
                            table.deleteRow(i); rowCount--; i--;
                        }
                    }
                } catch (e) { alert(e); }
            }
        </script>
        <script> function collectArr() {
//                var columns = $('#dataTable1 thead th').map(function() {
//                     /*This assumes that your headings are suitable to be used as
//                      JavaScript object keys. If the headings contain characters 
//                      that would be invalid, such as spaces or dashes, you should
//                      use a regex here to strip those characters out.*/
//                    return $(this).text(); });              
                var tblinfo = [];
                var $trs = $("#dataTable1 tr");
                $trs.each(function(i){ //go through each row
                  tblinfo[i] = [];
                  $(this).children().each(function(j){ //go through each column
                    tblinfo[i][j] = $(this).children('input, select').val();
                   });
                });
                alert(tblinfo);
                return tblinfo;
            }
        </script>
        <script type="text/javascript">
            function doSubmit(form) {
            document.forms[0].date.value = new Date().toLocaleString();
                    // set appropriate format extension
                    form.action = 'formaOsvoenie.' + form.format.value;
                    // form.reset();
                    // window.location.reload(true);
                    // document.location.reload();
            }         
            function doSubmit2() {
            form.window.location.reload(true);
                    window.location.reload(true);
            }
            function doSubmit3(form) {
                    form.action = "Forma-OsvoenieX.htm/add";
            }
        </script>
    </head>
    <body>
        <script>
            $(document).ready(function() {
            $("#fig").click(function() {  draw(
                   document.getElementById("wellDepth").value, document.getElementById("IDcas1").value, document.getElementById("OD1").value);
            });});
                function draw(L, IDcs, OD) {
                    var c = document.getElementById("myCanvas");
                            alert("L=" + L + ", IDcs=" + IDcs + ", OD=" + OD + ", (IDcs-OD)/2=" + (IDcs - OD) / 2 + ", (IDcs+OD)/2=" + (parseInt(IDcs) + parseInt(OD)) / 2);
                            var ctx = c.getContext("2d");
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
        <div id='d2' style="position:absolute; top:670px; left:1050px; z-index:2">  
            <canvas id="myCanvas" width="500" height="500" style="border:1px solid #000000;"></canvas>
            <button id="fig" type="button" style="position: absolute; top:500px; left:0px; z-index:2">Draw a scheme of the well!</button>
        </div>
        <h1 style="color: darkolivegreen;font-family: sans-serif , Times New Roman">
            Бланк исходных данных для плана работ по освоению скважины<br/>
            Initial data form for job design of well nitrogen lift</h1>
        <p><!--<img src="pict/region_logo_small.gif" height="75" alt="Region_logo" style="a: right">--></p>
        <p style="font-size: small;font-style: italic; color: blue">
            Please fill in the form. </p>
        <h3 style="color: tomato;">
            1. Well Information – Информация о скважине<br/></h3>
        <h4 style="color: brown">
            1.1. Общие данные – General data </h4>
        <!--    <form id="myForm">-->
        <form:form method="POST" modelAttribute="forma" id="formid">
            <%--    <form:form id="myForm" modelAttribute="account" action="Forma-OsvoenieX.htm" method="post"> --%>
            <table id="first">
                <tr>
                    <td>1. Field Name<br/>
                        Название бассейна (месторождения): </td>
                    <td>
                      <%-- <form:input path="fieldName" id="fieldName" type="text" name="fieldName" size="35"/> --%>
                        <input id="fieldName" type="text" name="fieldName" size="35"/>
                    </td>
                </tr>
                <tr>
                    <td>2. Well Name<br/>
                        Название скважины: </td>
                    <td><form:input path="wellName" id="wellName" type="text" name="wellName" size="35"/></td>
                </tr>
                <tr>
                    <td>3. Well Location<br/>
                        Место расположения скважины: </td>
                    <td><form:input path="wellLocation" id="wellLocation" type="text" name="wellLocation" size="35"/></td>
                </tr>
                <tr>
                    <td>4. Formation Name<br/>
                        Название образований: </td>
                    <td><input id="formationName" type="text" name="formationName" size="35"/></td>
                </tr>
                <tr>
                    <td>5. Well Type (oil or gas)<br/>
                        Тип скважины (нефтяная или газовая):</td>
                    <td><input id="wellType" type="text" name="wellType" size="35"/></td>
                </tr>
                <tr>
                    <td>6. Desired job date<br/>
                        Желаемая дата проведения работ: </td>
                    <td>
                        <input type="text" id="desiredJobDate" name="desiredJobDate" size="35">
                    </td>
                </tr>
                <tr>
                    <td>7. Slabbed well site/road to the well site <br/>
                        Плиты на скважине/подъездам к скважине </td>
                    <td><input id="slabbedWellSite" type="text" name="slabbedWellSite" size="35"/></td>
                </tr>
                <tr>
                    <td>8.Electricity on the well site<br/>
                        Электричество на скважине</td>
                    <td><input id="electricity" type="text" name="electricity" size="35"/></td>
                </tr>
                <tr>
                    <td>9. Rig on the well site<br/>
                        Наличие буровой установки на скважине</td>
                    <td><input id="rig" type="text" name="rig" size="35"/></td>
                </tr>
                <tr>
                    <td>10. Company name<br/>
                        Компания</td>
                    <td><input id="companyName" type="text" name="companyName" size="35"/></td>
                </tr>
                <tr>
                    <td>11. Company Representative<br/>
                        Представитель компании</td>
                    <td><input id="companyRepresentative" type="text" name="companyRepresentative" size="35"/></td>
                </tr>
                <tr>
                    <td>12. Comments<br/>
                        Комментарии</td>
                    <td><input id="comments" type="text" name="comments" size="35"/></td>
                </tr>
            </table>
            <h4 style="color: brown">
                1.2. Данные по скважине – Well data </h4>
            <table id="second">
                <tr>
                    <td>1. Тип скважинной головки и фонтанной арматуры<br/>(указать давления опрессовки)<br/>
                        Well head and Christmas tree type (specify testing pressure)  
                    </td> 
                    <td><input id="headChristmasTree" type="text" name="headChristmasTree" size="35"/></td>    
                </tr>
                <tr>
                    <td>2. Наличие, тип и глубина установки пакера<br/>
                        Presence of packer, its type and depth of the installation      
                    </td>  
                    <td><input id="packer" type="text" name="packer" size="35"/></td>   
                </tr>
                <tr>
                    <td>3. Глубина скважины (м)<br/>
                        Well depth (m)
                    </td>  
                    <td><input id="wellDepth" type="text" name="wellDepth" size="35"/></td>    
                </tr>
                <tr>
                    <td>4. Текущий забой (м)<br/>
                        PBTH depth (m)                       
                    </td>  
                    <td><input id="PBTHdepth" type="text" name="PBTHdepth" size="35"/></td>    
                </tr>
                <tr>
                    <td> 5.Интервал перфорации<br/>
                        Perforation interval                      
                    </td>  
                    <td><input id="perforationInterval" type="text" name="perforationInterval" size="35"/></td>   
                </tr>
                <tr>
                    <td>6. Состояние скважины, уровень и плотность скважинной жидкости<br/>
                        Well state, well fluid level and density                      
                    </td> 
                    <td><input id="fluidLevelDensity" type="text" name="fluidLevelDensity" size="35"/></td>   
                </tr>
                <tr>
                    <td>7. Пластовое давление<br/>
                        Formation pressure                     
                    </td> 
                    <td><input id="formationPressure" type="text" name="formationPressure" size="35"/></td>   
                </tr>
                <tr>
                    <td>8. Пластовая температура<br/>
                        Formation temperature                     
                    </td> 
                    <td><input id="formationTemperature" type="text" name="formationTemperature" size="35"/></td>   
                </tr>
                <tr>
                    <td>9. Наличие факельного амбара<br/>
                        Flare pit availability                     
                    </td> 
                    <td><input id="isFlarePit" type="text" name="isFlarePit" size="35"/></td>   
                </tr>
                <tr>
                    <td>10. Объем жидкости, поглощенной во время работ<br/>
                        Volume of fluid consumed during workover</td>
                    <td><input id="consumedVolume" type="text" name="consumedVolume" size="35"/></td>   
                </tr>
            </table>                  
            <h3 style="color: tomato">
                2. Well Construction – Конструкция скважины<br/></h3>
            <h4 style="color: brown">
                2.1. Параметры обсадной колонны – Casing parameters</h4>
            <table id="dataTable1" border="1">
                <thead>
                    <tr><th></th>
                        <th>Замер. глубина верха (м)<br/>
                            Top measured depth (m)</th>
                        <th>Замер. глубина низа (м)<br/>
                            Bot measured depth (m)</th>
                        <th>Обсадная колонна<br/>
                            Casing<br/></th>
                        <th>Тип колонны<br/></th>
                        <th>Макс. допуст. давл.(МПа)<br/>
                            Max. allowable pressure</th>
                        <th>Наруж диам. (см)<br/>
                            Outer diam. (cm)</th>
                        <th>Вес (кг/м)<br/>
                            Weight (kg/m)</th>
                        <th>Внутр. диам. (см)<br/>
                            Internal diam.(cm)</th>
                        <th>Марка стали<br/>
                            Steel Grade</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <TD><INPUT type="checkbox" name="chk"/></TD>
                        <td><input id="topDepthCasing1" type="text" name="T1.topDepthCasing.1"/></td>
                        <td><input id="botomDepthCasing1" type="text" name="T1.botomDepthCasing.1"/></td>
                        <td><select id="casing1" name="T1.casing.1" style="width:185px;">
                                <option value="" selected="selected"></option>
                                <option value="Незацемент. обсадн. кол./Free casing">Незацемент. обсадн. кол./Free casing</option>
                                <option value="Зацемент. обсадн. кол./Cemented casing">Зацемент. обсадн. кол./Cemented casing</option>
                            </select></td>
                        <td><select id="casingTip1" name="T1.casingTip.1" style="width:150px;">
                                <option value="" selected="selected"></option>
                                <option value="Кондуктор">Кондуктор</option>
                                <option value="Техническая">Техническая</option>
                                <option value="Эксплуатационная">Эксплуатационная</option>
                                <option value="Хвостовик">Хвостовик</option>                            
                            </select></td>
                        <td><input id="maxPressureCasing1" type="text" name="T1.maxPressureCasing.1"/></td>
                        <td><input id="outerDiamCasing1" type="text" name="T1.outerDiamCasing.1"/></td>
                        <td><input id="weightCasing1" type="text" name="T1.weightCasing.1"/></td>
                        <td><input id="IDcas1" type="text" name="T1.internalDiamCasing.1" value="0.0"/></td>
                        <td><input id="steelCasing1" type="text" name="T1.steelCasing.1"/></td>
                    </tr>
<!--                    <tr><TD><INPUT type="checkbox" name="chk"/></TD>
                        <td><input id="topDepthCasing2" type="text" name="row2.topDepthCasing2"/></td>
                        <td><input id="botomDepthCasing2" type="text" name="row2.botomDepthCasing2"/></td>
                        <td><select id="casing2" name="row2.casing2" style="width:185px;">
                                <option value="" selected="selected"></option>
                                <option value="Незацемент. обсадн. кол./Free casing">Незацемент. обсадн. кол./Free casing</option>
                                <option value="Зацемент. обсадн. кол./Cemented casing">Зацемент. обсадн. кол./Cemented casing</option>
                            </select></td>
                        <td><select id="casingTip2" name="row2.casingTip2" style="width:150px;">
                                <option value="" selected="selected"></option>
                                <option value="Кондуктор">Кондуктор</option>
                                <option value="Техническая">Техническая</option>
                                <option value="Эксплуатационная">Эксплуатационная</option>
                                <option value="Хвостовик">Хвостовик</option>                            
                            </select></td>
                        <td><input id="maxPressureCasing2" type="text" name="row2.maxPressureCasing2"/></td>
                        <td><input id="outerDiamCasing2" type="text" name="row2.outerDiamCasing2"/></td>
                        <td><input id="weightCasing2" type="text" name="row2.weightCasing2"/></td>
                        <td><input id="IDcas2" type="text" name="row2.internalDiamCasing2" value="0"/></td>
                        <td><input id="steelCasing2" type="text" name="row2.steelCasing2"/></td>
                    </tr>
                    <tr><TD><INPUT type="checkbox" name="chk"/></TD>
                        <td><input id="topDepthCasing3" type="text" name="row3.topDepthCasing3"/></td>
                        <td><input id="botomDepthCasing3" type="text" name="row3.botomDepthCasing3"/></td>
                        <td><select id="casing3" name="row3.casing3" style="width:185px;">
                                <option value="" selected="selected"></option>
                                <option value="Незацемент. обсадн. кол./Free casing">Незацемент. обсадн. кол./Free casing</option>
                                <option value="Зацемент. обсадн. кол./Cemented casing">Зацемент. обсадн. кол./Cemented casing</option>
                            </select></td>
                        <td><select id="casingTip3" name="row3.casingTip3" style="width:150px;">
                                <option value="" selected="selected"></option>
                                <option value="Кондуктор">Кондуктор</option>
                                <option value="Техническая">Техническая</option>
                                <option value="Эксплуатационная">Эксплуатационная</option>
                                <option value="Хвостовик">Хвостовик</option>                            
                            </select></td>
                        <td><input id="maxPressureCasing3" type="text" name="row3.maxPressureCasing3"/></td>
                        <td><input id="outerDiamCasing3" type="text" name="row3.outerDiamCasing3"/></td>
                        <td><input id="weightCasing3" type="text" name="row3.weightCasing3"/></td>
                        <td><input id="IDcas3" type="text" name="row3.internalDiamCasing3" value="0"/></td>
                        <td><input id="steelCasing3" type="text" name="row3.steelCasing3"/></td>
                    </tr>
                    <tr><TD><INPUT type="checkbox" name="chk"/></TD>
                        <td><input id="topDepthCasing4" type="text" name="row4.topDepthCasing4"/></td>
                        <td><input id="botomDepthCasing4" type="text" name="row4.botomDepthCasing4"/></td>
                        <td><select id="casing4" name="row4.casing4" style="width:185px;">
                                <option value="" selected="selected"></option>
                                <option value="Незацемент. обсадн. кол./Free casing">Незацемент. обсадн. кол./Free casing</option>
                                <option value="Зацемент. обсадн. кол./Cemented casing">Зацемент. обсадн. кол./Cemented casing</option>
                            </select></td>
                        <td><select id="casingTip4" name="row4.casingTip4" style="width:150px;">
                                <option value="" selected="selected"></option>
                                <option value="Кондуктор">Кондуктор</option>
                                <option value="Техническая">Техническая</option>
                                <option value="Эксплуатационная">Эксплуатационная</option>
                                <option value="Хвостовик">Хвостовик</option>                            
                            </select></td>
                        <td><input id="maxPressureCasing4" type="text" name="row4.maxPressureCasing4"/></td>
                        <td><input id="outerDiamCasing4" type="text" name="row4.outerDiamCasing4"/></td>
                        <td><input id="weightCasing4" type="text" name="row4.weightCasing4" /></td>
                        <td><input id="IDcas4" type="text" name="row4.internalDiamCasing4" value="0"/></td>
                        <td><input id="steelCasing4" type="text" name="row4.steelCasing4"/></td>
                    </tr>
                    <tr><TD><INPUT type="checkbox" name="chk"/></TD>
                        <td><input id="topDepthCasing5" type="text" name="row5.topDepthCasing5"/></td>
                        <td><input id="botomDepthCasing5" type="text" name="row5.botomDepthCasing5"/></td>
                        <td><select id="casing5" name="row5.casing5" style="width:185px;">
                                <option value="" selected="selected"></option>
                                <option value="Незацемент. обсадн. кол./Free casing">Незацемент. обсадн. кол./Free casing</option>
                                <option value="Зацемент. обсадн. кол./Cemented casing">Зацемент. обсадн. кол./Cemented casing</option>
                            </select></td>
                        <td><select id="casingTip5" name="row5.casingTip5" style="width:150px;">
                                <option value="" selected="selected"></option>
                                <option value="Кондуктор">Кондуктор</option>
                                <option value="Техническая">Техническая</option>
                                <option value="Эксплуатационная">Эксплуатационная</option>
                                <option value="Хвостовик">Хвостовик</option>                            
                            </select></td>
                        <td><input id="maxPressureCasing5" type="text" name="row5.maxPressureCasing5"/></td>
                        <td><input id="outerDiamCasing5" type="text" name="row5.outerDiamCasing5"/></td>
                        <td><input id="weightCasing5" type="text" name="row5.weightCasing5"/></td>
                        <td><input id="IDcas5" type="text" name="row5.internalDiamCasing5" value="0"/></td>
                        <td><input id="steelCasing5" type="text" name="row5.steelCasing5"/></td>
                    </tr>-->
                </tbody>
            </table>
            <INPUT id="add_1" type="button" value="Add Row" onclick="addRow('dataTable1')" />
            <INPUT id="rem_1" type="button" value="Delete Row" onclick="deleteRow('dataTable1')" />
            <h4 style="color: brown">
                2.2. Параметры наземной линии/НКТ – Surface line/Tubing parameters</h4>
            <table id="dataTable2" border="1">
                <thead>
                    <tr>
                        <td>№</td>
                        <td>Замер. глубина верха (м)<br/>
                            Top measured depth (m)</td>
                        <td>Замер. глубина низа (м)<br/>
                            Bot measured depth (m)</td>
                        <td>Наземная линия/НКТ<br/>
                            Surface line/Tubing<br/></td>
                        <td>Макс. допуст. давл.(МПа)<br/>
                            Max. allowable pressure</td>
                        <td>Наруж диам. (см)<br/>
                            Outer diam. (cm)</td>
                        <td>Вес (кг/м)<br/>
                            Weight (kg/m)</td>
                        <td>Внутр. диам. (см)<br/>
                            Internal diam.(cm)</td>
                        <td>Марка стали<br/>4
                            Steel Grade</td>
                    </tr> </thead>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="topDepthSurface1" type="text" name="T2.topDepthSurface.1"/></td>
                    <td><input id="botomDepthSurface1" type="text" name="T2.botomDepthSurface.1"/></td>
                    <td><select id="surfaceLineTubig1" name="T2.surfaceLineTubig.1" style="width:185px;">
                            <option value="" selected="selected"></option>
                            <option value="НКТ/Tubing">НКТ/Tubing</option>
                            <option value="Бурильная колонна/Drill pipe">Бурильная колонна/Drill pipe</option>
                            <option value="Пакер/Packer">Пакер/Packer</option>
                            <option value="Наземная линия/Surface line">Наземная линия/Surface line</option>
                            <option value="Наземная ГНКТ/Surface CTU">Наземная ГНКТ/Surface CTU</option>
                            <option value="Переходник/Cross over">Переходник/Cross over</option>
                        </select></td>
                    <td><input id="maxPressureSurface1" type="text" name="T2.maxPressureSurface.1"/></td>
                    <td><input id="OD1" type="text" name="T2.outerDiamSurface.1"/></td>
                    <td><input id="weightSurface1" type="text" name="T2.weightSurface.1"/></td>
                    <td><input id="internalDiamSurface1" type="text" name="T2.internalDiamSurface.1" value="0"/></td>
                    <td><input id="steelSurface1" type="text" name="T2.steelSurface.1"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="topDepthSurface2" type="text" name="T2.topDepthSurface.2"/></td>
                    <td><input id="botomDepthSurface2" type="text" name="T2.botomDepthSurface.2"/></td>
                    <td><select id="surfaceLineTubig2" name="T2.surfaceLineTubig.2" style="width:185px;">
                            <option value="" selected="selected"></option>
                            <option value="НКТ/Tubing">НКТ/Tubing</option>
                            <option value="Бурильная колонна/Drill pipe">Бурильная колонна/Drill pipe</option>
                            <option value="Пакер/Packer">Пакер/Packer</option>
                            <option value="Наземная линия/Surface line">Наземная линия/Surface line</option>
                            <option value="Наземная ГНКТ/Surface CTU">Наземная ГНКТ/Surface CTU</option>
                            <option value="Переходник/Cross over">Переходник/Cross over</option>
                        </select></td>
                    <td><input id="maxPressureSurface2" type="text" name="T2.maxPressureSurface.2"/></td>
                    <td><input id="OD2" type="text" name="T2.outerDiamSurface.2"/></td>
                    <td><input id="weightSurface2" type="text" name="T2.weightSurface.2"/></td>
                    <td><input id="internalDiamSurface2" type="text" name="T2.internalDiamSurface.2" value="0"/></td>
                    <td><input id="steelSurface2" type="text" name="T2.steelSurface.2"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="topDepthSurface3" type="text" name="T2.topDepthSurface.3"/></td>
                    <td><input id="botomDepthSurface3" type="text" name="T2.botomDepthSurface.3"/></td>
                    <td><select id="surfaceLineTubig3" name="T2.surfaceLineTubig.3" style="width:185px;">
                            <option value="" selected="selected"></option>
                            <option value="НКТ/Tubing">НКТ/Tubing</option>
                            <option value="Бурильная колонна/Drill pipe">Бурильная колонна/Drill pipe</option>
                            <option value="Пакер/Packer">Пакер/Packer</option>
                            <option value="Наземная линия/Surface line">Наземная линия/Surface line</option>
                            <option value="Наземная ГНКТ/Surface CTU">Наземная ГНКТ/Surface CTU</option>
                            <option value="Переходник/Cross over">Переходник/Cross over</option>
                        </select></td>
                    <td><input id="maxPressureSurface3" type="text" name="T2.maxPressureSurface.3"/></td>
                    <td><input id="OD3" type="text" name="T2.outerDiamSurface.3"/></td>
                    <td><input id="weightSurface3" type="text" name="T2.weightSurface.3"/></td>
                    <td><input id="internalDiamSurface3" type="text" name="T2.internalDiamSurface.3" value="0"/></td>
                    <td><input id="steelSurface3" type="text" name="T2.steelSurface.3"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="topDepthSurface4" type="text" name="T2.topDepthSurface.4"/></td>
                    <td><input id="botomDepthSurface4" type="text" name="T2.botomDepthSurface.4"/></td>
                    <td><select id="surfaceLineTubig4" name="T2.surfaceLineTubig.4" style="width:185px;">
                            <option value="" selected="selected"></option>
                            <option value="НКТ/Tubing">НКТ/Tubing</option>
                            <option value="Бурильная колонна/Drill pipe">Бурильная колонна/Drill pipe</option>
                            <option value="Пакер/Packer">Пакер/Packer</option>
                            <option value="Наземная линия/Surface line">Наземная линия/Surface line</option>
                            <option value="Наземная ГНКТ/Surface CTU">Наземная ГНКТ/Surface CTU</option>
                            <option value="Переходник/Cross over">Переходник/Cross over</option>
                        </select></td>
                    <td><input id="maxPressureSurface4" type="text" name="T2.maxPressureSurface.4"/></td>
                    <td><input id="OD4" type="text" name="T2.outerDiamSurface.4"/></td>
                    <td><input id="weightSurface4" type="text" name="T2.weightSurface.4"/></td>
                    <td><input id="internalDiamSurface4" type="text" name="T2.internalDiamSurface.4" value="0"/></td>
                    <td><input id="steelSurface4" type="text" name="T2.steelSurface.4"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="topDepthSurface5" type="text" name="T2.topDepthSurface.5"/></td>
                    <td><input id="botomDepthSurface5" type="text" name="T2.botomDepthSurface.5"/></td>
                    <td><select id="surfaceLineTubig5" name="T2.surfaceLineTubig.5" style="width:185px;">
                            <option value="" selected="selected"></option>
                            <option value="НКТ/Tubing">НКТ/Tubing</option>
                            <option value="Бурильная колонна/Drill pipe">Бурильная колонна/Drill pipe</option>
                            <option value="Пакер/Packer">Пакер/Packer</option>
                            <option value="Наземная линия/Surface line">Наземная линия/Surface line</option>
                            <option value="Наземная ГНКТ/Surface CTU">Наземная ГНКТ/Surface CTU</option>
                            <option value="Переходник/Cross over">Переходник/Cross over</option>
                        </select></td>
                    <td><input id="maxPressureSurface5" type="text" name="T2.maxPressureSurface.5"/></td>
                    <td><input id="OD5" type="text" name="T2.outerDiamSurface.5"/></td>
                    <td><input id="weightSurface5" type="text" name="T2.weightSurface.5"/></td>
                    <td><input id="internalDiamSurface5" type="text" name="T2.internalDiamSurface.5" value="0"/></td>
                    <td><input id="steelSurface5" type="text" name="T2.steelSurface.5"/></td>
                </tr>
            </table>
            <INPUT id="add_2" type="button" value="Add Row" onclick="addRow('dataTable2')" />
            <INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable2')" />   
            <h4 style="color: brown">
                2.3. Подземное оборудование – Downhole equipment</h4>
            <h5>Внести данные по установленному внутрискважинному оборудованию и сужениях в НКТ (переходник, ниппель и т.п.).<br/>
                Input data on installed downhole equipment and tubing constrictions (adapter, nipple etc.)</h5>
            <table id="dataTable3" border="1">
                <thead>
                    <tr>
                        <td>№</td>
                        <td>Замер. глубина (м)<br/>
                            Measured depth (m)</td>
                        <td>Тип оборудования<br/>
                            Type of the equipment</td>
                        <td>Макс. допуст. давл.(МПа)<br/>
                            Max. allowable pressure</td>
                        <td>Наруж. диам. (см)<br/>
                            Outer diam. (cm)</td>
                        <td>Внутр. диам. (см)<br/>
                            Internal diam.(cm)</td>
                    </tr> </thead>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="DownholeDepth1" type="text" name="T3.DownholeDepth.1"/></td>
                    <td><input id="DownholeEquipType1" type="text" name="T3.DownholeEquipType.1"/></td>
                    <td><input id="DownholeMaxPress1" type="text" name="T3.DownholeMaxPress.1"/></td>
                    <td><input id="DownholeOutDiam1" type="text" name="T3.DownholeOutDiam.1"/></td>
                    <td><input id="DownholeInterDiam1" type="text" name="T3.DownholeInterDiam.1"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="DownholeDepth2" type="text" name="T3.DownholeDepth.2"/></td>
                    <td><input id="DownholeEquipType2" type="text" name="T3.DownholeEquipType.2"/></td>
                    <td><input id="DownholeMaxPress2" type="text" name="T3.DownholeMaxPress.2"/></td>
                    <td><input id="DownholeOutDiam2" type="text" name="T3.DownholeOutDiam.2"/></td>
                    <td><input id="DownholeInterDiam2" type="text" name="T3.DownholeInterDiam.2"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="DownholeDepth3" type="text" name="T3.DownholeDepth.3"/></td>
                    <td><input id="DownholeEquipType3" type="text" name="T3.DownholeEquipType.3"/></td>
                    <td><input id="DownholeMaxPress3" type="text" name="T3.DownholeMaxPress.3"/></td>
                    <td><input id="DownholeOutDiam3" type="text" name="T3.DownholeOutDiam.3"/></td>
                    <td><input id="DownholeInterDiam3" type="text" name="T3.DownholeInterDiam.3"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="DownholeDepth4" type="text" name="T3.DownholeDepth.4"/></td>
                    <td><input id="DownholeEquipType4" type="text" name="T3.DownholeEquipType.4"/></td>
                    <td><input id="DownholeMaxPress4" type="text" name="T3.DownholeMaxPress.4"/></td>
                    <td><input id="DownholeOutDiam4" type="text" name="T3.DownholeOutDiam.4"/></td>
                    <td><input id="DownholeInterDiam4" type="text" name="T3.DownholeInterDiam.4"/></td>
                </tr>                     
            </table>
            <INPUT id="add_3" type="button" value="Add Row" onclick="addRow('dataTable3')" />
            <INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable3')" />
            <h4 style="color: brown">
                2.4. Инклинометрия – Directional Survey
            </h4>
            <h5>В таблицу внести имеющиеся данные<br/>
                1.2. Данные по скважине – Well data (или приложить полные данные по инклинометрии):<br/>
                Input mentioned data to the table (or attach full directional survey data):</h5>
            <table id="dataTable4" border="1">
                <thead>
                    <tr>
                        <td>№</td>
                        <td>Замер. глубина (м)<br/>
                            Measured depth (m)</td>
                        <td>Угол (º)<br/>
                            Degree(º)</td>
                        <td>Азимут (º)<br/>
                            Azimuth (º)</td>
                    </tr> </thead>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth1" type="text" name="T4.WellDepth.1"/></td>
                    <td><input id="WellDegree1" type="text" name="T4.WellDegree.1"/></td>
                    <td><input id="WellAzimuth1" type="text" name="T4.WellAzimuth.1"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth2" type="text" name="T4.WellDepth.2"/></td>
                    <td><input id="WellDegree2" type="text" name="T4.WellDegree.2"/></td>
                    <td><input id="WellAzimuth2" type="text" name="T4.WellAzimuth.2"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth3" type="text" name="T4.WellDepth.3"/></td>
                    <td><input id="WellDegree3" type="text" name="T4.WellDegree.3"/></td>
                    <td><input id="WellAzimuth3" type="text" name="T4.WellAzimuth.3"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth4" type="text" name="T4.WellDepth.4"/></td>
                    <td><input id="WellDegree4" type="text" name="T4.WellDegree.4"/></td>
                    <td><input id="WellAzimuth4" type="text" name="T4.WellAzimuth.4"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth5" type="text" name="T4.WellDepth.5"/></td>
                    <td><input id="WellDegree5" type="text" name="T4.WellDegree.5"/></td>
                    <td><input id="WellAzimuth5" type="text" name="T4.WellAzimuth.5"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth6" type="text" name="T4.WellDepth.6"/></td>
                    <td><input id="WellDegree6" type="text" name="T4.WellDegree.6"/></td>
                    <td><input id="WellAzimuth6" type="text" name="T4.WellAzimuth.6"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth7" type="text" name="T4.WellDepth.7"/></td>
                    <td><input id="WellDegree7" type="text" name="T4.WellDegree.7"/></td>
                    <td><input id="WellAzimuth7" type="text" name="T4.WellAzimuth.7"/></td>
                </tr>
                <tr>
                    <TD><INPUT type="checkbox" name="chk"/></TD>
                    <td><input id="WellDepth8" type="text" name="T4.WellDepth.8"/></td>
                    <td><input id="WellDegree8" type="text" name="T4.WellDegree.8"/></td>
                    <td><input id="WellAzimuth8" type="text" name="T4.WellAzimuth.8"/></td>
                </tr>
            </table>    
            <INPUT id="add_4" type="button" value="Add Row" onclick="addRow('dataTable4')" />
            <INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable4')" />
            <p></p>
            ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            <p><br/><br/><br/></p>
            <table>
                <tr>
                    <td>Preferred Format: </td>
                    <td>
                        <select name="format">
                            <option value="pdf" selected="selected">Portable Document Format (pdf)</option>
                            <option value="odt">OpenDocument Text (odt)</option>
                            <option value="doc">Microsoft Word (doc)</option>
                            <option value="txt">txt</option> <!--<option value="rtf">Rich Text Format (rtf)</option>-->
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="hidden" name="date" value=""/>
                        <input id="submitMe" type="submit"  onclick="doSubmit(form);" name="Save" value="Save Form"/>
                        <input type="submit" name="Calculate" value="Calculate"/>
                        <input type="submit" name="add" onclick="doSubmit3(form);" value="add"/>
                        <p> Destination:
                            <input type="text" name="destination" value="/home/alexey/Загрузки"/>
<!--                        <p> Name:
                            <label><input type="file" class="filename" name="text-filename" id="text-filename" placeholder="a plain document"/>.txt</label>-->
                    </td>
                </tr>
            </table>
            <p></p>
            <!--                </form>-->
        </form:form> 
        <div id="PageFooter">
            <input type="file" id="files" name="file"/> Read bytes: 
            <span class="readBytesButtons">
                <!--  <button data-startbyte="0" data-endbyte="4">1-5</button>
                  <button data-startbyte="5" data-endbyte="14">6-15</button>
                  <button data-startbyte="6" data-endbyte="7">7-8</button>-->
                <button>Загрузить файл</button>
            </span>
            <div id="byte_range"></div>
            <div id="byte_content"></div>
            <script type="text/javascript">
                        function readBlob() { //opt_startByte, opt_stopByte) {
                        var files = document.getElementById('files').files;
                                if (!files.length) {
                        alert('Please select a file!');
                                return;
                        }
                        var file = files[0]; // var start = parseInt(opt_startByte)||0; // var stop = parseInt(opt_stopByte)||file.size-1;
                                var start = 0;
                                var stop = file.size - 1;
                                var reader = new FileReader();
                                // If we use onloadend, we need to check the readyState.
                                reader.onloadend = function(evt) {
                                if (evt.target.readyState === FileReader.DONE) { // DONE == 2
                                document.getElementById('byte_content').textContent = evt.target.result;
                                        document.getElementById('byte_range').textContent =
                                        ['Read bytes: ', start + 1, ' - ', stop + 1, ' of ', file.size, ' byte file'].join('');
                                        replacer(evt.target.result.split(','));
                                        //var uri = 'http://your.domain/product.aspx?category=4&product_id=2140&query=lcd+tv';          
                                        //var queryString = {};
                                        //evt.target.result.replace(new RegExp("([^?=&]+)(=([^&]*))?", "g"),
                                        //    function($0, $1, $2, $3) { queryString[$1] = $3; });
                                        //console.log('WellAzimuth8: ' + queryString['WellAzimuth8']);     // ID: 2140
                                        //console.log('Name: ' + queryString['product_name']); // Name: undefined
                                        //console.log('Category: ' + queryString['category']); // Category: 4
                                }
                                };
                                var blob = file.slice(start, stop + 1);
                                reader.readAsText(file, "utf-8"); //reader.readAsBinaryString(blob);
                        }
                document.querySelector('.readBytesButtons').addEventListener('click', function(evt) {
                if (evt.target.tagName.toLowerCase() === 'button') {
                //  var startByte = evt.target.getAttribute('data-startbyte'); var endByte = evt.target.getAttribute('data-endbyte');
                readBlob(); //startByte, endByte);
                }
                }, false);
                        function  replacer(arr) {
                        //First Table
                        document.getElementById('fieldName').value = arr[0].replace(new RegExp(/(fieldName=)(\w*)/), "$2"); //1
                                document.getElementById('wellName').value = arr[1].replace(new RegExp(/(wellName=)(\w*)/), "$2"); //2
                                document.getElementById('wellLocation').value = arr[2].replace(new RegExp(/(wellLocation=)(\w*)/), "$2"); //3
                                document.getElementById('formationName').value = arr[3].replace(new RegExp(/(formationName=)(\w*)/), "$2"); //4
                                document.getElementById('wellType').value = arr[4].replace(new RegExp(/(wellType=)(\w*)/), "$2"); //5
                                document.getElementById('desiredJobDate').value = arr[5].replace(new RegExp(/(desiredJobDate=)(\w*)/), "$2"); //6
                                document.getElementById('slabbedWellSite').value = arr[6].replace(new RegExp(/(slabbedWellSite=)(\w*)/), "$2"); //7
                                document.getElementById('electricity').value = arr[7].replace(new RegExp(/(electricity=)(\w*)/), "$2"); //8
                                document.getElementById('rig').value = arr[8].replace(new RegExp(/(rig=)(\w*)/), "$2"); //9
                                document.getElementById('companyName').value = arr[9].replace(new RegExp(/(companyName=)(\w*)/), "$2"); //10
                                document.getElementById('companyRepresentative').value = arr[10].replace(new RegExp(/(companyRepresentative=)(\w*)/), "$2"); //11
                                document.getElementById('comments').value = arr[11].replace(new RegExp(/(comments=)(\w*)/), "$2"); //12
                                //Second Table
                                document.getElementById('headChristmasTree').value = arr[12].replace(new RegExp(/(headChristmasTree=)(\w*)/), "$2"); //1
                                document.getElementById('packer').value = arr[13].replace(new RegExp(/(packer=)(\w*)/), "$2"); //2
                                document.getElementById('wellDepth').value = arr[14].replace(new RegExp(/(wellDepth=)(\w*)/), "$2"); //3
                                document.getElementById('PBTHdepth').value = arr[15].replace(new RegExp(/(PBTHdepth=)(\w*)/), "$2"); //4
                                document.getElementById('perforationInterval').value = arr[16].replace(new RegExp(/(perforationInterval=)(\w*)/), "$2"); //5
                                document.getElementById('fluidLevelDensity').value = arr[17].replace(new RegExp(/(fluidLevelDensity=)(\w*)/), "$2"); //6
                                document.getElementById('formationPressure').value = arr[18].replace(new RegExp(/(formationPressure=)(\w*)/), "$2"); //7
                                document.getElementById('formationTemperature').value = arr[19].replace(new RegExp(/(formationTemperature=)(\w*)/), "$2"); //8
                                document.getElementById('isFlarePit').value = arr[20].replace(new RegExp(/(isFlarePit=)(\w*)/), "$2"); //9
                                document.getElementById('consumedVolume').value = arr[21].replace(new RegExp(/(consumedVolume=)(\w*)/), "$2"); //10
                                //Third Table
                                document.getElementById('topDepthCasing1').value = arr[22].replace(new RegExp(/(T1.topDepthCasing.1=)(\w*)/), "$2");
                                document.getElementById('botomDepthCasing1').value = arr[23].replace(new RegExp(/(T1.botomDepthCasing.1=)(\w*)/), "$2");
                                var myselect = document.getElementById("casing1");
                                for (var i = 0; i < myselect.options.length; i++) {
                        if (myselect.options[i].text == arr[24].replace(new RegExp(/(T1.casing.1=)(\w*)/), "$2")){
                        myselect.options[i].selected = true;
                                break
                        }
                        }
                        var myselect = document.getElementById("casingTip1");
                                for (var i = 0; i < myselect.options.length; i++) {
                        if (myselect.options[i].text == arr[25].replace(new RegExp(/(T1.casingTip.1=)(\w*)/), "$2")){
                        myselect.options[i].selected = true;
                                break
                        }
                        }
                        document.getElementById('maxPressureCasing1').value = arr[26].replace(new RegExp(/(T1.maxPressureCasing.1=)(\w*)/), "$2");
                                document.getElementById('outerDiamCasing1').value = arr[27].replace(new RegExp(/(T1.outerDiamCasing.1=)(\w*)/), "$2");
                                document.getElementById('weightCasing1').value = arr[28].replace(new RegExp(/(T1.weightCasing.1=)(\w*)/), "$2");
                                document.getElementById('IDcas1').value = arr[29].replace(new RegExp(/(T1.internalDiamCasing.1=)(\w*)/), "$2");
                                document.getElementById('steelCasing1').value = arr[30].replace(new RegExp(/(T1.steelCasing.1=)(\w*)/), "$2");
                                
//                                document.getElementById('topDepthCasing2').value = arr[31].replace(new RegExp(/(T1.topDepthCasingADD.2=)(\w*)/), "$2");
//                                document.getElementById('botomDepthCasing2').value = arr[32].replace(new RegExp(/(T1.botomDepthCasingADD.2=)(\w*)/), "$2");
//                                var myselect = document.getElementById("casing2");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[33].replace(new RegExp(/(T1.casingADD.2=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }
//                        }
//                        var myselect = document.getElementById("casingTip2");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[34].replace(new RegExp(/(T1.casingTipADD.2=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }
//                        }
//                        document.getElementById('maxPressureCasing2').value = arr[35].replace(new RegExp(/(T1.maxPressureCasingADD.2=)(\w*)/), "$2");
//                                document.getElementById('outerDiamCasing2').value = arr[36].replace(new RegExp(/(T1.outerDiamCasingADD.2=)(\w*)/), "$2");
//                                document.getElementById('weightCasing2').value = arr[37].replace(new RegExp(/(T1.weightCasingADD.2=)(\w*)/), "$2");
//                                document.getElementById('IDcas2').value = arr[38].replace(new RegExp(/(T1.internalDiamCasingADD.2=)(\w*)/), "$2");
//                                document.getElementById('steelCasing2').value = arr[39].replace(new RegExp(/(T1.steelCasingADD.2=)(\w*)/), "$2");
//                                document.getElementById('topDepthCasing3').value = arr[40].replace(new RegExp(/(T1.topDepthCasingADD.3=)(\w*)/), "$2");
//                                document.getElementById('botomDepthCasing3').value = arr[41].replace(new RegExp(/(T1.botomDepthCasingADD.3=)(\w*)/), "$2");
//                                var myselect = document.getElementById("casing3");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[42].replace(new RegExp(/(T1.casingADD.3=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }
//                        }
//                        var myselect = document.getElementById("casingTip3");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[43].replace(new RegExp(/(T1.casingTipADD.3=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }
//                        }
//                        document.getElementById('maxPressureCasing3').value = arr[44].replace(new RegExp(/(T1.maxPressureCasingADD.3=)(\w*)/), "$2");
//                                document.getElementById('outerDiamCasing3').value = arr[45].replace(new RegExp(/(T1.outerDiamCasingADD.3=)(\w*)/), "$2");
//                                document.getElementById('weightCasing3').value = arr[46].replace(new RegExp(/(T1.weightCasingADD.3=)(\w*)/), "$2");
//                                document.getElementById('IDcas3').value = arr[47].replace(new RegExp(/(T1.internalDiamCasingADD.3=)(\w*)/), "$2");
//                                document.getElementById('steelCasing3').value = arr[48].replace(new RegExp(/(T1.steelCasingADD.3=)(\w*)/), "$2");
//                                document.getElementById('topDepthCasing4').value = arr[49].replace(new RegExp(/(T1.topDepthCasingADD.4=)(\w*)/), "$2");
//                                document.getElementById('botomDepthCasing4').value = arr[50].replace(new RegExp(/(T1.botomDepthCasingADD.4=)(\w*)/), "$2");
//                                var myselect = document.getElementById("casing4");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[51].replace(new RegExp(/(T1.casingADD.4=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }
//                        }
//                        var myselect = document.getElementById("casingTip4");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[52].replace(new RegExp(/(T1.casingTipADD.4=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }
//                        }
//                        document.getElementById('maxPressureCasing4').value = arr[53].replace(new RegExp(/(T1.maxPressureCasingADD.4=)(\w*)/), "$2");
//                                document.getElementById('outerDiamCasing4').value = arr[54].replace(new RegExp(/(T1.outerDiamCasingADD.4=)(\w*)/), "$2");
//                                document.getElementById('weightCasing4').value = arr[55].replace(new RegExp(/(T1.weightCasingADD.4=)(\w*)/), "$2");
//                                document.getElementById('IDcas4').value = arr[56].replace(new RegExp(/(T1.internalDiamCasingADD.4=)(\w*)/), "$2");
//                                document.getElementById('steelCasing4').value = arr[57].replace(new RegExp(/(T1.steelCasingADD.4=)(\w*)/), "$2");
//                                document.getElementById('topDepthCasing5').value = arr[58].replace(new RegExp(/(T1.topDepthCasingADD.5=)(\w*)/), "$2");
//                                document.getElementById('botomDepthCasing5').value = arr[59].replace(new RegExp(/(T1.botomDepthCasingADD.5=)(\w*)/), "$2");
//                                var myselect = document.getElementById("casing5");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[60].replace(new RegExp(/(T1.casingADD.5=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }                   // newcell.innerHTML = table.rows[rowCount-1].cells[i].innerHTML.;
//                        }
//                        var myselect = document.getElementById("casingTip5");
//                                for (var i = 0; i < myselect.options.length; i++) {
//                        if (myselect.options[i].text == arr[61].replace(new RegExp(/(T1.casingTipADD.5=)(\w*)/), "$2")){
//                        myselect.options[i].selected = true;
//                                break
//                        }
//                        }
//                        document.getElementById('maxPressureCasing5').value = arr[62].replace(new RegExp(/(T1.maxPressureCasingADD.5=)(\w*)/), "$2");
//                                document.getElementById('outerDiamCasing5').value = arr[63].replace(new RegExp(/(T1.outerDiamCasingADD.5=)(\w*)/), "$2");
//                                document.getElementById('weightCasing5').value = arr[64].replace(new RegExp(/(T1.weightCasingADD.5=)(\w*)/), "$2");
//                                document.getElementById('IDcas5').value = arr[65].replace(new RegExp(/(T1.internalDiamCasingADD.5=)(\w*)/), "$2");
//                                document.getElementById('steelCasing5').value = arr[66].replace(new RegExp(/(T1.steelCasingADD.5=)(\w*)/), "$2");
                        //Forth Table---------------------------------------------------------------------------------------------/////////////
                                document.getElementById('topDepthSurface1').value = arr[31].replace(new RegExp(/(T2.topDepthSurface.1=)(\w*)/), "$2");
                                document.getElementById('botomDepthSurface1').value = arr[32].replace(new RegExp(/(T2.botomDepthSurface.1=)(\w*)/), "$2");
                                var myselect = document.getElementById("surfaceLineTubig1");
                                for (var i = 0; i < myselect.options.length; i++) {
                        if (myselect.options[i].text == arr[33].replace(new RegExp(/(T2.surfaceLineTubig.1=)(\w*)/), "$2")){
                        myselect.options[i].selected = true;
                                break
                        }
                        }
                        document.getElementById('maxPressureSurface1').value = arr[34].replace(new RegExp(/(T2.maxPressureSurface.1=)(\w*)/), "$2");
                                document.getElementById('OD1').value = arr[35].replace(new RegExp(/(T2.outerDiamSurface.1=)(\w*)/), "$2");
                                document.getElementById('weightSurface1').value = arr[36].replace(new RegExp(/(T2.weightSurface.1=)(\w*)/), "$2");
                                document.getElementById('internalDiamSurface1').value = arr[37].replace(new RegExp(/(T2.internalDiamSurface.1=)(\w*)/), "$2");
                                document.getElementById('steelSurface1').value = arr[38].replace(new RegExp(/(T2.steelSurface.1=)(\w*)/), "$2");
                                document.getElementById('topDepthSurface2').value = arr[75].replace(new RegExp(/(T2.topDepthSurface.2=)(\w*)/), "$2");
                                document.getElementById('botomDepthSurface2').value = arr[76].replace(new RegExp(/(T2.botomDepthSurface.2=)(\w*)/), "$2");
                                var myselect = document.getElementById("surfaceLineTubig2");
                                for (var i = 0; i < myselect.options.length; i++) {
                        if (myselect.options[i].text == arr[77].replace(new RegExp(/(T2.surfaceLineTubig.2=)(\w*)/), "$2")){
                        myselect.options[i].selected = true;
                                break
                        }
                        }
                        document.getElementById('maxPressureSurface2').value = arr[78].replace(new RegExp(/(T2.maxPressureSurface.2=)(\w*)/), "$2");
                                document.getElementById('OD2').value = arr[79].replace(new RegExp(/(T2.outerDiamSurface.2=)(\w*)/), "$2");
                                document.getElementById('weightSurface2').value = arr[80].replace(new RegExp(/(T2.weightSurface.2=)(\w*)/), "$2");
                                document.getElementById('internalDiamSurface2').value = arr[81].replace(new RegExp(/(T2.internalDiamSurface.2=)(\w*)/), "$2");
                                document.getElementById('steelSurface2').value = arr[82].replace(new RegExp(/(T2.steelSurface.2=)(\w*)/), "$2");
                                document.getElementById('topDepthSurface3').value = arr[83].replace(new RegExp(/(T2.topDepthSurface.3=)(\w*)/), "$2");
                                document.getElementById('botomDepthSurface3').value = arr[84].replace(new RegExp(/(T2.botomDepthSurface.3=)(\w*)/), "$2");
                                var myselect = document.getElementById("surfaceLineTubig3");
                                for (var i = 0; i < myselect.options.length; i++) {
                        if (myselect.options[i].text == arr[85].replace(new RegExp(/(T2.surfaceLineTubig.3=)(\w*)/), "$2")){
                        myselect.options[i].selected = true;
                                break
                        }
                        }
                        document.getElementById('maxPressureSurface3').value = arr[86].replace(new RegExp(/(T2.maxPressureSurface.3=)(\w*)/), "$2");
                                document.getElementById('OD3').value = arr[87].replace(new RegExp(/(T2.outerDiamSurface.3=)(\w*)/), "$2");
                                document.getElementById('weightSurface3').value = arr[88].replace(new RegExp(/(T2.weightSurface.3=)(\w*)/), "$2");
                                document.getElementById('internalDiamSurface3').value = arr[89].replace(new RegExp(/(T2.internalDiamSurface.3=)(\w*)/), "$2");
                                document.getElementById('steelSurface3').value = arr[90].replace(new RegExp(/(T2.steelSurface.3=)(\w*)/), "$2");
                                document.getElementById('topDepthSurface4').value = arr[91].replace(new RegExp(/(T2.topDepthSurface.4=)(\w*)/), "$2");
                                document.getElementById('botomDepthSurface4').value = arr[92].replace(new RegExp(/(T2.botomDepthSurface.4=)(\w*)/), "$2");
                                var myselect = document.getElementById("surfaceLineTubig4");
                                for (var i = 0; i < myselect.options.length; i++) {
                        if (myselect.options[i].text == arr[93].replace(new RegExp(/(T2.surfaceLineTubig.4=)(\w*)/), "$2")){
                        myselect.options[i].selected = true;
                                break
                        }
                        }
                        document.getElementById('maxPressureSurface4').value = arr[94].replace(new RegExp(/(T2.maxPressureSurface.4=)(\w*)/), "$2");
                                document.getElementById('OD4').value = arr[95].replace(new RegExp(/(T2.outerDiamSurface.4=)(\w*)/), "$2");
                                document.getElementById('weightSurface4').value = arr[96].replace(new RegExp(/(T2.weightSurface.4=)(\w*)/), "$2");
                                document.getElementById('internalDiamSurface4').value = arr[97].replace(new RegExp(/(T2.internalDiamSurface.4=)(\w*)/), "$2");
                                document.getElementById('steelSurface4').value = arr[98].replace(new RegExp(/(T2.steelSurface.4=)(\w*)/), "$2");
                                document.getElementById('topDepthSurface5').value = arr[99].replace(new RegExp(/(T2.topDepthSurface.5=)(\w*)/), "$2");
                                document.getElementById('botomDepthSurface5').value = arr[100].replace(new RegExp(/(T2.botomDepthSurface.5=)(\w*)/), "$2");
                                var myselect = document.getElementById("surfaceLineTubig5");
                                for (var i = 0; i < myselect.options.length; i++) {
                        if (myselect.options[i].text == arr[101].replace(new RegExp(/(T2.surfaceLineTubig.5=)(\w*)/), "$2")){
                        myselect.options[i].selected = true;
                                break
                        }
                        }
                        document.getElementById('maxPressureSurface5').value = arr[102].replace(new RegExp(/(T2.maxPressureSurface.5=)(\w*)/), "$2");
                                document.getElementById('OD5').value = arr[103].replace(new RegExp(/(T2.outerDiamSurface.5=)(\w*)/), "$2");
                                document.getElementById('weightSurface5').value = arr[104].replace(new RegExp(/(T2.weightSurface.5=)(\w*)/), "$2");
                                document.getElementById('internalDiamSurface5').value = arr[105].replace(new RegExp(/(T2.internalDiamSurface.5=)(\w*)/), "$2");
                                document.getElementById('steelSurface5').value = arr[106].replace(new RegExp(/(T2.steelSurface.5=)(\w*)/), "$2");
                                //Table Five
                                document.getElementById('DownholeDepth1').value = arr[107].replace(new RegExp(/(DownholeDepth1=)(\w*)/), "$2");
                                document.getElementById('DownholeEquipType1').value = arr[108].replace(new RegExp(/(DownholeEquipType1=)(\w*)/), "$2");
                                document.getElementById('DownholeMaxPress1').value = arr[109].replace(new RegExp(/(DownholeMaxPress1=)(\w*)/), "$2");
                                document.getElementById('DownholeOutDiam1').value = arr[110].replace(new RegExp(/(DownholeOutDiam1=)(\w*)/), "$2");
                                document.getElementById('DownholeInterDiam1').value = arr[111].replace(new RegExp(/(DownholeInterDiam1=)(\w*)/), "$2");
                                document.getElementById('DownholeDepth2').value = arr[112].replace(new RegExp(/(DownholeDepth2=)(\w*)/), "$2");
                                document.getElementById('DownholeEquipType2').value = arr[113].replace(new RegExp(/(DownholeEquipType2=)(\w*)/), "$2");
                                document.getElementById('DownholeMaxPress2').value = arr[114].replace(new RegExp(/(DownholeMaxPress2=)(\w*)/), "$2");
                                document.getElementById('DownholeOutDiam2').value = arr[115].replace(new RegExp(/(DownholeOutDiam2=)(\w*)/), "$2");
                                document.getElementById('DownholeInterDiam2').value = arr[116].replace(new RegExp(/(DownholeInterDiam2=)(\w*)/), "$2");
                                document.getElementById('DownholeDepth3').value = arr[117].replace(new RegExp(/(DownholeDepth3=)(\w*)/), "$2");
                                document.getElementById('DownholeEquipType3').value = arr[118].replace(new RegExp(/(DownholeEquipType3=)(\w*)/), "$2");
                                document.getElementById('DownholeMaxPress3').value = arr[119].replace(new RegExp(/(DownholeMaxPress3=)(\w*)/), "$2");
                                document.getElementById('DownholeOutDiam3').value = arr[120].replace(new RegExp(/(DownholeOutDiam3=)(\w*)/), "$2");
                                document.getElementById('DownholeInterDiam3').value = arr[121].replace(new RegExp(/(DownholeInterDiam3=)(\w*)/), "$2");
                                document.getElementById('DownholeDepth4').value = arr[122].replace(new RegExp(/(DownholeDepth4=)(\w*)/), "$2");
                                document.getElementById('DownholeEquipType4').value = arr[123].replace(new RegExp(/(DownholeEquipType4=)(\w*)/), "$2");
                                document.getElementById('DownholeMaxPress4').value = arr[124].replace(new RegExp(/(DownholeMaxPress4=)(\w*)/), "$2");
                                document.getElementById('DownholeOutDiam4').value = arr[125].replace(new RegExp(/(DownholeOutDiam4=)(\w*)/), "$2");
                                document.getElementById('DownholeInterDiam4').value = arr[126].replace(new RegExp(/(DownholeInterDiam4=)(\w*)/), "$2");
                                //Table Six
                                document.getElementById('WellDepth1').value = arr[127].replace(new RegExp(/(WellDepth1=)(\w*)/), "$2");
                                document.getElementById('WellDegree1').value = arr[128].replace(new RegExp(/(WellDegree1=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth1').value = arr[129].replace(new RegExp(/(WellAzimuth1=)(\w*)/), "$2");
                                document.getElementById('WellDepth2').value = arr[130].replace(new RegExp(/(WellDepth2=)(\w*)/), "$2");
                                document.getElementById('WellDegree2').value = arr[131].replace(new RegExp(/(WellDegree2=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth2').value = arr[132].replace(new RegExp(/(WellAzimuth2=)(\w*)/), "$2");
                                document.getElementById('WellDepth3').value = arr[133].replace(new RegExp(/(WellDepth3=)(\w*)/), "$2");
                                document.getElementById('WellDegree3').value = arr[134].replace(new RegExp(/(WellDegree3=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth3').value = arr[135].replace(new RegExp(/(WellAzimuth3=)(\w*)/), "$2");
                                document.getElementById('WellDepth4').value = arr[136].replace(new RegExp(/(WellDepth4=)(\w*)/), "$2");
                                document.getElementById('WellDegree4').value = arr[137].replace(new RegExp(/(WellDegree4=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth4').value = arr[138].replace(new RegExp(/(WellAzimuth4=)(\w*)/), "$2");
                                document.getElementById('WellDepth5').value = arr[139].replace(new RegExp(/(WellDepth5=)(\w*)/), "$2");
                                document.getElementById('WellDegree5').value = arr[140].replace(new RegExp(/(WellDegree5=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth5').value = arr[141].replace(new RegExp(/(WellAzimuth5=)(\w*)/), "$2");
                                document.getElementById('WellDepth6').value = arr[142].replace(new RegExp(/(WellDepth6=)(\w*)/), "$2");
                                document.getElementById('WellDegree6').value = arr[143].replace(new RegExp(/(WellDegree6=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth6').value = arr[144].replace(new RegExp(/(WellAzimuth6=)(\w*)/), "$2");
                                document.getElementById('WellDepth7').value = arr[145].replace(new RegExp(/(WellDepth7=)(\w*)/), "$2");
                                document.getElementById('WellDegree7').value = arr[146].replace(new RegExp(/(WellDegree7=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth7').value = arr[147].replace(new RegExp(/(WellAzimuth7=)(\w*)/), "$2");
                                document.getElementById('WellDepth8').value = arr[148].replace(new RegExp(/(WellDepth8=)(\w*)/), "$2");
                                document.getElementById('WellDegree8').value = arr[149].replace(new RegExp(/(WellDegree8=)(\w*)/), "$2");
                                document.getElementById('WellAzimuth8').value = arr[150].replace(new RegExp(/(WellAzimuth8=)(\w*)/), "$2");
                        }
            </script>
        </div>
    </body>
</html>