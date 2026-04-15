package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_role);
        View.OnClickListener goToLoginListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoleActivity.this, LoginActivity.class));
            }
        };


        findViewById(R.id.btn_student).setOnClickListener(goToLoginListener);
        findViewById(R.id.btn_teacher).setOnClickListener(goToLoginListener);
        findViewById(R.id.btn_admin).setOnClickListener(goToLoginListener);



    }


}