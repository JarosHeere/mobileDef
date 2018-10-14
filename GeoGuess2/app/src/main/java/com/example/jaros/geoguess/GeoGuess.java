package com.example.jaros.geoguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class GeoGuess extends AppCompatActivity {
    List<GeoObject> mGeoObjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_guess);


        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {

            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]));
        }


        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallbackLeft =

                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }


                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        int positon = viewHolder.getAdapterPosition();
                        left(mGeoObjects.get(positon));
                    }

                };
        new ItemTouchHelper(simpleItemTouchCallbackLeft).attachToRecyclerView(mGeoRecyclerView);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallbackRight =

                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }


                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        int position = viewHolder.getAdapterPosition();
                        right(mGeoObjects.get(position));

                    }

                };
        new ItemTouchHelper(simpleItemTouchCallbackRight).attachToRecyclerView(mGeoRecyclerView);


    }

    public void left(GeoObject object) {
        if (object.getmGeoName() == "yes") {
            Toast toast = Toast.makeText(getApplicationContext(), "That is correct", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "That is wrong", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void right(GeoObject object) {


        if (object.getmGeoName() == "no") {
            Toast toast = Toast.makeText(getApplicationContext(), "That is correct", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "That is wrong", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
