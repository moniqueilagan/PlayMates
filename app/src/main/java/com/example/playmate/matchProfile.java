package com.example.playmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playmates.Matches;
import com.example.playmates.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class matchProfile extends AppCompatActivity {
    TextView petName, petBio;
    String name;
    ConstraintLayout sendLayout;
    FloatingActionButton message_btn;
    Button send_btn;
    TextInputLayout messageTxt;
    FirebaseDatabase rootNode;
    DatabaseReference reference, referenceMessages;
    String email;
    String matchOwnerEmail;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_profile);

        name = getIntent().getExtras().getString("matchName");

        petName = findViewById(R.id.name_matchProfile_txt);
        petBio = findViewById(R.id.bio_matchProfile_txt);
        message_btn = findViewById(R.id.message_matchProfile_btn);
        sendLayout = findViewById(R.id.constraintLayout4);
        send_btn = findViewById(R.id.send_matchProfile_btn);
        messageTxt = findViewById(R.id.message_matchProfile_input);
        email = getIntent().getExtras().getString("email");

        backBtn = findViewById(R.id.back_matchProfile_btn);

        reference = FirebaseDatabase.getInstance().getReference().child("pet");
        referenceMessages = FirebaseDatabase.getInstance().getReference("Messages");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                matchOwnerEmail = "";
                String Name = "";
                String Bio = "";
                for (DataSnapshot x : snapshot.getChildren()){
                    String temp = x.getKey();
                    String temp1 = snapshot.child(temp).child("name").getValue().toString();
                    if (temp1.contains(name)){
                        matchOwnerEmail = temp;
                    }
                }

                Name = snapshot.child(matchOwnerEmail).child("name").getValue().toString();
                Bio = snapshot.child(matchOwnerEmail).child("bio").getValue().toString();
                petName.setText(Name);
                petBio.setText(Bio);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });



        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = messageTxt.getEditText().getText().toString();
                referenceMessages.child(matchOwnerEmail).child(email).child("received").setValue(m);
                referenceMessages.child(email).child(matchOwnerEmail).child("sent").setValue(m);
                Toast.makeText(getApplicationContext(),"MESSAGE SENT", Toast.LENGTH_LONG).show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(matchProfile.this, Matches.class);
                startActivity(i);
            }
        });

        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLayout.setVisibility(View.VISIBLE);
            }
        });

    }
}