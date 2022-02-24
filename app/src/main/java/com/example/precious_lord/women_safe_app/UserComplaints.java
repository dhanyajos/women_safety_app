package com.example.precious_lord.women_safe_app;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserComplaints extends AppCompatActivity {

    TextView dbEmail;
    TextView dbLocation;
    TextView dbCategory;
    TextView dbSubject;
    TextView dbMessage;

//    Button replyComplaint;
//    Button deleteComplaint;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_complaints);
        setTitle("Complaints");

        dbEmail = findViewById(R.id.dbemail);
        dbLocation = findViewById(R.id.dblocation);
        dbCategory = findViewById(R.id.dbcategory);
        dbSubject = findViewById(R.id.dbsubject);
        dbMessage = findViewById(R.id.dbmessage);

//        replyComplaint = findViewById(R.id.replyComplaint);
//        deleteComplaint = findViewById(R.id.deleteComplaint);

        databaseHelper = new DatabaseHelper(this);

//        deleteComplaint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteComp();
//            }
//        });

    }

    public void deleteComp(){
        if (databaseHelper.deleteComplaint() == 1){
            Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Unsuccessful", Toast.LENGTH_SHORT).show();
        }

    }
}
