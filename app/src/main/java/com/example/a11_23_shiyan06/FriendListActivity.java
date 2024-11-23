package com.example.a11_23_shiyan06;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FriendListActivity extends AppCompatActivity {

    private RecyclerView listView;
    private FriendAdapter friendAdapter;
    private List<Friend> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        listView = findViewById(R.id.listView); // 绑定到 XML 中的 RecyclerView

        // 初始化好友列表
        friendList = new ArrayList<>();
        loadFriends();

        // 设置适配器
        friendAdapter = new FriendAdapter(this, friendList);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(friendAdapter);
    }

    private void loadFriends() {
        // 模拟加载好友数据
        friendList.add(new Friend("Alice", R.drawable.img));
        friendList.add(new Friend("Bob", R.drawable.img_1));
        friendList.add(new Friend("Charlie", R.drawable.img_2));
        friendList.add(new Friend("Diana", R.drawable.img_3));
    }
}
