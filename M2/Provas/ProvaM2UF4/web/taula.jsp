<%-- 
    Document   : taula
    Created on : 08-abr-2021, 20:40:53
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int files = 0;%>
        <% int columnas = 0;%>
        
        <% files=Integer.valueOf(String.valueOf(session.getAttribute("files"))); %>
        <% columnas=Integer.valueOf(String.valueOf(session.getAttribute("columnes"))); %>
        
        <table border="1">
            
            <% for (int i = 0; i < files; i++) {%>
                <tr>
                    <% for (int j = 0; j < columnas; j++) {%>
                        <td><%=i+1%><%=j+1%></td>
                    <%}%>
                </tr>
            <%}%>
            
                
            
        </table>
    </body>
</html>
