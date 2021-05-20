import 'dart:async';
import 'dart:convert';

import 'package:flutter/services.dart';

class GlobalSettingsList {
  static const MethodChannel _channel =
      const MethodChannel('pln.com/global_settings_list');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  ///return adb_enabled 1 : true, 0 : false
  static Future<String?> get adbEnabled async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "adb_enabled"});
    return result;
  }

  ///return airplane_mode_on 1 : true, 0 : false
  static Future<String?> get airplaneModeOn async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "airplane_mode_on"});
    return result;
  }

  //return airplane_mode_radios
  static Future<String?> get airplaneModeRadios async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "airplane_mode_radios"});
    return result;
  }

  //return always_finish_activities
  static Future<String?> get alwaysFinishActivities async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "always_finish_activities"});
    return result;
  }

  //return float of scale animator_duration_scale
  static Future<String?> get animatorDurationScale async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "animator_duration_scale"});
    return result;
  }

  //return auto_time. 1 : true, 0 : false
  static Future<String?> get autoTime async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "auto_time"});
    return result;
  }

  //return auto_time_zone. 1 : true, 0 : false
  static Future<String?> get autoTimeZone async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "auto_time_zone"});
    return result;
  }

  //return bluetooth_on. 1 : true, 0 : false
  static Future<String?> get bluetoothOn async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "bluetooth_on"});
    return result;
  }

  //return boot_count. get boot count
  static Future<String?> get bootCount async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "boot_count"});
    return result;
  }

  //return contact_metadata_sync_enabled
  static Future<String?> get contactMetadataSyncEnabled async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "contact_metadata_sync_enabled"});
    return result;
  }

  //return data_roaming
  static Future<String?> get dataRoaming async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "data_roaming"});
    return result;
  }

  //return debug_app
  static Future<String?> get debugApp async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "debug_app"});
    return result;
  }

  //return development_settings_enabled. 1 : true, 0 : false
  static Future<String?> get developmentSettingsEnabled async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "development_settings_enabled"});
    return result;
  }

  //return string of device_name
  static Future<String?> get deviceName async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "device_name"});
    return result;
  }

  //return device_provisioned
  static Future<String?> get deviceProvisioned async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "device_provisioned"});
    return result;
  }

  //return string of http_proxy
  static Future<String?> get httpProxy async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "http_proxy"});
    return result;
  }

  //return install_non_market_apps. 1 : true, 0 : false
  static Future<String?> get installNonMarketApps async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "install_non_market_apps"});
    return result;
  }

  //return mode_ringer
  static Future<String?> get modeRinger async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "mode_ringer"});
    return result;
  }

  //return network_preference
  static Future<String?> get networkPreference async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "network_preference"});
    return result;
  }

  //return radio_bluetooth
  static Future<String?> get radioBluetooth async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "radio_bluetooth"});
    return result;
  }

  //return radio_cell
  static Future<String?> get radioCell async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "radio_cell"});
    return result;
  }

  //return radio_nfc
  static Future<String?> get radioNfc async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "radio_nfc"});
    return result;
  }

  //return radio_wifi
  static Future<String?> get radioWifi async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "radio_wifi"});
    return result;
  }

  //return show_processes
  static Future<String?> get showProcesses async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "show_processes"});
    return result;
  }

  //return stay_on_while_plugged_in, 1 : true, 0 : false
  static Future<String?> get stayOnWhilePluggedIn async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "stay_on_while_plugged_in"});
    return result;
  }

  //return transition_animation_scale, String float of transition animation scale
  static Future<String?> get transitionAnimationScale async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "transition_animation_scale"});
    return result;
  }

  //return usb_mass_storage_enabled, 1 : true, 0 : false
  static Future<String?> get usbMassStorageEnabled async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "usb_mass_storage_enabled"});
    return result;
  }

  //return use_google_mail
  static Future<String?> get useGoogleMail async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "use_google_mail"});
    return result;
  }

  //return wait_for_debugger
  static Future<String?> get waitForDebugger async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "wait_for_debugger"});
    return result;
  }

  //return wifi_device_owner_configs_lockdown
  static Future<String?> get wifiDeviceOwnerConfigsLockdown async {
    final String? result = await _channel.invokeMethod(
        "get", {"setting_name": "wifi_device_owner_configs_lockdown"});
    return result;
  }

  //return wifi_max_dhcp_retry_count, number of dhcp retry
  static Future<String?> get wifiMaxDhcpRetryCount async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "wifi_max_dhcp_retry_count"});
    return result;
  }

  //return wifi_mobile_data_transition_wakelock_timeout_ms
  static Future<String?> get wifiMobileDataTransitionWakelockTimeoutMs async {
    final String? result = await _channel.invokeMethod("get",
        {"setting_name": "wifi_mobile_data_transition_wakelock_timeout_ms"});
    return result;
  }

  //return wifi_networks_available_notification_on
  static Future<String?> get wifiNetworksAvailableNotificationOn async {
    final String? result = await _channel.invokeMethod(
        "get", {"setting_name": "wifi_networks_available_notification_on"});
    return result;
  }

  //return wifi_networks_available_repeat_delay
  static Future<String?> get wifiNetworksAvailableRepeatDelay async {
    final String? result = await _channel.invokeMethod(
        "get", {"setting_name": "wifi_networks_available_repeat_delay"});
    return result;
  }

  //return wifi_num_open_networks_kept
  static Future<String?> get wifiNumOpenNetworksKept async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "wifi_num_open_networks_kept"});
    return result;
  }

  //return wifi_on. 1 : true, 0 : false
  static Future<String?> get wifiOn async {
    final String? result =
        await _channel.invokeMethod("get", {"setting_name": "wifi_on"});
    return result;
  }

  //return wifi_sleep_policy
  static Future<String?> get wifiSleepPolicy async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "wifi_sleep_policy"});
    return result;
  }

  //return wifi_watchdog_on
  static Future<String?> get wifiWatchdogOn async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "wifi_watchdog_on"});
    return result;
  }

  //return window_animation_scale
  static Future<String?> get windowAnimationScale async {
    final String? result = await _channel
        .invokeMethod("get", {"setting_name": "window_animation_scale"});
    return result;
  }

  //return Map<String, dynamic>, the list of Settings.Global
  static Future<Map<String, dynamic>> get list async {
    final result = await _channel.invokeMethod('getList');
    Map<String, dynamic> map = json.decode(json.encode(result));
    //List<dynamic>.from(result.map<dynamic>(dynamic item)=>item);
    //print(map);
    return map;
  }
}
