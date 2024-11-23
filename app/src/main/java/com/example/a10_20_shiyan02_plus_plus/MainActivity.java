package com.example.a10_20_shiyan02_plus_plus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bottomButton1 = findViewById(R.id.bottom_button_1);
        Button bottomButton2 = findViewById(R.id.bottom_button_2);
        Button bottomButton3 = findViewById(R.id.bottom_button_3);
        Button bottomButton4 = findViewById(R.id.bottom_button_4);

        bottomButton1.setOnClickListener(v -> loadFragment(new FragmentOne()));
        bottomButton2.setOnClickListener(v -> loadFragment(new FragmentTwo()));
        bottomButton3.setOnClickListener(v -> loadFragment(new FragmentThree()));
        bottomButton4.setOnClickListener(v -> loadFragment(new FragmentFour()));

        horizontalScrollView = findViewById(R.id.horizontalScrollView);
        Button menuButton1 = findViewById(R.id.menu_button_1);
        Button menuButton2 = findViewById(R.id.menu_button_2);
        Button menuButton3 = findViewById(R.id.menu_button_3);
        Button menuButton4 = findViewById(R.id.menu_button_4);
        Button closeButton = findViewById(R.id.close_button);
        Button qrCodeButton = findViewById(R.id.qr_code_button);

        menuButton1.setOnClickListener(v -> {
            Toast.makeText(this, "菜单项 1", Toast.LENGTH_SHORT).show();
            loadFragment(new FragmentOne());
        });
        menuButton2.setOnClickListener(v -> {
            Toast.makeText(this, "菜单项 2", Toast.LENGTH_SHORT).show();
            loadFragment(new FragmentTwo());
        });
        menuButton3.setOnClickListener(v -> {
            Toast.makeText(this, "菜单项 3", Toast.LENGTH_SHORT).show();
            loadFragment(new FragmentThree());
        });
        menuButton4.setOnClickListener(v -> {
            Toast.makeText(this, "菜单项 4", Toast.LENGTH_SHORT).show();
            loadFragment(new FragmentFour());
        });

        closeButton.setOnClickListener(v -> {
            horizontalScrollView.smoothScrollTo(1500, 0);
            loadFragment(new FragmentOne());
        });

        qrCodeButton.setOnClickListener(v -> {
            horizontalScrollView.smoothScrollTo(1500, 0);
            loadFragment(new QRCodeFragment());
        });

        // 默认加载主内容
        if (savedInstanceState == null) {
            loadFragment(new FragmentOne()); // 默认显示 FragmentOne
        }

        // 启动后显示主内容
        horizontalScrollView.post(() -> horizontalScrollView.smoothScrollTo(2000, 0));
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
