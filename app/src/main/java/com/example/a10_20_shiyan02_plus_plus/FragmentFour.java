package com.example.a10_20_shiyan02_plus_plus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentFour extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        TextView textView = view.findViewById(R.id.text_view);
//        textView.setText("这是第四个页面");
        return view;
    }
}
