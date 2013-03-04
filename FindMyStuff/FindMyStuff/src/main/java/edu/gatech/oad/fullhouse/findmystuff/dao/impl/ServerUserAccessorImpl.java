package edu.gatech.oad.fullhouse.findmystuff.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import edu.gatech.oad.fullhouse.findmystuff.client.RESTClient;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.User;

/**
 * An implementation of UserAccessor to use the RoR server
 * for user information.
 * 
 * @author Jesse Rosalia
 *
 */
public class ServerUserAccessorImpl extends RESTClient<User> implements UserAccessor {

    public ServerUserAccessorImpl() {
        super(User.class);
    }
    public void addUser(User user) {
        super.create(user);
    }

    public User getUserByUsername(String username) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        String json = super.doGet("search", params);
        Gson gson = new Gson();
        return gson.fromJson(json, User.class);
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> getUsers() {
        return super.list();
    }
}
