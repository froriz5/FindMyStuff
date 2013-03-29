package edu.gatech.oad.fullhouse.findmystuff.view;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerUserAccessorImpl;
import edu.gatech.oad.fullhouse.findmystuff.model.Settings;
import edu.gatech.oad.fullhouse.findmystuff.model.User;

public class HelloAndroidActivity extends Activity {

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
        setContentView(R.layout.activity_login);
        
        //test code
        Settings.instance().setServerUrl("http://128.61.59.209:3000");
        ServerUserAccessorImpl client = new ServerUserAccessorImpl();
        client.list(); //TODO: problems with empty arrays
        User user = new User();
        user.setUsername("jrosalia");
        user.setPassword("wouldntyouliketoknow");
        
        client.create(user);
        
        client.getUserByUsername("jrosalia");
        client.list();
    }
}

