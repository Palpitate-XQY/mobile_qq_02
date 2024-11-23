package com.example.a11_23_shiyan06;

public class Friend {
    private String name;
    private int avatarResId;

    public Friend(String name, int avatarResId) {
        this.name = name;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public int getAvatarResId() {
        return avatarResId;
    }
}
