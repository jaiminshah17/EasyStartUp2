package com.example.jaiminshah.easystartup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private Button button;
     private Button button1;
     private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.x);
        button1=(Button)findViewById(R.id.y);
        button2=(Button)findViewById(R.id.z);

    }

    @Override
    public void onClick(View v) {
        if (v==button)
        {
            startActivity(new Intent(this,signinactivityforenterprise.class));
        }
        if (v==button1)
        {
            startActivity(new Intent(this,SigninActivityforJobSeeker.class));
        }

         if (v==button2)
         {
             startActivity(new Intent(this,signInpageforInvestor.class));
         }


    }
}
