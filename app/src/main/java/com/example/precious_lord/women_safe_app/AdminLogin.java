package com.example.precious_lord.women_safe_app;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {

    EditText adminID;
    EditText adminPass;

    Button adminLgnButton;
    TextView staff_reg_question;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        setTitle(R.string.title_adminloginpage);

        adminID = findViewById(R.id.adminID);
        adminPass = findViewById(R.id.adminPass);

        adminLgnButton = findViewById(R.id.adminLgnButton);
        staff_reg_question = findViewById(R.id.staff_reg_question);

        databaseHelper = new DatabaseHelper(this);

        adminLgnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyFromSQLite();
            }
        });

        staff_reg_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent staffRegIntent = new Intent(getApplicationContext(), StaffRegister.class);
                startActivity(staffRegIntent);

            }
        });
    }

    public void emptyFields(){
        adminID.setText(null);
        adminPass.setText(null);
    }

    private void verifyFromSQLite(){
        if (adminID.getText().toString().isEmpty() || adminPass.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Fill in field(s)", Toast.LENGTH_SHORT).show();
        }
       else if (databaseHelper.checkStaff(adminID.getText().toString(), adminPass.getText().toString())){
            Intent verifiedIntent =new Intent(AdminLogin.this, AdminComplaintHistory.class);
            Toast.makeText(this, "Accepted", Toast.LENGTH_SHORT).show();
            emptyFields();
            startActivity(verifiedIntent);


        }else{
            Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_LONG).show();
            emptyFields();
        }
    }

}
