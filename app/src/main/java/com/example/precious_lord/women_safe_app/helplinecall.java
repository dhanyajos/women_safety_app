package com.example.precious_lord.women_safe_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class helplinecall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helplinecall);
    }

    public void callDistress(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:1091"));
        startActivity(intent);
    }

    public void callAbuse(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:181"));
        startActivity(intent);
    }

    public void callPolice(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:100"));
        startActivity(intent);
    }

    public void callHelpline(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:1098"));
        startActivity(intent);
    }

    public void callAmbulance(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9526914652"));
        startActivity(intent);
    }
}