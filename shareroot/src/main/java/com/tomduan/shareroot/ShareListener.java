package com.tomduan.shareroot;

/**
 * Created by bask on 7/4/16.
 */
public interface ShareListener {

    void onComplete(String platform);

    void onError(String platform, String error);

    void onCancel(String platform);
}
