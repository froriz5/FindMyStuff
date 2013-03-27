package edu.gatech.oad.fullhouse.findmystuff.pres;

import edu.gatech.oad.fullhouse.findmystuff.view.SearchViewActivity;

public class SearchViewPresenter {

	private SearchViewActivity activity;
    //private ItemAccessor accessor;
    
	public SearchViewPresenter(SearchViewActivity activ) {
        activity = activ;
        //accessor = ServerAccessorFactory.getItemAccessor();
    }
}
