package com.example.apple.menunavigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class WelcomActivity extends AppCompatActivity {
    static final int TOTAL_PAGE = 2;

    private Button btNext,btSkip;
    private SmartTabLayout indicator;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        btNext = (Button) findViewById(R.id.btNext);
        btSkip = (Button) findViewById(R.id.btSkip);
        indicator = (SmartTabLayout) findViewById(R.id.indicator);
        pager = (ViewPager) findViewById(R.id.pager);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                WelcomeFragment fragment = null;

                switch (position) {
                    case 0:
                        fragment = WelcomeFragment.newInstance(R.layout.fragment_one);
                        break;
                    case 1:
                        fragment = WelcomeFragment.newInstance(R.layout.fragment_two);
                        break;
                }
                return fragment;
            }


            @Override
            public int getCount() {
                return TOTAL_PAGE;
            }
        };
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == TOTAL_PAGE - 1){
                    btNext.setText("Done");
                    btSkip.setVisibility(View.GONE);
                }else{
                    btNext.setText("Next");
                    btSkip.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pager.getCurrentItem() == TOTAL_PAGE - 1) {
                    finishWelcome();
                } else {
                    pager.setCurrentItem(pager.getCurrentItem() +1,true);
                }
            }
        });

        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishWelcome();
            }
        });
    }
    private void finishWelcome() {
        SharedPreferences preferences = getSharedPreferences("my_preferences",
                MODE_PRIVATE); preferences.edit()
                .putBoolean("welcome_complete",true).apply();
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();

    }
}
