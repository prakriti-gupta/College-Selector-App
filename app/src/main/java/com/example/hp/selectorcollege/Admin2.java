package com.example.hp.selectorcollege;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class Admin2 extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private Button b, bttnn;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        mListView = findViewById(R.id.listview);
        firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Data Register");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList <String> array = new ArrayList <>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Listlink2 user1 = new Listlink2();
                    user1.setFName(ds.getValue(Listlink.class).getFName());
                    user1.setEMail(ds.getValue(Listlink.class).getEMail());
                    // user1.setDescription(ds.getValue(listlink.class).getDescription());
                    array.add("Name: " + user1.getFName() + "\n" + "\n" + "Email: " + user1.getEMail() + "\n" + "\n");
                }
                ArrayAdapter <String> adapter = new ArrayAdapter(Admin2.this, android.R.layout.simple_list_item_1, array);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error In processing", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
