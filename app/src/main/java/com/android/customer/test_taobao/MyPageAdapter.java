package com.android.customer.test_taobao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Description: test_taobao
 * Created by gy(1984629668@qq.com)
 * Created Time on 2020/6/3 20:09
 */
public class MyPageAdapter extends PagerAdapter {

    private List<String> list;


    public MyPageAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Context context = container.getContext();

        View inflate = View.inflate(context, R.layout.scroll_view, null);
        TextView tv = inflate.findViewById(R.id.tv);

        tv.setText(list.get(position));
        container.addView(inflate);

        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
