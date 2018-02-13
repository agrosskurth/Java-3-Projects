<%-- 
    Document   : Loops
    Created on : Mar 8, 2017, 7:36:01 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loops</title>
    </head>
    <body>
            <% 
            for (int i = 0; i < 10; i++)
            {
                out.print("Go Braves!");
            %>
            <br>
            <%
            }
            %>
    </body>
</html>
