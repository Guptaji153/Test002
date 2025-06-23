<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <title>Doctor Details</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"/>
        <h:form>
            Doctor ID: <h:outputText value="#{doctorFound.doctorId}" /><br/>
            Doctor Name: <h:outputText value="#{doctorFound.doctorName}" /><br/>
            Specialization: <h:outputText value="#{doctorFound.specialization}" /><br/>
            Location: <h:outputText value="#{doctorFound.location}" /><br/>
            Mobile No: <h:outputText value="#{doctorFound.mobileNo}" /><br/>
            Status: <h:outputText value="#{doctorFound.isStatus}" /><br/>
        </h:form>
    </body>
</html>
</f:view>
