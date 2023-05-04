package com.example.digitalwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity<savedInstanceState> extends AppCompatActivity {

    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    Button backBtn, nextBtn, skipBtn;

    TextView[] dots;
    viewPagerAdapter viewPagerAdapter;


    @Override  public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backBtn = findViewById(R.id.backBtn);
        nextBtn = findViewById(R.id.nextBtn);
        skipBtn = findViewById(R.id.skipBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getitem(0) > 0){
                    mSlideViewPager.setCurrentItem(getitem(-1),true);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getitem(0) < 2){
                    mSlideViewPager.setCurrentItem(getitem(1),true);
                }
                else{
                    Intent i = new Intent(MainActivity.this, login.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, login.class);
                startActivity(i);
                finish();

            }
        });

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagerAdapter = new viewPagerAdapter(this);

        mSlideViewPager.setAdapter(viewPagerAdapter);

        setUpIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void setUpIndicator(int position){

        dots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpIndicator(position);
            if(position > 0){
                backBtn.setVisibility(View.VISIBLE);
            }
            else{
                backBtn.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i){
        return mSlideViewPager.getCurrentItem() + i;
    }


}