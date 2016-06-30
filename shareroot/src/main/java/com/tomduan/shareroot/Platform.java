package com.tomduan.shareroot;

import android.graphics.drawable.Drawable;

/**
 * Created by bask on 6/29/16.
 */
public class  Platform {
    private String platformName;
    private Drawable icon;
    private ShareAction action;

    public Platform() {
    }

    public Platform(String platformName, Drawable icon) {
        this.platformName = platformName;
        this.icon = icon;
    }

    public String getPlatformName() {
        return platformName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public ShareAction getAction() {
        return action;
    }
}
