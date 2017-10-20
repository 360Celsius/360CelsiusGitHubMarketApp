package com.a360.celsius.stocksalmanac.datamodel;

/**
 * Created by dennisshar on 20/10/2017.
 */

public class SideMenuItemDataModel {

    String categoryName;
    int categoryImage;

    public SideMenuItemDataModel(String categoryName, int categoryImage) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }
}
