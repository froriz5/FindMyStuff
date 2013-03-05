package edu.gatech.oad.fullhouse.findmystuff.pres;

import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.view.ViewItemsActivity;

public class ViewItemsPresenter {
	
	private ViewItemsActivity activity;
	private UserAccessor accessor;
	private Item[] items;
	
	public ViewItemsPresenter(ViewItemsActivity activ, Item[] items) {
		activity = activ;
		this.items = items;
	}
	
	/**
	 * Gets Items (Lost/Found) from server and updates Items List
	 */
	
	public void syncList() {
		
	}

}
