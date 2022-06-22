package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private  static  int SPLASH_TIME_OUT=2000;
    Animation topAnimation ,bottomAnimation,middleAnimation;
    //Hooks
    View first,second,third,fourth,fifth,sixth;
    TextView textView;
    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        middleAnimation= AnimationUtils.loadAnimation(this,R.anim.middle_animation);

        //hooks

        first=findViewById(R.id.first_line);
        second=findViewById(R.id.Second_line);
        third=findViewById(R.id.third_line);
        fourth=findViewById(R.id.fourth_line);
        fifth=findViewById(R.id.fifth_line);
        sixth=findViewById(R.id.six_line);

        img1=findViewById(R.id.ocas);
        img2=findViewById(R.id.brand);
        textView=findViewById(R.id.textview);

       //top animation
        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);


        //middle animation

        img1.setAnimation(middleAnimation);

        //bottom animation
        textView.setAnimation(bottomAnimation);
        img2.setAnimation(bottomAnimation);

        //splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                        finish();

            }

        },SPLASH_TIME_OUT);



    }
}