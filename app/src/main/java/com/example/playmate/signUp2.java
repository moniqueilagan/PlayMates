package com.example.playmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class signUp2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        Button signUp2 = (Button) findViewById(R.id.next_signUp2_btn);
        signUp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(signUp2.this, signUp3.class);
                startActivity(i);
            }
        });

        Button signUp_prev2 = (Button) findViewById(R.id.prev_signUp2_btn);
        signUp_prev2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(signUp2.this, signUp1.class);
                startActivity(i);
            }
        });

        Spinner age = findViewById(R.id.age_input);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ageArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age.setAdapter(adapter);

        Spinner spayNeuter = findViewById(R.id.spayNeuter_input);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spay_or_neuter_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spayNeuter.setAdapter(adapter2);
    }
}