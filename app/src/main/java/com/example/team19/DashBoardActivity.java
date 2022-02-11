package com.example.team19;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class DashBoardActivity extends AppCompatActivity {


    Button cdmakecomplaint;
    Button cdcomplainthistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);



        cdmakecomplaint = (Button) findViewById(R.id.cdmakecomplaint);
        cdcomplainthistory = (Button) findViewById(R.id.cdcomplainthistory);





        cdmakecomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent introIntent = new Intent(DashBoardActivity.this, ComplaintActivity.class);
                startActivity(introIntent);
            }
        });

        cdcomplainthistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Requires administrative priviledges..Sorry", Snackbar.LENGTH_LONG).show();
               Intent introIntent = new Intent(DashBoardActivity.this, ComplaintHistory.class);
               startActivity(introIntent);
            }
        });
    }
}
