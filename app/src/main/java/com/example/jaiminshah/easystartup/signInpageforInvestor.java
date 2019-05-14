package com.example.jaiminshah.easystartup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signInpageforInvestor extends AppCompatActivity implements View.OnClickListener {

    private Button buttonregister;
    private EditText editetxtemail;
    private EditText edittextpassword;
    private Button textviewsignup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_pageforinvestor);

        buttonregister = (Button) findViewById(R.id.email_sign_in_button);
        editetxtemail = (EditText) findViewById(R.id.email);
        edittextpassword = (EditText) findViewById(R.id.password);
        textviewsignup = (Button) findViewById(R.id.email_alreadysign_in_button);
        buttonregister.setOnClickListener(this);
        textviewsignup.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }
    private void userlogin() {
        String email = editetxtemail.getText().toString().trim();
        String password = edittextpassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email address", Toast.LENGTH_LONG).show();
            //email is empty
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
            //password is empty
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    startActivity(new Intent(getApplicationContext(), invesor_bottom_navigation_activity.class));
                    //sign in user
                    Toast.makeText(signInpageforInvestor.this,"login done",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(signInpageforInvestor.this,"login error",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == buttonregister) {
            userlogin();
        }
        if (v == textviewsignup) {
            finish();
            startActivity(new Intent(this, signUpPageforInvestor.class));
        }
    }
}
