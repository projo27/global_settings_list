import 'global_settings_list_platform_interface.dart';

class GlobalSettingsList {
  Future<String?> getPlatformVersion() {
    return GlobalSettingsListPlatform.instance.getPlatformVersion();
  }

  ///return adb_enabled || adb_wifi_enabled
  static Future<bool?> get getAdbStatus {
    return GlobalSettingsListPlatform.instance.getAdbStatus;
  }

  ///return adb_enabled 1 : true, 0 : false
  static Future<String?> get adbEnabled {
    return GlobalSettingsListPlatform.instance.adbEnabled;
  }

  ///return airplane_mode_on 1 : true, 0 : false
  static Future<String?> get airplaneModeOn {
    return GlobalSettingsListPlatform.instance.airplaneModeOn;
  }

  //return airplane_mode_radios
  static Future<String?> get airplaneModeRadios {
    return GlobalSettingsListPlatform.instance.airplaneModeRadios;
  }

  //return always_finish_activities
  static Future<String?> get alwaysFinishActivities {
    return GlobalSettingsListPlatform.instance.alwaysFinishActivities;
  }

  //return float of scale animator_duration_scale
  static Future<String?> get animatorDurationScale {
    return GlobalSettingsListPlatform.instance.animatorDurationScale;
  }

  //return auto_time. 1 : true, 0 : false
  static Future<String?> get autoTime {
    return GlobalSettingsListPlatform.instance.autoTime;
  }

  //return auto_time_zone. 1 : true, 0 : false
  static Future<String?> get autoTimeZone {
    return GlobalSettingsListPlatform.instance.autoTimeZone;
  }

  //return bluetooth_on. 1 : true, 0 : false
  static Future<String?> get bluetoothOn {
    return GlobalSettingsListPlatform.instance.bluetoothOn;
  }

  //return boot_count. get boot count
  static Future<String?> get bootCount {
    return GlobalSettingsListPlatform.instance.bootCount;
  }

  //return contact_metadata_sync_enabled
  static Future<String?> get contactMetadataEnabled {
    return GlobalSettingsListPlatform.instance.contactMetadataEnabled;
  }

  //return data_roaming
  static Future<String?> get dataRoaming {
    return GlobalSettingsListPlatform.instance.dataRoaming;
  }

  //return debug_app
  static Future<String?> get debugApp {
    return GlobalSettingsListPlatform.instance.debugApp;
  }

  //return development_settings_enabled. 1 : true, 0 : false
  static Future<String?> get developmentSettingsEnabled {
    return GlobalSettingsListPlatform.instance.developmentSettingsEnabled;
  }

  //return string of device_name
  static Future<String?> get deviceName {
    return GlobalSettingsListPlatform.instance.deviceName;
  }

  //return device_provisioned
  static Future<String?> get deviceProvisioned {
    return GlobalSettingsListPlatform.instance.deviceProvisioned;
  }

  //return string of http_proxy
  static Future<String?> get httpProxy {
    return GlobalSettingsListPlatform.instance.httpProxy;
  }

  //return install_non_market_apps. 1 : true, 0 : false
  static Future<String?> get installNonMarketApps {
    return GlobalSettingsListPlatform.instance.installNonMarketApps;
  }

  //return mode_ringer
  static Future<String?> get modeRinger {
    return GlobalSettingsListPlatform.instance.modeRinger;
  }

  //return network_preference
  static Future<String?> get networkPreference {
    return GlobalSettingsListPlatform.instance.networkPreference;
  }

  //return radio_bluetooth
  static Future<String?> get radioBluetooth {
    return GlobalSettingsListPlatform.instance.radioBluetooth;
  }

  //return radio_cell
  static Future<String?> get radioCell {
    return GlobalSettingsListPlatform.instance.radioCell;
  }

  //return radio_nfc
  static Future<String?> get radioNfc {
    return GlobalSettingsListPlatform.instance.radioNfc;
  }

  //return radio_wifi
  static Future<String?> get radioWifi {
    return GlobalSettingsListPlatform.instance.radioWifi;
  }

  //return show_processes
  static Future<String?> get showProcesses {
    return GlobalSettingsListPlatform.instance.showProcesses;
  }

  //return stay_on_while_plugged_in, 1 : true, 0 : false
  static Future<String?> get stayOnWhilePluggedIn {
    return GlobalSettingsListPlatform.instance.stayOnWhilePluggedIn;
  }

  //return transition_animation_scale, String float of transition animation scale
  static Future<String?> get transitionAnimationScale {
    return GlobalSettingsListPlatform.instance.transitionAnimationScale;
  }

  //return usb_mass_storage_enabled, 1 : true, 0 : false
  static Future<String?> get usbMassStorageEnabled {
    return GlobalSettingsListPlatform.instance.usbMassStorageEnabled;
  }

  //return use_google_mail
  static Future<String?> get useGoogleMail {
    return GlobalSettingsListPlatform.instance.useGoogleMail;
  }

  //return wait_for_debugger
  static Future<String?> get waitForDebugger {
    return GlobalSettingsListPlatform.instance.waitForDebugger;
  }

  //return wifi_device_owner_configs_lockdown
  static Future<String?> get wifiDeviceOwnerConfigsLockdown {
    return GlobalSettingsListPlatform.instance.wifiDeviceOwnerConfigsLockdown;
  }

  //return wifi_max_dhcp_retry_count, number of dhcp retry
  static Future<String?> get wifiMaxDhcpRetryCount {
    return GlobalSettingsListPlatform.instance.wifiMaxDhcpRetryCount;
  }

  //return wifi_mobile_data_transition_wakelock_timeout_ms
  static Future<String?> get wifiMobileDataTransitionWakelockTimeoutMs {
    return GlobalSettingsListPlatform.instance.wifiMobileDataTransitionWakelockTimeoutMs;
  }

  //return wifi_networks_available_notification_on
  static Future<String?> get wifiNetworksAvailableNotificationOn {
    return GlobalSettingsListPlatform.instance.wifiNetworksAvailableNotificationOn;
  }

  //return wifi_networks_available_repeat_delay
  static Future<String?> get wifiNetworksAvailableRepeatDelay {
    return GlobalSettingsListPlatform.instance.wifiNetworksAvailableRepeatDelay;
  }

  //return wifi_num_open_networks_kept
  static Future<String?> get wifiNumOpenNetworksKept {
    return GlobalSettingsListPlatform.instance.wifiNumOpenNetworksKept;
  }

  //return wifi_on. 1 : true, 0 : false
  static Future<String?> get wifiOn {
    return GlobalSettingsListPlatform.instance.wifiOn;
  }

  //return wifi_sleep_policy
  static Future<String?> get wifiSleepPolicy {
    return GlobalSettingsListPlatform.instance.wifiSleepPolicy;
  }

  //return wifi_watchdog_on
  static Future<String?> get wifiWatchdogOn {
    return GlobalSettingsListPlatform.instance.wifiWatchdogOn;
  }

  //return window_animation_scale
  static Future<String?> get windowAnimationScale {
    return GlobalSettingsListPlatform.instance.windowAnimationScale;
  }

  //return Map<String, dynamic>, the list of Settings.Global
  static Future<Map<String, dynamic>> get list {
    return GlobalSettingsListPlatform.instance.list;
  }
}
