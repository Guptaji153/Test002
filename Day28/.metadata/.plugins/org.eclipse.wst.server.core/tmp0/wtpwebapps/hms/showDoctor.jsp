<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 
<f:view>
<html>
    <head>
    
   
    
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Records</title>
        
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
       
        
    </head>
    <body>
    
    <jsp:include page="NavBar.jsp" />
    
    
        <h:form>
            <center>
                <h2>Doctor Records</h2>
            </center>
            <!-- Table to show list of doctors -->
            <h:dataTable value="#{doctorController.showDoctorList()}" var="d" border="3">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor ID"/>
                    </f:facet>
                    <h:outputText value="#{d.doctorId}"/>
                </h:column>
                
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor Name"/>
                    </f:facet>
                    <h:outputText value="#{d.doctorName}"/>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Specialization"/>
                    </f:facet>
                    <h:outputText value="#{d.specialization}"/>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Location"/>
                    </f:facet>
                    <h:outputText value="#{d.location}"/>
                </h:column>
                
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Mobile No"/>
                    </f:facet>
                    <h:outputText value="#{d.mobileNo}"/>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Status"/>
                    </f:facet>
                    <h:outputText value="#{d.isStatus}"/>
                </h:column>

                <!-- Add a search button for each doctor, pass doctorId as a parameter -->
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Search"/>
                    </f:facet>
                    <h:commandButton action="#{doctorController.searchDoctor(d.doctorId)}" value="Search Doctor" />
                </h:column>
            </h:dataTable>
        </h:form>
    </body>
</html>
</f:view>
