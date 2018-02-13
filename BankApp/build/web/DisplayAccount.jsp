<%-- 
    Document   : DisplayAccount
    Created on : Mar 8, 2017, 8:18:44 PM
    Author     : Andrew
--%>

<%@page import="Business.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Info</title>
    </head>
    <body>
        <% 
        Account a1;
        a1 =(Account)session.getAttribute("a1");
        %>
    <table width="150px" border="1">
        <tr>
            <th>Account Number</th>
            <th>Account Type</th>
            <th>Balance</th>
        </tr>
        <tr>
            <th><%= a1.getAcctNo()%></th>
            <th><%= a1.getAcctType()%></th>
            <th><%= a1.getBalance()%></th>
        </tr>
    </table>
    </body>
</html>
