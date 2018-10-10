package com.example.jaros.gamebacklog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Date;

public class moreInfo extends AppCompatActivity {

    GameRepository res;
    private TextInputEditText title;
    private TextInputEditText platform;
    private TextInputEditText notes;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final GameObject gameObject = (GameObject) getIntent().getExtras().get("object");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dropdown = findViewById(R.id.tvSpinner);
        String[] items = new String[]{"Want to play", "Playing", "Stalled", "Dropped"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setSelection(adapter.getPosition(gameObject.getStatus()));
        populateForm(gameObject);
        res = new GameRepository(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.setTitle(title.getText().toString());
                gameObject.setNotes(notes.getText().toString());
                gameObject.setPlatform(platform.getText().toString());
                gameObject.setStatus(dropdown.getSelectedItem().toString());
                gameObject.setDate(new Date().toString());
                launcActifity(gameObject);
            }
        });
    }

    private void launcActifity(GameObject object) {
        res.update(object);
        finish();
    }

    private void populateForm(GameObject object) {

        title = findViewById(R.id.tvTitle);
        platform = findViewById(R.id.tvPlatform);
        notes = findViewById(R.id.tvNotes);

        title.setText(object.getTitle());
        platform.setText(object.getPlatform());
        notes.setText(object.getNotes());
    }

}
