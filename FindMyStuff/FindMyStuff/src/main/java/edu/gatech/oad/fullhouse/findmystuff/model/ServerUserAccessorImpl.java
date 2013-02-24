package edu.gatech.oad.fullhouse.findmystuff.model;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.client.RESTClient;

/**
 * An implementation of UserAccessor to use the RoR server
 * for user information.
 * 
 * @author Jesse Rosalia
 *
 */
public class ServerUserAccessorImpl implements UserAccessor {

    private RESTClient<User> client;

    public ServerUserAccessorImpl() {
        this.client = new RESTClient<User>(User.class);
    }
    public void addUser(User user) {
        client.create(user);
    }

    public User getUserByUsername(String username) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> getUsers() {
        return client.list();
    }

}
