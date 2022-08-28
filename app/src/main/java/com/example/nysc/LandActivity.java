package com.example.nysc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LandActivity extends AppCompatActivity{

    ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setting = findViewById(R.id.setting);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        setting.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        });
    }
}