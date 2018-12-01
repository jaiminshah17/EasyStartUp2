package com.example.jaiminshah.easystartup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Jobseeker_ProfileActivity extends AppCompatActivity {

    private Button sendData;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseeker__profile);
        //FirebaseDatabase.setAndroidContext(this);

        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("https://easy-project-2.firebaseio.com/");
        sendData = (Button) findViewById(R.id.sendData);


        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference myRefchild = myRef.child("Name");
                myRefchild.setValue("bairen");
            }
        });

    }
}
