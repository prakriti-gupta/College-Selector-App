package com.example.hp.selectorcollege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class lovely extends AppCompatActivity {
    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovely);

          RatingBar ratingbar=(RatingBar)findViewById(R.id.rate);
          ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
              @Override
              public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                  Toast.makeText(lovely.this,String.valueOf(rating),Toast.LENGTH_LONG).show();
              }
          });

        Button b1=(Button) findViewById(R.id.button);
        //final TextView t1=(TextView)findViewById(R.id.text1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(lovely.this, viewReply.class);
                startActivity(i);
            }
        });


        int images[] = {R.drawable.lpu, R.drawable.lpu1, R.drawable.lpu2, R.drawable.lpu3, R.drawable.lpu4};

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