package com.example.playmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.playmates.Profile;
import com.example.playmates.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class messagesHub extends AppCompatActivity {
    String email, matchOwner;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ListView messagesRecipients;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_hub);

        email = getIntent().getExtras().getString("email");
        messagesRecipients = findViewById(R.id.messagesListView);
        back = findViewById(R.id.backBtn_messages);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        messagesRecipients.setAdapter(arrayAdapter);

        reference = FirebaseDatabase.getInstance().getReference("Messages");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                for (DataSnapshot x : snapshot.child(email).getChildren()){
                    String temp = x.getKey();
                    arrayAdapter.add(temp);
                }

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        messagesRecipients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                matchOwner = parent.getItemAtPosition(position).toString();
                Intent i = new Intent(messagesHub.this, messages.class);
                i.putExtra("matchOwner",matchOwner);
                i.putExtra("email",email);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(messagesHub.this, Profile.class);
                startActivity(i);
            }
        });
    }
}