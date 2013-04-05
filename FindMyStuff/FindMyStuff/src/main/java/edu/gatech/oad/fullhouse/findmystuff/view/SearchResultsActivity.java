package edu.gatech.oad.fullhouse.findmystuff.view;


import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
        Date date = new Date(bundle.getLong("date"));
        presenter.searchItems(name, category, status, date);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_view_items_list, menu);
        return true;
    }
	
	public void displayItems(List<Item> items) {
	    ListView lv = (ListView)this.findViewById(R.id.itemListFoundView);
	    String[] foundStrs = new String[items.size()];
	    for (int ii = 0; ii < items.size(); ii++) {
	        foundStrs[ii] = items.get(ii).getName();
	    }
	    lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foundStrs));
	}
}
