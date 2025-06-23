package com.java.crimeSystem.servlet;

import com.java.crimeSystem.dao.CrimeDao;
import com.java.crimeSystem.dao.CrimeDaoImp;
import com.java.crimeSystem.model.Incidents;
import com.java.crimeSystem.model.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/GenerateIncidentReportServlet")
public class GenerateReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            String incidentIdStr = request.getParameter("incidentId");
            String officerIdStr = request.getParameter("officerId");

            if (incidentIdStr == null || officerIdStr == null || incidentIdStr.isEmpty() || officerIdStr.isEmpty()) {
                out.println("<html><body><h3>Invalid input. Please enter valid Incident ID and Officer ID.</h3></body></html>");
                return;
            }

            // Converting  to integer
            int incidentId = Integer.parseInt(incidentIdStr);
            int officerId = Integer.parseInt(officerIdStr);

            // Create the Incidents object
            Incidents incident = new Incidents();
            incident.setIncidentID(incidentId);
            incident.setOfficerID(officerId);

            
            CrimeDao dao = new CrimeDaoImp();
            Report report = dao.generateIncidentReport(incident);

           
            out.println("<html><head><title>Report Generated</title></head><body>");
            out.println("<h2>Incident Report Details</h2>");
            out.println("<p><strong>Report ID:</strong> " + report.getReportID() + "</p>");
            out.println("<p><strong>Incident ID:</strong> " + report.getIncidentId() + "</p>");
            out.println("<p><strong>Reporting Officer:</strong> " + report.getReportingOfficer() + "</p>");
            out.println("<p><strong>Report Date:</strong> " + report.getReportDate() + "</p>");
            out.println("<p><strong>Status:</strong> " + report.getStatus() + "</p>");
           // out.println("<a href='index.html'>Back to Home</a>");
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("<html><body><h3>Error generating report: " + e.getMessage() + "</h3></body></html>");
        }
    }
}
