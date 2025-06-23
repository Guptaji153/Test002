<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Name.jsp">

<center>

Student Name:
<input type = "text" name = "sname"/>
<input type = "submit" value = "show"/>


</center>


</form>

<c:if test="${param.sname != null }"></c:if>
<c:set var = "sname" value="${param.sname }"></c:set>

Student Name: <b>
<c:out value="${sname }"></c:out>
</b>


</body>
</html>