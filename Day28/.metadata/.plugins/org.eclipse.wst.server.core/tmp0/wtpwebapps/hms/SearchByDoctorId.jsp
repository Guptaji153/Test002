<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <title>Search Patients by Doctor ID</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
    <jsp:include page="NavBar.jsp"/>

    <h:form>
        <h:panelGrid columns="2" cellpadding="5">
            <h:outputLabel for="doctorId" value="Enter Doctor ID:" />
            <h:inputText id="doctorId" value="#{doctorController.doctor.doctorId}" required="true" />

            <h:outputText value="" />
            <h:commandButton value="Search" action="#{doctorController.searchPatientsByDoctorId}" />
        </h:panelGrid>
    </h:form>

    <br/><hr/><br/>

    <h:panelGroup rendered="#{doctorController.searchPerformed}">
        <h:panelGroup rendered="#{empty doctorController.patientList}">
            <h:outputText value="No patients found for the given Doctor ID." style="color:red;" />
        </h:panelGroup>

        <h:dataTable value="#{doctorController.patientList}" var="patient" border="1"
                     rendered="#{not empty doctorController.patientList}">
            <h:column>
                <f:facet name="header"><b>Patient ID:-</b></f:facet>
                <h:outputText value="#{patient.patientId}" />
            </h:column>
            <h:column>
                <f:facet name="header"><b>Patient Name :- </b></f:facet>
                <h:outputText value="#{patient.patientName}" />
            </h:column>
            <h:column>
                <f:facet name="header"><b>Date of Birth :-</b></f:facet>
                <h:outputText value="#{patient.dateOfBirth}" />
            </h:column>
        </h:dataTable>
    </h:panelGroup>
</body>
</html>
</f:view>
