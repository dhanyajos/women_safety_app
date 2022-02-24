package com.example.precious_lord.women_safe_app;

import android.content.Intent;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StaffRegister extends AppCompatActivity {

    EditText staff_id;
    EditText fullname;
    EditText email;
    EditText phone;
    EditText password;
    EditText confirmPassword;

    Button regButton;
    TextView loginQuestion;

    private DatabaseHelper databaseHelper;
    private Staff staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Staff Registration");

        staff_id = findViewById(R.id.staff_id);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);

        regButton = findViewById(R.id.regButton);
        loginQuestion = findViewById(R.id.loginQuestion);

        //Initialize Objects

        databaseHelper = new DatabaseHelper(this);
        staff = new Staff();

        // Initialize and assign onClickListeners

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (staff_id.getText().toString().isEmpty() || fullname.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                        || phone.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirmPassword.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Fill in field(s)", Toast.LENGTH_SHORT).show();
                }
               else if (!password.getText().toString().equals(confirmPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(), "password do not match", Toast.LENGTH_LONG).show();
                }
                else if( phone.getText().length()>10||phone.getText().length()<10){
                    Toast.makeText(getApplicationContext(), "Invalid phone number", Toast.LENGTH_LONG).show();
                }

                else if(password.getText().equals("")||password.getText().length()<8)
                {
                    Toast.makeText(getApplicationContext(), "password must contain atleast 8 letter", Toast.LENGTH_LONG).show();
                }
                else if (!password.getText().toString().equals(confirmPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(), "password do not match", Toast.LENGTH_LONG).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    Toast.makeText(getApplicationContext(),"invalid email address",Toast.LENGTH_SHORT).show();
                } else{
                    postDataToSQLite();
                }
            }
        });

        loginQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    public void postDataToSQLite(){
        if (!databaseHelper.checkStaff(staff_id.getText().toString(), password.getText().toString())){

            staff.setStaff_id(staff_id.getText().toString());
            staff.setFullname(fullname.getText().toString());
            staff.setEmail(email.getText().toString());
            staff.setPhone(phone.getText().toString());
            staff.setPassword(password.getText().toString());

            databaseHelper.addStaff(staff);

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();

            Intent regUser = new Intent(this, AdminLogin.class);
            startActivity(regUser);

            emptyEditText();
        }else {
            Toast.makeText(this, "Staff exists already", Toast.LENGTH_LONG).show();
            emptyEditText();
        }
    }

    public void emptyEditText(){
        staff_id.setText(null);
        fullname.setText(null);
        email.setText(null);
        phone.setText(null);
        password.setText(null);
        confirmPassword.setText(null);
    }

}
