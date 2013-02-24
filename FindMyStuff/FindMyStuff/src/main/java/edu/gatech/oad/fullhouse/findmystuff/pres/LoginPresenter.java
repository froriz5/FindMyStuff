package edu.gatech.oad.fullhouse.findmystuff.pres;

import edu.gatech.oad.fullhouse.findmystuff.model.ServerUserAccessorImpl;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.model.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.view.LoginActivity;

public class LoginPresenter {
	private LoginActivity activity;
	private UserAccessor accessor;
	
	public LoginPresenter(LoginActivity activ) {
		activity = activ;
		accessor = new ServerUserAccessorImpl();
	}
	
	public void checkPassword(String username, String password) {
		User user = accessor.getUserByUsername(username);
		if (user == null) {
			activity.displayPasswordError();
		}
		if (user.isLocked()) {
			activity.displayLockedError();
		}
		if (user.checkPassword(password)) {
			// TODO Store current user
			activity.login();
		} else {
			activity.displayPasswordError();
		}
	}
}
