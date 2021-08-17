package com.example.playmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playmates.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class messages extends AppCompatActivity {
    TextView title;
    Button send, back;
    TextInputLayout reply;
    ListView list;
    String matchOwner, email;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        title = findViewById(R.id.matchOwner_messages);
        send = findViewById(R.id.send_messages_btn);
        reply = findViewById(R.id.replyInput_messages);
        list = findViewById(R.id.list_messages);
        back = findViewById(R.id.backBtnMessages);
        matchOwner = getIntent().getExtras().getString("matchOwner");
        email = getIntent().getExtras().getString("email");

        title.setText(matchOwner);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);

        reference = FirebaseDatabase.getInstance().getReference("Messages");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                arrayAdapter.clear();
                arrayAdapter.notifyDataSetChanged();
                ArrayList<String> messagesList = new ArrayList<>();
                int counter = 0;
                for (DataSnapshot x : snapshot.child(email).child(matchOwner).getChildren()){
                    String key = x.getKey();
                    String temp = x.getValue().toString();
                    String message = "";
                    if (key.equals("sent")){
                        message = email + ": " + temp;
                        messagesList.add(counter,message);
                        counter++;
                    } else if (key.equals("received")){
                        message = matchOwner + ": " + temp;
                        messagesList.add(counter,message);
                        counter++;
                    } else if (key.equals("reply")){
                        int repIndex = messagesList.indexOf(temp) + 1;
                        Boolean sBoolean = snapshot.child(email).child(matchOwner).hasChild("sent");
                        Boolean rBoolean = snapshot.child(email).child(matchOwner).hasChild("received");
                        if (sBoolean.equals(true)){
                            message = matchOwner + ": " + temp;
                        } else if (rBoolean.equals(true)){
                            message = email + ": " + temp;
                        } else {
                            message = "try again";
                        }
                        messagesList.add(counter,message);
                        counter = repIndex;
                    }
                }

                for (int i = 0;i < messagesList.size();i++){
                    String x = messagesList.get(i);
                    arrayAdapter.add(x);
                }

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String replyIn = reply.getEditText().getText().toString();
                        reference.child(email).child(matchOwner).child("reply").setValue(replyIn);
                        reference.child(matchOwner).child(email).child("reply").setValue(replyIn);
                        Toast.makeText(getApplicationContext(),"MESSAGE SENT", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(messages.this,messagesHub.class);
                startActivity(i);
            }
        });

    }
}