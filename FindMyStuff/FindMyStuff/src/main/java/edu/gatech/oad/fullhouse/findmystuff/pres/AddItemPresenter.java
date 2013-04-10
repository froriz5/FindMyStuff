package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.IncidentAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.view.AddItemActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.LookupUserActivity;

/**
 * A presenter for the add item screen that handles adding an item to the system
 * 
 * @author Felipe Roriz
 *
 */
public class AddItemPresenter {

    public static final String ITEM_ADDED = AddItemPresenter.class.getName()
            + ".ItemAdded";

    private AddItemActivity activity;
    private ItemAccessor accessor;
    private IncidentAccessor incidentAccessor;
    private Item item;
    private User user;

    public AddItemPresenter(AddItemActivity activ) {
        activity = activ;
        accessor = ServerAccessorFactory.getItemAccessor();
        incidentAccessor = ServerAccessorFactory.getIncidentAccessor();
        user = Session.instance().getLoggedInUser();
    }
    
    public AddItemPresenter(AddItemActivity activ, ItemAccessor accessor) {
		this.activity = activ;
		this.accessor = accessor;
	}

    /**
     * Puts a given item into the database. Tells the activity to finish if successful.
     * @param item the Item to be added
     */
    public void addItem(Item item) {
        this.activity.setProgressBarIndeterminateVisibility(true); 
	    new AsyncTask<Item, Void, Void>() {

            @Override
            protected Void doInBackground(Item ... params) {
                for (Item item : params) {
                    accessor.addItem(item);
                }
                return null;
            }
	        
            @Override
            protected void onPostExecute(Void result) {
                activity.setProgressBarIndeterminateVisibility(false); 
                activity.finish();
            }
	    }.execute(item);
	}

    /**
     * Gets the incidents created by the currently logged in user and populates
     * a spinner in the activity with them for the user to select.
     */
	public void getUsersIncidents() {
		this.activity.setProgressBarIndeterminateVisibility(true); 
	    new AsyncTask<Void, Void, List<Incident>>() {

            @Override
            protected List<Incident> doInBackground(Void ... params) {
                try {
                	List<Incident> userIncidents = incidentAccessor.getIncidentsByUser(user);
                    return userIncidents;
                } catch (Exception e) {
                    return new ArrayList<Incident>();
                }
            }
	        
            @Override
            protected void onPostExecute(List<Incident> result) {
                activity.setProgressBarIndeterminateVisibility(false);
                activity.populateIncidentSpinner(result);
            }
	    }.execute();

	}
    
}
