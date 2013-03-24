package edu.gatech.oad.fullhouse.findmystuff.dao.impl;

import edu.gatech.oad.fullhouse.findmystuff.dao.CategoryAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.IncidentAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;

/**
 * A factory for getting accessors.  This allows us to keep implementation details
 * out of our code.
 * 
 * @author Jesse Rosalia
 *
 */
public class ServerAccessorFactory {

    public static CategoryAccessor getCategoryAccessor() {
        return new ServerCategoryAccessorImpl();
    }

    public static IncidentAccessor getIncidentAccessor() {
        return new ServerIncidentAccessorImpl();
    }

    public static ItemAccessor getItemAccessor() {
        return new ServerItemAccessorImpl();
    }

    public static UserAccessor getUserAccessor() {
        return new ServerUserAccessorImpl();
    }
}
