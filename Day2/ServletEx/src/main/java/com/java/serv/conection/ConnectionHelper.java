package com.java.serv.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Hardcoded values for database connection
        String driver = "com.mysql.cj.jdbc.Driver";  // MySQL JDBC driver
        String url = "jdbc:mysql://localhost:3306/crime";  // Database URL
        String user = "root";  // Database username
        String password = "root";  // Database password

        // Load the JDBC driver class
        Class.forName(driver);

        // Establish and return the database connection
        Connection connection = DriverManager.getConnection(url, user, password);
        
        return connection;
    }
}
