package edu.gatech.oad.fullhouse.findmystuff;

import java.util.Date;

import android.location.Location;

public class User {
	private String username;
	private String password;
	private Location location;
	private Date dateJoined;
	private int loginAttempts;
	private boolean isLocked;
	private boolean isAdmin;
	private String emailAddress;
	private String phoneNumber;
	
	public User(String usern, String passw, Location loc, boolean admin, String email, String phone) {
		username = usern;
		password = passw;
		location = loc;
		dateJoined = new Date();
		loginAttempts = 0;
		isLocked = false;
		isAdmin = admin;
		emailAddress = email;
		phoneNumber = phone;
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	
	public boolean checkPassword(String attempt) {
		if (isLocked) {
			return false;
		}
		if (password.equals(attempt)) {
			loginAttempts = 0;
			return true;
		} else {
			loginAttempts++;
			if (loginAttempts > 2)
				isLocked = true;
			return false;
		}
	}
	
	public String getUsername() {
		return username;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Date getJoinDate() {
		return dateJoined;
	}
	
	public String getEmail() {
		return emailAddress;
	}
	
	public String getPhone() {
		return phoneNumber;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
}
