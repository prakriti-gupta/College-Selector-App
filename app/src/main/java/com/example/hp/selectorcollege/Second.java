package com.example.hp.selectorcollege;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    TextView t1,t2,t3;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = findViewById(R.id.t6);
        t2 = findViewById(R.id.t8);
        t3 = findViewById(R.id.t7);
        b  = findViewById(R.id.bn);
        Intent i = getIntent();

        String questions = i.getStringExtra("total");
        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your Marks have been submitted",Toast.LENGTH_LONG).show();
                Intent i = new Intent(Second.this,User1.class);
                startActivity(i);
            }
        });


    }
}
