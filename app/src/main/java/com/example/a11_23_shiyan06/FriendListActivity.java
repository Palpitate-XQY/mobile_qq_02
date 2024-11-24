package com.example.a11_23_shiyan06;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FriendListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFriendList;
    ;
    private FriendAdapter friendAdapter;
    private List<Friend> friendList;

    private DrawerLayout drawerLayout;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        // 获取 DrawerLayout
        drawerLayout = findViewById(R.id.drawerLayout);

        // 设置退出登录按钮事件
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            // 执行退出登录逻辑
            // 示例：返回登录页面
            Intent intent = new Intent(FriendListActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        // 设置菜单按钮点击事件
        ImageButton btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);  // 打开左侧菜单
        });


        // 设置二维码按钮事件
        Button btnQRCode = findViewById(R.id.btnQRCode);
        btnQRCode.setOnClickListener(v -> {
            // 示例：跳转到二维码页面
            Intent intent = new Intent(FriendListActivity.this, QRCodeActivity.class);
            startActivity(intent);
        });

        // 初始化手势检测器
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                // 如果是从左往右滑动
                if (e2.getX() - e1.getX() > 200) {  // 检测滑动距离是否足够
                    drawerLayout.openDrawer(GravityCompat.START);  // 打开右侧菜单
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.mainv).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);  // 传递触摸事件给 GestureDetector
            }
        });


        recyclerViewFriendList = findViewById(R.id.recyclerView);
        recyclerViewFriendList.setLayoutManager(new LinearLayoutManager(this));

        // 初始化好友列表
        friendList = new ArrayList<>();
        loadFriends();

        // 设置适配器
        friendAdapter = new FriendAdapter(this, friendList);
//        recyclerViewFriendList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFriendList.setAdapter(friendAdapter);

//         设置滑动手势
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToMenuCallback(friendAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerViewFriendList);
    }

    @Override
    public void onBackPressed() {
        // 如果菜单打开，先关闭菜单；否则正常返回
        if (drawerLayout.isDrawerOpen(findViewById(R.id.menuLayout))) {
            drawerLayout.closeDrawer(findViewById(R.id.menuLayout));
        } else {
            super.onBackPressed();
        }
    }

    private void loadFriends() {
        // 模拟加载好友数据
        friendList.add(new Friend("Alice", R.drawable.img));
        friendList.add(new Friend("Bob", R.drawable.img_1));
        friendList.add(new Friend("Charlie", R.drawable.img_2));
        friendList.add(new Friend("Diana", R.drawable.img_3));
    }


}
