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

/**
 * Created by bask on 6/29/16.
 */
public class BaskShare {
    private static final String BASKSHARE = "Bask Share";

    private Activity mActivity;
    private PopupWindow mPopupWindow;

    public BaskShare(Activity activity) {
        this.mActivity = activity;
        initView(mActivity);
    }

    private void initView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.container, null);
        FrameLayout outMostContainer = (FrameLayout) rootView.findViewById(R.id.outmost_container);
        outMostContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        mPopupWindow = new PopupWindow(rootView);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public void show(){
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.showAtLocation(this.mActivity.getWindow().getDecorView(), 80, 0, 0);
    }

    public void dismiss(){
        mPopupWindow.setFocusable(false);
        mPopupWindow.dismiss();
    }

}
