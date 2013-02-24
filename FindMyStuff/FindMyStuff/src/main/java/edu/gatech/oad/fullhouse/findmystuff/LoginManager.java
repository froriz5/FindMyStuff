
package edu.gatech.oad.fullhouse.findmystuff;

import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.model.UserAccessor;
import android.location.Location;

public class LoginManager {
	private static LoginManager instance;
	private UserAccessor accessor;
	
	public void newUser(String usern, String passw, String loc, boolean admin, String email, String phone) {
		accessor.addUser(User.newUser(usern, passw, loc, admin, email, phone));
	}
	
	public boolean checkUsernameT(String username) {
		return (accessor.getUserByUsername(username) != null);
	}
	
	public boolean checkEmailTaken(String emailAddress) {
		return (accessor.getUserByEmail(emailAddress) != null);
	}
}
