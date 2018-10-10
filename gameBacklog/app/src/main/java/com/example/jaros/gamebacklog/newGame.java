package com.example.jaros.gamebacklog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Date;

public class newGame extends AppCompatActivity {

    GameRepository res;
    private TextInputEditText title;
    private TextInputEditText notes;
    private TextInputEditText platform;
    private String date;
    Spinner dropdown;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add a new game");
        setContentView(R.layout.activity_new_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        res = new GameRepository(this);

        dropdown = findViewById(R.id.tvSpinner);
        String[] items = new String[]{"Want to play", "Playing", "Stalled", "Dropped"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        title = findViewById(R.id.tvTitle);
        notes = findViewById(R.id.tvNotes);
        platform = findViewById(R.id.tvPlatform);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActifity();
            }
        });
    }

    private void launchActifity(){

        date = String.valueOf(new Date());

        res.insert(new GameObject(
                title.getText().toString(),
                platform.getText().toString(),
                notes.getText().toString(),
                dropdown.getSelectedItem().toString(),
                date));
        finish();
    }



}
