package com.example.a11_23_shiyan06;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatMessage> chatMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);  // Ensure this layout has RecyclerView

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewChat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));  // Use LinearLayoutManager for vertical scrolling

        // Initialize chat messages list
        chatMessages = new ArrayList<>();

        // Add some sample messages for testing
        chatMessages.add(new ChatMessage("John", "Hello!"));
        chatMessages.add(new ChatMessage("Alice", "Hi, how are you?"));
        chatMessages.add(new ChatMessage("John", "I'm good, thanks!"));


        // Set up the adapter
        chatAdapter = new ChatAdapter(this, chatMessages);
        recyclerView.setAdapter(chatAdapter);

        Button btnSendMessage = findViewById(R.id.btnSendMessage);
        btnSendMessage.setOnClickListener(v -> {
            EditText etMessage = findViewById(R.id.etMessage);
            String message = etMessage.getText().toString();
            if (!message.isEmpty()) {
                // Add new message
                chatMessages.add(new ChatMessage("You", message)); // Replace "You" with actual sender
                chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                etMessage.setText("");  // Clear the input field
            }
        });

    }
}
