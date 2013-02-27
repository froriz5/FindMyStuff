package edu.gatech.oad.fullhouse.findmystuff.pres;

import edu.gatech.oad.fullhouse.findmystuff.model.ServerUserAccessorImpl;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.model.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.view.RegisterActivity;

public class RegisterPresenter {
	private RegisterActivity activity;
	private UserAccessor accessor;
	
	public RegisterPresenter(RegisterActivity activ) {
		activity = activ;
		accessor = new ServerUserAccessorImpl();
	}
	
	public void checkRegInfo(String usern, String passw, String name, String loc, String email, String phone) {
		boolean valid = true;
		
		if (accessor.getUserByUsername(usern) != null) {
			activity.displayUsernameTakenError();
			valid = false;
		}
		if (accessor.getUserByEmail(email) != null) {
			activity.displayEmailTakenError();
			valid = false;
		}
			
		
		valid = valid && checkUsername(usern);
		valid = valid && checkPassword(passw);
		valid = valid && checkName(name);
		valid = valid && checkLocation(loc);
		valid = valid && checkEmail(email);
		valid = valid && checkPhone(phone);
		
		if (valid) {
			accessor.addUser(User.newUser(usern, passw, name, loc, false, email, phone));
			activity.finish();
		}
	}
	
	/*
	 * These can be changed later for validity checking.
	 * Return false and call an error display in activity for invalid information.
	 */
	public boolean checkUsername(String username) {
		return true;
	}
	
	public boolean checkPassword(String password) {
		return true;
	}
	
	public boolean checkName(String name) {
		return true;
	}
	
	public boolean checkLocation(String loc) {
		return true;
	}
	
	public boolean checkEmail(String email) {
		return true;
	}
	
	public boolean checkPhone(String phone) {
		return true;
	}
}
