
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Account Page</title>

<style type="text/css">
.logout
{ margin-top: -20px; margin-left: 290px; height: 30px;}
.aone    
{ margin-top: 6px; margin-left: 0px; height: 38px; width:650px; color: #d56d2d;}     
.atwo   
{ margin-top: 4px; margin-left: 10px;height: 30px; width:150px; color: #7464aa;}
</style>
</head>
<body>
<br/>
<%
  String user=(String)session.getAttribute("admin");
  out.println("Welcome <b>" +user+"</b>");
  
%>
<br/><br/>

<div class="logout">
<input type="button" name="logout" value="Logout" onclick="window.location='index.html'">
</div>
<div class="aone" style =" background-color:#ff11ff ">
<div class= "atwo" style =" background-color:#ffff00 ">
<a href="AdminAccountDetails.jsp"> Admin Account Details</a> 
</div>
<div class="atwo"style="background-color:#ffff00;margin-top:-30px;margin-left:170px">
<a href="AddBooks.jsp">Add Books</a>
</div>

</div>
</div>
</body>
</html>
