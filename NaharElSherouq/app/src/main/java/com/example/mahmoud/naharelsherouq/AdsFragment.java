package com.example.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
        // Inflate the layout for this fragment
        TextView tv = (TextView) rootView.findViewById(R.id.catnamefragment);
        tv.setText(getArguments().getString(ARG_CATEGORY_NAME));
        return rootView;
    }

}
