package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.List;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.view.ViewItemsActivity;

public class ViewItemsPresenter {
	
	private ViewItemsActivity activity;
	private ItemAccessor accessor;
	
	public ViewItemsPresenter(ViewItemsActivity activ) {
		activity = activ;
		this.accessor = ServerAccessorFactory.getItemAccessor();
	}
	
	/**
	 * Gets Items (Lost/Found) from server and updates Items List
	 */
	
	public void syncList() {
		
	}

    public void loadItems() {
        this.activity.setProgressBarIndeterminateVisibility(true); 
        new AsyncTask<Void, Void, List<Item>>() {

            @Override
            protected List<Item> doInBackground(Void... params) {
                //TODO: select an incident before loading items
                return accessor.getItemsForIncident(null);
            }

            protected void onPostExecute(java.util.List<Item> result) {
                activity.setProgressBarIndeterminateVisibility(false); 
                activity.viewItems(result);
            };
        }.execute();
    }
}
