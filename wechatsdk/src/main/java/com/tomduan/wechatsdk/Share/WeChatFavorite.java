package com.tomduan.wechatsdk.Share;

import android.content.Context;
import android.util.Log;

import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tomduan.shareroot.Platform;
import com.tomduan.shareroot.ShareAction;
import com.tomduan.shareroot.ShareMedia;
import com.tomduan.wechatsdk.R;

/**
 * Created by bask on 7/1/16.
 */
public class WeChatFavorite implements ShareAction {
    private IWXAPI wxapi;
    private Context mContext;

    public WeChatFavorite(Context context) {
        wxapi = WXAPIFactory.createWXAPI(context, "wxae2c6f32c2608a89");
        wxapi.registerApp("wxae2c6f32c2608a89");
        mContext = context;
    }
    @Override
    public void share(ShareMedia media) {
        wechatShare(1);
    }

    @Override
    public Platform getPlatform() {
        return new Platform(
                mContext.getResources().getString(R.string.name),
                mContext.getResources().getDrawable(R.drawable.umeng_socialize_wechat));
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
        req.scene = SendMessageToWX.Req.WXSceneFavorite;
        wxapi.sendReq(req);

        Log.i("wxshare", "share");
    }
}
