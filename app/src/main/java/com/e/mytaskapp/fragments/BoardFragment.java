package com.e.mytaskapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.e.mytaskapp.Activity.MainActivity;
import com.e.mytaskapp.R;

public class  BoardFragment extends Fragment {

    ImageView imageView;
    TextView textTitle;
    TextView textDesc;
    Button startBtn;
    Button skipBtn;

    public BoardFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        imageView = view.findViewById(R.id.imageView);
        textTitle = view.findViewById(R.id.textTitle);
        textDesc= view.findViewById(R.id.textDesc);
        startBtn= view.findViewById(R.id.button_view);
        skipBtn = view.findViewById(R.id.button_skip);

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences= getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
                preferences.edit().putBoolean("isShown", true).apply();
                startActivity(new Intent(getContext(), MainActivity.class));

                getActivity().finish();
            }
        });



        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences= getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
                preferences.edit().putBoolean("isShown", true).apply();
                startActivity(new Intent(getContext(),MainActivity.class));

                getActivity().finish();
            }
        });
        RelativeLayout relativeLayout = view.findViewById(R.id.back);
        int pos = getArguments().getInt("pos");
        switch (pos){
            case 0:
                imageView.setImageResource(R.drawable.group);
                textTitle.setText("Добро пожаловать!");
                relativeLayout.setBackgroundColor(Color.RED);
                skipBtn.setVisibility(View.VISIBLE);
                break;

            case 1:
                imageView.setImageResource(R.drawable.checklist);
                textTitle.setText("Здесь вы можете делать заметки");
                relativeLayout.setBackgroundColor(Color.BLUE);
                skipBtn.setVisibility(View.VISIBLE);
                break;

            case 2:
                imageView.setImageResource(R.drawable.tasks);
                textTitle.setText("А также сохранить их");
                relativeLayout.setBackgroundColor(Color.GREEN);
                startBtn.setVisibility(View.VISIBLE);
                break;
        }
        return view;

    }

}
