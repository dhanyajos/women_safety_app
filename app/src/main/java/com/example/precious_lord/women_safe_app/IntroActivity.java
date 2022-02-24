package com.example.precious_lord.women_safe_app;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setTitle(R.string.title_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
