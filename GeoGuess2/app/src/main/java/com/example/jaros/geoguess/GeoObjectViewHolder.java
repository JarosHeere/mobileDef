package com.example.jaros.geoguess;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {
    public CardView geoCard;
    public ImageView geoImage;
    public View view;

    public GeoObjectViewHolder(View itemView) {
        super(itemView);
        //geoName = itemView.findViewById(R.id.geoTextView);
        geoImage = itemView.findViewById(R.id.geoImageView);
        geoCard = itemView.findViewById(R.id.tvCard);

        view = itemView;

    }

}
