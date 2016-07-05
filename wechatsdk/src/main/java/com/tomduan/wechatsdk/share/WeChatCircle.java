package com.tomduan.wechatsdk.share;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tomduan.shareroot.Platform;
import com.tomduan.shareroot.ShareAction;
import com.tomduan.shareroot.ShareMedia;
import com.tomduan.wechatsdk.R;
import com.tomduan.wechatsdk.WeChatPlatform;

/**
 * Created by bask on 7/1/16.
 */
public class WeChatCircle extends WeChatPlatform implements ShareAction {

    public WeChatCircle(Activity activity) {
        super(activity.getApplication());
    }
    @Override
    public void share(ShareMedia media) {
        wechatShare(1);
    }

    @Override
    public Platform getPlatform() {
        return new Platform(
                getContext().getResources().getString(R.string.circle),
                getContext().getResources().getDrawable(R.drawable.circle));
    }

    private void wechatShare(int flag){
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = "这里填写链接url";
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = "这里填写标题";
        msg.description = "这里填写内容";
        //这里替换一张自己工程里的图片资源
//        Bitmap thumb = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.umeng_socialize_wechat);
//        msg.setThumbImage(thumb);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneTimeline;
        wxapi.sendReq(req);

        Log.i("wxshare", "share");
    }
}
