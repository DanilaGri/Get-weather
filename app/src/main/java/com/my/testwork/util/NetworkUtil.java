package com.my.testwork.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Danila on 13.09.2017.
 */

public class NetworkUtil {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
