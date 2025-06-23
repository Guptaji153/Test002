<%@page import="com.java.exam.model.Gender"%>
<%@page import="com.java.exam.model.Agent"%>
<%@page import="com.java.exam.dao.AgentDaoImpl"%>
<%@page import="com.java.exam.dao.AgentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Agent</title>
</head>
<body>

<center><b><i>Welcome to Update Agent Page...</i></b></center> <br><br>

<%
    int agentID = Integer.parseInt(request.getParameter("agentID"));
    AgentDao dao = new AgentDaoImpl();
    Agent agent = dao.searchAgentDao(agentID);
%>

<form action="UpdateAgent.jsp">
    <center>
        Agent ID:
        <input type="number" name="agentID" value="<%=agent.getAgentID()%>" readonly="readonly" /> <br/><br/>
        Name:
        <input type="text" name="name" value="<%=agent.getName()%>" /> <br/><br/>
        Gender:
        <select name="gender">
            <option value="MALE" <%= agent.getGender().toString().equals("MALE") ? "selected" : "" %>>Male</option>
            <option value="FEMALE" <%= agent.getGender().toString().equals("FEMALE") ? "selected" : "" %>>Female</option>
        </select> <br/><br/>
        City:
        <input type="text" name="city" value="<%=agent.getCity()%>" /> <br/><br/>
        Marital Status:
        <input type="number" name="maritalStatus" value="<%=agent.getMaritalStatus()%>" /> <br/><br/>
        Premium:
        <input type="number" step="0.01" name="premium" value="<%=agent.getPremium()%>" /> <br/><br/>
        <input type="submit" value="Update Agent" />
    </center>
</form>

<%
    if (request.getParameter("premium") != null) {
        Agent agentUpd = new Agent();
        agentUpd.setAgentID(Integer.parseInt(request.getParameter("agentID")));
        agentUpd.setName(request.getParameter("name"));
        agentUpd.setGender(Gender.valueOf(request.getParameter("gender")));
        agentUpd.setCity(request.getParameter("city"));
        agentUpd.setMaritalStatus(Integer.parseInt(request.getParameter("maritalStatus")));
        agentUpd.setPremium(Double.parseDouble(request.getParameter("premium")));

        dao.updateAgentDao(agentUpd);
     
%>
        <jsp:forward page="ShowAgent.jsp" />
<%
    }
%>

</body>
</html>
