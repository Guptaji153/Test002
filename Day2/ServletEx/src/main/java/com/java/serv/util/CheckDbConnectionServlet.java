package com.java.serv.util;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckDbConnection")
public class CheckDbConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isConnected = DatabaseUtils.isDbConnected();
        
        if (isConnected) {
            response.getWriter().println("Database is connected!");
        } else {
            response.getWriter().println("Failed to connect to the database.");
        }
    }
}
