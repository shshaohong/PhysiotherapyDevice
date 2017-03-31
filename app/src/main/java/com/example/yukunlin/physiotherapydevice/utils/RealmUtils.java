package com.example.yukunlin.physiotherapydevice.utils;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by yukunlin on 2016/11/14.
 */

public class RealmUtils {
    private Context context;
    private static RealmUtils mInstance;
    private String realName = "device.realm";

    private RealmUtils(Context context) {
        this.context = context;
    }

    public static RealmUtils getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RealmUtils.class) {
                if (mInstance == null) {
                    mInstance = new RealmUtils(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获得Realm对象
     *
     * @return
     */
    public Realm getRealm() {


        return Realm.getInstance(new RealmConfiguration.Builder(context).name(realName).build());
    }
}
