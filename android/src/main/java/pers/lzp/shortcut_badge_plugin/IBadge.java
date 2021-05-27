package pers.lzp.shortcut_badge_plugin;

import android.content.Context;

public interface IBadge {

    /**
     * 设置应用的桌面角标
     *
     * @param context context
     * @param number  角标显示的数字
     */
    void setBadgeNumber(Context context, int number);
    
}
