<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Num.jsp">

<center>

Name:
<input type="text" name="sname" /> <br><br>
<input type="submit" value ="show"> <br><br>

</center>
</form>

<%

if(request.getParameter("sname")!= null){
	String sname= request.getParameter("sname");
	out.println("Student Name is <b>" +sname +"</b>");
}
%>

</body>
</html>