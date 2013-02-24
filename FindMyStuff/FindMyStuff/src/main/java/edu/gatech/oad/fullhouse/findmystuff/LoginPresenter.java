package edu.gatech.oad.fullhouse.findmystuff;

public class LoginPresenter {
	private LoginPresenter instance;
	
	private LoginPresenter() {
		instance = this;
	}
	
	public LoginPresenter getInstance() {
		if (instance == null)
			instance = new LoginPresenter();
		return instance;
	}
	
	public void loginAttempt(String username, String password) {
		switch(LoginManager.getInstance().checkPassword(username, password)) {
			case 0:
				
			
		}
	}
}
