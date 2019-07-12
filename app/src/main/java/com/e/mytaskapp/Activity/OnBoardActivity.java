package com.e.mytaskapp.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.e.mytaskapp.fragments.BoardFragment;
import com.e.mytaskapp.R;

import java.util.ArrayList;
import java.util.List;

public class OnBoardActivity extends AppCompatActivity  {

    ViewPager viewPager;
    SectionPagerAdapter adapter;

    private List<ImageView> dots;
    private final static int NUM_PAGES = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        addDots();


        viewPager = findViewById(R.id.viewPager);
        adapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tablayout = findViewById(R.id.tabDots);
        tablayout.setupWithViewPager(viewPager, true);
    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("pos", i);
            BoardFragment boardFragment = new BoardFragment();
            boardFragment.setArguments(bundle);
            return boardFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }


    }

    public void addDots() {
        dots = new ArrayList<>();
        LinearLayout dotsLayout = findViewById(R.id.dots);

        for (int i = 0; i < NUM_PAGES; i++) {
            ImageView dot = new ImageView(this);
            dot.setImageDrawable(getResources().getDrawable(R.drawable.tab_indicator_selected));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            dotsLayout.addView(dot, params);

            dots.add(dot);
        }

    }
}