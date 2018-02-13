<%-- 
    Document   : Loops2
    Created on : Mar 8, 2017, 7:48:31 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title>
    </head>
    <body>
        <%
            for (int i = 1; i < 7; i++) {
        %>
        <h<%= i%>> Hello World! </h<%= i%>>
        <%
            }
        %>
    </body>
</html>
