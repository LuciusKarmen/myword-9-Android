package com.example.myapplication.admin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_admin);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Intent intent = new Intent(OurActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_student) {
                Intent intent = new Intent(OurActivity.this, StudentActivity.class);
                startActivity(intent);
                return true;
            }
            else if (id == R.id.nav_teacher) {
                Intent intent = new Intent(OurActivity.this, TeacherActivity.class);
                startActivity(intent);
                return true;
            }
            else if (id == R.id.nav_our) {
                return true;
            }
            return false;
        });
    }

}
