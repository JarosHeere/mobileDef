package com.example.jaros.higher_lowerapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DiceRollActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mItems;
    private int[] plaatjes;

    private EditText mHighScore;
    private EditText mScore;
    private ImageView dice;

    private int currentScore = 0;
    private int highScore = 0;
    private int lastRoll;


    /*
    nog tedoen
          list omdraaien

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);




        mListView = findViewById(R.id.rollHistory);
        mItems = new ArrayList<>();

        mHighScore = findViewById(R.id.highScore);
        mScore = findViewById(R.id.Score);
        dice = findViewById(R.id.Dice);

        plaatjes = new int[]{R.drawable.een, R.drawable.twee, R.drawable.drie, R.drawable.vier, R.drawable.vijf, R.drawable.zes};


        Button bHigher = findViewById(R.id.bHigher);
        bHigher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                higherLower(true);

            }
        });

        Button bLower = findViewById(R.id.bLower);
        bLower.setOnClickListener(new View.OnClickListener() {
            public void onClick(View f) {

                higherLower(false);
            }
        });

        startUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice_roll, menu);
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

    /**
     * Bij opstarten programma het spel klaarzetten
     */
    private void startUp() {
        //basis getal klaarzetten
        int startRoll = (int) (Math.random() * 6 + 1);
        lastRoll = startRoll;
        mItems.add("Throw is: " + lastRoll);

        //dobelsteen aanpassen
        setDiceImmage(startRoll);

        //list klaarzetten
        updateHistory();

    }

    /**
     * @param gHigher wordt er gegokt dat het getal hoger is
     */
    public void higherLower(Boolean gHigher) {
        int roll = (int) (Math.random() * 6 + 1);

        //controle of het niet twee keer op het zelfde getal land
        if (roll == lastRoll) {
            higherLower(gHigher);
        } else {

            //bij rol hoger dan vorige roll
            if (roll > lastRoll) {
                if (gHigher) {
                    correct();
                } else {
                    fout();
                }
                //bij rol lager dan vorige roll
            } else {
                if (gHigher) {
                    fout();
                } else {
                    correct();
                }
            }
            //dobelsteen veranderen
            setDiceImmage(roll);
            //updaten waarden
            lastRoll = roll;
            mItems.add(0,"Throw is: " + lastRoll);

            updateHistory();
        }
    }

    /**
     * bij correcte gok
     */
    private void correct() {
        //score verhogen
        currentScore++;
        //controle highscore en dezer zonodig aanpassen
        if (currentScore > highScore) {
            highScore = currentScore;
            mHighScore.setText("HighScore: " + highScore);

        }
        mScore.setText("Score: " + currentScore);
        Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
    }

    /**
     * bij foute gok
     */
    private void fout() {
        //score terug zetten op 0
        currentScore = 0;
        mScore.setText("Score: " + currentScore);

        Toast.makeText(this, "You lost", Toast.LENGTH_SHORT).show();
        //geschidenis vorige spel verweideren
        mItems.clear();
    }

    /**
     * veranderen dobbelsteen naar gegooide waarde
     *
     * @param Number waarde van de rol
     */
    private void setDiceImmage(int Number) {
        dice.setImageResource(plaatjes[Number - 1]);
    }

    /**
     * klaarzetten van de list
     */
    private void updateHistory() {
        //bij opstarten de list aanmaken
        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, mItems);
            mListView.setAdapter(mAdapter);
            //anders waardes van de list updaten
        } else {

            mAdapter.notifyDataSetChanged();
        }


    }


}
