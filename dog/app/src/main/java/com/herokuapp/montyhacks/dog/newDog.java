package com.herokuapp.montyhacks.dog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newDog extends AppCompatActivity {
    String namee;
    String breed;
    double lat;
    double longi;
    String time;
    boolean newDoggo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }
    public Button button3;

    public void init()
    {
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDoggo = true;
                EditText editText = (EditText) findViewById(R.id.editText);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                EditText editText3 = (EditText) findViewById(R.id.editText3);
                EditText editText4 = (EditText) findViewById(R.id.editText4);
                EditText editText5 = (EditText) findViewById(R.id.editText5);

                namee = editText.getText().toString();
                breed = editText2.getText().toString();
                lat = Double.parseDouble(editText3.getText().toString());
                longi = Double.parseDouble(editText4.getText().toString());
                time = editText5.getText().toString();

                Intent bck = new Intent(newDog.this, finddog.class);
                Log.d("newDog", "something on tap button");
                bck.putExtra("dogNamee", namee);
                bck.putExtra("dogBreed", breed);
                bck.putExtra("dogLat", lat);
                bck.putExtra("dogLongi", longi);
                bck.putExtra("dogTime", time);

                startActivity(bck);

            }
        });
    }
}
