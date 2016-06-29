package com.tomduan.shareroot;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bask on 6/29/16.
 */
public class PlatformView extends PopupWindow {

    private final List<Platform> mPlatformList;
    private Context mContext;

    public PlatformView(Context context, List<Platform> platforms) {
        super(context);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.mPlatformList = platforms;
        this.mContext = context;
        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.container, null);
        setContentView(rootView);
        FrameLayout outMost = (FrameLayout) rootView.findViewById(R.id.outmost_container);
        LinearLayout contentContainer = (LinearLayout) rootView.findViewById(R.id.content_container);
        contentContainer.removeAllViews();
        initPlatForms(contentContainer);
        initPlatForms(contentContainer);
        initPlatForms(contentContainer);
        initPlatForms(contentContainer);
        outMost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private void initPlatForms(LinearLayout contentContainer) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_default, null);
        ImageView icon = (ImageView) rootView.findViewById(R.id.platform_icon);
        TextView name = (TextView) rootView.findViewById(R.id.platform_name);
        icon.setImageResource(com.tomduan.wechatsdk.R.drawable.wechat);
//        name.setText(com.tomduan.wechatsdk.R.string.name);
        Log.i("name", String.valueOf(com.tomduan.wechatsdk.R.string.name));
        contentContainer.addView(rootView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
    }
}
