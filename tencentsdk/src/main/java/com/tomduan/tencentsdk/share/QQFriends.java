package com.tomduan.tencentsdk.share;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.open.SocialConstants;
import com.tencent.tauth.Tencent;
import com.tomduan.shareroot.Platform;
import com.tomduan.shareroot.ShareAction;
import com.tomduan.shareroot.ShareMedia;
import com.tomduan.tencentsdk.R;
import com.tomduan.tencentsdk.TencentPlatform;
import com.tomduan.tencentsdk.TencentRequestListener;

/**
 * Created by bask on 7/1/16.
 */
public class QQFriends extends TencentPlatform implements ShareAction {

    private Activity activity;

    TencentRequestListener listener = new TencentRequestListener();

    public QQFriends(Activity activity) {
        super(activity);
        this.activity = activity;
    }


    @Override
    public void share(ShareMedia media) {

//        Tencent mTencent = Tencent.createInstance(getAppKey(), activity);

        Bundle bundle = new Bundle();
//这条分享消息被好友点击后的跳转URL。
        bundle.putString(SocialConstants.PARAM_TARGET_URL, "http://connect.qq.com/");
//分享的标题。注：PARAM_TITLE、PARAM_IMAGE_URL、PARAM_	SUMMARY不能全为空，最少必须有一个是有值的。
        bundle.putString(SocialConstants.PARAM_TITLE, "我在测试");
//分享的图片URL
        bundle.putString(SocialConstants.PARAM_IMAGE_URL,
                "http://img3.cache.netease.com/photo/0005/2013-03-07/8PBKS8G400BV0005.jpg");
//分享的消息摘要，最长50个字
        bundle.putString(SocialConstants.PARAM_SUMMARY, "测试");
//手Q客户端顶部，替换“返回”按钮文字，如果为空，用返回代替
        bundle.putString(SocialConstants.PARAM_APPNAME, "??我在测试");
//标识该消息的来源应用，值为应用名称+AppId。
        bundle.putString(SocialConstants.PARAM_APP_SOURCE, "ShareSDK" + "1105513452");

        mTencent.shareToQQ(this.activity, bundle , listener);
    }

    @Override
    public Platform getPlatform() {
        return new Platform(
                activity.getResources().getString(R.string.qq),
                activity.getResources().getDrawable(R.drawable.qq)
        );
    }
}
