package com.example.myapplication.admin;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_admin);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Intent intent = new Intent(TeacherActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_student) {
                Intent intent = new Intent(TeacherActivity.this, StudentActivity.class);
                startActivity(intent);
                return true;
            }
            else if (id == R.id.nav_teacher) {
                Intent intent = new Intent(TeacherActivity.this, TeacherActivity.class);
                startActivity(intent);
                return true;
            }
            else if (id == R.id.nav_our) {
                Intent intent = new Intent(TeacherActivity.this, OurActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }

}
