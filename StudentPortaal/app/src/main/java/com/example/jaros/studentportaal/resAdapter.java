package com.example.jaros.studentportaal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.logging.Logger;

public class resAdapter extends RecyclerView.Adapter<resAdapter.portalsViewHolder> {


    private Context context;
    public List<portalObject> listNameObject;

    public resAdapter(Context context, List<portalObject> PortalObject) {
        this.context = context;
        this.listNameObject = PortalObject;

    }

    @NonNull
    @Override
    public portalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.portals_screen, parent, false);
        return new portalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull portalsViewHolder holder, int position) {
        // Gets a single item in the list from its position
        final portalObject portalObject = listNameObject.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.urlTitle.setText(portalObject.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("URL", portalObject.getUrl());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listNameObject.size();
    }

    public class portalsViewHolder extends RecyclerView.ViewHolder {

        public TextView urlTitle;
        public View view;

        public portalsViewHolder(View itemView) {
            super(itemView);
            urlTitle = itemView.findViewById(R.id.urlTitle);
            //geoImage = itemView.findViewById(R.id.geoImageView);
            view = itemView;

        }
    }

}



