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
import com.mintain.mahmoud.naharelsherouq.Models.Categories.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mahmoud on 1/28/2017.
 */

public class ServicesRecyclerViewAdabter extends RecyclerView.Adapter<ServicesRecyclerViewAdabter.ViewHolder> {
    private Context context;
    private List<Category> categories;
    private StorageReference mStorageRef;

    public ServicesRecyclerViewAdabter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public ServicesRecyclerViewAdabter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.grid_item, parent, false);
        ServicesRecyclerViewAdabter.ViewHolder viewHolder = new ServicesRecyclerViewAdabter.ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Category category = this.categories.get(position);

        holder.catName.setText(category.getName());
        String imageFile = category.getIcon();
        //Picasso.with(context).load("file:///android_asset/"+imageFile).resize(50,50).into(holder.catIcon);

        // START TESTING STORADGE
        mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference filePath = mStorageRef.child("images/categories/"+imageFile);

        filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(context).load(uri).resize(80,80).into(holder.catIcon);
            }
        });
        // END TESTING STORADGE

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "you selected "+ category.getName(), Toast.LENGTH_LONG).show();
                AdsFragment1 adsFragment = AdsFragment1.newInstance(category.getName());
                FragmentActivity host = (FragmentActivity) v.getContext();


                host.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.root_frame2, adsFragment)
                        .commit();



            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView catName;
        public ImageView catIcon;
        public View view;


        public ViewHolder(View itemView) {
            super(itemView);
            catName = (TextView) itemView.findViewById(R.id.catName);
            catIcon = (ImageView) itemView.findViewById(R.id.catImage);
            view = itemView;
        }
    }
}
