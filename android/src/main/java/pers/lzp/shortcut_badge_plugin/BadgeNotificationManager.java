package pers.lzp.shortcut_badge_plugin;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class BadgeNotificationManager {

    public final static int NOTIFY_ID = 2002;

    private Context context;

    private int number;

    private Notification notification;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public BadgeNotificationManager(Context context, int number) {
        this.context = context;
        this.number = number;
        notification = createNotification();
    }

    /**
     * 设置应用的桌面角标
     *
     */
    public Notification createNotification() {
        Notification notification = new NotificationCompat.Builder(context, "pers.lzp.shortcut_badge_plugin.badge")
                .setContentTitle("消息提醒")
                .setContentText("您有" + number + "条未读消息")
                .setNumber(number)
                .setSmallIcon(R.drawable.ic_small_notification_icon)
                .setAutoCancel(true).build();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //8.0之后添加角标需要NotificationChannel
            NotificationChannel channel = new NotificationChannel("pers.lzp.shortcut_badge_plugin.badge", "桌面角标", NotificationManager.IMPORTANCE_LOW);
            channel.setShowBadge(true);
            ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);
        }
        return notification;
    }

    /**
     * 通知消息
     */
    public void createNotify() {
        NotificationManager mNotificationManager = ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE));
        mNotificationManager.notify(NOTIFY_ID, notification);
    }

    /**
     * 取消通知消息
     */
    public void cancelNotify() {
        NotificationManager mNotificationManager = ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE));
        mNotificationManager.cancel(NOTIFY_ID);
    }
}
