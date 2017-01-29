package com.mintain.mahmoud.naharelsherouq.Models.Categories;

/**
 * Created by mahmoud on 1/23/2017.
 */

public class Category {
    private String name;
    private String icon;
    private boolean isService;

    public Category() {
    }

    public Category(String name, String icon, boolean isService) {
        this.name = name;
        this.icon = icon;
        this.isService = isService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isService() {
        return isService;
    }

    public void setService(boolean service) {
        isService = service;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
