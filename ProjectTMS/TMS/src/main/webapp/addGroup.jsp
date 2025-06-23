<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Group</title>
</head>
<body>

<h:form id="groupForm">
    
    <!-- Group Name -->
    <h:outputLabel value="Group Name: " for="name" />
    <h:inputText id="name" value="#{controllerTMS.ejbGroup.name}" required="true" />
    <h:message for="name" style="color:red" />
    <br><br>
    
   <h:outputText value="You are creating this group as: #{controllerTMS.ejbUser.name}" />

    <br><br>
    
    <!-- Submit Button -->
    <h:commandButton action="#{controllerTMS.addGroupEjb(ejbGroup)}" value="Add Group" immediate="false" />
    
</h:form>

</body>
</html>
</f:view>
