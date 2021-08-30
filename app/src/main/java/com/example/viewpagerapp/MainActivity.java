package com.example.viewpagerapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    public int[] car_logo = {R.drawable.audi, R.drawable.fox_wagon, R.drawable.honda, R.drawable.isuzu, R.drawable.jaguar};

    ArrayList<Page> arrayList = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);

        for (int i = 0; i < car_logo.length; i++) {
            arrayList.add(new Page("Car Log: " + i, car_logo[i]));
        }

        SwipeClass swipe = new SwipeClass(this, arrayList);
        viewPager.setAdapter(swipe);

    }


    static class SwipeClass extends PagerAdapter {

        LayoutInflater layoutInflater;
        private final Context context;

        ArrayList<Page> arraySwipe;

        public SwipeClass(Context context1, ArrayList<Page> array_list) {
            this.context = context1;
            this.arraySwipe = array_list;
        }

        @Override
        public int getCount() {
            return arraySwipe.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }

        @SuppressLint("ServiceCast")
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.row_itme, container, false);
            ImageView img = view.findViewById(R.id.imageView);
            TextView txt_name = view.findViewById(R.id.textView);

            img.setImageResource(arraySwipe.get(position).getId());
            txt_name.setText(arraySwipe.get(position).getName());
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}