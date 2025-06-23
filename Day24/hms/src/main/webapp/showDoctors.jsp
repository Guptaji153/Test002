<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Records</title>
    </head>
    <body>
        <h:form>
            <center>
                <h2><h:outputText value="Doctor Records"/></h2>
            </center>

            <h:dataTable value="#{doctorController.showDoctorList()}" var="d" border="3">
                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Doctor ID" />
                    </f:facet>
                    <h:outputText value="#{d.doctorId}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Doctor Name" />
                    </f:facet>
                    <h:outputText value="#{d.doctorName}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Specialization" />
                    </f:facet>
                    <h:outputText value="#{d.specialization}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Location" />
                    </f:facet>
                    <h:outputText value="#{d.location}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Mobile No" />
                    </f:facet>
                    <h:outputText value="#{d.mobileNo}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{d.isStatus}" />
                </h:column>
            </h:dataTable>
        </h:form>
    </body>
</html>
</f:view>
