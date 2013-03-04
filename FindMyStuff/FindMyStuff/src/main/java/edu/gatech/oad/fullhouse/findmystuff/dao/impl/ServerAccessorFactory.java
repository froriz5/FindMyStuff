package edu.gatech.oad.fullhouse.findmystuff.dao.impl;

import edu.gatech.oad.fullhouse.findmystuff.dao.IncidentAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;

public class ServerAccessorFactory {

    public IncidentAccessor getIncidentAccessor() {
        return new ServerIncidentAccessorImpl();
    }

    public ItemAccessor getItemAccessor() {
        return new ServerItemAccessorImpl();
    }

    public UserAccessor getUserAccessor() {
        return new ServerUserAccessorImpl();
    }
}
