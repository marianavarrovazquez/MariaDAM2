<%-- 
    Document   : ChooseColors1_jsp
    Created on : 28-abr-2021, 21:36:15
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Colors</title>
    </head>
     <body>
        <form action="ServletColors" method="post">
            <label>Foreground color</label>
            <input type="text" name="foregroundColor"/>
            <br>
            <br>
            <label>Background color:</label>
            <input type="text" name="backgroundColor"/>
            <br>
            <br>
            <input type="submit" value="Show Colors"/>
        </form>
    </body>
</html>
