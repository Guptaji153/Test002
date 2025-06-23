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

public class AssignOfficerAndAgencyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AssignOfficerAndAgencyServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Getting parameters from request
        int incidentId = Integer.parseInt(request.getParameter("incidentID"));
        int officerId = Integer.parseInt(request.getParameter("officerID"));
        int agencyId = Integer.parseInt(request.getParameter("agencyID"));
     //   incident.setDescription(request.getParameter("description"));
        String ActionReport = request.getParameter("Action_Report");

        // Call DAO method to assign officer and agency
        CrimeDao dao = new CrimeDaoImp();
        try {
            boolean result = dao.assignOfficerAndAgencyToIncident(incidentId, officerId, agencyId, ActionReport);
            if (result) {
                out.println("Officer and agency assigned successfully and incident status updated to Under Investigation");
            } else {
                out.println("Error occurred while assigning officer and agency.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while processing the request.");
        }
    }
}
