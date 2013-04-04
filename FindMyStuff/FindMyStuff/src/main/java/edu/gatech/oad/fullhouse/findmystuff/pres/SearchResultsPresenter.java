package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchResultsActivity;

public class SearchResultsPresenter {
	
	private SearchResultsActivity activity;
    private ItemAccessor accessor;
	
	public SearchResultsPresenter(SearchResultsActivity activ) {
        activity = activ;
        accessor = ServerAccessorFactory.getItemAccessor();
    }
	
	public void searchItems(String name, String category, String status, String date) {
		// TODO Implement
		List<Item> itemList = null;
		activity.displayItems(itemList);
	}
}
