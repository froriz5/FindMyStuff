package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.pres.LookupUserPresenter;

public class LookupUserActivity extends Activity {
	
	private LookupUserPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lookup_user);
        presenter = new LookupUserPresenter(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lookup_user, menu);
		return true;
	}
	
	public void userNotFoundError() {
		findViewById(R.id.notFoundError).setVisibility(View.VISIBLE);
	}
	
	public void setFields(String username, String name, String email, boolean admin) {
		((TextView)findViewById(R.id.usernameDisplay)).setText(username);
		((TextView)findViewById(R.id.nameDisplay)).setText(name);
		((TextView)findViewById(R.id.emailDisplay)).setText(email);
		((TextView)findViewById(R.id.adminDisplay)).setText(admin ? "Yes" : "No");
	}
	
	public void lookup(View v) {
		findViewById(R.id.notFoundError).setVisibility(View.GONE);
		String username = ((TextView)findViewById(R.id.userameEntry)).getText().toString();
		presenter.lookupUser(username);
	}
	
	public void delete(View v) {
		presenter.deleteUser();
	}
	
	public void makeAdmin(View v) {
		presenter.makeAdmin();
	}
	
	public void unlock(View v) {
		presenter.unlockUser();
	}
}
