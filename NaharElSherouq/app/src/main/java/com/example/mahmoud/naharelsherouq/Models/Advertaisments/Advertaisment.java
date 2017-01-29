package com.example.mahmoud.naharelsherouq.Models.Advertaisments;

import com.example.mahmoud.naharelsherouq.ServicesRecyclerViewAdabter;

/**
 * Created by mahmoud on 1/23/2017.
 */

public class Advertaisment {
    private String brandName;
    private String iconImage;
    private String advertaismentImage;
    private String description;
    private String categoryName;

    public Advertaisment() {
    }

    public Advertaisment(String brandName, String iconImage, String advertaismentImage, String description, String categoryName) {
        this.brandName = brandName;
        this.iconImage = iconImage;
        this.advertaismentImage = advertaismentImage;
        this.description = description;
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public String getAdvertaismentImage() {
        return advertaismentImage;
    }

    public void setAdvertaismentImage(String advertaismentImage) {
        this.advertaismentImage = advertaismentImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Advertaisment{" +
                "brandName='" + brandName + '\'' +
                ", iconImage='" + iconImage + '\'' +
                ", advertaismentImage='" + advertaismentImage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
