package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    //array
    public int[] slide_image = {
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,

    };

    public int[] heading = {
            R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three,
            };

    public int [] description={
            R.string.desc_one,
            R.string.desc_two,
            R.string.desc_three,

    };


    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.titleimage);
        TextView slideHeading = (TextView) view.findViewById(R.id.texttite);
        TextView slideDescription=(TextView)view.findViewById(R.id.description);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(heading[position]);
        slideDescription.setText(description[position]);

        container.addView(view);


        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout) object);
    }
}

