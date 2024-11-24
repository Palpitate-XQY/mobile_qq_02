package com.example.a11_23_shiyan06;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    Context context;
    private List<Friend> friendList;

    public FriendAdapter(Context context, List<Friend> friendList) {
        this.context = context;
        this.friendList = friendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friend_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Log.d("Debug", "llMenu: " + holder.llMenu);
//        Log.d("Debug", "btnLogout: " + holder.btnLogout);
//        Log.d("Debug", "btnProfile: " + holder.btnProfile);

        Friend friend = friendList.get(position);
        holder.nameTextView.setText(friend.getName());
        holder.avatarImageView.setImageResource(friend.getAvatarResId());

//         设置点击监听器，点击任何地方进入聊天界面
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra("friendName", friend.getName());  // 传递好友名称
            intent.putExtra("avatarResId", friend.getAvatarResId());  // 传递头像资源ID
            context.startActivity(intent);
        });
//        holder.itemView.setOnTouchListener(new OnSwipeTouchListener(context) {
//
//            public void onSwipeRight() {
//                holder.llMenu.setVisibility(View.VISIBLE); // 显示菜单
//            }
//
//
//            public void onSwipeLeft() {
//                holder.llMenu.setVisibility(View.GONE); // 隐藏菜单
//            }
//        });
//        // 绑定菜单按钮的事件
//        holder.btnLogout.setOnClickListener(v -> {
//            // 执行退出登录逻辑
//        });
//
//        holder.btnProfile.setOnClickListener(v -> {
//            // 执行个人信息页面跳转
//        });
    }

    public void showMenu(ViewHolder holder) {
        // 向右滑动，显示菜单

    }

    public void restoreItem(ViewHolder holder) {
        // 向左滑动，恢复项

    }


    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        LinearLayout llMenu;
        ImageView avatarImageView;
        Button btnLogout, btnProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.friend_name);
            llMenu = itemView.findViewById(R.id.menuLayout); // 获取菜单布局
            avatarImageView = itemView.findViewById(R.id.friend_avatar);
            btnLogout = itemView.findViewById(R.id.btnLogout);
//            btnProfile = itemView.findViewById(R.id.btnProfile);
        }
    }
}
