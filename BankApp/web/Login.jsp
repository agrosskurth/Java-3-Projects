<%-- 
    Document   : Login
    Created on : Jan 25, 2017, 7:52:48 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <form action="LoginServlet">
        <h1>Login Page</h1>
        <table width="150px" border="1">
            <tr>
                <th>Username</th>
                <th><input type="text" name="untb" /></th>
            </tr>
            <tr>
                <th>Password</th>
                <th><input type="password" name="pwtb" /></th>
            </tr>
        </table>
        <button type="submit" style="height:25px;width:80px" name="logbtn">Login</button>
        &nbsp;
        <button type="button" style="height:25px;width:80px" name="clearbtn">Clear</button>
    </form>
</html>
