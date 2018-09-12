package com.example.jaros.geoguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GeoGuess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_guess);

        Glide.with(this)
                .load(R.drawable.img1_yes_denmark)
                .into((ImageView) findViewById(R.id.plaatje1));

    }
}
