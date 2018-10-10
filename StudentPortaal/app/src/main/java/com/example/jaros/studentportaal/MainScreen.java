package com.example.jaros.studentportaal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {
    List<portalObject> porlatLists = new ArrayList<>();

    private resAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        final RecyclerView mPortalRecyclerView = findViewById(R.id.portalsRecyc);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        mPortalRecyclerView.setLayoutManager(mLayoutManager);
        final resAdapter mAdapter = new resAdapter(this, porlatLists);
        mPortalRecyclerView.setAdapter(mAdapter);
        adapter = mAdapter;


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivityNewPortal();
            }
        });
    }

    private void launchActivityNewPortal() {

        Intent intent = new Intent(this, AddNewPortal.class);
        startActivityForResult(intent, 1234);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234){
            if(resultCode == RESULT_OK){
                porlatLists.add((portalObject)data.getSerializableExtra("object"));
                adapter.notifyDataSetChanged();
            }
        }

    }
}
