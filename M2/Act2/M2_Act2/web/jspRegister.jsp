<%-- 
    Document   : jspRegister
    Created on : 25-abr-2021, 1:07:46
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body BGCOLOR="#FDF5E6">
        <h1>Registering with Sessions</h1>
        <%String firstName = String.valueOf(session.getAttribute("firstName"));%>
        <%String lastName = String.valueOf(session.getAttribute("lastName"));%>
        <%String email = String.valueOf(session.getAttribute("email"));%>
        
        <ul>
            <li><b>First name: </b><%=firstName%></li> 
            <li><b>Last Name: </b><%=lastName%></li> 
            <li><b>Email Address: </b><%=email%></li>      
        </ul>
    </body>
</html>
