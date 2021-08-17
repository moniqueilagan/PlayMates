package com.example.playmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class signUp4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        Button signUp4_prev = (Button) findViewById(R.id.prev_signUp4_btn);
        signUp4_prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(signUp4.this, signUp3.class);
                startActivity(i);
            }
        });


        Button done_signUp4 = (Button) findViewById(R.id.done_signUp4_btn);
        done_signUp4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(signUp4.this, profile.class);
                startActivity(i);
            }
        });


    }

    public void onCheckboxClicked(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.describe1_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe2_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe3_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe4_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe5_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe6_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe7_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe8_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe9_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe10_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe11_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe12_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe13_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe14_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe15_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe17_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe18_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe19_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe20_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe21_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe22_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe23_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe24_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe25_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe26_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe27_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe28_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe29_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe30_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe31_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe32_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe33_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe34_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe35_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe37_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe38_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe39_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe40_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.described41_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe42_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe43_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe44_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe45_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe46_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe47_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe48_chck:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.describe49_chck:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.describe50_chck:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}