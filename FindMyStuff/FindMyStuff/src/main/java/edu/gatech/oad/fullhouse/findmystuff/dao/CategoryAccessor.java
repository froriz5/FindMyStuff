package edu.gatech.oad.fullhouse.findmystuff.dao;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.model.Category;

public interface CategoryAccessor {

    public List<Category> getAvailableCategories();
}
