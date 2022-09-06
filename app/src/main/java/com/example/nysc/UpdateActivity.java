package com.example.nysc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    EditText name, userEmail, phone, nysc, course, school, lga, state, address,  password;
    AppCompatButton submit;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        course = findViewById(R.id.course);
        school = findViewById(R.id.school);
        lga = findViewById(R.id.lga);
        state = findViewById(R.id.state);
        address = findViewById(R.id.address);

        name.setText(SharedPrefManager.getInstance(this).getUserDetails());




    }
}