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

public class activity_company_profile extends AppCompatActivity {

    EditText Cn, Rp, Cd;
    Button save;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);

        Cn=(EditText)findViewById(R.id.Cn);
        Rp=(EditText)findViewById(R.id.Rp);
        Cd=(EditText)findViewById(R.id.Cd);
        save=(Button)findViewById(R.id.save);

        databaseReference = FirebaseDatabase.getInstance().getReference("Enterprise");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companyprofile1();

            }
        });
    }


    private void companyprofile1(){
        String Companyname = Cn.getText().toString().trim();
        String RecuritPosition =Rp.getText().toString().trim();
        String CompanyDescription = Cd.getText().toString().trim();

        if(!TextUtils.isEmpty(Companyname))
        {
            String UserID = databaseReference.push().getKey();
            CompanyProfile companyProfile = new CompanyProfile(UserID,Companyname,RecuritPosition,CompanyDescription);
            databaseReference.child(UserID).setValue(companyProfile);
//          adapter.notifyDataSetChanged();
            Cn.setText("");
            Rp.setText("");
            Cd.setText("");

            Toast.makeText(this,"CProfile save",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"You should enter your company name",Toast.LENGTH_LONG).show();
        }
    }


}
