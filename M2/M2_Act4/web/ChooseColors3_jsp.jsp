<%-- 
    Document   : ChooseColors3_jsp
    Created on : 29-abr-2021, 13:35:17
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                <jsp:useBean id="segonPunt" class="act04.ColorBean" scope="application"/>
                <jsp:setProperty name="segonPunt" property="*"/>
                background-color: <jsp:getProperty name="segonPunt" property="backgroundColor"/>;
                color: <jsp:getProperty name="segonPunt" property="foregroundColor"/>;    
            }
        </style>
    </head>
    <body>
        <h1>Choose Colors (Tercer Apartat)</h1>
    </body>
</html>
