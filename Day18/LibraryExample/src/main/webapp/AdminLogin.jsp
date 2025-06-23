<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="AdminLogin.jsp">
<center>
<h2>Admin Login :</h2>
Username : <input type="text" name="adminUserName" size="50"> <br/><br/>
Password : <input type="password" name="password" size="50"> <br/><br/>
<input type="submit" value="Login">
</center>
</form>

<%

if (request.getParameter("adminUserName")!=null && 
request.getParameter("password")!=null){
	
	String admin = request.getParameter("adminUserName");
	String pwd = request.getParameter("password");
		
%>
    <jsp:useBean id="adminUser" class = "com.java.lib.model.AdminUser"></jsp:useBean>
    <jsp:setProperty property="*" name="adminUser"/>
    <jsp:useBean id="libraryDao" class = "com.java.lib.dao.LibraryDaoImpl"></jsp:useBean>


   <% int count = libraryDao.adminLogin(adminUser);
       if (count ==1){
    	   session.setAttribute("admin", request.getParameter("adminUserName"));
    	   
    	   %>
    	   <jsp:forward page="AdminMenu.jsp" />
    	   <% 
    	   
       }else{
    	   
    	   %>
		   
    	    <font color="red">Invalid Details....</font>
    <%	   
	   }
   %> 

<% 	
}
%>

</body>
</html>