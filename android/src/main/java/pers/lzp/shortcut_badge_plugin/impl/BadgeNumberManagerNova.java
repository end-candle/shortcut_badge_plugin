package pers.lzp.shortcut_badge_plugin.impl;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import pers.lzp.shortcut_badge_plugin.IBadge;
import pers.lzp.shortcut_badge_plugin.Utils;

/**
 * nova机型的桌面角标设置管理类
 */

public class BadgeNumberManagerNova implements IBadge {

    /**
     * 设置应用的桌面角标
     *
     * @param context context
     * @param number  角标显示的数字
     */
    @Override
    public void setBadgeNumber(Context context, int number) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("tag", context.getPackageName() + "/" + Utils.getLauncherClassName(context));
            contentValues.put("count", number);
            context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"),
                    contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
