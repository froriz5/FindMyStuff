package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.ArrayList;
import java.util.List;

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
        //TODO: incident not yet implemented
//        List<Item> items = this.accessor.getItemsForIncident(null);
        //TEST DATA
        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        item.setName("Washing Machine");
        item.setStatus("Lost");
        item.setCategory("Appliances");
        items.add(item);
        item = new Item();
        item.setName("Picture Frame");
        item.setStatus("Found");
        item.setCategory("Decor");
        items.add(item);
        activity.viewItems(items);
    }

}
