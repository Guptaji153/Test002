<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Menu</title>
        <!-- Linking to external CSS file for styling -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menuStyle.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
    </head>
    <body>
        <!-- Including Navbar -->
        <jsp:include page="NavBar.jsp" />
        
        <!-- Main Menu Content -->
        <div class="main-menu-container">
            <h2>Welcome to the Hospital Management System</h2>

            <!-- Menu Links as Boxes -->
            <div class="menu-items">
                <div class="menu-item">
                    <a href="${pageContext.request.contextPath}/Menu.jsf">Home</a>
                </div>
                <div class="menu-item">
                    <a href="${pageContext.request.contextPath}/showDoctor.jsf">All Doctors</a>
                </div>
                <div class="menu-item">
                    <a href="${pageContext.request.contextPath}/DoctorBySpecialization.jsf">Doctors by Specialization</a>
                </div>
                <div class="menu-item">
                    <a href="${pageContext.request.contextPath}/AddDoctor.jsf">Add Doctor</a>
                </div>
                <div class="menu-item">
                    <a href="${pageContext.request.contextPath}/SearchByDoctorId.jsf">Search Patient By Doctor Id</a>
                </div>
                <div class="menu-item">
                    <a href="${pageContext.request.contextPath}/SearchPatient.jsf">Search Patient By Id</a>
                </div>
            </div>
        </div>
    </body>
</html>
</f:view>
