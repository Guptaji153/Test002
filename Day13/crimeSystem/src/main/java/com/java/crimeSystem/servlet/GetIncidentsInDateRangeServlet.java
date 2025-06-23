package com.java.crimeSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.crimeSystem.dao.CrimeDao;
import com.java.crimeSystem.dao.CrimeDaoImp;
import com.java.crimeSystem.model.Incidents;

public class GetIncidentsInDateRangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetIncidentsInDateRangeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String startDateParam = request.getParameter("startDate");
        String endDateParam = request.getParameter("endDate");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
           
            Date startDate = Date.valueOf(startDateParam);
            Date endDate = Date.valueOf(endDateParam);

            
            CrimeDao dao = new CrimeDaoImp();
            List<Incidents> incidentsList = dao.getIncidentsInDateRange(startDate, endDate);

            // Displaying the results
            if (incidentsList != null && !incidentsList.isEmpty()) {
                out.println("<h3>Incidents from " + startDate + " to " + endDate + "</h3>");
                out.println("<table border='1'>");
                out.println("<tr><th>Incident ID</th><th>Incident Type</th><th>Incident Date</th><th>Status</th><th>Officer ID</th><th>Agency ID</th></tr>");
                for (Incidents incident : incidentsList) {
                    out.println("<tr>");
                    out.println("<td>" + incident.getIncidentID() + "</td>");
                    out.println("<td>" + incident.getIncidentType() + "</td>");
                    out.println("<td>" + incident.getIncidentDate() + "</td>");
                    out.println("<td>" + incident.getStatus() + "</td>");
                    out.println("<td>" + incident.getOfficerID() + "</td>");
                    out.println("<td>" + incident.getAgencyID() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("Not Found Between These Range");
            }
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
            out.println("Error retrieving incidents: " + e.getMessage());
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if needed, this just redirects to the doGet method.
        doGet(request, response);
    }
}
