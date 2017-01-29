package com.mintain.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mintain.mahmoud.naharelsherouq.Models.Categories.Category;
import com.mintain.mahmoud.naharelsherouq.Models.Categories.CategoryDataProvider;

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
        List<Category> cats = CategoryDataProvider.categoryList;
        ShopRecyclerViewAdabter adabter = new ShopRecyclerViewAdabter(rootView.getContext(), cats);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(),3));
        recyclerView.setAdapter(adabter);

        // Inflate the layout for this fragment
        return rootView;
    }



}
