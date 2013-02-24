
package edu.gatech.oad.fullhouse.findmystuff;

import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.model.UserAccessor;
import android.location.Location;

public class LoginManager {
	private static LoginManager instance;
	private UserAccessor accessor;
	
	private LoginManager() {
		instance = this;
	}
	
	public static LoginManager getInstance() {
		if (instance == null)
			instance = new LoginManager();
		return instance;
	}
	
	/*
	 * Returns 0 for invalid username, 1 for incorrect password, 2 for successful login
	 */
	public int checkPassword(String username, String password) {
		User user = accessor.getUserByUsername(username);
		if (user == null) {
			return 0;
		}
		if (user.checkPassword(password)) {
			return 2;
		} else {
			return 1;
		}
	}
	
	public void newUser(String usern, String passw, Location loc, boolean admin, String email, String phone) {
		accessor.addUser(User.newUser(usern, passw, loc, admin, email, phone));
	}
	
	public boolean checkUsernameT(String username) {
		return (accessor.getUserByUsername(username) != null);
	}
	
	public boolean checkEmailTaken(String emailAddress) {
		return (accessor.getUserByEmail(emailAddress) != null);
	}
}
