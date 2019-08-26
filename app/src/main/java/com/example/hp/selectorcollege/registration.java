package com.example.hp.selectorcollege;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registration extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter <CharSequence> adapter;
    Button bt;


    private FirebaseAuth firebaseAuth;
    private EditText fname, lname, phno, adr, tenmrks, eml, psw, condept,twlmrks,strm;
    //private Spinner dept;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_registration);
       fname = (EditText) findViewById(R.id.fn);
       lname = (EditText) findViewById(R.id.ln);
       phno = (EditText) findViewById(R.id.cno);
       // dept=(Spinner) findViewById(R.id.drp);
       eml = (EditText) findViewById(R.id.eml);
       adr = (EditText) findViewById(R.id.adr);
       tenmrks = (EditText) findViewById(R.id.tmk);
      // strm = (EditText) findViewById(R.id.cfs);
       twlmrks = (EditText) findViewById(R.id.tlmk);
       psw=(EditText)findViewById(R.id.tlmk);
       condept = (EditText) findViewById(R.id.cdept);
       bt = findViewById(R.id.btn);


       firebaseAuth = FirebaseAuth.getInstance();


       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (checkFun()) {
                   /*String e_mail = eml.getText().toString().trim();
                   String pswd = psw.getText().toString().trim();

                   firebaseAuth.createUserWithEmailAndPassword(e_mail, pswd).addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task <AuthResult> task) {
                           if (task.isSuccessful()) {
                               Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                               Intent change = new Intent(registration.this, marks.class);
                               startActivity(change);
                           } else {
                               Toast.makeText(getApplicationContext(), "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });*/
                   String first_name = fname.getText().toString().trim();
                   String last_name = lname.getText().toString().trim();
                   String phone_no = phno.getText().toString().trim();
                   String email = eml.getText().toString().trim();
                   //String Strm=strm.getText().toString().trim();
                   String tenmarks = tenmrks.getText().toString().trim();
                   String address = adr.getText().toString().trim();
                   String twelvemrks=twlmrks.getText().toString().trim();
                   String confirmdept = condept.getText().toString().trim();
                   String tmks = psw.getText().toString().trim();

                   DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Data Register");

                   ref.child(first_name).child("FName").setValue(first_name);
                   ref.child(first_name).child("Last Name").setValue(last_name);
                   ref.child(first_name).child("Phone No").setValue(phone_no);
                   ref.child(first_name).child("10th Marks").setValue(tenmarks);
                   ref.child(first_name).child("12th Marks").setValue(twelvemrks);
                   ref.child(first_name).child("Address").setValue(address);
                   ref.child(first_name).child("EMail").setValue(email);
                   //ref.child(first_name).child("Stream").setValue(Strm);
                   ref.child(first_name).child("Confirm Department").setValue(confirmdept);
                   Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                   Intent change = new Intent(registration.this, marks.class);
                   startActivity(change);
               } else {
                   Toast.makeText(getApplicationContext(), "Fill Correctly!!", Toast.LENGTH_SHORT).show();
               }
           }
       });


       spinner = findViewById(R.id.drp);
       adapter = ArrayAdapter.createFromResource(this, R.array.Department, android.R.layout.simple_spinner_item);

       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       spinner.setAdapter(adapter);


       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {

               Toast.makeText(getApplicationContext(), "Selected", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView <?> parent) {

           }
       });
   }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean checkFun() {
        String first_name = fname.getText().toString().trim();
        String last_name = lname.getText().toString().trim();
        String phone_no = phno.getText().toString().trim();
        String email = eml.getText().toString().trim();
        //String Strm=strm.getText().toString().trim();
        String tenmarks = tenmrks.getText().toString().trim();
        String twelvemrks=twlmrks.getText().toString().trim();
        String address = adr.getText().toString().trim();
        String confirmdept = condept.getText().toString().trim();
        String tmks = psw.getText().toString().trim();
       boolean result=false;
        if(first_name.isEmpty() || last_name.isEmpty() || phone_no.isEmpty() || email.isEmpty() || address.isEmpty() || tenmarks.isEmpty()||confirmdept.isEmpty() || twelvemrks.isEmpty()){
            result=false;
        }
        else{

            String vemail = "[a-zA-Z0-9\\+\\.\\_\\@\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+";

            Matcher m = Pattern.compile(vemail).matcher(email);

            if(m.matches())
            {
                return true;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Enter correct email", Toast.LENGTH_SHORT).show();
            }
        }
        return result;
    }




    }

