package com.java.crimeSystem.model;

public class IncidentSuspect {
    private int incidentID;
    private int suspectID;

    // Default constructor
    public IncidentSuspect() {}

 
    
    public IncidentSuspect(int incidentID, int suspectID) {
        this.incidentID = incidentID;
        this.suspectID = suspectID;
    }

  
    public int getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

    public int getSuspectID() {
        return suspectID;
    }

    public void setSuspectID(int suspectID) {
        this.suspectID = suspectID;
    }
}

