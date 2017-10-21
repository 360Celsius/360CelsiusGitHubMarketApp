package com.a360.celsius.stocksalmanac.datamodel;

import android.widget.RelativeLayout;

/**
 * Created by dennisshar on 20/10/2017.
 */

public class SideMenuItemDataModel {

    String categoryName;
    int categoryImage;
    int color;
    int categoryID;

    public SideMenuItemDataModel(String categoryName, int categoryImage,int color,int categoryID) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.color = color;
        this.categoryID = categoryID;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
