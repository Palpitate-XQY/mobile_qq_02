package com.example.a11_23_shiyan06;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "friends_chat.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_FRIENDS = "friends";
    public static final String COLUMN_FRIEND_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AVATAR = "avatar"; // 头像路径或资源名称

    public static final String TABLE_MESSAGES = "messages";
    public static final String COLUMN_MESSAGE_ID = "message_id";
    public static final String COLUMN_SENDER = "sender"; // 发送者
    public static final String COLUMN_RECEIVER = "receiver"; // 接收者
    public static final String COLUMN_MESSAGE = "message"; // 消息内容
    public static final String COLUMN_TIMESTAMP = "timestamp"; // 时间戳

    private static final String CREATE_FRIENDS_TABLE =
            "CREATE TABLE " + TABLE_FRIENDS + " (" +
                    COLUMN_FRIEND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_AVATAR + " TEXT);";

    private static final String CREATE_MESSAGES_TABLE =
            "CREATE TABLE " + TABLE_MESSAGES + " (" +
                    COLUMN_MESSAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_SENDER + " TEXT, " +
                    COLUMN_RECEIVER + " TEXT, " +
                    COLUMN_MESSAGE + " TEXT, " +
                    COLUMN_TIMESTAMP + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FRIENDS_TABLE);
        db.execSQL(CREATE_MESSAGES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        onCreate(db);
    }
}
