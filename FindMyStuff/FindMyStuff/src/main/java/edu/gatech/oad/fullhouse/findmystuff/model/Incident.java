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
    
    private Date incident_date;
    
    private String location;
    
    private String title;

    private long user;

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public Date getIncident_date() {
        return incident_date;
    }
    
    public void setIncident_date(Date incident_date) {
        this.incident_date = incident_date;
    }
    
    public String getlocation() {
    	return location;
    }
    
    public void setLocation(String loc) {
    	this.location = loc;
    }

    public String getTitle() {
    	return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public long getUser() {
        return user;
    }

    public void setUser(long id) {
        this.user = id;
    }
}
