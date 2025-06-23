<%@page import="com.java.jdbc.dao.EmployDaoImpl"%>
<%@page import="com.java.jdbc.dao.EmployDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><b>Welcome To Delete Page</b></center>

<% 
int empno = Integer.parseInt(request.getParameter("empno"));
EmployDao dao = new EmployDaoImpl();
dao.deleteEmployDao(empno);


%>
<jsp:forward page="EmployShow.jsp"></jsp:forward>

</body>
</html>