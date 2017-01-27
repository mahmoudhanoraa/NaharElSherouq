package com.example.mahmoud.naharelsherouq.Models.Categories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mahmoud on 1/23/2017.
 */

public class CategoryDataProvider {
    public static List<Category> categoryList;
    public static Map<String, Category> stringCategoryMap;

    static {
        categoryList = new ArrayList<Category>();
        stringCategoryMap = new HashMap<String, Category>();

        addCategory(new Category("Pharmacy", "Doctors Bag.png"));
        addCategory(new Category("Restaurant", "Restaurant.png"));
        addCategory(new Category("Barbershop", "Barbershop.png"));
        addCategory(new Category("Photography", "Camera.png"));
        addCategory(new Category("Pet Care", "Cat Footprint.png"));
        addCategory(new Category("Stationary", "Print.png"));
        addCategory(new Category("Games", "Controller.png"));
        addCategory(new Category("Beauty Center", "Woman's Hair.png"));
        addCategory(new Category("Gym", "Dumbbell.png"));
        addCategory(new Category("Car care", "Automotive.png"));
        addCategory(new Category("Laundry", "Carpet Cleaning.png"));
        addCategory(new Category("Grocery", "Checkout.png"));

    }
    private static void addCategory(Category category){
        categoryList.add(category);
        stringCategoryMap.put(category.name, category);
    }


}
