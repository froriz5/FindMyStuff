package edu.gatech.oad.fullhouse.findmystuff.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.pres.AddIncidentPresenter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AddIncidentActivity extends Activity{
	
	private Incident incident;
	private AddIncidentPresenter pres;
    private boolean incidentAdded;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        //must be before adding contents
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_add_incident);  
        this.pres = new AddIncidentPresenter(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_incident, menu);
		return true;
	}
	
	private void doAddIncident(){
		
		User user = Session.instance().getLoggedInUser();
		String dateString = ((TextView)findViewById(R.id.addIncidentDateField)).getText().toString();
		DateFormat df = DateFormat.getDateInstance();
		Date date = new Date();
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String city = ((TextView)findViewById(R.id.addIncidentCityField)).getText().toString();
		String state = ((TextView)findViewById(R.id.addIncidentStateField)).getText().toString();
		String location = city + ", " + state;
		Incident incident = new Incident();
		incident.setIncidentDate(date);
		incident.setIncidentLocation(location);
		incident.setUser(user);
		
		pres.addIncident(incident);
		incidentAdded = true;
	}
	
	@Override
	public void finish() {
        if (incidentAdded) {
            setResult(Activity.RESULT_OK);
        }
	    super.finish();
	}
	
}
