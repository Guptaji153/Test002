<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="login.jsp" method ="post">

<center>

User Name:
<input type ="text" name = "userName"/><br><br>
Password:
<input type="password" name="password"/> <br><br>
<input type="submit" value="login"/>
</center>

</form>

<%
if(request.getParameter("userName") != null && request.getParameter("passWord") != null){
	String user = request.getParameter("userName");
	String pass = request.getParameter("password");
	if(user.equals("Infinite") && pass.equals("Infinite")){
		
%>
		 <jsp:forward page="Menu.jsp"></jsp:forward>
<% 
	}else{
		out.println("***Invalid Credentials***");
	}
}

%>

</body>
</html>