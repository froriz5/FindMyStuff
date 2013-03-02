package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.R.string;
import edu.gatech.oad.fullhouse.findmystuff.model.Settings;
import edu.gatech.oad.fullhouse.findmystuff.pres.LoginPresenter;

public class LoginActivity extends Activity {

    private static String TAG = "FindMyStuff";
    private LoginPresenter presenter;

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
-     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        presenter = new LoginPresenter(this);
        
        //NOTE: change this to your own ip...eventually, we'll stand up a global server
        Settings.instance().setServerUrl("http://floating-wildwood-5355.herokuapp.com");
    }
    
    public void register(View v) {
    	Intent intent = new Intent(this, RegisterActivity.class);
    	startActivity(intent);
    }
    
    public void loginAttempt(View v) {
    	String username = ((TextView)findViewById(R.id.usernameText)).getText().toString();
        String password = ((TextView)findViewById(R.id.passwordText)).getText().toString();
        ((TextView)findViewById(R.id.textViewLockedError)).setVisibility(View.GONE);
        ((TextView)findViewById(R.id.textViewPasswordError)).setVisibility(View.GONE);
        ((TextView)findViewById(R.id.textViewSuccess)).setVisibility(View.GONE);
        presenter.login(username, password);
    }
    
    public void doLogin() {
        // TODO
        ((TextView)findViewById(R.id.textViewSuccess)).setVisibility(View.VISIBLE);
    }
    
    public void displayLockedError() {
    	// TODO
    	((TextView)findViewById(R.id.textViewLockedError)).setVisibility(View.VISIBLE);
    }
    
    public void displayPasswordError() {
    	// TODO
//    	((TextView)findViewById(R.id.passwordError)).setText("Username/Password incorrect");
    	((TextView)findViewById(R.id.textViewPasswordError)).setVisibility(View.VISIBLE);
    }

}
