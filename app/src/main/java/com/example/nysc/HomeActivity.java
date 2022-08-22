package com.example.nysc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    CardView logout;
    ImageButton settingGear;

    void changeActivity(Class activity){
        Intent intent = new Intent(getApplicationContext(), activity);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logout = findViewById(R.id.logout);
        settingGear = findViewById(R.id.setting);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        settingGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this,"There is no back action",Toast.LENGTH_SHORT).show();
            }
        });

//        logout.setOnClickListener(view -> {
//            changeActivity(MainActivity.class);
//        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(HomeActivity.this,"There is no back action",Toast.LENGTH_SHORT).show();
    }

}