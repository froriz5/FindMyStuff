package edu.gatech.oad.fullhouse.findmystuff.view;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import edu.gatech.oad.fullhouse.findmystuff.R;

public class DashboardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_dashboard, menu);
		return true;
	}

}
