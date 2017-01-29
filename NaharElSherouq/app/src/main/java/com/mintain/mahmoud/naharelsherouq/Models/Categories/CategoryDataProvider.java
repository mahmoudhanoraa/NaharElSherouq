package com.mintain.mahmoud.naharelsherouq.Models.Categories;

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
    public static List<Category> servicesList;

    static {
        categoryList = new ArrayList<Category>();
        stringCategoryMap = new HashMap<String, Category>();
        servicesList = new ArrayList<Category>();

        addCategory(new Category("Pharmacy", "Doctors Bag.png", false));
        addCategory(new Category("Restaurant", "Restaurant.png", false));
        addCategory(new Category("Barbershop", "Barbershop.png",false));
        addCategory(new Category("Photography", "Camera.png",false));
        addCategory(new Category("Pet Care", "Cat Footprint.png",false));
        addCategory(new Category("Stationary", "Print.png",false));
        addCategory(new Category("Games", "Controller.png",false));
        addCategory(new Category("Beauty Center", "Woman's Hair.png",false));
        addCategory(new Category("Gym", "Dumbbell.png",false));
        addCategory(new Category("Car care", "Automotive.png",false));
        addCategory(new Category("Laundry", "Carpet Cleaning.png",false));
        addCategory(new Category("Grocery", "Checkout.png",false));
        addCategory(new Category("Hospital", "hospital.png", true));
        addCategory(new Category("ATM", "ATM.png", true));




    }
    private static void addCategory(Category category){
        if(category.isService() == true) {
            servicesList.add(category);
            return;
        }
        categoryList.add(category);
        stringCategoryMap.put(category.getName(), category);
    }


}
