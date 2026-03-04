package com.example.myapplication00
import androidx.compose.ui.tooling.preview.Preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 直接使用 MaterialTheme，不包裹自定义主题
            MaterialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    DailyInspiration(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DailyInspiration(modifier: Modifier = Modifier) {
    val quotes = listOf(
        "你不需要很厉害才能开始，但你需要开始才能很厉害。",
        "生活不是等待风暴过去，而是学会在雨中跳舞。",
        "今天的努力，是明天的底气。",
        "慢一点没关系，只要你在往前走。",
        "世界很大，但属于你的光，正在路上。",
        "允许自己偶尔脆弱，但别忘了你比想象中坚强。",
        "种一棵树最好的时间是十年前，其次是现在。",
        "你值得被爱，也值得拥有平静与喜悦。"
    )

    val currentQuote = remember { quotes.random() }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currentQuote,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.9f),
            lineHeight = 28.sp,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(0.9f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DailyInspirationPreview() {
    // 预览时也直接用 MaterialTheme
    MaterialTheme {
        DailyInspiration()
    }
}