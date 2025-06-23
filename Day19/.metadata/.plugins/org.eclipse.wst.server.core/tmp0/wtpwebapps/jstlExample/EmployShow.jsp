<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var ="conn"
driver="com.mysql.cj.jdbc.Driver"
url = "jdbc:mysql://localhost:3306/infinitepractice"
user = "root"
password = "root"
/>

<sql:query var="employQuery" dataSource="${conn }"> select * from employ
</sql:query>

<c:forEach var ="employ" items ="${ employQuery.rows}">

Employ No : <c:out value="${ employ.empno}"></c:out> <br>
Employ Name : <c:out value="${employ.name }"></c:out> <br>
Gender : <c:out value="${employ.gender }"></c:out> <br>
Department:<c:out value="${employ.dept }"/><br/>
Designation:<c:out value="${employ.desig}"/><br/>
Basic:<c:out value="${employ.basic}"/><br/><hr/>
</c:forEach>
</body>
</html>