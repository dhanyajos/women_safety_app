package com.example.precious_lord.women_safe_app;

import android.content.Intent;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button lgnButton;
    TextView registerQuestion;
    TextView adminLoginQuestion;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.title_loginpage);

        //Initialize views

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        lgnButton = findViewById(R.id.lgnButton);

        registerQuestion = findViewById(R.id.registerQuestion);

        adminLoginQuestion = findViewById(R.id.adminLoginQuestion);
        // Initialize Object

        databaseHelper = new DatabaseHelper(this);


        // Verify if all the fields are filled up first
        email.addTextChangedListener(loginTextWatcher);
        password.addTextChangedListener(loginTextWatcher);


        // Initialize onClickListeners

        lgnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyFromSQLite();
            }
        });

        registerQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(regIntent);
            }
        });

        adminLoginQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(getApplicationContext(), AdminLogin.class);
                startActivity(regIntent);
            }
        });
    }

    private void verifyFromSQLite(){

         if (databaseHelper.checkUser(email.getText().toString(), password.getText().toString())){
            Intent verifiedIntent = new Intent(getApplicationContext(), LoginSuccess.class);
            Toast.makeText(this, "Accepted", Toast.LENGTH_SHORT).show();

            startActivity(verifiedIntent);
        }
        else{
            Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_LONG).show();

        }
    }



    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String useremail = email.getText().toString().trim();
            String userpassword = password.getText().toString().trim();

            lgnButton.setEnabled(!useremail.isEmpty() && !userpassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}