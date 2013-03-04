package edu.gatech.oad.fullhouse.findmystuff.pres;

import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerUserAccessorImpl;
import edu.gatech.oad.fullhouse.findmystuff.view.AddItemActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.LoginActivity;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;

public class AddItemPresenter {

	private AddItemActivity activity;
	private UserAccessor accessor;
	private Item item;
	
	public AddItemPresenter(AddItemActivity activ, Item item) {
		activity = activ;
		accessor = new ServerUserAccessorImpl();
		this.item = item;
	}
	
	public void addItem(Item item) {
		
	}

}
