package pers.lzp.shortcut_badge_plugin;


import android.content.Context;
import android.os.Build;

import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerDefault;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerHTC;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerHuaWei;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerNova;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerOPPO;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerSony;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerSamsung;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerVIVO;
import pers.lzp.shortcut_badge_plugin.impl.BadgeNumberManagerXiaoMi;

/**
 * 应用桌面角标设置的管理类
 * Created by zlq on 2017 17/8/23 14:50.
 */

public class BadgeNumberManager {

    private Context mContext;

    private BadgeNumberManager(Context context) {
        mContext = context;
    }

    public static BadgeNumberManager from(Context context) {
        return new BadgeNumberManager(context);
    }

    private static final IBadge IMPL;


    /**
     * 设置应用在桌面上显示的角标数字
     *
     * @param number 显示的数字
     */
    public void setBadgeNumber(int number, boolean openNotification) {
        if (openNotification) {
            BadgeNotificationManager badgeNotificationManager = new BadgeNotificationManager(mContext, number);
            IMPL.setBadgeNumber(mContext, number);
            if (number == 0) {
                badgeNotificationManager.cancelNotify();
            } else {
                badgeNotificationManager.createNotify();
            }
        } else {
            IMPL.setBadgeNumber(mContext, number);
        }
    }


    static {
        String manufacturer = Build.MANUFACTURER;
        if (manufacturer.equalsIgnoreCase(MobileBrand.HUAWEI)) {
            IMPL = new BadgeNumberManagerHuaWei();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.XIAOMI)) {
            IMPL = new BadgeNumberManagerXiaoMi();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.VIVO)) {
            IMPL = new BadgeNumberManagerVIVO();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.OPPO)) {
            IMPL = new BadgeNumberManagerOPPO();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.SONY)) {
            IMPL = new BadgeNumberManagerSony();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.NOVA)) {
            IMPL = new BadgeNumberManagerNova();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.HTC)) {
            IMPL = new BadgeNumberManagerHTC();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.SAMSUNG) || manufacturer.equalsIgnoreCase(MobileBrand.LG)) {
            IMPL = new BadgeNumberManagerSamsung();
        } else if (manufacturer.equalsIgnoreCase(MobileBrand.ZUK) || manufacturer.equalsIgnoreCase(MobileBrand.LENOVO)) {
            IMPL = new BadgeNumberManagerSamsung();
        } else {
            IMPL = new BadgeNumberManagerDefault();
        }
    }
}
