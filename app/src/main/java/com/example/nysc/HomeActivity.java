package com.example.nysc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private long pressedTime;
    TextView logouttxt, txtDeploy, txtEdit;
    ImageButton settingGear;
    LinearLayout deploy, logout, edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        settingGear = findViewById(R.id.setting);
        logout = findViewById(R.id.logout);
        deploy = findViewById(R.id.deploy);
        edit = findViewById(R.id.edit);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }


        logout.setOnClickListener(this);
        deploy.setOnClickListener(this);
        edit.setOnClickListener(this);
        settingGear.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    } else {
        Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
    }
        pressedTime = System.currentTimeMillis();
    }


    @Override
    public void onClick(View view) {
        if (view == logout){
            startActivity(new Intent(this, MainActivity.class));
        }if (view == settingGear){
            startActivity(new Intent(this, SettingsActivity.class));
        }if (view == edit){
            startActivity(new Intent(this, UpdateActivity.class));
        }if (view == deploy){
            startActivity(new Intent(this, DashboardActivity.class));
        }
    }
}