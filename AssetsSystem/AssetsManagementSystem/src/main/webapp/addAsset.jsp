<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
<body>
    <h:form>
        <h:outputLabel for="name" value="Asset Name:"/>
        <h:inputText id="name" value="#{assetsController.asset.name}" required="true"/>
        <br/>

        <h:outputLabel for="desc" value="Description:"/>
        <h:inputText id="desc" value="#{assetsController.asset.description}"/>
        <br/>

        <h:outputLabel for="qty" value="Quantity:"/>
        <h:inputText id="qty" value="#{assetsController.asset.quantity}" required="true"/>
        <br/>

        <h:commandButton value="Add Asset" action="#{assetsController.addAsset(assetsController.asset)}"/>
    </h:form>
</body>
</html>
</f:view>
