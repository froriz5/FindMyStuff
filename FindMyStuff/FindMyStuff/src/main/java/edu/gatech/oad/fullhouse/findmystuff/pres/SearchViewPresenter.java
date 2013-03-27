package edu.gatech.oad.fullhouse.findmystuff.pres;

import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchViewActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.ViewItemsActivity;

public class SearchViewPresenter {

	private SearchViewActivity activity;
	private ItemAccessor accessor;
	
	public SearchViewPresenter(SearchViewActivity activ) {
		activity = activ;
		this.accessor = ServerAccessorFactory.getItemAccessor();
	}
	
}
