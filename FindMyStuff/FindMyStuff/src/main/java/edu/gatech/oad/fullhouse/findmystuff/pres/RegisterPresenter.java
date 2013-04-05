package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerUserAccessorImpl;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.view.RegisterActivity;

public class RegisterPresenter {
	private RegisterActivity activity;
	private UserAccessor accessor;
	
	public RegisterPresenter(RegisterActivity activ) {
		activity = activ;
		accessor = ServerAccessorFactory.getUserAccessor();
	}
	
	public void checkRegInfo(final String usern, final String passw, final String name, final String loc,
			final String email, final String phone) {
		boolean valid = true;
		
		valid = valid && checkUsername(usern);
		valid = valid && checkPassword(passw);
		valid = valid && checkName(name);
		valid = valid && checkLocation(loc);
		valid = valid && checkEmail(email);
		valid = valid && checkPhone(phone);
		
		if (valid) {
			new AsyncTask<Void, Void, Integer>() {
				@Override
				protected Integer doInBackground(Void... params) {
					try {
	                    // return 1 for a username taken error if user found
	                    accessor.getUserByUsername(usern);
	                    return 1;
	                } catch (Exception e) { }
					try {
						// return 2 for an email taken error if user found
	                    accessor.getUserByUsername(email);
	                    return 2;
	                } catch (Exception e) { }
					
					// return 0 for successful user creation
					accessor.addUser(User.newUser(usern, passw, name, loc, false, email, phone));
					return 0;
				}
				
				@Override
				protected void onPostExecute(Integer result) {
					if (result == 0) {
						activity.finish();
					} else if (result == 1) {
						activity.displayUsernameTakenError();
					} else if (result == 2) {
						activity.displayEmailTakenError();
					}
				}
			}.execute();
		}
	}
	
	/*
	 * These can be changed later for validity checking.
	 * Return false and call an error display in activity for invalid information.
	 */
	public boolean checkUsername(String username) {
		if (username.length() == 0) {
			return false;
		}
		return true;
	}
	
	public boolean checkPassword(String password) {
		if (password.length() == 0) {
			return false;
		}
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
