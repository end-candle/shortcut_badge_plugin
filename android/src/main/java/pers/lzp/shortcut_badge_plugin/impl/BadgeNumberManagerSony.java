package pers.lzp.shortcut_badge_plugin.impl;

import android.content.Context;
import android.content.Intent;

import pers.lzp.shortcut_badge_plugin.IBadge;
import pers.lzp.shortcut_badge_plugin.Utils;

/**
 * 索尼机型的桌面角标设置管理类
 */

public class BadgeNumberManagerSony implements IBadge {

    /**
     * 设置应用的桌面角标
     *
     * @param context context
     * @param number  角标显示的数字
     */
    @Override
    public void setBadgeNumber(Context context, int number) {
        try {
            String launcherClassName = Utils.getLauncherClassName(context);
            if (launcherClassName == null) {
                return;
            }
            boolean isShow = true;
            if (number == 0) {
                isShow = false;
            }
            Intent localIntent = new Intent();
            localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
            localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", isShow);//是否显示
            localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", launcherClassName);//启动页
            localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(number));//数字
            localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", context.getPackageName());//包名
            context.sendBroadcast(localIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
