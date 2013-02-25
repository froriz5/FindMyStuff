package edu.gatech.oad.fullhouse.findmystuff.model;

import java.util.List;


/**
 * An interface for accessing users and user information.
 * 
 * @author Rachel Clark
 *
 */
public interface UserAccessor {
    /**
     * Add a new user to the system
     * 
     * @param user
     */
	public abstract void addUser(User user);

	/**
	 * Get a user by username.  There can only be one user per username.
	 * 
	 * @param username
	 * @return
	 */
	public abstract User getUserByUsername(String username);
	
	/**
	 * Get a user by email address.  There can only be one user per email address.
	 * 
	 * @param email
	 * @return
	 */
	public abstract User getUserByEmail(String email);

	/**
	 * Get a list of all of the users in the system.
	 * 
	 * @return
	 */
	public abstract List<User> getUsers();
}
