<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Doctor</title>
        
        <!-- Linking the external CSS file -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/AddDoctors.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
        
    </head>
    <body>
        <!-- Including Navbar -->
        <jsp:include page="NavBar.jsp" />
        
        <!-- Main Content Section -->
        <div class="main-content">
            <div class="form-container">
                <h2>Add Doctor</h2>
                <h:form prependId="false">
                    <!-- Doctor ID Field -->
                    <div class="form-group">
                        <h:outputLabel value="Doctor ID " for="doctorId" />
                        <h:inputText id="doctorId" value="#{doctor.doctorId}" />
                        <h:message for="doctorId" style="color:red" />
                    </div>

                    <!-- Doctor Name Field -->
                    <div class="form-group">
                        <h:outputLabel value="Doctor Name " for="doctorName" />
                        <h:inputText id="doctorName" value="#{doctor.doctorName}" />
                        <h:message for="doctorName" style="color:red" />
                    </div>

                    <!-- Specialization Dropdown -->
                    <div class="form-group">
                        <h:outputLabel value="Specialization " for="specialization" />
                        <h:selectOneMenu id="specialization" value="#{doctor.specialization}" onchange="submit()">
                            <f:selectItems value="#{doctorDao.getSpecializations()}" var="spec" itemValue="#{spec}" itemLabel="#{spec}" />
                        </h:selectOneMenu>
                        <h:message for="specialization" style="color:red" />
                    </div>

                    <!-- Mobile Number Field -->
                    <div class="form-group">
                        <h:outputLabel value="Mobile Number " for="mobileNo" />
                        <h:inputText id="mobileNo" value="#{doctor.mobileNo}" />
                        <h:message for="mobileNo" style="color:red" />
                    </div>

                    <!-- Status Dropdown -->
                    <div class="form-group">
                        <h:outputLabel value="Status " for="isStatus" />
                        <h:selectOneMenu id="isStatus" value="#{doctor.isStatus}">
                            <f:selectItems value="#{doctorDao.getStatuses()}" var="status" itemValue="#{status}" itemLabel="#{status}" />
                        </h:selectOneMenu>
                        <h:message for="isStatus" style="color:red" />
                    </div>

                    <!-- Location Field -->
                    <div class="form-group">
                        <h:outputLabel value="Location " for="location" />
                        <h:inputText id="location" value="#{doctor.location}" />
                        <h:message for="location" style="color:red" />
                    </div>

                    <!-- Submit Button -->
                    <div class="form-group">
                       <!--   <h:commandButton action="#{doctorController.addDoctor(doctor)}" value="Add Doctor" />  -->
                       
                      <h:commandButton action="#{doctorController.addDoctor}" value="Add Doctor" />

                       
                    </div>
                </h:form>
            </div>
        </div>
    </body>
</html>
</f:view>
