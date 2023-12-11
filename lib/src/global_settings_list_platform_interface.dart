import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'global_settings_list_method_channel.dart';

abstract class GlobalSettingsListPlatform extends PlatformInterface {
  /// Constructs a AppSettingsLocalPlatform.
  GlobalSettingsListPlatform() : super(token: _token);

  static final Object _token = Object();

  static GlobalSettingsListPlatform _instance = MethodChannelAppSettingsLocal();

  /// The default instance of [GlobalSettingsListPlatform] to use.
  ///
  /// Defaults to [MethodChannelAppSettingsLocal].
  static GlobalSettingsListPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [GlobalSettingsListPlatform] when
  /// they register themselves.
  static set instance(GlobalSettingsListPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }

  ///return adb_enabled || adb_wifi_enabled
  Future<bool?> get getAdbStatus {
    throw UnimplementedError('getAdbStatus() has not been implemented.');
  }

  ///return adb_enabled 1 : true, 0 : false
  Future<String?> get adbEnabled {
    throw UnimplementedError('adbEnabled() has not been implemented.');
  }

  ///return airplane_mode_on 1 : true, 0 : false
  Future<String?> get airplaneModeOn {
    throw UnimplementedError('airplaneModeOn() has not been implemented.');
  }

  //return airplane_mode_radios
  Future<String?> get airplaneModeRadios {
    throw UnimplementedError('airplaneModeRadios() has not been implemented.');
  }

  //return always_finish_activities
  Future<String?> get alwaysFinishActivities {
    throw UnimplementedError('alwaysFinishActivities() has not been implemented.');
  }

  //return float of scale animator_duration_scale
  Future<String?> get animatorDurationScale {
    throw UnimplementedError('animatorDurationScale() has not been implemented.');
  }

  //return auto_time. 1 : true, 0 : false
  Future<String?> get autoTime {
    throw UnimplementedError('autoTime() has not been implemented.');
  }

  //return auto_time_zone. 1 : true, 0 : false
  Future<String?> get autoTimeZone {
    throw UnimplementedError('autoTimeZone() has not been implemented.');
  }

  //return bluetooth_on. 1 : true, 0 : false
  Future<String?> get bluetoothOn {
    throw UnimplementedError('bluetoothOn() has not been implemented.');
  }

  //return boot_count. get boot count
  Future<String?> get bootCount {
    throw UnimplementedError('bootCount() has not been implemented.');
  }

  //return contact_metadata_sync_enabled
  Future<String?> get contactMetadataEnabled {
    throw UnimplementedError('contactMetadataEnabled() has not been implemented.');
  }

  //return data_roaming
  Future<String?> get dataRoaming {
    throw UnimplementedError('dataRoaming() has not been implemented.');
  }

  //return debug_app
  Future<String?> get debugApp {
    throw UnimplementedError('debugApp() has not been implemented.');
  }

  //return development_settings_enabled. 1 : true, 0 : false
  Future<String?> get developmentSettingsEnabled {
    throw UnimplementedError('developmentSettingsEnabled() has not been implemented.');
  }

  //return string of device_name
  Future<String?> get deviceName {
    throw UnimplementedError('deviceName() has not been implemented.');
  }

  //return device_provisioned
  Future<String?> get deviceProvisioned {
    throw UnimplementedError('deviceProvisioned() has not been implemented.');
  }

  //return string of http_proxy
  Future<String?> get httpProxy {
    throw UnimplementedError('httpProxy() has not been implemented.');
  }

  //return install_non_market_apps. 1 : true, 0 : false
  Future<String?> get installNonMarketApps {
    throw UnimplementedError('installNonMarketApps() has not been implemented.');
  }

  //return mode_ringer
  Future<String?> get modeRinger {
    throw UnimplementedError('modeRinger() has not been implemented.');
  }

  //return network_preference
  Future<String?> get networkPreference {
    throw UnimplementedError('networkPreference() has not been implemented.');
  }

