package com.mintain.mahmoud.naharelsherouq.Models.Advertaisments;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mahmoud on 1/23/2017.
 */

public class Advertaisment implements Parcelable {
    private String brandName;
    private String iconImage;
    private String description;
    private String categoryName;
    private String descAndContacts;


    public Advertaisment() {
    }

    public Advertaisment(String brandName, String iconImage, String description, String categoryName, String descAndContacts) {
        this.brandName = brandName;
        this.iconImage = iconImage;
        this.description = description;
        this.categoryName = categoryName;
        this.descAndContacts = descAndContacts;
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

    public String getDescAndContacts() {
        return descAndContacts;
    }

    public void setDescAndContacts(String descAndContacts) {
        this.descAndContacts = descAndContacts;
    }

    @Override
    public String toString() {
        return "Advertaisment{" +
                "brandName='" + brandName + '\'' +
                ", iconImage='" + iconImage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.brandName);
        dest.writeString(this.iconImage);
        dest.writeString(this.description);
        dest.writeString(this.categoryName);
        dest.writeString(this.descAndContacts);
    }

    protected Advertaisment(Parcel in) {
        this.brandName = in.readString();
        this.iconImage = in.readString();
        this.description = in.readString();
        this.categoryName = in.readString();
        this.descAndContacts = in.readString();
    }

    public static final Parcelable.Creator<Advertaisment> CREATOR = new Parcelable.Creator<Advertaisment>() {
        @Override
        public Advertaisment createFromParcel(Parcel source) {
            return new Advertaisment(source);
        }

        @Override
        public Advertaisment[] newArray(int size) {
            return new Advertaisment[size];
        }
    };
}
