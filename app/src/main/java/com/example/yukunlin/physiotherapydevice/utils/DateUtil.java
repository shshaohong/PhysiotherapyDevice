package com.example.yukunlin.physiotherapydevice.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class DateUtil {

    public static String getCurrentDatatime() {
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }
}
