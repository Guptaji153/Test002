package com.java.crimeSystem.model;

public class IncidentVictim {
    private int incidentID;
    private int victimID;

   
    public IncidentVictim() {}

    // Parameterized constructor
    public IncidentVictim(int incidentID, int victimID) {
        this.incidentID = incidentID;
        this.victimID = victimID;
    }

    // Getters and Setters
    public int getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

    public int getVictimID() {
        return victimID;
    }

    public void setVictimID(int victimID) {
        this.victimID = victimID;
    }
}
