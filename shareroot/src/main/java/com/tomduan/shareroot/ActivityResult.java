package com.tomduan.shareroot;

import android.content.Intent;

/**
 * Created by bask on 7/4/16.
 */
public interface ActivityResult {
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
