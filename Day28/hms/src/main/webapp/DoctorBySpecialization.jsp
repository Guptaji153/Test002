<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctors by Specialization</title>
        
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/DoctorBy.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
        
        
    </head>
    <body>
        <jsp:include page="NavBar.jsp" />

        <h:form>
        <br>
            <!-- Dropdown to select Specialization -->
            <h:selectOneMenu id="specialization" value="#{doctorDao.localCategory}" 
                             onchange="submit()" valueChangeListener="#{doctorDao.doctorCategoryChanged}">
                <f:selectItems value="#{doctorDao.specializations}" />
            </h:selectOneMenu>
            
            <br/><br/>
            <br>
           <b> <h:outputLabel value="Selected Specialization: " /> </b> <br>
            <h:outputText value="#{doctorDao.localCategory}" />
<br>
            <!-- Table of doctors filtered by specialization -->
            <h:dataTable value="#{doctorController.showDoctorsBySpecialization(doctorDao.localCategory)}" 
                         var="doc" border="2">
                
                <h:column>
                    <f:facet name="header"><h:outputText value="Doctor ID" /></f:facet>
                    <h:outputText value="#{doc.doctorId}" />
                </h:column>
                
                <h:column>
                    <f:facet name="header"><h:outputText value="Name" /></f:facet>
                    <h:outputText value="#{doc.doctorName}" />
                </h:column>
                
                <h:column>
                    <f:facet name="header"><h:outputText value="Specialization" /></f:facet>
                    <h:outputText value="#{doc.specialization}" />
                </h:column>
                
                <h:column>
                    <f:facet name="header"><h:outputText value="Mobile No" /></f:facet>
                    <h:outputText value="#{doc.mobileNo}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="Status" /></f:facet>
                    <h:outputText value="#{doc.isStatus}" />
                </h:column>

            </h:dataTable>
        </h:form>
    </body>
</html>
</f:view>
