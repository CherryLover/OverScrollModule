package com.osapling.overscrollmodule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class PagerActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, PagerActivity.class);
        context.startActivity(starter);
    }

    ViewPager vpPagers;

    List<String> titleList = new ArrayList<>();
    List<Integer> colorList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        vpPagers = findViewById(R.id.vp_pager);
        titleList.add("1");
        titleList.add("2");
        titleList.add("3");
        colorList.add(Color.BLUE);
        colorList.add(Color.BLACK);
        colorList.add(Color.RED);

        OverScrollDecoratorHelper.setUpOverScroll(vpPagers);

        vpPagers.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup collection, int position) {
                LayoutInflater inflater = LayoutInflater.from(PagerActivity.this);
                ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.item_vp, collection, false);
                View itemRoot = layout.findViewById(R.id.ll_vp_item_root);
                TextView tvName = layout.findViewById(R.id.tv_item_name);
                itemRoot.setBackgroundColor(colorList.get(position));
                tvName.setText(titleList.get(position));
                collection.addView(layout);
                return layout;
            }

            @Override
            public void destroyItem(ViewGroup collection, int position, Object view) {
                collection.removeView((View) view);
            }

            @Override
            public int getCount() {
                return titleList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });
//        vpPagers.setAdapter(new FragmentP);
    }
}
