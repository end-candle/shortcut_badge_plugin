package pers.lzp.shortcut_badge_plugin.impl;

import android.app.Notification;
import android.content.Context;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import pers.lzp.shortcut_badge_plugin.BadgeNotificationManager;
import pers.lzp.shortcut_badge_plugin.IBadge;

/**
 * 小米机型的桌面角标设置管理类
 * Created by zlq on 2017 17/8/23 16:35.
 */

public class BadgeNumberManagerXiaoMi implements IBadge {

    public void setBadgeNumber(Notification notification, int number) {
        try {
            Field field = notification.getClass().getDeclaredField("extraNotification");
            Object extraNotification = field.get(notification);
            Method method = extraNotification.getClass().getDeclaredMethod("setMessageCount", int.class);
            method.invoke(extraNotification, number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置应用的桌面角标
     *
     * @param context  context
     * @param number   角标显示的数字
     */
    @Override
    public void setBadgeNumber(Context context, int number) {
        BadgeNotificationManager badgeNotificationManager = new BadgeNotificationManager(context, number);
        setBadgeNumber(badgeNotificationManager.getNotification(), number);
        if (number == 0) {
            badgeNotificationManager.cancelNotify();
        } else {
            badgeNotificationManager.createNotify();
        }
    }
}