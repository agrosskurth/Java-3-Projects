<%-- 
    Document   : Account
    Created on : Jan 25, 2017, 8:11:58 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Info Page</title>
    </head>
    <form action="AccountLookupServlet">
        <h1>Account Lookup</h1>
        <table width="350px" border="1">
            <tr>
                <th>AccNum</th>
                <th><input type="text" name="acntb" /></th>
            </tr>
            <tr>
                <th>CustID</th>
                <th><input type="text" name="cidtb" /></th>
            </tr>
            <tr>
                <th>Type</th>
                <th><input type="text" name="typetb" /></th>
            </tr>
            <tr>
                <th>Balance</th>
                <th><input type="text" name="baltb" /></th>
            </tr>
        </table>
        <button type="submit" style="height:25px;width:80px" name="findbtn">Find</button>
        &nbsp;
        <button type="button" style="height:25px;width:80px" name="acclearbtn">Clear</button>
    </form>
</html>
