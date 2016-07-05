package com.tomduan.weibosdk;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;

/**
 * Created by bask on 7/5/16.
 */
public class WeiboPlatform {

    private Application application;

    private String appId;
    private String appSecret;

    protected IWeiboShareAPI mWeiboShareAPI;

    public WeiboPlatform(Application application) {
        this.application = application;
        ApplicationInfo info = this.application.getApplicationInfo();

//        appId = info.metaData.getString("wechat_id");
//        appSecret = info.metaData.getString("wechat_secret");

        initWeibo();
    }

    private void initWeibo() {
        mWeiboShareAPI = WeiboShareSDK.createWeiboAPI(application, "3988384473");
        mWeiboShareAPI.registerApp();
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public Context getContext() {
        return application;
    }

}
