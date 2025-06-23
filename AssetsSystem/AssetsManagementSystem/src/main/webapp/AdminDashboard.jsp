<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h1>Admi dashbord</h1>
<a href="addAdmin.jsf">Add Admin</a> <br>
<a href="showAsset.jsf">Show Assets</a><br>
<a href="addAsset.jsf">Add Assets</a><br>
<a href="searchAssets.jsf">Search Assets</a>

<h:form>
<h:commandButton value="Logout" action="#{assetsController.logout}" />
</h:form>
</body>
</html>
</f:view>