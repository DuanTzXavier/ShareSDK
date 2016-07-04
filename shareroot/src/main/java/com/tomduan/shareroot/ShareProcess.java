package com.tomduan.shareroot;

/**
 * Created by bask on 7/4/16.
 */
public interface ShareProcess {

    void startLoading();

    void stopLoadingIfNeed();

    void showError(String errorMessage);
}
