package com.example.mahmoud.naharelsherouq;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud.naharelsherouq.Models.Categories.Category;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by mahmoud on 1/23/2017.
 */

public class ShopRecyclerViewAdabter extends RecyclerView.Adapter<ShopRecyclerViewAdabter.ViewHolder> {

    private Context context;
    private List<Category> categories;

    public ShopRecyclerViewAdabter(Context context, List<Category> categories) {
        this.categories = categories;
        this.context = context;
    }

    @Override
    public ShopRecyclerViewAdabter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.grid_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Category category = this.categories.get(position);


            holder.catName.setText(category.getName());
            String imageFile = category.getIcon();
            Picasso.with(context).load("file:///android_asset/"+imageFile).resize(50,50).into(holder.catIcon);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "you selected "+ category.getName(), Toast.LENGTH_LONG).show();
                AdsFragment adsFragment = AdsFragment.newInstance(category.getName());
                FragmentActivity host = (FragmentActivity) v.getContext();


                host.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("koko")
                        .replace(R.id.root_frame, adsFragment)
                        .commit();



            }
        });




    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

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
