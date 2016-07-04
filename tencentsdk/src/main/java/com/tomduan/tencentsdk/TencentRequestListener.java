package com.tomduan.tencentsdk;

import android.support.annotation.Nullable;

import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tomduan.shareroot.ShareListener;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

/**
 * Created by bask on 7/2/16.
 */
public class TencentRequestListener implements IUiListener {

    private ShareListener listener;

    public TencentRequestListener(@Nullable ShareListener listener) {
        this.listener = listener;
    }

    @Override
    public void onComplete(Object o) {
        if (listener != null){
            listener.onComplete("tencent");
        }
    }

    @Override
    public void onError(UiError uiError) {
        if (listener != null){
            listener.onError("tencent", uiError.errorMessage);
        }
    }

    @Override
    public void onCancel() {
        if (listener != null){
            listener.onCancel("tencent");
        }
    }
}
