package edu.gatech.oad.fullhouse.findmystuff;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SearchView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_view, menu);
		return true;
	}

}
