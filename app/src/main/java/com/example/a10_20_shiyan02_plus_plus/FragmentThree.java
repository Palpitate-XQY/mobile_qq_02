package com.example.a10_20_shiyan02_plus_plus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        TextView textView = view.findViewById(R.id.text_view);
//        textView.setText("这是第三个页面");
        return view;
    }
}
