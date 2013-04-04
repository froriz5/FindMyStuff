package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import edu.gatech.oad.fullhouse.findmystuff.dao.CategoryAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Category;
import edu.gatech.oad.fullhouse.findmystuff.util.Transitioner;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchResultsActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchViewActivity;

public class SearchViewPresenter {

	private SearchViewActivity activity;
	private ItemAccessor accessor;
    private CategoryAccessor catAccessor;
	
	public SearchViewPresenter(SearchViewActivity activ) {
		activity = activ;
		this.accessor    = ServerAccessorFactory.getItemAccessor();
        this.catAccessor = ServerAccessorFactory.getCategoryAccessor();
	}
	
	public void searchItems(String name, String category, String status, String date) {
		Bundle bundle = new Bundle();
		if (name != null && name.length() == 0) {
		    name = null;
		}
		bundle.putString("name", name);
		bundle.putString("category", category);
		bundle.putString("status", status);
		bundle.putString("date", date);
		new Transitioner(activity).transitionTo(SearchResultsActivity.class, bundle);
	}

    public void loadSearchForm() {
        this.activity.setProgressBarIndeterminateVisibility(true); 
        new AsyncTask<Void, Void, List<Category>>() {

            @Override
            protected List<Category> doInBackground(Void... params) {
                return catAccessor.getAvailableCategories();
            }
            
            protected void onPostExecute(List<Category> categories) {
                activity.setProgressBarIndeterminateVisibility(false); 
                activity.showSearchForm(categories);
            }
        }.execute();
    }
}
