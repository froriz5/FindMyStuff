package edu.gatech.oad.fullhouse.findmystuff.model;

import java.util.Date;

import android.location.Location;

public class User {
	private String username;
	private String password;
	private String name;
	private String location;
	private Date dateJoined;
	private int loginAttempts;
	private boolean isLocked;
	private boolean isAdmin;
	private String emailAddress;
	private String phoneNumber;
	
	public User() {
	    
	}

	public static User newUser(String usern, String passw, String name, String loc, boolean admin, String email, String phone) {
	    User user = new User();
		user.username = usern;
		user.password = passw;
		user.name = name;
		user.location = loc;
		user.dateJoined = new Date();
		user.loginAttempts = 0;
		user.isLocked = false;
		user.isAdmin = admin;
		user.emailAddress = email;
		user.phoneNumber = phone;
		return user;
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	
	public boolean checkPassword(String attempt) {
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
	public void setUsername(String username) {
        this.username = username;
    }
	
	public void setPassword(String password) {
        this.password = password;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
        this.name = name;
    }

	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
        this.location = location;
    }
	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
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
