package edu.gatech.oad.fullhouse.findmystuff.pres;

import edu.gatech.oad.fullhouse.findmystuff.dao.IncidentAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.view.AddItemActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchResultsActivity;

public class SearchResultsPresenter {
	
	private SearchResultsActivity activity;
    //private ItemAccessor accessor;
    //private IncidentAccessor incidentAccessor;
    //private Item item;
    //private User user;
	
	public SearchResultsPresenter(SearchResultsActivity activ) {
        activity = activ;
        //accessor = ServerAccessorFactory.getItemAccessor();
        //incidentAccessor = ServerAccessorFactory.getIncidentAccessor();
        //user = Session.instance().getLoggedInUser();
    }
}
