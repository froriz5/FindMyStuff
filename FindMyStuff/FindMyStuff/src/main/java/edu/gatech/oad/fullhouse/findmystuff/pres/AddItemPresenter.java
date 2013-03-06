package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.view.AddItemActivity;

public class AddItemPresenter {

	private AddItemActivity activity;
	private ItemAccessor accessor;
	private Item item;
	
	public AddItemPresenter(AddItemActivity activ) {
		activity = activ;
		accessor = ServerAccessorFactory.getItemAccessor();
	}
	
	public void addItem(Item item) {
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
                super.onPostExecute(result);
                activity.finish();
            }
	    }.execute(item);
	}

}
