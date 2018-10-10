package com.example.jaros.studentportaal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddNewPortal extends AppCompatActivity {

    private EditText url;
    private EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addportal_screen);


        url = findViewById(R.id.urlInput);
        title = findViewById(R.id.titleInput);

        FloatingActionButton fab = findViewById(R.id.áddPortal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (url.getText() == null || title.getText() == null) {

                } else {
                    Intent intend2 = new Intent();
                    intend2.putExtra("object", new portalObject(title.getText().toString(), url.getText().toString()));
                    setResult(RESULT_OK, intend2);
                    finish();

                }
            }

        });
    }
}
