package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;

public class LoginActivity extends Activity {

    private static String TAG = "FindMyStuff";

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
    }
    
    public void register(View v) {
    	
    }
    
    public void login(View v) {
    	String username = ((TextView)findViewById(R.id.usernameText)).getText().toString();
        String password = ((TextView)findViewById(R.id.passwordText)).getText().toString();
    }
    
    public void displayLockedError() {
    	
    }
    
    public void displayPasswordError() {
    	
    }

}
