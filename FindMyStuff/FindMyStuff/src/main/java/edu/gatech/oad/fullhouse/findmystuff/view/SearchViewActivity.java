package edu.gatech.oad.fullhouse.findmystuff.view;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.model.Category;
import edu.gatech.oad.fullhouse.findmystuff.pres.SearchViewPresenter;

public class SearchViewActivity extends Activity{
	
	private SearchViewPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //must be before adding contents
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(false);        

        setContentView(R.layout.activity_search_view);
        this.presenter = new SearchViewPresenter(this);
        
        ((Button)findViewById(R.id.searchItemButton)).setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                doSearch(v);
            }
            
        });
        presenter.loadSearchForm();
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_view_items_list, menu);
        return true;
    }
	
	@Override
	protected void onResume() {
	    super.onResume();
	}
	
	public void showSearchForm(List<Category> categories) {
	    Spinner catSpin = (Spinner)findViewById(R.id.searchItemCategory);
	    String[] catStrings = new String[categories.size()];
	    for (int ii = 0; ii < categories.size(); ii++) {
	        catStrings[ii] = categories.get(ii).getName();
	    }
	    catSpin.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, catStrings));
	}

	public void doSearch(View v) {
		// TODO Implement
		Date date = getDateFromDatePicker((DatePicker)findViewById(R.id.searchItemDatePicker));
		String name     = ((TextView)findViewById(R.id.searchItemName)).getText().toString();
		String category = ((Spinner)findViewById(R.id.searchItemCategory)).getSelectedItem().toString();
		String status   = ((Spinner)findViewById(R.id.searchItemStatus)).getSelectedItem().toString();
		presenter.searchItems(name, category, status, date);
	}
	
	public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
	    int day = datePicker.getDayOfMonth();
	    int month = datePicker.getMonth();
	    int year =  datePicker.getYear();

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(year, month, day);

	    return calendar.getTime();
	}
}
