<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Group Settlement</title>
</head>
<body>
<h:form>
    <h:panelGrid columns="2">

        <h:outputLabel value="Enter Group ID:" for="groupId" />
        <h:inputText id="groupId" value="#{controllerTMS.group.id}" />

        <h:commandButton value="Calculate Settlement" action="#{controllerTMS.doSettlement(controllerTMS.group.id)}" />
    </h:panelGrid>

    <!-- Show result if available -->
    <h:panelGroup rendered="#{not empty controllerTMS.settlementResult}">
   <h3>Settlement Summary</h3>
<ul>
    <li>Total Collected: <h:outputText value="#{controllerTMS.settlementResult.totalCollected}" /></li>
    <li>Total Expenses: <h:outputText value="#{controllerTMS.settlementResult.totalExpenses}" /></li>
    <li>Member Count: <h:outputText value="#{controllerTMS.settlementResult.memberCount}" /></li>
    <li>Balance Per Person: <h:outputText value="#{controllerTMS.settlementResult.balancePerPerson}" /></li>
    <li>Admin Refund Amount: <h:outputText value="#{controllerTMS.settlementResult.adminRefundAmount}" /></li>
    <li>Settlement Date: <h:outputText value="#{controllerTMS.settlementResult.settlementDate}">
        <f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
    </h:outputText></li>
</ul>

    </h:panelGroup>
</h:form>
</body>
</html>
</f:view>
