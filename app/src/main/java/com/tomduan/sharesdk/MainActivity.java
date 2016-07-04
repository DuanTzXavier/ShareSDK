package com.tomduan.sharesdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tomduan.shareroot.BaskShare;
import com.tomduan.shareroot.Platform;
import com.tomduan.shareroot.ShareListener;
import com.tomduan.tencentsdk.share.QQFriends;
import com.tomduan.tencentsdk.share.Q_zone;
import com.tomduan.wechatsdk.share.WeChatCircle;
import com.tomduan.wechatsdk.share.WeChatFavorite;
import com.tomduan.wechatsdk.share.WeChatFriends;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ShareListener {

    private static final String BaskShareDemo = "BaskShareDemo";

    @Bind(R.id.test)
    TextView test;

    private BaskShare mBaskShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initBaskShare();
    }

    private void initBaskShare() {
        mBaskShare = new BaskShare(this)
                .setOneLineCount(5)
                .setListener(this)
                .setPlatForm(
                        new Platform(new Q_zone(this)),
                        new Platform(new QQFriends(this)),
                        new Platform(new WeChatCircle(this)),
                        new Platform(new WeChatFavorite(this)),
                        new Platform(new WeChatFriends(this)));
    }

    @OnClick(R.id.test)
    public void test(){
        mBaskShare.show();
    }

    @Override
    public void onComplete(String platform) {
        Log.i(BaskShareDemo, platform);
    }

    @Override
    public void onError(String platform, String error) {
        Log.i(BaskShareDemo, platform + error);
    }

    @Override
    public void onCancel(String platform) {
        Log.i(BaskShareDemo, platform);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        /** attention to this below ,must add this**/
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        mBaskShare.onActivityResult(requestCode, resultCode, data);
        Log.d("result","onActivityResult");
    }
}
