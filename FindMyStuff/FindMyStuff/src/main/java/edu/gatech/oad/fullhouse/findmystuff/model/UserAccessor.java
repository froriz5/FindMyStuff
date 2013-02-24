package edu.gatech.oad.fullhouse.findmystuff.model;


/**
 * An interface for accessing users.
 * 
 * @author Rachel Clark
 *
 */
public interface UserAccessor {
	public abstract void addUser(User user);
	public abstract User getUserByUsername(String username);
	public abstract User getUserByEmail(String email);
	public abstract User[] getUsers();
}
