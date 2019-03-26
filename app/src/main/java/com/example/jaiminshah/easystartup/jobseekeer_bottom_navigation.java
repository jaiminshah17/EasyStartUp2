package com.example.jaiminshah.easystartup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class jobseekeer_bottom_navigation extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(getApplicationContext(),activity_company_listpage.class));
                   // mTextMessage.setText(R.string.title_home);
                    //return true;
                    break;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(getApplicationContext(),Jobseeker_ListActivity.class));
                    //mTextMessage.setText(R.string.title_dashboard);
                    //return true;
                    break;
                case R.id.navigation_notifications:
                    startActivity(new Intent(getApplicationContext(),Jobseeker_ProfileActivity.class));
                    break;
                    //mTextMessage.setText(R.string.title_notifications);
                    //return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseekeer_bottom_navigation);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
