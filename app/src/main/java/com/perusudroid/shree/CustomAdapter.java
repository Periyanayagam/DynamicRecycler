package com.perusudroid.shree;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Intel on 23-03-2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Country> countryList;

    public CustomAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    public void refresh(List<Country> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }



    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = null;

        switch (viewType) {
            case 1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_grid_item, parent, false);
                break;
            case 2:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_item, parent, false);
                break;

        }

        return new ViewHolder(v);
    }


    @Override
    public int getItemViewType(int position) {
        return countryList.get(position).getPic();
    }

    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {

        Country country = countryList.get(position);
        holder.countryName.setText(String.valueOf(country.getCountryName()));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView countryName;
        public ImageView ivAlbumCover;

        public ViewHolder(View v) {
            super(v);
            countryName = (TextView) v.findViewById(R.id.tv_country_name);
            ivAlbumCover = (ImageView) v.findViewById(R.id.iv_album_cover);

        }
    }
}