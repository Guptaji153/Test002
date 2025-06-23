<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Leave History</title>
</head>
<body>
    <!-- Initialize LeaveDAOImpl class -->
    <jsp:useBean id="leaveDetailsDAO" class="com.java.lms.dao.LeaveDAOImpl" />

    <!-- Fetch empId from request parameters -->
    <c:set var="empId" value="${param.empId}" />
    
    <!-- Fetch leave history for the employee -->
    <c:set var="employeeLeaveHistory" value="${leaveDetailsDAO.showLeaveHistory(empId)}" />

    <h2>Leave History for Employee ID: ${empId}</h2>
    <table border="3" align="center">
        <tr>
            <th>Leave ID</th>
            <th>Leave Start Date</th>
            <th>Leave End Date</th>
            <th>Leave Type</th>
            <th>No of Days</th>
            <th>Status</th>
            <th>Manager Comments</th>
            <th>Leave Reason</th>
        </tr>

        <!-- Iterate through employee's leave history -->
        <c:forEach var="history" items="${employeeLeaveHistory}">
            <tr>
                <td>${history.leaveId}</td>
                <td>${history.startDate}</td>
                <td>${history.endDate}</td>
                <td>${history.leaveType}</td>
                <td>${history.noOfDays}</td>
                <td>${history.leaveStatus}</td>
                <td>${history.managerComent}</td>
                <td>${history.reason}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="EmployShow.jsp">Back to Employee List</a>
</body>
</html>
