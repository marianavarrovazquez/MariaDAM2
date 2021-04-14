<%-- 
    Document   : paginajsp
    Created on : 07-abr-2021, 20:38:48
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
        <% for (int i = 0; i < 3; i++) {%>
            <h1>Hello <%=session.getAttribute("valor")%> World!</h1>
            
        <%}%>
        <%=session.getAttribute("valor")%>
                
        <table border="1">
            <tr>
                <td>11</td>
                <td>12</td>
            </tr>
            <tr>
                <td>21</td>
                <td>22</td>
            </tr>
        </table>
    </body>
</html>
