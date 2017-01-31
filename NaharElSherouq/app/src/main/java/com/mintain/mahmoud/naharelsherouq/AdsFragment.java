package com.mintain.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.Advertaisment;
import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.AdvertaismentDataProvider;
import com.mintain.mahmoud.naharelsherouq.Models.Categories.Category;

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
        final List<Advertaisment> categoryAds = new ArrayList<Advertaisment>();
        final AdvertaismentShopsRecyclerViewAdabter aRecyclerViewAdabter = new AdvertaismentShopsRecyclerViewAdabter(rootView.getContext(), categoryAds);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        // Inflate the layout for this fragment
        final String category = getArguments().getString(ARG_CATEGORY_NAME);
//        List<Advertaisment> allAds = AdvertaismentDataProvider.advertaismentsList;
//        List<Advertaisment> categoryAds = new ArrayList<Advertaisment>();
//        for (int i = 0; i < allAds.size(); i++){
//            Advertaisment ad = allAds.get(i);
//            if (ad.getCategoryName() == category) {
//                categoryAds.add(ad);
//            }
//        }

        databaseReference.child("Advertisements").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children){
                    Advertaisment ad = child.getValue(Advertaisment.class);

                    if(ad.getCategoryName().equals(category)){
                        categoryAds.add(ad);
                    }
                }
                aRecyclerViewAdabter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager((new LinearLayoutManager(rootView.getContext())));
        recyclerView.setAdapter(aRecyclerViewAdabter);
        return rootView;
    }

}
