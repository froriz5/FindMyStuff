package edu.gatech.oad.fullhouse.findmystuff.model;

public class Session {

    private static Session _instance;

    private User loggedInUser;

    public static Session newSession() {
        _instance = new Session(); // blow away the old session
        return _instance;
    }

    public static Session instance() {
        if (_instance == null) {
            newSession();
        }
        return _instance;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
