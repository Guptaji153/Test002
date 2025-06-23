<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Patient</title>
        
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
       
    </head>
    <body>
        <jsp:include page="NavBar.jsp"/>
        
        <h1>Search Patient by ID</h1>

        <!-- Search form -->
        <h:form>
            <h:outputLabel for="patientId" value="Enter Patient ID: " />
            <h:inputText id="patientId" value="#{doctorController.patient.patientId}" required="true" label="Patient ID" />
            <h:message for="patientId" style="color:red;" />
            <br/><br/>
            <h:commandButton value="Search" action="#{doctorController.searchPatientById(doctorController.patient.patientId)}" />
        </h:form>

        <hr/>

        <!-- Show patient details if found -->
        <h:panelGrid columns="2" rendered="#{not empty sessionScope.patientFound}">
            <h:outputText value="Patient ID:" />
            <h:outputText value="#{sessionScope.patientFound.patientId}" />

            <h:outputText value="Patient Name:" />
            <h:outputText value="#{sessionScope.patientFound.patientName}" />

            <h:outputText value="Date of Birth:" />
            <h:outputText value="#{sessionScope.patientFound.dateOfBirth}" />
        </h:panelGrid>

        <!-- Show message if search was performed but no result found -->
        <h:outputText 
            rendered="#{doctorController.searchPerformed and empty sessionScope.patientFound}" 
            value="No patient found with the given ID." 
            style="color:red;" />
    </body>
</html>
</f:view>
