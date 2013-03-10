package edu.gatech.oad.fullhouse.findmystuff.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an item that is either lost or found.
 * 
 * @author Jesse Rosalia
 *
 */
public class Item {

    private String name;

    private String category;

    private Incident incident;

    private String status;

    private List<ItemFeature> item_features = new ArrayList<ItemFeature>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemFeature> getItem_Features() {
        return item_features;
    }

    public void setItem_Features(List<ItemFeature> item_features) {
        this.item_features = item_features;
    }

}
