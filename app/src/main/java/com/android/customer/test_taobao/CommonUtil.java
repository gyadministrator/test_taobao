package com.android.customer.test_taobao;

import android.content.Context;

/**
 * Description: test_taobao
 * Created by gy(1984629668@qq.com)
 * Created Time on 2020/6/3 20:31
 */
public class CommonUtil {
    public static int dp2px(Context context, float dpValue) {
        if (null == context) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int getScreenWidth(Context context) {
        if (null == context) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
