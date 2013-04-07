package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.pres.RegisterPresenter;

public class RegisterActivity extends Activity {
	
	private RegisterPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		presenter = new RegisterPresenter(this, ServerAccessorFactory.getUserAccessor());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_resgister, menu);
		return true;
	}

	public void registerAttempt(View v) {
		((TextView)findViewById(R.id.registerUsernameError)).setVisibility(View.GONE);
		((TextView)findViewById(R.id.registerUsernameFormatError)).setVisibility(View.GONE);	
        ((TextView)findViewById(R.id.registerEmailError)).setVisibility(View.GONE);
        ((TextView)findViewById(R.id.registerEmailFormatError)).setVisibility(View.GONE);
        ((TextView)findViewById(R.id.registerPasswordMismatchError)).setVisibility(View.GONE);
        ((TextView)findViewById(R.id.registerPasswordLengthError)).setVisibility(View.GONE);

		
		String name = ((TextView)findViewById(R.id.editTextName)).getText().toString();
		String city = ((TextView)findViewById(R.id.editTextCity)).getText().toString();
		String state = ((TextView)findViewById(R.id.editTextState)).getText().toString();
		String location = city + ", " + state;
		String username = ((TextView)findViewById(R.id.editTextUsername)).getText().toString();
		String email = ((TextView)findViewById(R.id.editTextEmail)).getText().toString();
        String password = ((TextView)findViewById(R.id.editTextPassword)).getText().toString();
        String repassword = ((TextView)findViewById(R.id.editTextRePassword)).getText().toString();
       
       	presenter.checkRegInfo(username, password, repassword, name, location, email, "Phone");
     
    }
	
	public void displayUsernameTakenError() {
		((TextView)findViewById(R.id.registerUsernameError)).setVisibility(View.VISIBLE);
	}
	
	public void displayUsernameFormatError() {
		((TextView)findViewById(R.id.registerUsernameFormatError)).setVisibility(View.VISIBLE);		
	}
	
	public void displayEmailTakenError() {
		((TextView)findViewById(R.id.registerEmailError)).setVisibility(View.VISIBLE);
	}
	
	public void displayEmailFormatError() {
		((TextView)findViewById(R.id.registerEmailFormatError)).setVisibility(View.VISIBLE);		
	}
	
	public void displayPasswordMismatchError() {
		((TextView)findViewById(R.id.registerPasswordMismatchError)).setVisibility(View.VISIBLE);
	}

	public void displayPasswordLengthError() {
		((TextView)findViewById(R.id.registerPasswordLengthError)).setVisibility(View.VISIBLE);		
	}
	
	
}
