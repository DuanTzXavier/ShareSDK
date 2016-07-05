package com.tomduan.weibosdk;

import android.app.Activity;

import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.tomduan.shareroot.Platform;
import com.tomduan.shareroot.ShareAction;
import com.tomduan.shareroot.ShareMedia;

/**
 * Created by bask on 7/5/16.
 */
public class Weibo extends WeiboPlatform implements ShareAction {

    private Activity activity;

    public Weibo(Activity activity) {
        super(activity.getApplication());
        this.activity = activity;
    }

    @Override
    public void share(ShareMedia media) {

        TextObject textObject = new TextObject();
        textObject.text = "hahaha";

        WeiboMultiMessage weiboMessage = new WeiboMultiMessage();

        weiboMessage.textObject = textObject;

        SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
        request.transaction = String.valueOf(System.currentTimeMillis());
        request.multiMessage = weiboMessage;

        mWeiboShareAPI.sendRequest(activity, request);
    }

    @Override
    public Platform getPlatform() {
        return new Platform(
                getContext().getResources().getString(R.string.weibo),
                getContext().getResources().getDrawable(R.drawable.weibo));
    }
}
