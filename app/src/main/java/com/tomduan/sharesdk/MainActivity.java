package com.tomduan.sharesdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tomduan.shareroot.BaskShare;
import com.tomduan.shareroot.Platform;
import com.tomduan.wechatsdk.Share.WeChatCircle;
import com.tomduan.wechatsdk.Share.WeChatFavorite;
import com.tomduan.wechatsdk.Share.WeChatFriends;

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
    }

    @OnClick(R.id.test)
    public void test(){
        BaskShare baskShare = new BaskShare(this);
        baskShare.setOneLineCount(3);
        baskShare.setPlatForm(
                new Platform(new WeChatCircle(this)),
                new Platform(new WeChatFavorite(this)),
                new Platform(new WeChatFriends(this)));
        baskShare.show();
    }
}
