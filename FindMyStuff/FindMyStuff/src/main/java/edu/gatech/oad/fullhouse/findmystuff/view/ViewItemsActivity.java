package edu.gatech.oad.fullhouse.findmystuff.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.pres.ViewItemsPresenter;
import edu.gatech.oad.fullhouse.findmystuff.util.Transitioner;

public class ViewItemsActivity extends Activity {

    private ViewItemsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_items);
        this.presenter = new ViewItemsPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.presenter.loadItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_view_items_list, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_add_item:
            new Transitioner(this).transitionTo(AddItemActivity.class);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    public void viewItems(List<Item> items) {
        //separate the items into lost and found lists
        //NOTE: this does not handle donated items or items w/o a status.
        //TODO: probably build a custom list adapter so we can display more information
        List<String> lostItems  = new ArrayList<String>();
        List<String> foundItems = new ArrayList<String>();
        for (Item item : items) {
            if (item.getStatus() != null) {
                if (item.getStatus().equalsIgnoreCase("lost")) {
                    lostItems.add(item.getName());
                } else if (item.getStatus().equalsIgnoreCase("found")) {
                    foundItems.add(item.getName());
                }
            }
        }
        
        //populate the lost and found list views here
        ListView lv = (ListView) findViewById(R.id.itemListLostView);
        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, lostItems.toArray(new String[lostItems.size()])));
        lv = (ListView) findViewById(R.id.itemListFoundView);
        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, foundItems.toArray(new String[foundItems.size()])));
    }
}
