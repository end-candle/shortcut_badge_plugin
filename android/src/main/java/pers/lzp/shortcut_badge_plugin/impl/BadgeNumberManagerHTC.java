package pers.lzp.shortcut_badge_plugin.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import pers.lzp.shortcut_badge_plugin.IBadge;
import pers.lzp.shortcut_badge_plugin.Utils;


/**
 * HTC机型的桌面角标设置管理类
 */

public class BadgeNumberManagerHTC implements IBadge {

    /**
     * 设置应用的桌面角标
     *
     * @param context context
     * @param number  角标显示的数字
     */
    @Override
    public void setBadgeNumber(Context context, int number) {
        try {
            Intent intentNotification = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
            ComponentName localComponentName = new ComponentName(context.getPackageName(), Utils.getLauncherClassName(context));
            intentNotification.putExtra("com.htc.launcher.extra.COMPONENT", localComponentName.flattenToShortString());
            intentNotification.putExtra("com.htc.launcher.extra.COUNT", number);
            context.sendBroadcast(intentNotification);

            Intent intentShortcut = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
            intentShortcut.putExtra("packagename", context.getPackageName());
            intentShortcut.putExtra("count", number);
            context.sendBroadcast(intentShortcut);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

