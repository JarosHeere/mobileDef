package com.example.jaros.gamebacklog;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private cardAdapter adapter;
    List<GameObject> gameObject = new ArrayList<>();
    GameRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final RecyclerView mPortalRecyclerView = findViewById(R.id.cardsR);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        mPortalRecyclerView.setLayoutManager(mLayoutManager);
        final cardAdapter mAdapter = new cardAdapter(this, gameObject);
        mPortalRecyclerView.setAdapter(mAdapter);
        adapter = mAdapter;

        res = new GameRepository(this);
        res.getAllObjects().observe(this, new Observer<List<GameObject>>() {

            @Override
            public void onChanged(@Nullable List<GameObject> gameObjects) {
                MainActivity.this.gameObject = gameObjects;
                adapter.setListNameObject(gameObject);
                gameObject = gameObjects;
                adapter.notifyDataSetChanged();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcActivity();
            }
        });

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =

                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }


                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        GameObject toRemove = gameObject.get(viewHolder.getAdapterPosition());
                        //Get the index corresponding to the selected position
                        res.delete(toRemove);
                    }

                };
        new ItemTouchHelper(simpleItemTouchCallback).attachToRecyclerView(mPortalRecyclerView);

    }

    private void launcActivity() {

        Intent intent = new Intent(this, newGame.class);
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
