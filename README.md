# shortcut_badge_plugin

This plugin for [Flutter](https://flutter.io) adds the ability to change the badge of the app in the launcher.
It supports iOS and some Android devices (the official API does not support the feature, even on Oreo).

## installed

```yaml
dependencies:
  jmessage_flutter:
    git:
      url: git@github.com:flee-lether/shortcut_badge_plugin.git
      ref: main
```

## Getting Started

### iOS

On iOS, the notification permission is required to update the badge.
It is automatically asked when the badge is added or removed.

Please also add the following to your Info.plist:
```xml
<key>UIBackgroundModes</key>
<array>
    <string>remote-notification</string>
</array>
```


### Android

On Android, no official API exists to show a badge in the launcher. But some devices (Samsung, HTC...) support the feature.

Supported List

|brand|completed|passed|
|-----|---------|------|
|HTC|√||
|Huawei|√|√|
|Nova Launcher|√||
|OPPO|√||
|VIVO|√||
|Samsung|√||
|Sony|√||
|ZUK|√||
|XiaoMi|√|√|


### Dart

First, you just have to import the package in your dart files with:
```dart
import 'package:shortcut_badge_plugin/shortcut_badge_plugin.dart';
```

Then you can add a badge:
```dart
// show notification
ShortcutBadgePlugin.updateBadgeCount(1);
// or 
ShortcutBadgePlugin.updateBadgeCount(1, true);
// hide notification but show shortcut badge
ShortcutBadgePlugin.updateBadgeCount(1, false);
```

Remove a badge:
```dart
ShortcutBadgePlugin.removeBadge();
```
