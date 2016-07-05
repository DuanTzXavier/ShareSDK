package com.tomduan.tencentsdk;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tomduan.shareroot.ShareListener;

/**
 * Created by bask on 7/2/16.
 */
public class TencentRequestListener implements IUiListener {

    private ShareListener listener;

    public TencentRequestListener(ShareListener listener) {
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
