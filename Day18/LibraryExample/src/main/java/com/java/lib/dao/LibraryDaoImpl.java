package com.java.lib.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.lib.model.AdminUser;
import com.java.lib.model.Books;
import com.java.lib.model.LibUsers;
import com.java.lib.model.TranBook;
import com.java.lib.util.ConnectionHelper;
import com.java.lib.util.EncryptPassword;

public class LibraryDaoImpl implements LibraryDao {

	Connection connection;
	PreparedStatement psmt;
	
	
	
	public int issueOrNot(String userName, int bookId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String sql = "select count(*) cnt from TranBook where UserName=? and BookId=?";
		psmt = connection.prepareStatement(sql);
		psmt.setString(1, userName);
		psmt.setInt(2, bookId);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		int count =rs.getInt("cnt");
		return count;
	}
	
	@Override
	public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(libUsers.getPassWord());
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into LibUsers(UserName,Password) values(?,?)";
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, libUsers.getUserName());
		psmt.setString(2, encr);
		psmt.executeUpdate();
		return "User Account Created Successfully...";
	}

	@Override
	public int login(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(libUsers.getPassWord());
		connection = ConnectionHelper.getConnection();
		String cmd = "select count(*) cnt from LibUsers where UserName = ? AND "
				+ " Password = ?";
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, libUsers.getUserName());
		psmt.setString(2, encr);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		int count= rs.getInt("cnt");
		return count;
	}

	@Override
	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String cmd;
		boolean isValid = true;
		if(searchType.equals("id")) {
			cmd = " SELECT * FROM Books WHERE Id = ? " ;
		} else if (searchType.equals("bookname")) {
			cmd = " SELECT * FROM Books Where Name = ?";
		} else if (searchType.equals("authorname")) {
			cmd = "SELECT * FROM Books where Author = ?";
		} else if (searchType.equals("dept")) {
			cmd = "select * from Books where Dept = ?";
		} else {
			isValid = false;
			cmd = "select * from Books";
		}
		connection = ConnectionHelper.getConnection();
		psmt = connection.prepareStatement(cmd);
		if (isValid == true) {
			psmt.setString(1, searchValue);
		}
		ResultSet rs = psmt.executeQuery();
		Books books = null;
		List<Books> booksList = new ArrayList<Books>();
		while(rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
			booksList.add(books);
		}
		return booksList;
	}

	
	 // Checking Count Of Books

    public int getUserBookCount(String userName) throws SQLException, ClassNotFoundException {
        int count = 0;
        connection = ConnectionHelper.getConnection();
        String query = "SELECT COUNT(*) FROM TranBook WHERE UserName = ?";
        psmt = connection.prepareStatement(query);
        psmt.setString(1, userName);
        ResultSet rs = psmt.executeQuery();
        if (rs.next()) {
        	// Getting the count of books borrowed by the user
            count = rs.getInt(1); 
        }
        return count;
    }
	
	
	@Override
	public String issueBook(String userName, int bookId) throws ClassNotFoundException, SQLException {
	    // Checking how many books the user has already borrowed
	    int userBookCount = getUserBookCount(userName);

	    // If the user already has 4 books, prevent issuing the book
	    if (userBookCount >= 4) {
	        return "You cannot borrow more than 4 books at a time.";
	    }
	    
	    // Checking if the book has only 1 copy left
	    connection = ConnectionHelper.getConnection();
	    String checkCopiesQuery = "SELECT TotalBooks FROM Books WHERE Id = ?";
	    psmt = connection.prepareStatement(checkCopiesQuery);
	    psmt.setInt(1, bookId);
	    ResultSet rs = psmt.executeQuery();
	    
	    if (rs.next()) {
	        int noOfCopies = rs.getInt("TotalBooks");
	        
	        // If there is only 1 copy of the book, prevent issuing it
	        if (noOfCopies == 1) {
	            return "This book is not available for issue as there is only 1 copy left.";
	        }
	    }

	    // Proceed with issuing the book
	    int count = issueOrNot(userName, bookId);
	    if (count == 0) {
	        // Issue the book to the user
	        String sql = "INSERT INTO TranBook(UserName, BookId) VALUES(?, ?)";
	        psmt = connection.prepareStatement(sql);
	        psmt.setString(1, userName);
	        psmt.setInt(2, bookId);
	        psmt.executeUpdate();
	        
	        // Decrease the number of available books by 1
	        String updateBooksQuery = "UPDATE Books SET TotalBooks = TotalBooks - 1 WHERE Id = ?";
	        psmt = connection.prepareStatement(updateBooksQuery);
	        psmt.setInt(1, bookId);
	        psmt.executeUpdate();
	        
	        return "Book with Id " + bookId + " issued successfully.";
	    } else {
	        return "Book with Id " + bookId + " has already been issued to you.";
	    }
	}


	

	@Override
	public List<TranBook> accountDetails(String userName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from tranbook where username = ?";
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, userName);
		ResultSet rs = psmt.executeQuery();
		List<TranBook> booksIssued = new ArrayList<TranBook>();
		TranBook tranBook = null;
		while(rs.next()) {
			tranBook = new TranBook();
			tranBook.setBookId(rs.getInt("BookId"));
			tranBook.setUserName(rs.getString("UserName"));
			tranBook.setFromDate(rs.getDate("FromDate"));
			booksIssued.add(tranBook);
		}
		return booksIssued;
	}

	@Override
	public String returnBook(String userName, int bookId) throws ClassNotFoundException, SQLException {
		String cmd = "SELECT * FROM TranBook WHERE Username = ? and BookId = ?";
		connection = ConnectionHelper.getConnection();
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, userName);
		psmt.setInt(2, bookId);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		Date fromDate = rs.getDate("fromDate");
		
		String sql2 = " INSERT INTO TransReturn(UserName,BookId,FromDate) VALUES (?,?,?)" ;
		psmt = connection.prepareStatement(sql2);
		psmt.setString(1,userName);
		psmt.setInt(2,bookId);
		psmt.setDate(3,fromDate);
		psmt.executeUpdate();
		
		String sql1 = "DELETE FROM TranBook WHERE BookId = ? AND Username = ? " ;
		psmt = connection.prepareStatement(sql1);
		psmt.setInt(1,bookId);
		psmt.setString(2,userName);
		psmt.executeUpdate();
		
		String sql3 = "Update Books set TotalBooks = TotalBooks + 1 where Id = ?";
		psmt = connection.prepareStatement(sql3);
		psmt.setInt(1, bookId);
		psmt.executeUpdate();
		return "Book with Id " +bookId + " For User " +userName + " Returned Successfully...";
	}

	@Override
	public String CreateAdmin(AdminUser adminUser) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String encr = EncryptPassword.getCode(adminUser.getPassword());
		connection = ConnectionHelper.getConnection();
		
		String query = "Insert into AdminUser (AdminNAme,password) values(?,?)";
		psmt = connection.prepareStatement(query);
		psmt.setString(1, adminUser.getPassword());
		psmt.setString(2, encr);
		psmt.executeUpdate();
		
		return "Admin Account Created.....";
	}

	@Override
	public int adminLogin(AdminUser adminUser) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(adminUser.getPassword());
		connection = ConnectionHelper.getConnection();
		String cmd = "select count(*) cnt from adminuser where AdminName = ? AND "
				+ " Password = ?";
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, adminUser.getAdminUserName());
		psmt.setString(2, encr);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		int count= rs.getInt("cnt");
		return count;
	}

	
	
	public boolean checkBookExists(String bookName, String author) throws SQLException, ClassNotFoundException {
        boolean exists = false;
        connection = ConnectionHelper.getConnection();
        String query = "SELECT COUNT(*) FROM Books WHERE Name = ? AND Author = ?";
        psmt = connection.prepareStatement(query);
        psmt.setString(1, bookName);
        psmt.setString(2, author);
        ResultSet rs = psmt.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                exists = true;
            }
        }
        return exists;
    }

    // Update the count of books if it already exists
    public boolean updateBookCount(String bookName, String author, int additionalCount) throws SQLException, ClassNotFoundException {
        boolean updated = false;
        connection = ConnectionHelper.getConnection();
        String query = "UPDATE Books SET TotalBooks = TotalBooks + ? WHERE Name = ? AND Author = ?";
        psmt = connection.prepareStatement(query);
        psmt.setInt(1, additionalCount);
        psmt.setString(2, bookName);
        psmt.setString(3, author);
        int rowsAffected = psmt.executeUpdate();
        if (rowsAffected > 0) {
            updated = true;
        }
        return updated;
    }

    // Add a new book to the database
    public boolean addNewBook(Books book) throws SQLException, ClassNotFoundException {
        boolean added = false;
        connection = ConnectionHelper.getConnection();
        String query = "INSERT INTO Books (Name, Author, Edition, Dept, TotalBooks) VALUES (?, ?, ?, ?, ?)";
        psmt = connection.prepareStatement(query);
        psmt.setString(1, book.getName());
        psmt.setString(2, book.getAuthor());
        psmt.setString(3, book.getEdition());
        psmt.setString(4, book.getDept());
        psmt.setInt(5, book.getNoOfBooks());
        int rowsAffected = psmt.executeUpdate();
        if (rowsAffected > 0) {
            added = true;
        }
        return added;
    }

    // Add or Update Book (This method will be called from your JSP)
    public String addBook(Books book) throws SQLException, ClassNotFoundException {
        // Check if the book exists in the database
        boolean exists = checkBookExists(book.getName(), book.getAuthor());

        if (exists) {
            // If the book exists, update the book count
            boolean updated = updateBookCount(book.getName(), book.getAuthor(), book.getNoOfBooks());
            if (updated) {
                return "Book count updated successfully!";
            } else {
                return "Error updating book count.";
            }
        } else {
            // If the book does not exist, add it as a new book
            boolean added = addNewBook(book);
            if (added) {
                return "New book added successfully!";
            } else {
                return "Error adding new book.";
            }
        }
    }
    
   

}     