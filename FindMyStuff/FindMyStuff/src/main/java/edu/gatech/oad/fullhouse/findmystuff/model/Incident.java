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
    
    private String incident_date;
    
    private String location;
    
    private String title;

    private long user_id;

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getIncident_date() {
        return incident_date;
    }
    
    public void setIncident_date(String incident_date) {
        this.incident_date = incident_date;
    }
    
    public String getLocation() {
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

    public long getUser_id() {
        return user_id;
    }
    
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
