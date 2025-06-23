<%@page import="com.java.lib.model.TranBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="LibraryDao" class = "com.java.lib.dao.LibraryDaoImpl"></jsp:useBean>

<% String userName =(String)session.getAttribute("user");
 List<TranBook> bookList = LibraryDao.accountDetails(userName);
%>

<jsp:include page="Menu.jsp"></jsp:include>

<form action = "ReturnNext.jsp">
 
 <table border = "3">
 
 <tr>
       <th>Book ID</th>
       <th>User Name</th>
       <th> Issued On</th>
       <th> Return </th>
       </tr>
       
       <%
        
       for(TranBook tbook : bookList){
        
       %>
    
      <tr>
      <td> <%= tbook.getBookId() %></td>  
      <td> <%= tbook.getUserName() %></td>
      <td> <%= tbook.getFromDate() %></td>
      <td> <input type = "checkbox" name = "bookId" value=<%= tbook.getBookId() %> >
      </td>
      </tr>
    
 <%
            }
 %>
 </table>

<input type = "submit" value = "Return Book(s)">

</form>

</body>
</html>