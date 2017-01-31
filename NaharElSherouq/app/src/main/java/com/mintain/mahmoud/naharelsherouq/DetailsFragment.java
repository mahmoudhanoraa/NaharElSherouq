package com.mintain.mahmoud.naharelsherouq;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.Advertaisment;
import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.AdvertaismentDataProvider;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private static final String ARG_ADVERTAISMENT_KEY = "advertaisment_key";
    private Advertaisment mAd;
    private StorageReference mStorageRef;


    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(Advertaisment advert) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_ADVERTAISMENT_KEY, advert);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_details, container, false);
       // Advertaisment ad = AdvertaismentDataProvider.advertaismentMap.get(getArguments().getString(ARG_ADVERTAISMENT_NAME));
       Bundle args = getArguments();
        if(args == null) throw new AssertionError();

        mAd = args.getParcelable(ARG_ADVERTAISMENT_KEY);

        TextView name = (TextView) rootView.findViewById(R.id.AdDetailName);
        TextView description = (TextView) rootView.findViewById(R.id.descriptionAdDetailText);
        final ImageView pic = (ImageView) rootView.findViewById(R.id.imageAdDetail);
        TextView contacts = (TextView) rootView.findViewById(R.id.descriptionContactsDetails);

        name.setText(mAd.getBrandName());
        description.setText(mAd.getDescription());
        contacts.setText(mAd.getDescAndContacts());

        // START TESTING STORADGE
        mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference filePath = mStorageRef.child("images/ads_icons/"+mAd.getIconImage());

        filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(rootView.getContext()).load(uri).resize(150,150).into(pic);
            }
        });
        // END TESTING STORADGE


       // Picasso.with(rootView.getContext()).load("file:///android_asset/"+ ad.getIconImage()).resize(150,150).into(pic);


        return rootView;
    }

}
