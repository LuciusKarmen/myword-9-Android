// HomeActivity.java
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    private static final List<String> QUOTES = Arrays.asList(
            "你不需要很厉害才能开始，但你需要开始才能很厉害。",
            "生活不是等待风暴过去，而是学会在雨中跳舞。",
            "今天的努力，是明天的底气。",
            "慢一点没关系，只要你在往前走。",
            "世界很大，但属于你的光，正在路上。",
            "允许自己偶尔脆弱，但别忘了你比想象中坚强。",
            "种一棵树最好的时间是十年前，其次是现在。",
            "你值得被爱，也值得拥有平静与喜悦。"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 随机选择一句语录并显示
        TextView quoteTextView = findViewById(R.id.quote_text_view);
        String randomQuote = QUOTES.get(new Random().nextInt(QUOTES.size()));
        quoteTextView.setText(randomQuote);

        // 底部导航
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_choose) {
                startActivity(new Intent(HomeActivity.this, ChooseActivity.class));
                return true;
            } else if (id == R.id.nav_our) {
                startActivity(new Intent(HomeActivity.this, OurActivity.class));
                return true;
            }
            return false;
        });
    }
}