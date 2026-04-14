import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
package com.example.myapplication;

import android.os.Bundle;
// ... existing code ...


public class ChooseActivity extends AppCompatActivity {

    private TextView tvResponse;
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data); // 替换为你的布局文件名

        tvResponse = findViewById(R.id.tv_response);

        loadStudentData();
    }

    private void loadStudentData() {
        String url = "http://118.195.143.104:8885/student/querystudentAll";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> tvResponse.setText("❌ 请求失败:\n" + e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    runOnUiThread(() -> tvResponse.setText(responseData));
                } else {
                    runOnUiThread(() -> tvResponse.setText("❌ HTTP 错误: " + response.code()));
                }
            }
        });
    }
}