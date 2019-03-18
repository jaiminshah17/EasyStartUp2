package com.example.jaiminshah.easystartup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Jobseeker_ProfileActivity extends AppCompatActivity {

    private Button sendData;

    EditText fn, ln ;
    EditText email, phone, address;
    EditText clg, major;
    EditText job, company, description;
    Button save;
    DatabaseReference databaseReference ;
//    FirebaseRecyclerAdapter<UserProfile, ProfileRecyclerViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseeker__profile);
        fn=(EditText)findViewById(R.id.fn);
        ln=(EditText)findViewById(R.id.ln);
        email=(EditText) findViewById(R.id.email);
        phone=(EditText) findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address) ;
        clg=(EditText)findViewById(R.id.clg);
        major=(EditText)findViewById(R.id.major);
        job=(EditText)findViewById(R.id.job);
        company=(EditText)findViewById(R.id.company);
        description=(EditText)findViewById(R.id.description);
        save=(Button)findViewById(R.id.save);


        databaseReference = FirebaseDatabase.getInstance().getReference("JobSeeker");
        save.setOnClickListener(new View.OnClickListener() {
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
        String Email = email.getText().toString().trim();
        String Phone = phone.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String college =clg.getText().toString().trim();
        String Major = major.getText().toString().trim();
        String Job = job.getText().toString().trim();
        String Company = company.getText().toString().trim();
        String Description = description.getText().toString().trim();

        if(!TextUtils.isEmpty(firstname))
        {
            String UserID = databaseReference.push().getKey();
          UserProfile userProfile = new UserProfile(UserID,firstname,lastname,Email,Phone, Address, college, Major, Job, Company, Description);
          databaseReference.child(UserID).setValue(userProfile);
//          adapter.notifyDataSetChanged();
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
