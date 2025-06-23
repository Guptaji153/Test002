<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Search Assets</title>
</head>
<body>

<h2>Search Asset by Name</h2>

<h:form id="searchForm">
    <h:outputLabel for="assetName" value="Asset Name: " />
    <h:inputText id="assetName" value="#{assetsController.asset.name}" required="true" />
    <h:message for="assetName" style="color:red" />
    <br/><br/>
    <h:commandButton value="Search" action="#{assetsController.searchAssetsByName}" />
    <br/><br/>

    <!-- Asset results table............. -->
    <h:dataTable value="#{assetsController.filteredAssets}" var="asset" border="1"
                 rendered="#{not empty assetsController.filteredAssets}">

        <h:column>
         <f:facet name="id">
             <h:outputText value="Product Id:" />
           </f:facet>
             <h:outputText value="#{asset.id}" />
        </h:column>

        <h:column>
            <f:facet name="header">
            <h:outputText value="Product Name:" />
            </f:facet>
            <h:outputText value="#{asset.name}" />
        </h:column>

        <h:column>
            <f:facet name="header">
            <h:outputText value="Product Description:" />
            </f:facet>
            <h:outputText value="#{asset.description}" />
        </h:column>

        <h:column>
            <f:facet name="header">
            <h:outputText value="Product Quantity:" />
            </f:facet>
            <h:outputText value="#{asset.quantity}" />
        </h:column>
    </h:dataTable>

    <h:outputText value="No results found." 
                  rendered="#{not empty assetsController.asset.name and empty assetsController.filteredAssets}" 
                  style="color:red" />

</h:form>

</body>
</html>
</f:view>
