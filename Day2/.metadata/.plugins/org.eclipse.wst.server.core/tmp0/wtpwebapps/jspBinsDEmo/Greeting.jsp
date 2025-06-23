<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="greeting" class="com.java.bins.Greeting" scope="request" />

Default message:
<b>
<jsp:getProperty property="message" name="greeting"/>

</b>

<jsp:setProperty name="greeting" property="message" value="Hello from JSP!" />

<br>
Updated message:
<jsp:getProperty property="message" name="greeting"/>

</body>
</html>