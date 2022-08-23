package com.example.nysc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private long pressedTime;
    CardView logout;
    ImageButton settingGear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logout = findViewById(R.id.logout);
        settingGear = findViewById(R.id.setting);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        settingGear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                return;
//            }
//        });

//        logout.setOnClickListener(view -> {
//            changeActivity(MainActivity.class);
//        });
    }

    public void changeActivity(Class activity){
        Intent intent = new Intent(getApplicationContext(), activity);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
        super.onBackPressed();
        finish();
    } else {
        Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
    }
        pressedTime = System.currentTimeMillis();
    }


}