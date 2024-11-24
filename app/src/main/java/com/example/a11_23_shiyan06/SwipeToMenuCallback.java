package com.example.a11_23_shiyan06;

import android.graphics.Canvas;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeToMenuCallback extends ItemTouchHelper.Callback {

    private final FriendAdapter adapter;

    public SwipeToMenuCallback(FriendAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 允许向左和向右滑动
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(0, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false; // 这里只处理滑动，不需要移动项目
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // 获取 ViewHolder
        FriendAdapter.ViewHolder friendViewHolder = (FriendAdapter.ViewHolder) viewHolder;

        // 处理滑动
        if (direction == ItemTouchHelper.RIGHT) {
            // 向右滑动，显示菜单
            adapter.showMenu(friendViewHolder);
        } else if (direction == ItemTouchHelper.LEFT) {
            // 向左滑动，恢复项
            adapter.restoreItem(friendViewHolder);
        }
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        // 可以添加自定义的动画效果
    }
}
