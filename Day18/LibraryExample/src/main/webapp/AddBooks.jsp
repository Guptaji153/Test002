<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.java.lib.dao.LibraryDaoImpl" %>
<%@ page import="com.java.lib.model.Books" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
<jsp:include page="AdminMenu.jsp" />

<h2>Add a New Book</h2>


<form action="AddBooks.jsp" method="post">
    Book Name: <input type="text" name="bookName" required><br><br>
    Author: <input type="text" name="author" required><br><br>
    Edition: <input type="text" name="edition" required><br><br>
    Department: <input type="text" name="department" required><br><br>
    Number of Books: <input type="number" name="noOfBooks" required><br><br>
    <input type="submit" value="Add/Update Book">
</form>

<%
    // Check if form is submitted
    if (request.getMethod().equalsIgnoreCase("POST")) {
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String edition = request.getParameter("edition");
        String department = request.getParameter("department");
        int noOfBooks = Integer.parseInt(request.getParameter("noOfBooks"));

        // Create a new book object
        Books newBook = new Books();
        newBook.setName(bookName);
        newBook.setAuthor(author);
        newBook.setEdition(edition);
        newBook.setDept(department);
        newBook.setNoOfBooks(noOfBooks);

        // Use LibraryDao to add or update the book
        LibraryDaoImpl libraryDao = new LibraryDaoImpl();
        String result = libraryDao.addBook(newBook);

        // Display the result
        out.println("<p>" + result + "</p>");
    }
%>

</body>
</html>
