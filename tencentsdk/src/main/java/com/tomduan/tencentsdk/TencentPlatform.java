package com.tomduan.tencentsdk;

import android.app.Activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import com.tencent.tauth.Tencent;

/**
 * Created by bask on 7/3/16.
 */
public class TencentPlatform {

    private Activity activity;

    private String appId;
    private String appKey;

    protected Tencent mTencent;

    public TencentPlatform(Activity activity) {
        this.activity = activity;
        ApplicationInfo info = activity.getApplication().getApplicationInfo();
        appId = String.valueOf(info.metaData.getInt("qq_id"));
        appKey = info.metaData.getString("qq_key");

        initTencent();
    }

    private void initTencent() {
        mTencent = Tencent.createInstance(appId, activity);
    }

    public Context getContext() {
        return activity;
    }

    public Activity getActivity() {
        return activity;
    }
}
