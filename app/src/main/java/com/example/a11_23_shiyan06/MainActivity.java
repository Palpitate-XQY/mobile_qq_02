package com.example.a11_23_shiyan06;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 获取 SharedPreferences 中保存的登录状态
        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            // 如果已登录，直接跳转到好友列表页面
            Intent intent = new Intent(MainActivity.this, FriendListActivity.class);
            startActivity(intent);
            finish();  // 结束 MainActivity，避免用户点击返回键返回到登录页面
        } else {
            // 如果没有登录，跳转到登录页面
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();  // 结束 MainActivity
        }
    }
}
