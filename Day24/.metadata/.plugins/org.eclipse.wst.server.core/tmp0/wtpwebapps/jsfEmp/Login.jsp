<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h:form>
	<h:outputLabel value="User Name" />
 <h:inputText id="userName" value="#{login.userName}"/><br>	
 <h:outputLabel value="PassWord " /> 
<h:inputSecret  id="passCode" value="#{login.passCode}"/><br>	
<p style="color:red;"> 	<h:outputText value="#{error}" /></p>
	<h:commandButton action="#{employController.validate(login)}" 
		value="Login" />
        </h:form>
    </body>
</html>
</f:view>