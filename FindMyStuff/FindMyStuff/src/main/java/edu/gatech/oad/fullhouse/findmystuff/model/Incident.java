package edu.gatech.oad.fullhouse.findmystuff.model;

import java.util.Date;
import java.util.List;

/**
 * This class represents an incident, which represents a set of items lost on a certain date.
 * 
 * @author Jesse Rosalia
 *
 */
public class Incident {

    private long id;
    
    private Date incidentDate;

    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
