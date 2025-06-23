<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
    <head>
        <title>User Registration</title>
    </head>
    <body>

    <h2>Register New User</h2>

    <h:form>

        <h:outputLabel for="name" value="Name:" />
        <h:inputText id="name" value="#{assetsController.user.name}" />
        <h:message  for="name" style="color:red;" />
        <br/><br/>
        <h:outputLabel for="email" value="Email:" />
        <h:inputText id="email" value="#{assetsController.user.email}" required="true" />
        <h:message for="email" style="color:red;" />
        <br/><br/>
        <h:outputLabel for="password" value="Password:" />
        <h:inputSecret id="password" value="#{assetsController.user.password}"  />
        <h:message for="password" style="color:red;" />
        <br/><br/>
        <h:commandButton value="Register" action="#{assetsController.addUser(assetsController.user)}" />

    </h:form>

    </body>
    </html>
</f:view>
