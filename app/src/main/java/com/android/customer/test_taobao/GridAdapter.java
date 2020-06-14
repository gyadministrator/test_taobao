package com.android.customer.test_taobao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Description: test_taobao
 * Created by gy(1984629668@qq.com)
 * Created Time on 2020/6/4 19:48
 */
public class GridAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> list;

    public GridAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
            viewHolder.iv = view.findViewById(R.id.iv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Integer integer = list.get(i);
        viewHolder.iv.setImageResource(integer);
        return view;
    }

    static class ViewHolder {
        ImageView iv;
    }
}
