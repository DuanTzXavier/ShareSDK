package com.tomduan.sharesdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tomduan.shareroot.BaskShare;
import com.tomduan.shareroot.Platform;
import com.tomduan.tencentsdk.share.QQFriends;
import com.tomduan.tencentsdk.share.Q_zone;
import com.tomduan.wechatsdk.share.WeChatCircle;
import com.tomduan.wechatsdk.share.WeChatFavorite;
import com.tomduan.wechatsdk.share.WeChatFriends;

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
        baskShare.setPlatForm(
                new Platform(new Q_zone(this)),
                new Platform(new QQFriends(this)),
                new Platform(new WeChatCircle(this)),
                new Platform(new WeChatFavorite(this)),
                new Platform(new WeChatFriends(this)));
        baskShare.show();
    }
}
