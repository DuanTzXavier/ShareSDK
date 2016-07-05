package com.tomduan.tencentsdk;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;

import com.tencent.tauth.Tencent;
import com.tomduan.shareroot.ActivityResult;
import com.tomduan.shareroot.BaskShare;

/**
 * Created by bask on 7/3/16.
 */
public class TencentPlatform implements ActivityResult{

    private Activity activity;

    private String appId;
    private String appKey;

    protected Tencent mTencent;

    private TencentRequestListener listener = new TencentRequestListener(BaskShare.listener);

    public TencentPlatform(Activity activity) {
        this.activity = activity;
        ApplicationInfo info = activity.getApplication().getApplicationInfo();
        appId = String.valueOf(info.metaData.getInt("qq_id"));
        appKey = info.metaData.getString("qq_key");
        initTencent();
    }

    private void initTencent() {
        mTencent = Tencent.createInstance(appId, activity);
        BaskShare.activityResult = this;
    }

    public Context getContext() {
        return activity;
    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        mTencent.onActivityResult(requestCode, resultCode, data);
        Tencent.onActivityResultData(requestCode, resultCode, data, listener);
    }

    public TencentRequestListener getListener() {
        return listener;
    }
}
