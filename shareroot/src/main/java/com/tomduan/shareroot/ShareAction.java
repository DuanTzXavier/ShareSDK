package com.tomduan.shareroot;

/**
 * Created by bask on 6/30/16.
 */
public interface ShareAction {

    void share(ShareMedia media);

    Platform getPlatform();
}
