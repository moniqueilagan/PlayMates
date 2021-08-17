package com.example.playmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class signUp3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);

        Button signUp_prev3 = (Button) findViewById(R.id.prev_signUp3_btn);
        signUp_prev3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(signUp3.this, signUp2.class);
                startActivity(i);
            }
        });


        Button next_signUp3 = (Button) findViewById(R.id.next_signUp3_btn);
        next_signUp3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(signUp3.this, signUp4.class);
                startActivity(i);
            }
        });

        Spinner size = findViewById(R.id.weight_input);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.dogSize_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(adapter3);

        Spinner energy = findViewById(R.id.energy_input);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.energyArray, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        energy.setAdapter(adapter4);

        Spinner temp = findViewById(R.id.temp_input);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.tempermentArray, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp.setAdapter(adapter5);
    }
}