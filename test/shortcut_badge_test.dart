import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:shortcut_badge_plugin/shortcut_badge_plugin.dart';

void main() {
  const MethodChannel channel = MethodChannel('shortcut_badge_plugin');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await ShortcutBadgePlugin.platformVersion, '42');
  });
}
