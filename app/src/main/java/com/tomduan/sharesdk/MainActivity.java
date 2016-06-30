package com.tomduan.sharesdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tomduan.shareroot.BaskShare;
import com.tomduan.shareroot.Platform;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.test)
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        test.setText(com.tomduan.wechatsdk.R.string.app_name);
    }

    @OnClick(R.id.test)
    public void test(){
        BaskShare baskShare = new BaskShare(this);
        baskShare.setOneLineCount(3);
        baskShare.setPlatForm(Platform.EMAIL, Platform.EMAIL, Platform.EMAIL, Platform.EMAIL);
        baskShare.show();
    }
}
