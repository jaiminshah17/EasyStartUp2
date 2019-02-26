package com.example.jaiminshah.easystartup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Jobseeker_ProfileActivity extends AppCompatActivity {

    private Button sendData;
    Button submit;
    EditText fn ;
    EditText ln;
    EditText clg;
    DatabaseReference databaseReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseeker__profile);
        fn=(EditText)findViewById(R.id.fn);
        ln=(EditText)findViewById(R.id.ln);
        clg=(EditText)findViewById(R.id.clg);
        submit=(Button)findViewById(R.id.submit);
        //FirebaseDatabase.setAndroidContext(this);

        databaseReference = FirebaseDatabase.getInstance().getReference("JobSeeker");


        //sendData = (Button) findViewById(R.id.sendData);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userprofile1();

            }
        });




    }

    private void userprofile1()
    {
        String firstname = fn.getText().toString().trim();
        String lastname =ln.getText().toString().trim();
        String college =clg.getText().toString().trim();
        if(!TextUtils.isEmpty(firstname))
        {
            String UserID = databaseReference.push().getKey();
          UserProfile userProfile = new UserProfile(UserID,firstname,lastname,college);
          databaseReference.child(UserID).setValue(userProfile);
          fn.setText("");
          ln.setText("");
          clg.setText("");

          Toast.makeText(this,"Profile save",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"You should enter first name",Toast.LENGTH_LONG).show();
        }

    }
}
