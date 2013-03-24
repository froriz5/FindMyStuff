package edu.gatech.oad.fullhouse.findmystuff.dao.impl;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.client.RESTClient;
import edu.gatech.oad.fullhouse.findmystuff.dao.CategoryAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.Category;

public class ServerCategoryAccessorImpl extends RESTClient<Category> implements CategoryAccessor {

    public ServerCategoryAccessorImpl() {
        super(Category.class);
    }

    public List<Category> getAvailableCategories() {
        return super.list();
    }
}
