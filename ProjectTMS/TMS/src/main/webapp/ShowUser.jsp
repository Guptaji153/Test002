<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
    <head>
        <title>User List</title>
    </head>
    <body>

    <h2>User List</h2>

    <!-- Load users button -->
    <h:form>
        <h:commandButton value="Load Users" action="#{controllerTMS.showUser}" />
    </h:form>

    <!-- Display user list -->
    <h:dataTable value="#{controllerTMS.userList}" var="user" border="1">

        <h:column>
            <f:facet name="header"><h:outputText value="ID" /></f:facet>
            <h:outputText value="#{user.id}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Name" /></f:facet>
            <h:outputText value="#{user.name}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Email" /></f:facet>
            <h:outputText value="#{user.email}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Created At" /></f:facet>
            <h:outputText value="#{user.createdAt}" />
        </h:column>

    </h:dataTable>

    </body>
    </html>
</f:view>
