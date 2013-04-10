package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.os.AsyncTask;
import android.provider.ContactsContract.CommonDataKinds.Email;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerUserAccessorImpl;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.view.RegisterActivity;

/**
 * Checks user information provided and adds a User to the system if valid
 * 
 * @author Rachel Clark
 */
public class RegisterPresenter {
	public static final int USERNAME_TAKEN_ERROR = 1;
	public static final int EMAIL_TAKEN_ERROR = 2;
	public static final int SUCCESS = 0;
	
	private RegisterActivity activity;
	private UserAccessor accessor;
	
	public RegisterPresenter(RegisterActivity activ, UserAccessor accessor) {
		this.activity = activ;
		this.accessor = accessor;
	}
	
	/**
	 * Checks given user information and adds a new User to the database if valid
	 * 
	 * @param usern the username of the new User
	 * @param passw the passwrod of the new User
	 * @param repassw confirmation of the password to ensure it was typed correctly
	 * @param name the name of the new User
	 * @param loc the location of the new User
	 * @param email the email address of the new User
	 * @param phone the phone number of the new User
	 */
	public void checkRegInfo(final String usern, final String passw, final String repassw, final String name, final String loc,
			final String email, final String phone) {
		boolean valid = true;
		
		valid = valid && checkUsername(usern);
		valid = valid && checkPassword(passw, repassw);
		valid = valid && checkName(name);
		valid = valid && checkLocation(loc);
		valid = valid && checkEmail(email);
		valid = valid && checkPhone(phone);
		
		if (valid) {
			new AsyncTask<Void, Void, Integer>() {
				@Override
				protected Integer doInBackground(Void... params) {
					try {
	                    accessor.getUserByUsername(usern);
	                    return USERNAME_TAKEN_ERROR;
	                } catch (Exception e) { }
					try {
	                    accessor.getUserByUsername(email);
	                    return EMAIL_TAKEN_ERROR;
	                } catch (Exception e) { }
					
					accessor.addUser(User.newUser(usern, passw, name, loc, false, email, phone));
					return SUCCESS;
				}
				
				@Override
				protected void onPostExecute(Integer result) {
					switch(result) {
					case SUCCESS:
						activity.finish();
					case USERNAME_TAKEN_ERROR:
						activity.displayUsernameTakenError();
					case EMAIL_TAKEN_ERROR:
						activity.displayEmailTakenError();
					}
				}
			}.execute();
		}
		
	}
	
	/*
	 * Validity checking. (Can be improved if needed.)
	 * Return false and call an error display in activity for invalid information.
	 */
	
	/**
	 * Checks the username and displays an error if invalid
	 * @param username the username to check
	 * @return true if valid or false if not
	 */
	public boolean checkUsername(String username) {
		if (!username.matches("[_A-Za-z0-9-]+")) {
			activity.displayUsernameFormatError();
			return false;
		}
		return true;
	}
	
	/**
	 * Checks the password and displays an error if invalid
	 * @param password the password to check
	 * @param repassword reentry of the password to ensure no typos
	 * @return true if valid or false if not
	 */
	public boolean checkPassword(String password, String repassword) {
		if (!password.equals(repassword)) {
			activity.displayPasswordMismatchError();
			return false;
		}
		else if (password.length() < 3) {
			activity.displayPasswordLengthError();
			return false;
		}
		return true;
	}
	
	/**
	 * Checks the name and displays an error if invalid
	 * @param name the name to check
	 * @return true if valid or false if not
	 */
	public boolean checkName(String name) {
		return true;
	}
	
	/**
	 * Checks the location and displays an error if invalid
	 * @param loc the location to check
	 * @return true if valid or false if not
	 */
	public boolean checkLocation(String loc) {
		return true;
	}
	
	/**
	 * Checks the email address and displays an error if invalid
	 * @param email the email address to check
	 * @return true if valid or false if not
	 */
	public boolean checkEmail(String email) {
		if (!email.matches("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})")) {
			activity.displayEmailFormatError();
			return false;
		}
		return true;
	}
	
	/**
	 * Checks the phone number and displays an error if invalid
	 * @param phone the phone number to check
	 * @return true if valid or false if not
	 */
	public boolean checkPhone(String phone) {
		return true;
	}
}
