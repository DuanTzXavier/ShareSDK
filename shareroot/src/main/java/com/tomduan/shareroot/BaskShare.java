package com.tomduan.shareroot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import java.util.Arrays;
import java.util.List;

/**
 * Created by bask on 6/29/16.
 */
public class BaskShare {
    private static final String BASKSHARE = "Bask Share";

    private Activity mActivity;
    private PlatformView mPopupWindow;
    private List<Platform> mPlatformList = new ArrayList<>();
    private int mOneLineCount = 4;

    public static ActivityResult activityResult;

    public static ShareListener listener;

    public BaskShare(Activity activity) {
        this.mActivity = activity;
    }

    public void show(){
        mPopupWindow = new PlatformView(mActivity, mPlatformList, mOneLineCount);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.showAtLocation(this.mActivity.getWindow().getDecorView(), 80, 0, 0);
        Log.i(BASKSHARE, mPopupWindow.toString());
    }

    public BaskShare setPlatForm(Platform... platForm){
        mPlatformList.clear();
        mPlatformList = Arrays.asList(platForm);
        return this;
    }

    public BaskShare setOneLineCount(int count){
        this.mOneLineCount = count;
        return this;
    }

    public BaskShare setListener(ShareListener listener){
        this.listener = listener;
        return this;
    }

//    public void setActivityResult(ActivityResult activityResult){
//        this.activityResult = activityResult;
//    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        activityResult.onActivityResult(requestCode, resultCode, data);
    }
}
