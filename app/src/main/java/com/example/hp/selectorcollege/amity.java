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

public class amity extends AppCompatActivity {

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amity);

        RatingBar ratingbar=(RatingBar)findViewById(R.id.rate);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(amity.this,String.valueOf(rating),Toast.LENGTH_LONG).show();
            }
        });

        Button b1=(Button) findViewById(R.id.subutton);
       // final TextView t1=(TextView)findViewById(R.id.text1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(amity.this, viewReply.class);
                startActivity(i);
            }
        });



        int images[] = {R.drawable.am, R.drawable.am1, R.drawable.am2, R.drawable.am3, R.drawable.am4};

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
