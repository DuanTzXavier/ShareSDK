package com.tomduan.shareroot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.tomduan.wechatsdk.Utils;

import java.util.List;

/**
 * Created by bask on 6/29/16.
 */
public class PlatformView extends PopupWindow {

    private final List<Platform> mPlatformList;
    private Context mContext;
    private final int mOneLineCount;

    public PlatformView(Context context, List<Platform> platforms, int count) {
        super(context);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.mPlatformList = platforms;
        this.mContext = context;
        this.mOneLineCount = count;
        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.container, null);
        setContentView(rootView);
        FrameLayout outMost = (FrameLayout) rootView.findViewById(R.id.outmost_container);
        LinearLayout contentContainer = (LinearLayout) rootView.findViewById(R.id.content_container);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1);

        for (int line = 0;line < getLineCount();line++){
            LinearLayout lineContainer = new LinearLayout(mContext);
            lineContainer.setOrientation(LinearLayout.HORIZONTAL);
            for (int i = 0;i < mOneLineCount;i++){
                initPlatForms(lineContainer, line * mOneLineCount + i);
            }
            contentContainer.addView(lineContainer, params);
        }
        outMost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private int getLineCount() {
        return 0 == mPlatformList.size() % mOneLineCount ?
                mPlatformList.size() / mOneLineCount :
                mPlatformList.size() / mOneLineCount + 1;
    }

    private void initPlatForms(LinearLayout contentContainer, int index) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_default, null);
        if (index < mPlatformList.size()){
            ImageView icon = (ImageView) rootView.findViewById(R.id.platform_icon);
            TextView name = (TextView) rootView.findViewById(R.id.platform_name);
            icon.setImageResource(com.tomduan.wechatsdk.R.drawable.wechat);
            name.setText(Utils.PLATFORM_NAME);
        }
        contentContainer.addView(rootView, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1));
    }
}
