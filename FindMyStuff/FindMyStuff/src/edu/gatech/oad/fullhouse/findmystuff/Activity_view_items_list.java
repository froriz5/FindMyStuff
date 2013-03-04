package edu.gatech.oad.fullhouse.findmystuff;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Activity_view_items_list extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_view_items_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_items_list, menu);
		return true;
	}

}
