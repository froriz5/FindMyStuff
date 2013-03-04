package edu.gatech.oad.fullhouse.findmystuff.dao;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.User;

/**
 * An accessor for Incidents.  Incidents provide a grouping of items
 * 
 * 
 * @author thejenix
 *
 */
public interface IncidentAccessor {

    public void addIncident(Incident incident);
    
    public List<Incident> getIncidentsByUser(User user);
    
    public void updateIncident(Incident incident);
    
    public void deleteIncident(Incident incident);
}
