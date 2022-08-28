package com.example.nysc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {

    ToggleButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button = findViewById(R.id.offThumb);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
    }
}