  //return radio_bluetooth
  Future<String?> get radioBluetooth {
    throw UnimplementedError('radioBluetooth() has not been implemented.');
  }

  //return radio_cell
  Future<String?> get radioCell {
    throw UnimplementedError('radioCell() has not been implemented.');
  }

  //return radio_nfc
  Future<String?> get radioNfc {
    throw UnimplementedError('radioNfc() has not been implemented.');
  }

  //return radio_wifi
  Future<String?> get radioWifi {
    throw UnimplementedError('radioWifi() has not been implemented.');
  }

  //return show_processes
  Future<String?> get showProcesses {
    throw UnimplementedError('showProcesses() has not been implemented.');
  }

  //return stay_on_while_plugged_in, 1 : true, 0 : false
  Future<String?> get stayOnWhilePluggedIn {
    throw UnimplementedError('stayOnWhilePluggedIn() has not been implemented.');
  }

  //return transition_animation_scale, String float of transition animation scale
  Future<String?> get transitionAnimationScale {
    throw UnimplementedError('transitionAnimationScale() has not been implemented.');
  }

  //return usb_mass_storage_enabled, 1 : true, 0 : false
  Future<String?> get usbMassStorageEnabled {
    throw UnimplementedError('usbMassStorageEnabled() has not been implemented.');
  }

  //return use_google_mail
  Future<String?> get useGoogleMail {
    throw UnimplementedError('useGoogleMail() has not been implemented.');
  }

  //return wait_for_debugger
  Future<String?> get waitForDebugger {
    throw UnimplementedError('waitForDebugger() has not been implemented.');
  }

  //return wifi_device_owner_configs_lockdown
  Future<String?> get wifiDeviceOwnerConfigsLockdown {
    throw UnimplementedError('wifiDeviceOwnerConfigsLockdown() has not been implemented.');
  }

  //return wifi_max_dhcp_retry_count, number of dhcp retry
  Future<String?> get wifiMaxDhcpRetryCount {
    throw UnimplementedError('wifiMaxDhcpRetryCount() has not been implemented.');
  }

  //return wifi_mobile_data_transition_wakelock_timeout_ms
  Future<String?> get wifiMobileDataTransitionWakelockTimeoutMs {
    throw UnimplementedError('wifiMobileDataTransitionWakelockTimeoutMs() has not been implemented.');
  }

  //return wifi_networks_available_notification_on
  Future<String?> get wifiNetworksAvailableNotificationOn {
    throw UnimplementedError('wifiNetworksAvailableNotificationOn() has not been implemented.');
  }

  //return wifi_networks_available_repeat_delay
  Future<String?> get wifiNetworksAvailableRepeatDelay {
    throw UnimplementedError('wifiNetworksAvailableRepeatDelay() has not been implemented.');
  }

  //return wifi_num_open_networks_kept
  Future<String?> get wifiNumOpenNetworksKept {
    throw UnimplementedError('wifiNumOpenNetworksKept() has not been implemented.');
  }

  //return wifi_on. 1 : true, 0 : false
  Future<String?> get wifiOn {
    throw UnimplementedError('wifiOn() has not been implemented.');
  }

  //return wifi_sleep_policy
  Future<String?> get wifiSleepPolicy {
    throw UnimplementedError('wifiSleepPolicy() has not been implemented.');
  }

  //return wifi_watchdog_on
  Future<String?> get wifiWatchdogOn {
    throw UnimplementedError('wifiWatchdogOn() has not been implemented.');
  }

  //return window_animation_scale
  Future<String?> get windowAnimationScale {
    throw UnimplementedError('windowAnimationScale() has not been implemented.');
  }

  //return Map<String, dynamic>, the list of Settings.Global
  Future<Map<String, dynamic>> get list {
    throw UnimplementedError('list() has not been implemented.');
  }
}
