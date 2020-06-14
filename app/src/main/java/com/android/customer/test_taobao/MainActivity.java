package com.android.customer.test_taobao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String[] titles = {"好的", "坏的", "烂的"};
    private LinearLayout llPicturew;
    private List<View> views = new ArrayList<>();
    private int[] icon = {R.drawable.address_book, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llPicturew = findViewById(R.id.ll_picturew);

        initPicturew(5);
        readerPicturew(this, llPicturew, views, 2, true);

        SlidingTabLayout slidingTabLayout = findViewById(R.id.slidtab);
        ViewPager vp = findViewById(R.id.vp);

        List<String> stringList = new ArrayList<>();
        stringList.add("我是数据111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        stringList.add("我是数据222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222");
        stringList.add("我是数据333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333");

        MyPageAdapter myPageAdapter = new MyPageAdapter(stringList);
        vp.setAdapter(myPageAdapter);

        slidingTabLayout.setViewPager(vp, titles);
    }

    private void readerPicturew(Context context, LinearLayout llContent, List<View> views, int rowSize, boolean isSpecial) {
        if (llContent == null || views == null || views.size() == 0 || rowSize == 0) return;
        if (isSpecial) {
            @SuppressLint("InflateParams") View view = LayoutInflater.from(context).inflate(R.layout.special, null);
            ImageView iv1 = view.findViewById(R.id.iv1);
            ImageView iv2 = view.findViewById(R.id.iv2);
            ImageView iv3 = view.findViewById(R.id.iv3);
            ImageView iv4 = view.findViewById(R.id.iv4);
            iv1.setImageResource(icon[0]);
            iv2.setImageResource(icon[1]);
            iv3.setImageResource(icon[2]);
            iv4.setImageResource(icon[3]);

            llContent.addView(view);
        } else {
            int size = views.size();
            int layoutNum;
            if (size % rowSize == 0) {
                layoutNum = size / rowSize;
            } else {
                layoutNum = (size / rowSize) + 1;
            }
            for (int i = 0; i < layoutNum; i++) {
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                int sum = 0;
                Iterator<View> iterator = views.iterator();
                while (iterator.hasNext()) {
                    View view = iterator.next();
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    linearLayout.addView(view);
                    iterator.remove();
                    if (views.size() < rowSize) {
                        if (linearLayout.getParent() != null) {
                            ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
                        }
                        llPicturew.addView(linearLayout);
                    }
                    sum += 1;
                    if (sum == rowSize) {
                        if (linearLayout.getParent() != null) {
                            ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
                        }
                        llContent.addView(linearLayout);
                        break;
                    }
                }
            }
        }
    }

    private void initPicturew(int num) {
        for (int i = 0; i < num; i++) {
            @SuppressLint("InflateParams") View view = LayoutInflater.from(this).inflate(R.layout.grid_item, null);
            ImageView imageView = view.findViewById(R.id.iv);
            imageView.setImageResource(R.drawable.speech_balloon);
            views.add(view);
        }
        /*for (int i = 0; i < 3; i++) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayouts.add(linearLayout);


            int sum = 0;
            Iterator<View> iterator = views.iterator();
            while (iterator.hasNext()) {
                Log.e(TAG, "initPicturew----size: " + views.size());
                View view = iterator.next();
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                linearLayout.addView(view);
                iterator.remove();
                if (views.size() < count) {
                    llPicturew.addView(linearLayout);
                }
                sum += 1;
                if (sum == count) {
                    sum = 0;
                    Log.e(TAG, "initPicturew-----: " + linearLayout.getChildCount());
                    if (linearLayout.getParent() != null) {
                        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
                    }
                    llPicturew.addView(linearLayout);
                    break;
                }
            }
        }
        Log.e(TAG, "initPicturew: " + llPicturew.getChildCount());*/
    }

}