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
import java.util.List;

//@WebServlet("/GenerateIncidentReportServlet1")
public class GenerateIncidentReportServlet1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html");

        
        String incidentIdStr = request.getParameter("incidentId");
        String officerIdStr = request.getParameter("officerId");

        try (PrintWriter out = response.getWriter()) {

         

        
            int incidentId = Integer.parseInt(incidentIdStr);
            int officerId = Integer.parseInt(officerIdStr);

            // Creating the Incidents object with provided data
            Incidents incident = new Incidents();
            incident.setIncidentID(incidentId);
            incident.setOfficerID(officerId);

           
            CrimeDao dao = new CrimeDaoImp();
            List<Report> reports = dao.generateIncidentReports(incident); 

            // Output the results
            out.println("<html><head><title>Incident Report</title></head><body>");
            out.println("<h2>Generated Incident Reports</h2>");

            if (reports.isEmpty()) {
                out.println("<p>No reports found for this Incident ID and Officer ID.</p>");
            } else {
                
                for (Report report : reports) {
                    out.println("<hr>");
                    out.println("<p><strong>Report ID:</strong> " + report.getReportID() + "</p>");
                    out.println("<p><strong>Incident ID:</strong> " + report.getIncidentId() + "</p>");
                    out.println("<p><strong>Reporting Officer:</strong> " + report.getReportingOfficer() + "</p>");
                    out.println("<p><strong>Report Date:</strong> " + report.getReportDate() + "</p>");
                    out.println("<p><strong>Status:</strong> " + report.getStatus() + "</p>");
                }
            }
           
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            
          
            e.printStackTrace(); 
        }
    }
}
