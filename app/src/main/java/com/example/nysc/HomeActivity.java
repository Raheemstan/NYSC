package com.example.nysc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private long pressedTime;
    LinearLayout logout;
    ImageButton settingGear;
    ImageView imageView;

    public ImageButton getSettingGear() {
        ImageButton settingGear = this.settingGear;
        return settingGear;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logout = findViewById(R.id.logout);
        settingGear = findViewById(R.id.setting);
        imageView = findViewById(R.id.imgLogout);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }


//        settingGear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                return;
//            }
//        });

//        logout.setOnClickListener(this);
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
//        if (view == logout){
//            changeActivity(MainActivity.class);
//        }
    }
}