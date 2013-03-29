package edu.gatech.oad.fullhouse.findmystuff.view;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import edu.gatech.oad.fullhouse.findmystuff.R;

public class SearchResultsActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //must be before adding contents
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_search_results);
        //this.presenter = new ViewItemsPresenter(this);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_view_items_list, menu);
        return true;
    }
}
