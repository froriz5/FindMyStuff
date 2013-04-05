package edu.gatech.oad.fullhouse.findmystuff.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.pres.AddIncidentPresenter;

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
	
	//this suppresslint is ok, because we're using the SDF for a very specific format for the server
	@SuppressLint("SimpleDateFormat")
    public void doAddIncident(View v){
		
		long userID = Session.instance().getLoggedInUser().getId();
		String title = ((TextView)findViewById(R.id.addIncidentTitleField)).getText().toString();
		String city = ((TextView)findViewById(R.id.addIncidentCityField)).getText().toString();
		String state = ((TextView)findViewById(R.id.addIncidentStateField)).getText().toString();
		String location = city + ", " + state;
		Date date = getDateFromDatePicker((DatePicker)findViewById(R.id.addIncidentDatePicker));
		
		Incident incident = new Incident();
		incident.setTitle(title);
		incident.setLocation(location);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		incident.setIncident_date(sdf.format(date));
		incident.setUser_id(userID);
		
		pres.addIncident(incident);
		incidentAdded = true;
	}
	
	/**
	 * 
	 * @param datePicker
	 * @return a java.util.Date
	 */
	public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
	    int day = datePicker.getDayOfMonth();
	    int month = datePicker.getMonth();
	    int year =  datePicker.getYear();

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(year, month, day);

	    return calendar.getTime();
	}
	
	@Override
	public void finish() {
        if (incidentAdded) {
            setResult(Activity.RESULT_OK);
        }
	    super.finish();
	}
	
}
