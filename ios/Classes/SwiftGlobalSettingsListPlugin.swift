import Flutter
import UIKit

public class SwiftGlobalSettingsListPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "pln.com/global_settings_list", binaryMessenger: registrar.messenger())
    let instance = SwiftGlobalSettingsListPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("iOS " + UIDevice.current.systemVersion)
  }
}
