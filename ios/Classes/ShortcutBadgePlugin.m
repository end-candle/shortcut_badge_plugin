#import "ShortcutBadgePlugin.h"
#if __has_include(<shortcut_badge_plugin/shortcut_badge_plugin-Swift.h>)
#import <shortcut_badge_plugin/shortcut_badge_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "shortcut_badge_plugin-Swift.h"
#endif

@implementation ShortcutBadgePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftShortcutBadgePlugin registerWithRegistrar:registrar];
}
@end
