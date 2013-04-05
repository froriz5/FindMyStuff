package edu.gatech.oad.fullhouse.findmystuff.model;

import java.util.Date;

/**
 * This class represents an incident, which represents a set of items lost on a certain date.
 * 
 * @author Jesse Rosalia
 *
 */
public class Incident {

    private long id;
    
    private Date incidentDate;
    
    private String incidentLocation;
    
    private String title;

    private long user;

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }
    
    public String getIncidentLocation() {
    	return incidentLocation;
    }
    
    public void setIncidentLocation(String loc) {
    	this.incidentLocation = loc;
    }

    public String getIncidentTitle() {
    	return title;
    }
    
    public void setIncidentTitle(String title) {
    	this.title = title;
    }
    
    public long getUserID() {
        return user;
    }

    public void setUserID(long id) {
        this.user = id;
    }
}
