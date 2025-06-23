<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="AddAdmin.jsp">
		Admin User Name : 
		<input type="text" name="adminUserName" /> <br/><br/>
		Password : 
		<input type="password" name="password" /> <br/><br/>
		Re-Type Password : 
		<input type="password" name="retypePassCode" /> <br/><br/> 
		<input type="submit" value="Create Account" />
	</form>

<%
		if (request.getParameter("adminUserName")!=null && 
			request.getParameter("password")!=null
				) {
			String pwd = request.getParameter("password");
			String reType = request.getParameter("retypePassCode");
			if (pwd.equals(reType)) {
	%>
	
	<jsp:useBean id="adminUser" class="com.java.lib.model.AdminUser" />
	<jsp:useBean id="libDao" class="com.java.lib.dao.LibraryDaoImpl" />
	<jsp:setProperty property="*" name="adminUser"/>
	<%=libDao.CreateAdmin(adminUser) %>
	<%
			}
		}
	%>
	<jsp:forward page="AdminLogin.jsp"></jsp:forward>

</body>
</html>