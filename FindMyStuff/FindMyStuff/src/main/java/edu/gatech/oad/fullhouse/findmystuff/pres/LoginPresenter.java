package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerUserAccessorImpl;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.util.Transitioner;
import edu.gatech.oad.fullhouse.findmystuff.view.DashboardActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.LoginActivity;

/**
 * A presenter for login screens, that handles logging in/checking the password
 * 
 * @author Rachel Clark
 *
 */
public class LoginPresenter {
	private LoginActivity activity;
	private UserAccessor accessor;
	
	public LoginPresenter(LoginActivity activ) {
		activity = activ;
		accessor = ServerAccessorFactory.getUserAccessor();
	}
	
	/**
	 * Log in to the FindMyStuff system.  This will call a login method in the
	 * LoginActivity if successful, or several error handler methods if not.
	 * 
	 * @param username
	 * @param password
	 */
	public void login(final String username, final String password) {
	    //have to use an async task to avoid a NetworkOnMainThreadException
        this.activity.setProgressBarIndeterminateVisibility(true); 
	    new AsyncTask<Void, Void, User>() {

            @Override
            protected User doInBackground(Void... params) {
                try {
                    //try to find the user, or catch an error if there was a problem
                    User user = accessor.getUserByUsername(username);
                    //don't even check the password if the user is locked
                    if (user.isLocked()) {
                        return user;
                    }
                    //this will up the loginAttempt count, if incorrect, or reset it if correct
                    boolean validPassword = user.checkPassword(password);
                    //in both cases, update the user object
                    accessor.updateUser(user);
                    return validPassword || user.isLocked() ? user : null;
                } catch (Exception e) {
                    return null;
                }
            }
	        
            @Override
            protected void onPostExecute(User user) {
                //NOTE: runs in the UI thread, so activity calls are safe
                activity.setProgressBarIndeterminateVisibility(false); 
                
                //test the states of the user object...
                if (user == null) { //not found, or invalid password
                    activity.displayPasswordError();
                }else if (user.isLocked()) { //locked
                    activity.displayLockedError();
                } else { //SUCCESS!
                    Session.newSession().setLoggedInUser(user);
                    activity.doLogin();
                    //transition to the next page
//                    new Transitioner(activity).transitionTo(ViewItemsActivity.class);
                    new Transitioner(activity).transitionTo(DashboardActivity.class);
                }
            }
	    }.execute();
	}
}
