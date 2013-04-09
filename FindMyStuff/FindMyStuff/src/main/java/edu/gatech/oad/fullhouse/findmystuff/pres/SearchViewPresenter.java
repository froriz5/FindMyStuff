package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.Date;
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

/**
 * A presenter for starting seraches
 * 
 * @author Rachel Clark
 *
 */
public class SearchViewPresenter {

	private SearchViewActivity activity;
	private ItemAccessor accessor;
    private CategoryAccessor catAccessor;
	
	public SearchViewPresenter(SearchViewActivity activ) {
		activity = activ;
		this.accessor    = ServerAccessorFactory.getItemAccessor();
        this.catAccessor = ServerAccessorFactory.getCategoryAccessor();
	}
	
	/**
	 * Starts an activity to perform a serach with the given parameters
	 * @param name the name of the item searching for or null to not be considered
	 * @param category the category to filter by
	 * @param status the status to filter by
	 * @param date the date to filter by
	 */
	public void searchItems(String name, String category, String status, Date date) {
		Bundle bundle = new Bundle();
		if (name != null && name.length() == 0) {
		    name = null;
		}
		bundle.putString("name", name);
		bundle.putString("category", category);
		bundle.putString("status", status);
		bundle.putLong("date", date.getTime());
		new Transitioner(activity).transitionTo(SearchResultsActivity.class, bundle);
	}

	/**
	 * Gets the categories in the database and gives them to the activity
	 */
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
