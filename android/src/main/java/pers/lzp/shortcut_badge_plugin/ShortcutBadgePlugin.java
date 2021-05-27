package pers.lzp.shortcut_badge_plugin;

import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/**
 * ShortcutBadgePlugin
 */
public class ShortcutBadgePlugin implements FlutterPlugin, MethodCallHandler {
    public static final String CHANNEL_NAME = "end_candle/shortcut_badge_plugin";
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private MethodChannel channel;

    private Context context;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), CHANNEL_NAME);
        channel.setMethodCallHandler(this);
        context = flutterPluginBinding.getApplicationContext();
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        switch (call.method) {
            case "getPlatformVersion":
                result.success("Android " + android.os.Build.VERSION.RELEASE);
                break;
            case "updateBadgeCount":
                updateBadgeCount(call, result);
                break;
            case "removeBadge":
                removeBadge(call, result);
                break;
            default:
                result.notImplemented();
        }
    }

    /**
     * 移除app图标显示
     *
     * @param call   flutter调用栈
     * @param result 结果返回
     */
    private void removeBadge(@NonNull MethodCall call, @NonNull Result result) {
        BadgeNumberManager.from(context).setBadgeNumber(0, Boolean.parseBoolean(String.valueOf(call.argument("openNotification"))));
        result.success(null);
    }

    /**
     * 更新app图标显示
     *
     * @param call   flutter调用栈
     * @param result 结果返回
     */
    private void updateBadgeCount(@NonNull MethodCall call, @NonNull Result result) {
        BadgeNumberManager.from(context).setBadgeNumber(Integer.parseInt(String.valueOf(call.argument("count"))), Boolean.parseBoolean(String.valueOf(call.argument("openNotification"))));
        result.success(null);
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }
}
