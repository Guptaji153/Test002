<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
    <head>
        <title>Expenses List</title>
    </head>
    <body>

    <h2>Expenses List</h2>

    <!-- Load expenses button -->
    <h:form>
        <h:commandButton value="Load Expenses" action="#{controllerTMS.showExpenses}" />
    </h:form>

    <!-- Display expenses table -->
    <h:dataTable value="#{controllerTMS.expensesList}" var="exp" border="1">

        <h:column>
            <f:facet name="header"><h:outputText value="ID" /></f:facet>
            <h:outputText value="#{exp.id}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Paid By (User ID)" /></f:facet>
            <h:outputText value="#{exp.paidByUser}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Description" /></f:facet>
            <h:outputText value="#{exp.description}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Total Amount" /></f:facet>
            <h:outputText value="#{exp.totalAmount}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Expense Date" /></f:facet>
            <h:outputText value="#{exp.expenseDate}">
                <f:convertDateTime pattern="yyyy-MM-dd" />
            </h:outputText>
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Created At" /></f:facet>
            <h:outputText value="#{exp.createdAt}">
                <f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
            </h:outputText>
        </h:column>

    </h:dataTable>

    </body>
    </html>
</f:view>
