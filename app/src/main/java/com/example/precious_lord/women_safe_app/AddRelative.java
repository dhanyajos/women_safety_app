package com.example.precious_lord.women_safe_app;
/*
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class AddRelative extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    DatabaseHelperAdd myDB;
    Button btnAdd,btnView;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_relative);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelperAdd(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                String newEntry1 = editText2.getText().toString();
                if(editText.length()!= 0){
                    AddData(newEntry);
                    AddData(newEntry1);
                    editText.setText("");
                }else{
                    Toast.makeText(AddRelative.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRelative.this, ViewListContents.class);
                startActivity(intent);
            }
        });


    }

    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        int action, keycode;

        action = event.getAction();
        keycode = event.getKeyCode();

        switch (keycode)
        {
            case KeyEvent.KEYCODE_VOLUME_UP:
            {
                if(KeyEvent.ACTION_UP == action){
//                    count++;
                    //String S1 = String.valueOf(count);
                    //Log.d("upButton", S1);
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"));
                    if (ActivityCompat.checkSelfPermission(AddRelative.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(AddRelative.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                    } else {
                        callIntent.setData(Uri.parse("tel:"));
                        startActivity(callIntent);
                    }
                    startActivity(callIntent);
                }
            }
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if(KeyEvent.ACTION_DOWN == action){
                    //count = 0;
                    //String S2 = String.valueOf(count);
                    //Log.d("downButton", S2);
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"));
                    if (ActivityCompat.checkSelfPermission(AddRelative.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(AddRelative.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                    } else {
                        callIntent.setData(Uri.parse("tel:"));
                        startActivity(callIntent);
                    }
                    startActivity(callIntent);
                }
        }
        return super.dispatchKeyEvent(event);
    }
}
*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;

import com.google.android.material.textfield.TextInputEditText;


public class AddRelative extends AppCompatActivity {

    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_relative);

        number = findViewById(R.id.numberEdit);
    }

    public void saveNumber(View view) {
        String numberString = number.getText().toString();
        if(numberString.length()==10){
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("ENUM", numberString);
            myEdit.apply();
            AddRelative.this.finish();
        }else {
            Toast.makeText(this, "Enter Valid Number!", Toast.LENGTH_SHORT).show();
        }
    }




}

