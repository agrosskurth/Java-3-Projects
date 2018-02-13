<%@page import="Business.AppointmentList, Business.Appointment, Business.Patient"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Patient Home</title>
      <style>
      /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
      @import url(http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700);
body {
  background: #999;
  padding: 40px;
  font-family: "Open Sans Condensed", sans-serif;
}

#bg {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: url("css/room.jpg") no-repeat center center fixed;
  background-size: cover;
  -webkit-filter: blur(4px);    
}

form {
  position: relative;
  width: 950px;
  margin: 0 auto;
  background: rgba(130,130,130,.3);
  padding: 20px 22px;
  border: 1px solid;
  border-top-color: rgba(255,255,255,.4);
  border-left-color: rgba(255,255,255,.4);
  border-bottom-color: rgba(60,60,60,.4);
  border-right-color: rgba(60,60,60,.4);
}

form input, form button {
  width: 80px;
  border: 1px solid;
  border-bottom-color: rgba(255,255,255,.5);
  border-right-color: rgba(60,60,60,.35);
  border-top-color: rgba(60,60,60,.35);
  border-left-color: rgba(80,80,80,.45);
  background-color: rgba(0,0,0,.2);
  background-repeat: no-repeat;
  padding: 8px 24px 8px 10px;
  font: bold .875em/1.25em "Open Sans Condensed", sans-serif;
  letter-spacing: .075em;
  color: #fff;
  text-shadow: 0 1px 0 rgba(0,0,0,.1);
  margin-bottom: 19px;
}

form input:focus { background-color: rgba(0,0,0,.4); }

::-webkit-input-placeholder { color: #ccc; text-transform: uppercase; }
::-moz-placeholder { color: #ccc; text-transform: uppercase; }
:-ms-input-placeholder { color: #ccc; text-transform: uppercase; }

form button[type=submit] {
  width: 95px;
  margin-bottom: 19px;
  color: #3f898a;
  letter-spacing: .05em;
  text-shadow: 0 1px 0 #133d3e;
  text-transform: uppercase;
  background: #225556;
  border-top-color: #9fb5b5;
  border-left-color: #608586;
  border-bottom-color: #1b4849;
  border-right-color: #1e4d4e;
  cursor: pointer;
}
    </style>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<body>
  <%
        Patient p1;
        p1 = (Patient)session.getAttribute("p1");
        String pid = p1.getPatId();
        
        AppointmentList apps = p1.getAppointmentList();
        int count = apps.getCount();
  %>
  <div id="bg"></div>
<form action="PatientInfoChangeServlet">
    <h1>Patient Info</h1>
    <table border="1">
        <tr>
            <th>Patient ID</th>
            <th>Password</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Email</th>
            <th>Insurance Company</th>
        </tr>
        <tr>
            <th><input type="text" name="pid" value="<%= p1.getPatId()%>"></th>
            <th><input type="text" name="pwd" value="<%= p1.getPasswd()%>"</th>
            <th><input type="text" name="pfn" value="<%= p1.getFirstName() %>"</th>
            <th><input type="text" name="pln" value="<%= p1.getLastName() %>"</th>
            <th><input type="text" name="adr" value="<%= p1.getAddr() %>"</th>
            <th><input type="text" name="ema" value="<%= p1.getEmail() %>"</th>
            <th><input type="text" name="ins" value="<%= p1.getInsCo() %>"</th>
            <th><button type="submit">Change</button></th>
        </tr>
    </table>
</form>
        <% 
        if(count > 0)
        {
            Appointment a1 = apps.alist[0];
            a1.display();
        %>
<form action="AppointmentChange">
    <h1>Appointment</h1>
    <table border="1">
        <tr>
            <th>Appointment Date/Time<br>
                (Ex. Dec 1, 2017, 11am)</th>
            <th>Patient Id</th>
            <th>Doctor ID</th>
            <th>Procedure Code</th>
        </tr>
        <tr>
            <th><input type="text" name="adt" value="<%= a1.getApptDateTime()%>"></th>
            <th><input type="text" name="pid" value="<%= a1.getPatId()%>"></th>
            <th><input type="text" name="did" value="<%= a1.getDentId()%>"></th>
            <th><input type="text" name="prcc" value="<%= a1.getProcCode()%>"></th>
            <th><button type="submit">Change</button></th>
        </tr>
    </table>
</form>
        <%
        }
        else if(count == 0)
        {
        %>
<form action="AppointmentCreate">
    <table border="1">
        <h1>Appointment</h1>
        <tr>
            <th>Appointment Date/Time<br>
                (Ex. Dec 1, 2017, 11am)</th>
            <th>Patient Id</th>
            <th>Doctor ID</th>
            <th>Procedure Code</th>
        </tr>
        <tr>
            <th><input type="text" name="adtin"></th>
            <th><input type="text" name="pidin"></th>
            <th><input type="text" name="didin"></th>
            <th><input type="text" name="prccin"></th>
            <th><button type="submit">Create</button></th>
        </tr>
        <%
        }
        %>
    </table>
</form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>
