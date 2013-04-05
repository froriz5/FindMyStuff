package edu.gatech.oad.fullhouse.findmystuff.view;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.pres.AddItemPresenter;

public class AddItemActivity extends Activity {

	private Item item;
	private AddItemPresenter pres;
    private boolean itemAdded;
    private List<Incident> incidents;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        //must be before adding contents
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_add_item);
		Button btn = (Button)findViewById(R.id.addItemAddButton);
		btn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                doAddItem();
            }
		});
		
        btn = (Button)findViewById(R.id.addItemCancelButton);
        btn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });
        
        this.pres = new AddItemPresenter(this);
        pres.getUsersIncidents();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item, menu);
		return true;
	}
	
	public void populateIncidentSpinner(List<Incident> incidents) {
		this.incidents = incidents;
    	// Display User's Incidents in Incident Spinner
        int numIncidents = incidents.size();
        String[] incidents_array = new String[numIncidents];
        for(int i = 0; i < numIncidents; i++) {
        	incidents_array[i] = incidents.get(i).getTitle();
        }
        
        ((Spinner)findViewById(R.id.addItemIncident)).setAdapter(new ArrayAdapter<String>(AddItemActivity.this, android.R.layout.simple_dropdown_item_1line, incidents_array));
    }
	
	private void doAddItem() {
		String name = ((TextView)findViewById(R.id.addItemNameField)).getText().toString();
		String category = ((TextView)findViewById(R.id.addItemCategoryField)).getText().toString();
		//String feature = ((TextView)findViewById(R.id.addItemFeature)).getText().toString();
		String incidentString = ((Spinner)findViewById(R.id.addItemIncident)).getSelectedItem().toString();
		String status = ((Spinner)findViewById(R.id.addItemStatus)).getSelectedItem().toString();
		String location = ((TextView)findViewById(R.id.addItemLocationField)).getText().toString();
		Item item = new Item();
		item.setName(name);
		item.setCategory(category);
		//item.setFeatures(features);
		
		// Get the selected incident
		Incident incident = new Incident();
		for(Incident i : incidents) {
			if(i.getTitle().equals(incidentString)) {
				incident = i;
			}
		}
		item.setIncident(incident);
		item.setStatus(status);
		pres.addItem(item);
		itemAdded = true;
	}

	public void newIncident(View v) {
		Intent intent = new Intent(this, AddIncidentActivity.class);
		startActivity(intent);
	}
	
	@Override
	public void finish() {
        if (itemAdded) {
            setResult(Activity.RESULT_OK);
        }
	    super.finish();
	}
}
