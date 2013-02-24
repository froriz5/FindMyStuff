package edu.gatech.oad.fullhouse.findmystuff.model;

import edu.gatech.oad.fullhouse.findmystuff.client.RESTClient;


public class ServerUserAccessorImpl implements UserAccessor {

    public void addUser(User user) {
        RESTClient<User> client = new RESTClient<User>(User.class);
        client.create(user);
    }

    public User getUserByUsername(String username) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public User[] getUsers() {
        return null;
    }

}
