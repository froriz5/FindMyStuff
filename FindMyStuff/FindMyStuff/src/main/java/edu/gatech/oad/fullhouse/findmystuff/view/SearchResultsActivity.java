package edu.gatech.oad.fullhouse.findmystuff.view;


import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.pres.SearchResultsPresenter;

public class SearchResultsActivity extends Activity{
	
	private SearchResultsPresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //must be before adding contents
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_search_results);
        this.presenter = new SearchResultsPresenter(this);
        
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String category = bundle.getString("category");
        String status = bundle.getString("status");
        String date = bundle.getString("date");
        presenter.searchItems(name, category, status, date);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_view_items_list, menu);
        return true;
    }
	
	public void displayItems(List<Item> items) {
		// TODO Implement
	}
}
