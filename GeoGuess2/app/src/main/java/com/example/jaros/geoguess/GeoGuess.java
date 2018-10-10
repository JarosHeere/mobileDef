package com.example.jaros.geoguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class GeoGuess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_guess);


        List<GeoObject> mGeoObjects = new ArrayList<>();


        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {

            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]));
        }


        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);


    }
}
