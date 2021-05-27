package pers.lzp.shortcut_badge_plugin.impl;

import android.content.Context;
import android.content.Intent;

import pers.lzp.shortcut_badge_plugin.IBadge;

/**
 * vivo机型的桌面角标设置管理类
 */
public class BadgeNumberManagerVIVO implements IBadge {

    @Override
    public void setBadgeNumber(Context context, int number) {
        try {
            Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", context.getPackageName());
            String launchClassName = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent().getClassName();
            intent.putExtra("className", launchClassName);
            intent.putExtra("notificationNum", number);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
