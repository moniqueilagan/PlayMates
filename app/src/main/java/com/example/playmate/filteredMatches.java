package com.example.playmate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.playmates.Profile;
import com.example.playmates.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class filteredMatches extends AppCompatActivity {
    String age, size, spayNeuterStatus, tempStatus, email, petName, petDescription;
    ListView mList;
    Button backBtn;
    ArrayAdapter arrayAdapter1;
    ArrayList<String> arrayListS = new ArrayList<>();
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_matches);

        age = getIntent().getExtras().getString("age");
        size = getIntent().getExtras().getString("size");
        spayNeuterStatus = getIntent().getExtras().getString("spayNeuter");
        tempStatus = getIntent().getExtras().getString("temp");
        email = getIntent().getExtras().getString("email");
        petName = getIntent().getExtras().getString("petName");
        petDescription = getIntent().getExtras().getString("petDescription");

        mList = findViewById(R.id.filteredMatches_listView);
        backBtn = findViewById(R.id.back_filteredMatches);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(filteredMatches.this, Profile.class);
                startActivity(i);
            }
        });

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String matchName = parent.getItemAtPosition(position).toString();
                Intent i = new Intent(filteredMatches.this, matchProfile.class);
                i.putExtra("matchName",matchName);
                i.putExtra("email",email);
                startActivity(i);
            }
        });


        arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayListS);
        mList.setAdapter(arrayAdapter1);

        //Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();

        reference = FirebaseDatabase.getInstance().getReference("pet");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull  DataSnapshot snapshot, @Nullable String previousChildName) {
                String petNames = snapshot.child("name").getValue().toString();
                String petDescriptions = snapshot.child("description").getValue().toString();
                String ageData = snapshot.child("age").getValue().toString();;
                String sizeData=snapshot.child("size").getValue().toString();
                String nameData =snapshot.child("name").getValue().toString();
                String spayNeuterData=snapshot.child("fixed").getValue().toString();
                String tempData = snapshot.child("temp").getValue().toString();

                ArrayList<String> x = new ArrayList<>();
                ArrayList<String> y = new ArrayList<>();
                x.add(petNames);
                y.add(petDescriptions);

                getPetMatches help = new getPetMatches(x,y,email,petDescription,petName);



                getFilteredPetMatches saveH = new getFilteredPetMatches(age,size,spayNeuterStatus,tempStatus,ageData,nameData,sizeData,spayNeuterData,tempData,help.getMatchesArrayList());

                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
                arrayAdapter1.add(saveH.getFilteredMatches());
                arrayAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull  DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }
}