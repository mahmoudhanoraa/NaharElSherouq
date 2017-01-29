package com.mintain.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.Advertaisment;
import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.AdvertaismentDataProvider;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdsFragment extends Fragment {


    private static final String ARG_CATEGORY_NAME = "category_name";

    public AdsFragment() {
        // Required empty public constructor
    }

    public static AdsFragment newInstance(String category) {
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY_NAME, category);
        AdsFragment fragment = new AdsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ads, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.shopsAdsRecyclerView);
        // Inflate the layout for this fragment
        String category = getArguments().getString(ARG_CATEGORY_NAME);
        List<Advertaisment> allAds = AdvertaismentDataProvider.advertaismentsList;
        List<Advertaisment> categoryAds = new ArrayList<Advertaisment>();
        for (int i = 0; i < allAds.size(); i++){
            Advertaisment ad = allAds.get(i);
            if (ad.getCategoryName() == category) {
                categoryAds.add(ad);
            }
        }

        AdvertaismentShopsRecyclerViewAdabter aRecyclerViewAdabter = new AdvertaismentShopsRecyclerViewAdabter(rootView.getContext(), categoryAds);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager((new LinearLayoutManager(rootView.getContext())));
        recyclerView.setAdapter(aRecyclerViewAdabter);
        return rootView;
    }

}
