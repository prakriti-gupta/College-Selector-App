package com.example.hp.selectorcollege;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class chitkara extends AppCompatActivity {
   /* private DatabaseReference mDatabase;
    private EditText etText;
    private Button btnAdd;
    private ListView listView;

    private ArrayList<String> arrayList=new ArrayList <>();
    private ArrayAdapter<String> adapter;*/



    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitkara);

        RatingBar ratingbar=(RatingBar)findViewById(R.id.rate);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(chitkara.this,String.valueOf(rating),Toast.LENGTH_LONG).show();
            }
        });

        Button b1=(Button) findViewById(R.id.subutton);
        // final TextView t1=(TextView)findViewById(R.id.text1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(chitkara.this, viewReply.class);
                startActivity(i);
            }
        });


        /*mDatabase= FirebaseDatabase.getInstance().getReference();


        adapter =new ArrayAdapter <String >(this, android.R.layout.simple_list_item_1,arrayList);

        etText=(EditText)findViewById(R.id.etDatabase);
        btnAdd =(Button)findViewById(R.id.btnAdd);
        listView=(ListView)findViewById(R.id.database_list_view);


       listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.push().setValue(etText.getText().toString());
            }
        });

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String string=dataSnapshot.getValue(String.class);
                arrayList.add(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String string=dataSnapshot.getValue(String.class);
                arrayList.add(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        RatingBar ratingbar=(RatingBar)findViewById(R.id.rate);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(chitkara.this,String.valueOf(rating),Toast.LENGTH_LONG).show();
            }
        });

       /* Button b1=(Button) findViewById(R.id.subutton);
       // final TextView t1=(TextView)findViewById(R.id.text1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(chitkara.this, viewReply.class);
                startActivity(i);
            }
        });*/



        int images[] = {R.drawable.ctk, R.drawable.ctk2, R.drawable.ctk1, R.drawable.ctk3, R.drawable.ctk4};

        v_flipper = (ViewFlipper) findViewById(R.id.v_flipper);

        for (int image : images) {
            flipperImages(image);
        }

    }

    public void flipperImages(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this,android.R.anim.slide_out_right);
    }
}