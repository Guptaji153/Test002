<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
    <html>
    <head>
        <title>Show Users</title>
    </head>
    <body>
    <h:form>
        <h2>List of Users</h2>

        <h:dataTable value="#{tmsController.usersList}" var="u" border="1">
            <h:column>
                <f:facet name="header"><h:outputText value="User ID" /></f:facet>
                <h:outputText value="#{u.id}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Name" /></f:facet>
                <h:outputText value="#{u.name}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Email" /></f:facet>
                <h:outputText value="#{u.email}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Created At" /></f:facet>
                <h:outputText value="#{u.createdAt}">
                    <f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
                </h:outputText>
            </h:column>
        </h:dataTable>
    </h:form>
    </body>
    </html>
</f:view>
