package com.example.team19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        Intent i = new Intent(getApplicationContext(), Location.class);
        startActivity(i);
    }

    public void HowTo(View v) {
        Intent i = new Intent(getApplicationContext(), DashBoardActivity.class);
        startActivity(i);
    }

    public void LogOut(View v) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}