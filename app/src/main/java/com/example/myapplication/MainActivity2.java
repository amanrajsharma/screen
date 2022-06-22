package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDOTLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private TextView[] mDots;
    private Button mNextBtn;
    private Button mBackBtn;
    private Button mSkipBtn;
    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideviewpager);
        mDOTLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        //buttons
        mNextBtn=(Button)findViewById(R.id.nextbutton);
        mBackBtn=(Button)findViewById(R.id.backbutton);
        mSkipBtn=(Button)findViewById(R.id.skip);


        viewPagerAdapter = new ViewPagerAdapter(this);
        mSlideViewPager.setAdapter(viewPagerAdapter);
        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //button click

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });
        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,loginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void addDotsIndicator( int position){
        mDots =new TextView[3];
        mDOTLayout.removeAllViews();
        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.white));

            mDOTLayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            mCurrentPage=position;

            if(position==0){
                mNextBtn.setEnabled(true);
                mNextBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);


                mNextBtn.setText("Next");
                mBackBtn.setText(" ");

            }else if (position== mDots.length -1){
                mNextBtn.setEnabled(true);
                mNextBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);


                mNextBtn.setText("Finish");
                mBackBtn.setText("Back");

            }else{
                mNextBtn.setEnabled(true);
                mNextBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);


                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}


