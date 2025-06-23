<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
    <head>
        <title>Group List</title>
    </head>
    <body>

    <h2>Group List</h2>

    <!-- Load groups button -->
    <h:form>
        <h:commandButton value="Load Groups" action="#{controllerTMS.showGroup}" />
    </h:form>

    <!-- Display group list -->
    <h:dataTable value="#{controllerTMS.groupList}" var="group" border="1">

        <h:column>
            <f:facet name="header"><h:outputText value="ID" /></f:facet>
            <h:outputText value="#{group.id}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Name" /></f:facet>
            <h:outputText value="#{group.name}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Created At" /></f:facet>
            <h:outputText value="#{group.createdAt}" />
        </h:column>

    </h:dataTable>

    </body>
    </html>
</f:view>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
    <head>
        <title>Group List</title>
    </head>
    <body>

    <h2>Group List</h2>

    <!-- Load groups button -->
    <h:form>
        <h:commandButton value="Load Groups" action="#{controllerTMS.showGroup}" />
    </h:form>

    <!-- Display group list -->
    <h:dataTable value="#{controllerTMS.groupList}" var="group" border="1">

        <h:column>
            <f:facet name="header"><h:outputText value="ID" /></f:facet>
            <h:outputText value="#{group.id}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Name" /></f:facet>
            <h:outputText value="#{group.name}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Created At" /></f:facet>
            <h:outputText value="#{group.createdAt}" />
        </h:column>

    </h:dataTable>

    </body>
    </html>
</f:view>
