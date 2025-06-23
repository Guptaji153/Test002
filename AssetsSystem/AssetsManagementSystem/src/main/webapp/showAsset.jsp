<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
<html>
<head>
    <title>Asset List</title>
</head>
<body>

<h2>Asset List</h2>

<h:form>
    <h:commandButton value="Load Assets" action="#{assetsController.showAsset}" />
</h:form>

<h:dataTable value="#{assetsController.assestList}" var="asset" border="1">

    <h:column>
        <f:facet name="header"><h:outputText value="ID" /></f:facet>
        <h:outputText value="#{asset.id}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputText value="Name" /></f:facet>
        <h:outputText value="#{asset.name}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputText value="Description" /></f:facet>
        <h:outputText value="#{asset.description}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputText value="Quantity" /></f:facet>
        <h:outputText value="#{asset.quantity}" />
    </h:column>

</h:dataTable>

</body>
</html>
</f:view>
