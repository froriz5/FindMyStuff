package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.pres.SearchViewPresenter;

public class SearchViewActivity extends Activity{
	
	private SearchViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //must be before adding contents
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_search_view);
        this.presenter = new SearchViewPresenter(this);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_view_items_list, menu);
        return true;
    }
	
	public void doSearch(View v) {
		// TODO Implement
		String name = null;
		String feature = null;
		String status = null;
		String date = null;
		presenter.searchItems(name, feature, status, date);
	}
}
