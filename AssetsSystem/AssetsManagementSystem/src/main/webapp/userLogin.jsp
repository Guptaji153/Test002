<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<h:form id="loginForm">
    <h:outputLabel for="name" value="Name: " />
    <h:inputText id="name" value="#{assetsController.user.name}" required="true" />
    <h:message for="name" style="color:red" />
    <br>

    <h:outputLabel for="password" value="Password: " />
    <h:inputText id="password" value="#{assetsController.user.password}" required="true" />
    <h:message for="password" style="color:red" />
    <br>

    <h:commandButton value="User Login" action="#{assetsController.validateUser(user)}" />

</h:form>
<a href="menu.jsf.jsf">User Register </a>

</body>
</html>
</f:view>
