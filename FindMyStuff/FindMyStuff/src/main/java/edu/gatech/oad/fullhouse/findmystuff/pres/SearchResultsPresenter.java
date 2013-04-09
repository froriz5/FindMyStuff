package edu.gatech.oad.fullhouse.findmystuff.pres;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.view.SearchResultsActivity;

/**
 * A presenter to perform a search and display the results
 * 
 * @author Rachel Clark
 *
 */
public class SearchResultsPresenter {
	
	private SearchResultsActivity activity;
    private ItemAccessor accessor;
	
	public SearchResultsPresenter(SearchResultsActivity activ) {
        activity = activ;
        accessor = ServerAccessorFactory.getItemAccessor();
    }
	
	/**
	 * Searches the database with the given parameters
	 * @param name the name of the item searching for or null to not be considered
	 * @param category the category to filter by
	 * @param status the status to filter by
	 * @param date the date to filter by
	 */
	public void searchItems(final String name, final String category, final String status, final Date date) {
	    new AsyncTask<Void, Void, List<Item>>() {

            @Override
            protected List<Item> doInBackground(Void... params) {
                try {
                	Calendar calendar = new GregorianCalendar();
                	calendar.setTime(date);
                	int day = calendar.get(Calendar.DAY_OF_MONTH);
                	int month = calendar.get(Calendar.MONTH);
                	int year = calendar.get(Calendar.YEAR);
                	String sDate = String.format("%4d-%02d-%02d", year, month, day);
                    return accessor.searchForItems(name, category, status, sDate);
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
