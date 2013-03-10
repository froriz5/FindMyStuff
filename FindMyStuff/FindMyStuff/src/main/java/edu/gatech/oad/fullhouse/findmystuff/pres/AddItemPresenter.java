package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.view.AddItemActivity;

public class AddItemPresenter {

    public static final String ITEM_ADDED = AddItemPresenter.class.getName()
            + ".ItemAdded";

    private AddItemActivity activity;
    private ItemAccessor accessor;
    private Item item;

    public AddItemPresenter(AddItemActivity activ) {
        activity = activ;
        accessor = ServerAccessorFactory.getItemAccessor();
    }

    public void addItem(Item item) {
        this.activity.setProgressBarIndeterminateVisibility(true); 
	    new AsyncTask<Item, Void, Void>() {

            @Override
            protected Void doInBackground(Item ... params) {
                for (Item item : params) {
                    accessor.addItem(item);
                }
                return null;
            }
	        
            @Override
            protected void onPostExecute(Void result) {
                activity.setProgressBarIndeterminateVisibility(false); 
                activity.finish();
            }
	    }.execute(item);
	}
}
