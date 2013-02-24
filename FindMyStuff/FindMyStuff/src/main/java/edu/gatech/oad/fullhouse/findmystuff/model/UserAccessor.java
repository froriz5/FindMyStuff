package edu.gatech.oad.fullhouse.findmystuff.model;

import java.util.List;


/**
 * An interface for accessing users and user information.
 * 
 * @author Rachel Clark
 *
 */
public interface UserAccessor {
	public abstract void addUser(User user);
	public abstract User getUserByUsername(String username);
	public abstract User getUserByEmail(String email);
	public abstract List<User> getUsers();
}
