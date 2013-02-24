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
	
	public void checkRegInfon(String usern, String passw, String loc, String email, String phone) {
		boolean valid = true;
		valid = valid && checkUsername(usern);
		valid = valid && checkPassword(passw);
		valid = valid && checkLocation(loc);
		valid = valid && checkEmail(email);
		valid = valid && checkPhone(phone);
		
		if (valid) {
			accessor.addUser(User.newUser(usern, passw, loc, false, email, phone));
			activity.finish();
		}
	}
	
	public boolean checkUsername(String username) {
		return false;
	}
	
	public boolean checkPassword(String password) {
		return false;
	}
	
	public boolean checkLocation(String loc) {
		return false;
	}
	
	public boolean checkEmail(String email) {
		return false;
	}
	
	public boolean checkPhone(String phone) {
		return false;
	}
}
