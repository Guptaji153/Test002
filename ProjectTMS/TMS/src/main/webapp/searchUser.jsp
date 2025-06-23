<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <title>Search User</title>
</head>
<body>
    <h:form>
        <h:outputLabel for="userId" value="Enter User ID:" />
        <h:inputText id="userId" value="#{controllerTMS.user.id}" />
        <h:commandButton value="Search" action="#{controllerTMS.searchEmploy(controllerTMS.user.id)}" />
    </h:form>

    <h:panelGroup rendered="#{not empty sessionScope.UserFound}">
        <h2>User Found:</h2>
        <h:outputText value="ID: #{sessionScope.UserFound.id}" /><br/>
        <h:outputText value="Name: #{sessionScope.UserFound.name}" /><br/>
        <h:outputText value="Email: #{sessionScope.UserFound.email}" /><br/>
        <h:outputText value="Role: #{sessionScope.UserFound.role}" /><br/>
    </h:panelGroup>

</body>
</html>
</f:view>
