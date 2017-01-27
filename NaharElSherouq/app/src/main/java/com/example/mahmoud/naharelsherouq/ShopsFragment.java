package com.example.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahmoud.naharelsherouq.Models.Categories.Category;
import com.example.mahmoud.naharelsherouq.Models.Categories.CategoryDataProvider;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFragment extends android.support.v4.app.Fragment implements OnBackPressListener{

    private Fragment parentFragment;


    public ShopsFragment() {
        // Required empty public constructor
    }

    public ShopsFragment newInstance(Fragment parentFragment) {

        Bundle args = new Bundle();
        this.parentFragment = parentFragment;
        ShopsFragment fragment = new ShopsFragment();
        fragment.setArguments(args);
        return fragment;
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

    @Override
    public boolean onBackPressed() {

        if (parentFragment == null) return false;

        int childCount = parentFragment.getChildFragmentManager().getBackStackEntryCount();

        if (childCount == 0) {
            // it has no child Fragment
            // can not handle the onBackPressed task by itself
            return false;

        } else {
            // get the child Fragment
            FragmentManager childFragmentManager = parentFragment.getChildFragmentManager();
            OnBackPressListener childFragment = (OnBackPressListener) childFragmentManager.getFragments().get(0);

            // propagate onBackPressed method call to the child Fragment
            if (!childFragment.onBackPressed()) {
                // child Fragment was unable to handle the task
                // It could happen when the child Fragment is last last leaf of a chain
                // removing the child Fragment from stack
                childFragmentManager.popBackStackImmediate();

            }

            // either this Fragment or its child handled the task
            // either way we are successful and done here
            return true;
        }
    }

}
