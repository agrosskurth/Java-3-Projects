<%-- 
    Document   : Error
    Created on : Mar 1, 2017, 8:02:22 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Business.Account, Business.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>ERROR 404</h1>
        <%
        Customer c1;
        c1 = (Customer)session.getAttribute("c1");
        System.out.println("In error jsp...");
        %>
        
        <h1>Error logging in with ID <%= c1.getID()%></h1>
    </body>
</html>
