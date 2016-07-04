package com.tomduan.wechatsdk;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tomduan.shareroot.Platform;

/**
 * Created by bask on 6/30/16.
 */
public abstract class WeChatPlatform {

    private Application application;

    private String appId;
    private String appSecret;

    protected IWXAPI wxapi;

    public WeChatPlatform(Application application) {
        this.application = application;
        ApplicationInfo info = this.application.getApplicationInfo();

        appId = info.metaData.getString("wechat_id");
        appSecret = info.metaData.getString("wechat_secret");

        initWXAPI();
    }

    private void initWXAPI() {
        wxapi = WXAPIFactory.createWXAPI(application, getAppId());
        wxapi.registerApp(getAppId());
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
