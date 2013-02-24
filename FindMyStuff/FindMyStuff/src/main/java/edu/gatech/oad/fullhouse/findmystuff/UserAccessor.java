package edu.gatech.oad.fullhouse.findmystuff;

public interface UserAccessor {
	public abstract void addUser(User user);
	public abstract User getUserByUsername(String username);
	public abstract User getUserByEmail(String email);
	public abstract User[] getUsers();
}
