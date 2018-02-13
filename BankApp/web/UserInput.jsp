<%-- 
    Document   : UserInput
    Created on : Feb 1, 2017, 7:22:07 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function validateAge(){
                var a;
                a=document.DataForm.agetb.value;
                if(a>=125){
                    alert("Age must be below 100");
                }
                if(isNaN(a)){
                    alert("Age must be a number!");
                }
                if(a<0){
                    alert("Age must be above 0!");
                }
                if(a===""){
                    alert("You must enter a value for Age!");
                }
            }
            function validateSalary() {
                var s;
                s=document.DataForm.saltb.value;
                if(s>=200000){
                    alert("Salary must be less than 200,000!");
                }
                if(isNaN(s)){
                    alert("Salary must be a number!");
                }
                if(s<0){
                    alert("Salary must be above 0!");
                }
                if(s===""){
                    alert("You must enter a value for Salary!");
                }
            }
        </script>
        <title>User Input</title>
    </head>
    <form name="DataForm">
        <h1>User Input</h1>
        <table width="150px" border="1">
            <tr>
                <th>Age</th>
                <th><input type="text" name="agetb" onSubmit="validateAge()" /></th>
            </tr>
            <tr>
                <th>Salary</th>
                <th><input type="text" name="saltb" onSubmit="validateSalary()" /></th>
            </tr>
        </table>
        <button type="submit" style="height:25px;width:80px" name="sendbtn">Send</button>
        &nbsp;
        <button type="button" style="height:25px;width:80px" name="clearbtn">Clear</button>
    </form>
</html>