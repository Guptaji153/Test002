package com.java.crimeSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.crimeSystem.dao.CrimeDao;
import com.java.crimeSystem.dao.CrimeDaoImp;
import com.java.crimeSystem.model.IncidentStatus;
import com.java.crimeSystem.model.Incidents;

public class AddIncidentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddIncidentServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Create and populate the Incidents object with data from the request
        Incidents incident = new Incidents();
       // incident.setIncidentID(Integer.parseInt(request.getParameter("incidentID")));
        incident.setIncidentType(request.getParameter("incidentType"));
        incident.setIncidentDate(Date.valueOf(request.getParameter("incidentDate"))); 
        incident.setLatitude(Double.parseDouble(request.getParameter("latitude")));
        incident.setLongitude(Double.parseDouble(request.getParameter("longitude")));
        incident.setDescription(request.getParameter("description"));
        
        // Set the status by converting the string to an enums
      //  incident.setStatus(IncidentStatus.valueOf(request.getParameter("status").toUpperCase().replace(" ", "_")));

//        incident.setAgencyID(Integer.parseInt(request.getParameter("agencyID")));
//       incident.setOfficerID(Integer.parseInt(request.getParameter("officerID")));

       
        CrimeDao dao = new CrimeDaoImp();
        try {
            dao.createIncident(incident); 
            out.println("Incident added successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while adding the incident.");
        }
    }
}
