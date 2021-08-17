package com.example.playmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.playmates.R;

public class filter extends AppCompatActivity {
    Button filterDone;
    String age, size, spayNeuterStatus, tempStatus, email, petName, petDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        filterDone = findViewById(R.id.done_Matches);
        email = getIntent().getExtras().getString("email");
        petName = getIntent().getExtras().getString("name");
        petDescription = getIntent().getExtras().getString("petDescription");

        filterDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(filter.this,filteredMatches.class);
                i.putExtra("age",age);
                i.putExtra("size",size);
                i.putExtra("spayNeuter",spayNeuterStatus);
                i.putExtra("temp",tempStatus);
                i.putExtra("email",email);
                i.putExtra("petDescription", petDescription);
                i.putExtra("petName",petName);
                startActivity(i);
            }
        });
    }

    public void onAgeCheckboxClicked(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.age1_btn:
                CheckBox a1 = findViewById(R.id.age1_btn);
                if (checked){
                    String age1s = a1.getText().toString();
                    age = age1s;
                }
                break;
            case R.id.age2_btn:
                CheckBox a2 = findViewById(R.id.age2_btn);
                if (checked){
                    String age2s = a2.getText().toString();
                    age = age2s;
                }
                break;
            case R.id.age3_btn:
                CheckBox a3 = findViewById(R.id.age3_btn);
                if (checked){
                    String age3s = a3.getText().toString();
                    age = age3s;
                }
                break;
            case R.id.age4_btn:
                CheckBox a4 = findViewById(R.id.age4_btn);
                if (checked){
                    String age4s = a4.getText().toString();
                    age = age4s;
                }
                break;
        }
    }

    public void onSizeCheckboxClicked(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.size1_btn:
                CheckBox s1 = findViewById(R.id.size1_btn);
                if (checked){
                    String size1s = s1.getText().toString();
                    size = size1s;
                }
                break;
            case R.id.size2_btn:
                CheckBox s2 = findViewById(R.id.size2_btn);
                if (checked){
                    String size2s = s2.getText().toString();
                    size = size2s;
                }
                break;
            case R.id.size3_btn:
                CheckBox s3 = findViewById(R.id.size3_btn);
                if (checked){
                    String size3s = s3.getText().toString();
                    size = size3s;
                }
                break;
            case R.id.size4_btn:
                CheckBox s4 = findViewById(R.id.size4_btn);
                if (checked){
                    String size4s = s4.getText().toString();
                    size = size4s;
                }
                break;
            case R.id.size5_btn:
                CheckBox s5 = findViewById(R.id.size5_btn);
                if (checked){
                    String size5s = s5.getText().toString();
                    size = size5s;
                }
                break;
        }
    }

    public void onSpayNeuterRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.yesSpayNeuter:
                RadioButton y = findViewById(R.id.yesSpayNeuter);
                if (checked){
                    String ys = y.getText().toString();
                    spayNeuterStatus = ys;
                }
                break;
            case R.id.noSpayNeuter:
                RadioButton n = findViewById(R.id.noSpayNeuter);
                if (checked){
                    String ns = n.getText().toString();
                    spayNeuterStatus = ns;
                }
                break;
        }
    }

    public void onShyOutgoingRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.shy_btn:
                RadioButton s = findViewById(R.id.shy_btn);
                if (checked){
                    String ss = s.getText().toString();
                    tempStatus = ss;
                }
                break;
            case R.id.outgoing_btn:
                RadioButton o = findViewById(R.id.outgoing_btn);
                if (checked){
                    String os = o.getText().toString();
                    tempStatus = os;
                }
                break;
            case R.id.notsure_btn:
                RadioButton n = findViewById(R.id.notsure_btn);
                if (checked){
                    String ns = n.getText().toString();
                    tempStatus = ns;
                }
                break;
        }
    }
}