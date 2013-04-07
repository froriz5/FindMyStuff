package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.view.LookupUserActivity;

/**
 * A presenter for looking up users and changing admin privileges, unlocking, and deleting
 * 
 * @author Rachel Clark
 *
 */
public class LookupUserPresenter {
	private LookupUserActivity activity;
	private User currentLookup;
	private UserAccessor accessor;
	
	public LookupUserPresenter(LookupUserActivity activ, UserAccessor accessor) {
		this.activity = activ;
		this.accessor = accessor;
	}
	
	/**
	 * Looks up a user by username. This will have display the information of the
	 * found user in the LookupUserActivity if successful or display and error
	 * in the LookupUserActivity if unsuccessful.
	 * 
	 * @param username
	 */
	public void lookupUser(final String username) {

	    this.activity.setProgressBarIndeterminateVisibility(true); 
		new AsyncTask<Void, Void, User>() {
			
			@Override
            protected User doInBackground(Void... params) {
                try {
                    //try to find the user, or catch an error if there was a problem
                    return accessor.getUserByUsername(username);
                } catch (Exception e) {
                    return null;
                }
            }
	        
            @Override
            protected void onPostExecute(User user) {
                //NOTE: runs in the UI thread, so activity calls are safe
                activity.setProgressBarIndeterminateVisibility(false); 
                
                //test the states of the user object...
                if (user == null) {
                    activity.userNotFoundError();
                } else {
                	activity.setFields(user.getUsername(), user.getName(), user.getEmail(), user.isLocked(), user.isAdmin());
                	currentLookup = user;
                }
            }
		}.execute();
	}
	
	/**
	 * Unlocks a user if one has been looked up
	 */
	public void unlockUser() {
		if (currentLookup == null) {
			activity.userNotFoundError();
		} else {
			currentLookup.resetLogin();
			activity.changeLockedField(false);
			new AsyncTask<Void, Void, Void>() {
				@Override
	            protected Void doInBackground(Void... params) {
	                accessor.updateUser(currentLookup);
	                return null;
	            }
			}.execute();
		}
	}
	
	/**
	 * Makes a user into an admin if one has been looked up
	 */
	public void makeAdmin() {
		if (currentLookup == null) {
			activity.userNotFoundError();
		} else {
			currentLookup.setAdmin(true);
			activity.changeAdminField(true);
			new AsyncTask<Void, Void, Void>() {
				@Override
	            protected Void doInBackground(Void... params) {
	                accessor.updateUser(currentLookup);
	                return null;
	            }
			}.execute();
		}
	}
	
	/**
	 * Deletes a user if one has been looked up
	 */
	public void deleteUser() {
		if (currentLookup == null) {
			activity.userNotFoundError();
		} else {
			String currentUsername = Session.instance().getLoggedInUser().getUsername();
			if (currentLookup.getUsername().equals(currentUsername))
				return;
			activity.removeFields();
			new AsyncTask<Void, Void, Void>() {
				@Override
	            protected Void doInBackground(Void... params) {
	                accessor.deleteUser(currentLookup);
	                return null;
	            }
				
				@Override
				protected void onPostExecute(Void v) {
					activity.deleteSuccessMessage();
				}
			}.execute();
		}
	}
}
