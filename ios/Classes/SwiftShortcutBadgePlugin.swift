import Flutter
import UIKit

public class SwiftShortcutBadgePlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "end_candle/shortcut_badge_plugin", binaryMessenger: registrar.messenger())
    let instance = SwiftShortcutBadgePlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    switch call.method {
      case "updateBadge":
        if let args = call.arguments as? Dictionary<String, Any>,
          let count = args["count"] as? Int {
          UIApplication.shared.applicationIconBadgeNumber = count
          result(nil)
        } else {
          result(FlutterError.init(code: "bad args", message: nil, details: nil))
        }
      case "removeBadge":
        UIApplication.shared.applicationIconBadgeNumber = 0
        result(nil)
      case "getPlatformVersion":
        result("iOS " + UIDevice.current.systemVersion)
      default:
        result(FlutterMethodNotImplemented)
    }
  }
}
