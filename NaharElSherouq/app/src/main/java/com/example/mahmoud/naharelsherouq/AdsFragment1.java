package com.example.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahmoud.naharelsherouq.Models.Advertaisments.Advertaisment;
import com.example.mahmoud.naharelsherouq.Models.Advertaisments.AdvertaismentDataProvider;
import com.example.mahmoud.naharelsherouq.Models.Categories.CategoryDataProvider;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdsFragment1 extends Fragment {


    private static final String ARG_CATEGORY_NAME = "category_name";

    public AdsFragment1() {
        // Required empty public constructor
    }

    public static AdsFragment1 newInstance(String category) {

        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY_NAME, category);
        AdsFragment1 fragment = new AdsFragment1();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ads_fragment1, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.servicesAdsRecyclerView);

        String category = getArguments().getString(ARG_CATEGORY_NAME);
        List<Advertaisment> allAds = AdvertaismentDataProvider.advertaismentsList;
        List<Advertaisment> categoryAds = new ArrayList<Advertaisment>();
        for (int i = 0; i < allAds.size(); i++){
            Advertaisment ad = allAds.get(i);
            if (ad.getCategoryName() == category) {
                categoryAds.add(ad);
            }
        }
        AdvertaismentServicesRecyclerViewAdabter aRecyclerViewAdabter = new AdvertaismentServicesRecyclerViewAdabter(rootView.getContext(), categoryAds);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager((new LinearLayoutManager(rootView.getContext())));
        recyclerView.setAdapter(aRecyclerViewAdabter);

        return rootView;
    }

}
