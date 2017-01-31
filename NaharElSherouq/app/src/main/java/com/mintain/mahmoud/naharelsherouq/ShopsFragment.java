package com.mintain.mahmoud.naharelsherouq;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mintain.mahmoud.naharelsherouq.Models.Categories.Category;
import com.mintain.mahmoud.naharelsherouq.Models.Categories.CategoryDataProvider;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFragment extends android.support.v4.app.Fragment{

    public ShopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shops_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.shopsRecyclerView);
//        List<Category> cats = CategoryDataProvider.categoryList;


        //START DATABASE TESTS

        final List<Category> cats = new ArrayList<Category>();
        final ShopRecyclerViewAdabter adabter = new ShopRecyclerViewAdabter(rootView.getContext(), cats);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        databaseReference.child("Categories").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children){
                    Category cat = child.getValue(Category.class);
//                    Log.d("data", Boolean.toString(!cat.isIsService()));
                    if(!cat.isIsService()) {
                        cats.add(cat);
                    }
                   // adabter.notifyDataSetChanged();
                }
                adabter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //END DATABASE TESTS

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(),3));
        recyclerView.setAdapter(adabter);
        // Inflate the layout for this fragment

        return rootView;
    }



}
