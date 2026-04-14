package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Intent intent = new Intent(OurActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_choose) {
                Intent intent = new Intent(OurActivity.this, ChooseActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_our) {
                // 处理 Our 点击
                return true;
            }
            return false;
        });
    }

}
