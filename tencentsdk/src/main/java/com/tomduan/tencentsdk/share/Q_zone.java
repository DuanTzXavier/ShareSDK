package com.tomduan.tencentsdk.share;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.Tencent;
import com.tomduan.shareroot.Platform;
import com.tomduan.shareroot.ShareAction;
import com.tomduan.shareroot.ShareMedia;
import com.tomduan.tencentsdk.R;
import com.tomduan.tencentsdk.TencentPlatform;
import com.tomduan.tencentsdk.TencentRequestListener;

import java.util.ArrayList;

/**
 * Created by bask on 7/3/16.
 */
public class Q_zone extends TencentPlatform implements ShareAction {

    TencentRequestListener listener = new TencentRequestListener();

    public Q_zone(Activity activity) {
        super(activity);
    }


    @Override
    public void share(ShareMedia media) {
        Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_NO_TYPE);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "分享到QQ空间的标题");
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY,"分享到QQ空间的内容");
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL,"http://connect.qq.com/");
        ArrayList<String> arrayList  = new ArrayList<String>();   //分享至QQ空间支持多图片分享
        arrayList.add("http://img3.cache.netease.com/photo/0005/2013-03-07/8PBKS8G400BV0005.jpg");
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL,arrayList);
        mTencent.shareToQzone(getActivity(), params , listener);
    }

    @Override
    public Platform getPlatform() {
        return new Platform(
                getContext().getResources().getString(R.string.q_zone),
                getContext().getResources().getDrawable(R.drawable.qzone)
        );
    }
}
