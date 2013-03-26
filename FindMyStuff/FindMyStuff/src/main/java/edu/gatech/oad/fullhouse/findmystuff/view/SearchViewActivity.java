package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.pres.SearchViewPresenter;
import edu.gatech.oad.fullhouse.findmystuff.pres.ViewItemsPresenter;

public class SearchViewActivity extends Activity{
	
	private SearchViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //must be before adding contents
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_view_items);
        this.presenter = new SearchViewPresenter(this);
    }

}
