package com.example.precious_lord.women_safe_app;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class LoginSuccess extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);


    }




    //    public void myProfile(View v){
//        Intent i = new Intent(getApplicationContext(), MyProfile.class);
//        startActivity(i);
//    }

    public void addRelative(View v) {
        Intent i = new Intent(getApplicationContext(), AddRelative.class);
        startActivity(i);
    }

    public void helplineNumbers(View v) {
        Intent i = new Intent(getApplicationContext(), helplinecall.class);
        startActivity(i);
    }

    public void triggers(View v) {
        Intent i = new Intent(getApplicationContext(), TrigActivity.class);
        startActivity(i);
    }

    public void developedBy(View v) {
        Intent intent = new Intent(getApplicationContext(), Location.class);
        startActivity(intent);
    }

    public void HowTo(View v) {
        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(i);
    }

    public void LogOut(View v) {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }
}