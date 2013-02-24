package edu.gatech.oad.fullhouse.findmystuff;

import android.location.Location;

public class LoginManager {
	private UserAccessor accessor;
	
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
		accessor.addUser(new User(usern, passw, loc, admin, email, phone));
	}
	
	public boolean checkUsernameT(String username) {
		return (accessor.getUserByUsername(username) != null);
	}
	
	public boolean checkEmailTaken(String emailAddress) {
		return (accessor.getUserByEmail(emailAddress) != null);
	}
}
