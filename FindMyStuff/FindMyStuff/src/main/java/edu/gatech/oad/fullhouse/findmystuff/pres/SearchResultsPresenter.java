package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.AsyncTask;
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
	
	public void searchItems(final String name, final String category, final String status, final Date date) {
	    new AsyncTask<Void, Void, List<Item>>() {

            @Override
            protected List<Item> doInBackground(Void... params) {
                try {
                    return accessor.searchForItems(name, category, status, date);
                } catch (Exception e) {
                    //FIXME: this swallows more important errors...we should separate the "no results found" error
                    // from the rest
                    return new ArrayList<Item>();
                }
            }
            
            protected void onPostExecute(List<Item> itemList) {
                activity.displayItems(itemList);
            }
	    }.execute();
	}
}
