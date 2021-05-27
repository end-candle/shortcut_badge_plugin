package pers.lzp.shortcut_badge_plugin.impl;

import android.content.Context;
import android.content.Intent;

import pers.lzp.shortcut_badge_plugin.IBadge;
import pers.lzp.shortcut_badge_plugin.Utils;


/**
 * Samsung机型的桌面角标设置管理类
 */

public class BadgeNumberManagerSamsung implements IBadge {

    /**
     * 设置应用的桌面角标
     *
     * @param context context
     * @param number  角标显示的数字
     */
    @Override
    public void setBadgeNumber(Context context, int number) {
        try {
            // 获取你当前的应用
            String launcherClassName = Utils.getLauncherClassName(context);
            if (launcherClassName == null) {
                return;
            }
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", number);
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", launcherClassName);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
