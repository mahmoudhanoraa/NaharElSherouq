package com.mintain.mahmoud.naharelsherouq;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mintain.mahmoud.naharelsherouq.Models.Advertaisments.Advertaisment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mahmoud on 1/28/2017.
 */

public class AdvertaismentServicesRecyclerViewAdabter extends RecyclerView.Adapter<AdvertaismentServicesRecyclerViewAdabter.ViewHolder> {
    private Context context;
    private List<Advertaisment> advertaismentList;
    private StorageReference mStorageRef;


    public AdvertaismentServicesRecyclerViewAdabter(Context context, List<Advertaisment> advertaismentList) {
        this.context = context;
        this.advertaismentList = advertaismentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.ads_item_card, parent, false);
        AdvertaismentServicesRecyclerViewAdabter.ViewHolder viewHolder = new AdvertaismentServicesRecyclerViewAdabter.ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Advertaisment advertaisment = advertaismentList.get(position);

        holder.brandName.setText(advertaisment.getBrandName());
        holder.description.setText(advertaisment.getDescription());
        String imageFile = advertaisment.getIconImage();
        // START TESTING STORADGE
        mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference filePath = mStorageRef.child("images/ads_icons/"+imageFile);

        filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(context).load(uri).resize(150,150).into(holder.icon);
            }
        });
        // END TESTING STORADGE
        //Picasso.with(context).load("file:///android_asset/"+imageFile).resize(150,150).into(holder.icon);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "you selected "+ category.getName(), Toast.LENGTH_LONG).show();
                DetailsFragment detailsFragment = DetailsFragment.newInstance(advertaisment);
                FragmentActivity host = (FragmentActivity) v.getContext();

                host.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.root_frame2, detailsFragment)
                        .commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return advertaismentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView icon;
        public TextView brandName;
        public TextView description;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.adImage);
            brandName = (TextView) itemView.findViewById(R.id.adName);
            description = (TextView) itemView.findViewById(R.id.adDisc);
            view = itemView;

        }
    }
}
