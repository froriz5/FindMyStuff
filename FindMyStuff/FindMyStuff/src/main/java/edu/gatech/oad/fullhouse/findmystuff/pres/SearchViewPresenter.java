package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.os.Bundle;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.util.Transitioner;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchResultsActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchViewActivity;

public class SearchViewPresenter {

	private SearchViewActivity activity;
	private ItemAccessor accessor;
	
	public SearchViewPresenter(SearchViewActivity activ) {
		activity = activ;
		this.accessor = ServerAccessorFactory.getItemAccessor();
	}
	
	public void searchItems(String name, String category, String status, String date) {
		Bundle bundle = new Bundle();
		bundle.putString("name", name);
		bundle.putString("category", category);
		bundle.putString("status", date);
		bundle.putString("status", date);
		new Transitioner(activity).transitionTo(SearchResultsActivity.class, bundle);
	}
}
