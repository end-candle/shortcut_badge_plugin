import 'dart:async';

import 'package:flutter/services.dart';

class ShortcutBadgePlugin {
  static const MethodChannel _channel =
      const MethodChannel('end_candle/shortcut_badge_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  /// 更新图标数
  static Future<bool> updateBadgeCount(int count,
      [bool openNotification = true]) {
    return _channel.invokeMethod('updateBadgeCount',
        {"count": count, "openNotification": openNotification});
  }

  /// 移除图标
  static Future<bool> removeBadge([bool openNotification = true]) {
    return _channel
        .invokeMethod('removeBadge', {"openNotification": openNotification});
  }
}
