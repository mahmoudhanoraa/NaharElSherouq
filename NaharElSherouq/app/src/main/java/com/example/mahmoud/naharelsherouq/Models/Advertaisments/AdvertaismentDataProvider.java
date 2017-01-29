package com.example.mahmoud.naharelsherouq.Models.Advertaisments;

import com.example.mahmoud.naharelsherouq.Models.Categories.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mahmoud on 1/23/2017.
 */

public class AdvertaismentDataProvider {
    public static List<Advertaisment> advertaismentsList;
    public static Map<String, Advertaisment> advertaismentMap;

    static {
        advertaismentsList = new ArrayList<Advertaisment>();
        advertaismentMap = new HashMap<String, Advertaisment>();

        addAdvertaisment(new Advertaisment("شو طيب", "sho_tiab_icon.jpg", "sho_tiab.jpg", "Wonderful food", "ATM"));
        addAdvertaisment(new Advertaisment("Iron Gym", "Iron_Gym_logo.jpg", "iron_gym_pic.jpg","Health Club for all family members", "Gym"));
        addAdvertaisment(new Advertaisment("Spectra", "spectra_icon.jpg", "spectra.jpg", "Wonderfull Food", "Restaurant"));





    }

    private static void addAdvertaisment(Advertaisment advertaisment){
        advertaismentsList.add(advertaisment);
        advertaismentMap.put(advertaisment.getBrandName(), advertaisment);
    }

}
