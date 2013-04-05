package edu.gatech.oad.fullhouse.findmystuff.dao.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import edu.gatech.oad.fullhouse.findmystuff.client.RESTClient;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;

public class ServerItemAccessorImpl extends RESTClient<Item> implements ItemAccessor {

    public ServerItemAccessorImpl() {
        super(Item.class);
    }

    public void addItem(Item item) {
        super.create(item);
    }

    public List<Item> getItemsForIncident(Incident incident) {
        Map<String, String> params = new HashMap<String, String>();
        String json = "";
        if (incident != null) {
            params.put("incident_id", incident.getId() + "");
            json = super.doGet("search", params);
            return (List<Item>) new Gson().fromJson(json, Item.class);
        } else {
            return super.list();
        }
    }

    public void updateItem(Item item) {
        throw new UnsupportedOperationException("NYI");
    }

    public void deleteItem(Item item) {
        throw new UnsupportedOperationException("NYI");
    }

    public List<Item> searchForItems(String name, String category,
            String status, String date) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("category", category);
        params.put("status", status);
        params.put("date", date);
        String json = "";
        if (!params.isEmpty()) {
            json = super.doGet("search", params);
            return Arrays.asList(new Gson().fromJson(json, Item[].class));
        } else {
            return super.list();
        }
    }
}
