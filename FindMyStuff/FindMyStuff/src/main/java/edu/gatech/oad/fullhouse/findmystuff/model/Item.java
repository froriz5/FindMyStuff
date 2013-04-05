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

    private long incident_id;

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

    public long getIncident_id() {
        return incident_id;
    }
    
    public void setIncident_id(long incident_id) {
        this.incident_id = incident_id;
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
