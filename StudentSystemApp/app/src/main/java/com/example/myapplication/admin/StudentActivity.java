
package com.example.myapplication.admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class StudentActivity extends AppCompatActivity {

    private static final String TAG = "ChooseActivity";
    private TextView tvResponse;
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_admin);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Intent intent = new Intent(StudentActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_student) {
                Intent intent = new Intent(StudentActivity.this, StudentActivity.class);
                startActivity(intent);
                return true;
            }
            else if (id == R.id.nav_teacher) {
                Intent intent = new Intent(StudentActivity.this, TeacherActivity.class);
                startActivity(intent);
                return true;
            }
            else if (id == R.id.nav_our) {
                Intent intent = new Intent(StudentActivity.this, OurActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });

        tvResponse = findViewById(R.id.tv_response);
        loadStudentData();
    }
    private void loadStudentData() {
        String url = "http://118.195.143.104:8886/student/querystudentAll";
        Log.d(TAG, "正在请求: " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "请求失败", e);
                runOnUiThread(() ->
                        tvResponse.setText("❌ 请求失败:\n" + e.getMessage())
                );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                        String responseData = response.body().string();
                        Log.d(TAG, "响应成功: " + responseData);
                        runOnUiThread(() -> tvResponse.setText(responseData));
                    } else {
                        Log.w(TAG, "HTTP 错误: " + response.code());
                        runOnUiThread(() ->
                                tvResponse.setText("❌ HTTP 错误: " + response.code())
                        );
                    }
                } finally {
                    response.close();
                }
            }
        });
    }
}