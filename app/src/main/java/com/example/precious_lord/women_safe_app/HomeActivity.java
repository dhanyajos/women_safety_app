package com.example.precious_lord.women_safe_app;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {


    TextView complaintHstry;
    TextView makeComplnt;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        complaintHstry = findViewById(R.id.complaintHstry);
        makeComplnt = findViewById(R.id.makeComplnt);


        complaintHstry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent introIntent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(introIntent);
            }
        });

        makeComplnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent introIntent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(introIntent);
            }
        });
    }
}
