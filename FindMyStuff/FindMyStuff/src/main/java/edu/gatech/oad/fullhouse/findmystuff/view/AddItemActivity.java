package edu.gatech.oad.fullhouse.findmystuff.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.pres.AddItemPresenter;

public class AddItemActivity extends Activity {

	private Item item;
	private AddItemPresenter pres;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item, menu);
		return true;
	}
	
	public void add(View v) {
		String name = ((TextView)findViewById(R.id.addItemNameField)).getText().toString();
		String category = ((TextView)findViewById(R.id.addItemCategoryField)).getText().toString();
		//String feature = ((TextView)findViewById(R.id.addItemFeature)).getText().toString();
		String incident = ((TextView)findViewById(R.id.addItemIncidentField)).getText().toString();
		String status = ((TextView)findViewById(R.id.addItemStatusField)).getText().toString();
		String location = ((TextView)findViewById(R.id.addItemLocationField)).getText().toString();
		Item item = new Item();
		item.setName(name);
		item.setCategory(category);
		//item.setFeatures(features);
		//item.setIncident((Incident)incident);
		item.setStatus(status);
		pres.addItem(item);
	}

}
