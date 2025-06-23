package com.java.crimeSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.crimeSystem.dao.CrimeDao;
import com.java.crimeSystem.dao.CrimeDaoImp;
import com.java.crimeSystem.model.IncidentStatus;

public class UpdateIncidentStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateIncidentStatusServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        int incidentId = Integer.parseInt(request.getParameter("incidentId"));
        String actionReport = request.getParameter("Action_Report");
        String statusStr = request.getParameter("status");

      
        IncidentStatus status = IncidentStatus.valueOf(statusStr.toUpperCase().replace(" ", "_"));

        CrimeDao dao = new CrimeDaoImp();
        try {
            boolean updated = dao.updateIncidentStatus(status, incidentId,actionReport );
            if (updated) {
                out.println("Incident status updated successfully.");
            } else {
                out.println("Incident ID not found or status not updated.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while updating the status.");
        }
    }
}
