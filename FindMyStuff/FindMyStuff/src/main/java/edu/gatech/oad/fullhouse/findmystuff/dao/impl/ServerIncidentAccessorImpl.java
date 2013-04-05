package edu.gatech.oad.fullhouse.findmystuff.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import edu.gatech.oad.fullhouse.findmystuff.client.RESTClient;
import edu.gatech.oad.fullhouse.findmystuff.dao.IncidentAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.User;

public class ServerIncidentAccessorImpl extends RESTClient<Incident> implements IncidentAccessor {

    public ServerIncidentAccessorImpl() {
        super(Incident.class);
    }

    public void addIncident(Incident incident) {
        super.create(incident);
    }

    public List<Incident> getIncidentsByUser(User user) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", user.getId() + "");
        String json = super.doGet("search", params);
        return (List<Incident>) new Gson().fromJson(json, Incident.class);
    }

    public void updateIncident(Incident incident) {
        throw new UnsupportedOperationException("NYI");
    }

    public void deleteIncident(Incident incident) {
        throw new UnsupportedOperationException("NYI");
    }
}
