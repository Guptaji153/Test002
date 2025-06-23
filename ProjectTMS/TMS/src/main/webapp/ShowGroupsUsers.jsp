<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
    <head>
        <title>Group Members</title>
    </head>
    <body>

    <h2>Group Members</h2>

    <!-- Load Group Members Button -->
    <h:form>
        <h:commandButton value="Load Group Members" action="#{controllerTMS.loadGroupsMember}" />
    </h:form>

    <!-- Display Group Members -->
    <h:dataTable value="#{controllerTMS.showGroupMemberList}" var="gm" border="1">

           <h:column>
            <f:facet name="header"><h:outputText value = "ID"/></f:facet>
            <h:outputText value="#{gm.id}" />
        </h:column>
        
        <h:column>
            <f:facet name="header"><h:outputText value = "Group Id"/></f:facet>
            <h:outputText value="#{gm.group.id}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value = "Group Name"/></f:facet>
            <h:outputText value="#{gm.group.name}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value = "User ID"/></f:facet>
            <h:outputText value="#{gm.user.id}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value = "User Name"/></f:facet>
            <h:outputText value="#{gm.user.name}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value = "Joined At"/></f:facet>
            <h:outputText value="#{gm.joinedAt}" />
        </h:column>

    </h:dataTable>

    </body>
    </html>
</f:view>
