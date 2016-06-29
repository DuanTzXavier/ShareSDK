package com.tomduan.shareroot;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bask on 6/29/16.
 */
public class BaskShare {
    private static final String BASKSHARE = "Bask Share";

    private Activity mActivity;
    private PlatformView mPopupWindow;
    private List<Platform> mPlatformList = new ArrayList<>();
    private View mRootView;

    public BaskShare(Activity activity) {
        this.mActivity = activity;
    }

    public void show(){
        mPopupWindow = new PlatformView(mActivity, mPlatformList);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.showAtLocation(this.mActivity.getWindow().getDecorView(), 80, 0, 0);
        Log.i(BASKSHARE, mPopupWindow.toString());
    }

    public void setPlatForm(List<Platform> platforms){
        mPlatformList.clear();
        mPlatformList.addAll(platforms);
    }

}
