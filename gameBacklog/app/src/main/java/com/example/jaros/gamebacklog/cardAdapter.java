package com.example.jaros.gamebacklog;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.cardssViewHolder> {
    private Context context;
    public List<GameObject> listNameObject;

    public cardAdapter(Context context, List<GameObject> listNameObject) {
        this.context = context;
        this.listNameObject = listNameObject;
    }

    @NonNull
    @Override
    public cardssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new cardssViewHolder(view);
    }

    public void setListNameObject(List<GameObject> listNameObject) {
        this.listNameObject = listNameObject;
    }

    @Override
    public void onBindViewHolder(@NonNull cardssViewHolder holder, int position) {
        // Gets a single item in the list from its position
        final GameObject object = listNameObject.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.title.setText(object.getTitle());
        holder.platform.setText(object.getPlatform());
        holder.status.setText(object.getStatus());
        holder.datum.setText(object.getDate());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, moreInfo.class);
                intent.putExtra("object", object);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listNameObject.size();
    }

    public GameObject getItem(int position){
        return listNameObject.get(position);
    }

    public class cardssViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView platform;
        public TextView status;
        public TextView datum;
        public View view;

        public cardssViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.id_title);
            platform = itemView.findViewById(R.id.id_platform);
            status = itemView.findViewById(R.id.id_status);
            datum = itemView.findViewById(R.id.id_date);

            view = itemView;
        }
    }
}
