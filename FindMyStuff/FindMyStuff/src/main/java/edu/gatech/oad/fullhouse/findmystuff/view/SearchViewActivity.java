package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.os.Bundle;
import edu.gatech.oad.fullhouse.findmystuff.R;

public class SearchViewActivity extends Activity{
	
	//private SearchViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //must be before adding contents
        //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        //setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_search_view);
        //this.presenter = new SearchViewPresenter(this);
    }

}
