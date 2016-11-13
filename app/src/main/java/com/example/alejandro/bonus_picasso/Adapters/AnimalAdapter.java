package com.example.alejandro.bonus_picasso.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alejandro.bonus_picasso.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by Alejandro on 13/11/16.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private Context context;
    private String[] animals;
    private int layout;


    public AnimalAdapter(Context context, String[] animals, int layout) {
        this.context = context;
        this.animals = animals;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.with(context).load(animals[position]).fit().placeholder(R.drawable.spinner).into(holder.image, new Callback() {
            @Override
            public void onSuccess() {
                //holder.image.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.imageViewLayout);
        }

    }
}