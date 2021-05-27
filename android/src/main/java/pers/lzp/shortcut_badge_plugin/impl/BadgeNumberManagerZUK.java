package pers.lzp.shortcut_badge_plugin.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import pers.lzp.shortcut_badge_plugin.IBadge;


/**
 * ZUK机型的桌面角标设置管理类
 */

public class BadgeNumberManagerZUK implements IBadge {

    /**
     * 设置应用的桌面角标
     *
     * @param context context
     * @param number  角标显示的数字
     */
    @Override
    public void setBadgeNumber(Context context, int number) {
        try {
            Bundle extra = new Bundle();
            extra.putInt("app_badge_count", number);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, extra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
