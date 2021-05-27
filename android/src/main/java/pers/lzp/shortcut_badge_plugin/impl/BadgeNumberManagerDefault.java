package pers.lzp.shortcut_badge_plugin.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

import io.flutter.Log;
import pers.lzp.shortcut_badge_plugin.IBadge;
import pers.lzp.shortcut_badge_plugin.Utils;

/**
 * 默认机型的桌面角标设置管理类
 */

public class BadgeNumberManagerDefault implements IBadge {

    @Override
    public void setBadgeNumber(Context context, int number) {
        try {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", number);
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", Utils.getLauncherClassName(context));
            if (canResolveBroadcast(context, intent)) {
                context.sendBroadcast(intent);
            } else {
                Log.e("Default" + " Badge error", "unable to resolve intent: " + intent.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean canResolveBroadcast(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> receivers = packageManager.queryBroadcastReceivers(intent, 0);
        return receivers.size() > 0;
    }

}
