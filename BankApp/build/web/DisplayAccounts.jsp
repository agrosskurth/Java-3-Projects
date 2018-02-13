
<%@page import="Business.AccountList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Business.Account, Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Info</title>
    </head>
    <body>
        <% 
        Customer c1;
        c1 =(Customer)session.getAttribute("c1");
        
        AccountList accs = c1.getAccountList();
        int count = accs.getCount();
        System.out.println("DisplayAccounts jsp loaded...");
        accs.display();
        %>
    <table width="150px" border="1">
        <tr>
            <th>Account Number</th>
            <th>Account Type</th>
            <th>Balance</th>
        </tr>
        <% for(int i = 0; i < (count-1); i++)
        {
            Account a1 = accs.alist[i];
        %>
        <tr>
            
            <th><%= a1.getAcctNo()%></th>
            <th><%= a1.getAcctType()%></th>
            <th><%= a1.getBalance()%></th>
            
        </tr>
        <%
        }
        %>
    </table>
    </body>
</html>
