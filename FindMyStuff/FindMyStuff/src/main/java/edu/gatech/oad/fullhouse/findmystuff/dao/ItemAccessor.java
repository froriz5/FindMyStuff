package edu.gatech.oad.fullhouse.findmystuff.dao;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;

/**
 * An accessor for item objects.  This will also manage ItemFeature objects, as an owned attribute of Item.
 * 
 * @author thejenix
 *
 */
public interface ItemAccessor {

    /**
     * Add an item to the incident, as specified by the Incident member of the Item object.
     * 
     * @param item
     */
    public void addItem(Item item);

    /**
     * Get items for a specific incident.
     * 
     * @param incident
     * @return
     */
    public List<Item> getItemsForIncident(Incident incident);
    
    /**
     * Update an item.
     * 
     * @param item
     */
    public void updateItem(Item item);

    /**
     * Delete an item.
     * 
     * @param item
     */
    public void deleteItem(Item item);
}
