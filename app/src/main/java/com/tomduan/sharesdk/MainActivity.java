package com.tomduan.sharesdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tomduan.shareroot.BaskShare;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.test)
    public void test(){
        BaskShare baskShare = new BaskShare(this);
        baskShare.show();
    }
}
