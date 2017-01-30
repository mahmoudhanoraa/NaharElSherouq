package com.mintain.mahmoud.naharelsherouq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.Advertaisment;
import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.AdvertaismentDataProvider;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private static final String ARG_ADVERTAISMENT_NAME = "advertaisment_name";

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(String adName) {

        Bundle args = new Bundle();
        args.putString(ARG_ADVERTAISMENT_NAME, adName);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        Advertaisment ad = AdvertaismentDataProvider.advertaismentMap.get(getArguments().getString(ARG_ADVERTAISMENT_NAME));
        TextView name = (TextView) rootView.findViewById(R.id.AdDetailName);
        TextView description = (TextView) rootView.findViewById(R.id.descriptionAdDetailText);
        ImageView pic = (ImageView) rootView.findViewById(R.id.imageAdDetail);

        name.setText(ad.getBrandName());
        description.setText(ad.getDescription());
        Picasso.with(rootView.getContext()).load("file:///android_asset/"+ad.getIconImage()).resize(150,150).into(pic);


        return rootView;
    }

}
