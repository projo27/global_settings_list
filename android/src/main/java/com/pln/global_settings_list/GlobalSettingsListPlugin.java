package com.pln.global_settings_list;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** GlobalSettingsListPlugin */
public class GlobalSettingsListPlugin implements FlutterPlugin, MethodCallHandler {
    MethodChannel channel;
    ContentResolver contentResolver;
    Map<String, Object> list = new HashMap<String, Object>();
  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    setupMethodChannel(
            flutterPluginBinding.getFlutterEngine().getDartExecutor(),
            flutterPluginBinding.getApplicationContext().getContentResolver()
    );
  }

  public static void registerWith(Registrar registrar) {
    GlobalSettingsListPlugin plugin = new GlobalSettingsListPlugin();
    plugin.setupMethodChannel(registrar.messenger(), registrar.context().getContentResolver());
  }

  @SuppressLint("MethodCall")
  @Override
  public void onMethodCall(MethodCall call, MethodChannel.Result result) {
      listGlobal();
    if(call.method.equals("get")){
        result.success(list.get(call.argument("setting_name").toString().toLowerCase()));
    }
    else if(call.method.equals("getList")){
        result.success(list);
    }
    else if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }
    else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
      channel.setMethodCallHandler(null);
      channel = null;
  }

  private void setupMethodChannel(BinaryMessenger messenger, ContentResolver contentResolver){
    Log.d("Paijo", "Setup Method Channel");
    channel = new MethodChannel(messenger, "pln.com/global_settings_list");
    this.contentResolver = contentResolver;
    channel.setMethodCallHandler(this);
    listGlobal();
  }

  @SuppressLint("Deprecation")
  private void listGlobal(){
      if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
          listGlobalSettings();
      else
          listGlobalSettingsOld();
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
  private void listGlobalSettings(){
      list.put("adb_enabled", Settings.Global.getString(contentResolver, Settings.Global.ADB_ENABLED));
      list.put("airplane_mode_on", Settings.Global.getString(contentResolver, Settings.Global.AIRPLANE_MODE_ON));
      list.put("airplane_mode_radios", Settings.Global.getString(contentResolver, Settings.Global.AIRPLANE_MODE_RADIOS));
      list.put("always_finish_activities", Settings.Global.getString(contentResolver, Settings.Global.ALWAYS_FINISH_ACTIVITIES));
      list.put("animator_duration_scale", Settings.Global.getString(contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE));
      list.put("auto_time", Settings.Global.getString(contentResolver, Settings.Global.AUTO_TIME));
      list.put("auto_time_zone", Settings.Global.getString(contentResolver, Settings.Global.AUTO_TIME_ZONE));
      list.put("bluetooth_on", Settings.Global.getString(contentResolver, Settings.Global.BLUETOOTH_ON));
      list.put("boot_count", Settings.Global.getString(contentResolver, Settings.Global.BOOT_COUNT));
      list.put("contact_metadata_sync_enabled", Settings.Global.getString(contentResolver, Settings.Global.CONTACT_METADATA_SYNC_ENABLED));
      list.put("data_roaming", Settings.Global.getString(contentResolver, Settings.Global.DATA_ROAMING));
      list.put("debug_app", Settings.Global.getString(contentResolver, Settings.Global.DEBUG_APP));
      list.put("development_settings_enabled", Settings.Global.getString(contentResolver, Settings.Global.DEVELOPMENT_SETTINGS_ENABLED));
      list.put("device_name", Settings.Global.getString(contentResolver, Settings.Global.DEVICE_NAME));
      list.put("device_provisioned", Settings.Global.getString(contentResolver, Settings.Global.DEVICE_PROVISIONED));
      list.put("http_proxy", Settings.Global.getString(contentResolver, Settings.Global.HTTP_PROXY));
      list.put("install_non_market_apps", Settings.Global.getString(contentResolver, Settings.Global.INSTALL_NON_MARKET_APPS));
      list.put("mode_ringer", Settings.Global.getString(contentResolver, Settings.Global.MODE_RINGER));
      list.put("network_preference", Settings.Global.getString(contentResolver, Settings.Global.NETWORK_PREFERENCE));
      list.put("radio_bluetooth", Settings.Global.getString(contentResolver, Settings.Global.RADIO_BLUETOOTH));
      list.put("radio_cell", Settings.Global.getString(contentResolver, Settings.Global.RADIO_CELL));
      list.put("radio_nfc", Settings.Global.getString(contentResolver, Settings.Global.RADIO_NFC));
      list.put("radio_wifi", Settings.Global.getString(contentResolver, Settings.Global.RADIO_WIFI));
      list.put("show_processes", Settings.Global.getString(contentResolver, Settings.Global.SHOW_PROCESSES));
      list.put("stay_on_while_plugged_in", Settings.Global.getString(contentResolver, Settings.Global.STAY_ON_WHILE_PLUGGED_IN));
      list.put("transition_animation_scale", Settings.Global.getString(contentResolver, Settings.Global.TRANSITION_ANIMATION_SCALE));
      list.put("usb_mass_storage_enabled", Settings.Global.getString(contentResolver, Settings.Global.USB_MASS_STORAGE_ENABLED));
      list.put("use_google_mail", Settings.Global.getString(contentResolver, Settings.Global.USE_GOOGLE_MAIL));
      list.put("wait_for_debugger", Settings.Global.getString(contentResolver, Settings.Global.WAIT_FOR_DEBUGGER));
      list.put("wifi_device_owner_configs_lockdown", Settings.Global.getString(contentResolver, Settings.Global.WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN));
      list.put("wifi_max_dhcp_retry_count", Settings.Global.getString(contentResolver, Settings.Global.WIFI_MAX_DHCP_RETRY_COUNT));
      list.put("wifi_mobile_data_transition_wakelock_timeout_ms", Settings.Global.getString(contentResolver, Settings.Global.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS));
      list.put("wifi_networks_available_notification_on", Settings.Global.getString(contentResolver, Settings.Global.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON));
      list.put("wifi_networks_available_repeat_delay", Settings.Global.getString(contentResolver, Settings.Global.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY));
      list.put("wifi_num_open_networks_kept", Settings.Global.getString(contentResolver, Settings.Global.WIFI_NUM_OPEN_NETWORKS_KEPT));
      list.put("wifi_on", Settings.Global.getString(contentResolver, Settings.Global.WIFI_ON));
      list.put("wifi_sleep_policy", Settings.Global.getString(contentResolver, Settings.Global.WIFI_SLEEP_POLICY));
      list.put("wifi_watchdog_on", Settings.Global.getString(contentResolver, Settings.Global.WIFI_WATCHDOG_ON));
      list.put("window_animation_scale", Settings.Global.getString(contentResolver, Settings.Global.WINDOW_ANIMATION_SCALE));
  }

  private void listGlobalSettingsOld(){
      list.put("adb_enabled", Settings.System.getString(contentResolver, Settings.System.ADB_ENABLED));
      list.put("airplane_mode_on", Settings.System.getString(contentResolver, Settings.System.AIRPLANE_MODE_ON));
      list.put("airplane_mode_radios", Settings.System.getString(contentResolver, Settings.System.AIRPLANE_MODE_RADIOS));
      list.put("always_finish_activities", Settings.System.getString(contentResolver, Settings.System.ALWAYS_FINISH_ACTIVITIES));
      list.put("animator_duration_scale", Settings.System.getString(contentResolver, Settings.System.ANIMATOR_DURATION_SCALE));
      list.put("auto_time", Settings.System.getString(contentResolver, Settings.System.AUTO_TIME));
      list.put("auto_time_zone", Settings.System.getString(contentResolver, Settings.System.AUTO_TIME_ZONE));
      list.put("bluetooth_on", Settings.System.getString(contentResolver, Settings.System.BLUETOOTH_ON));
      list.put("boot_count", Settings.System.getString(contentResolver, Settings.Global.BOOT_COUNT));
      list.put("contact_metadata_sync_enabled", Settings.System.getString(contentResolver, Settings.Global.CONTACT_METADATA_SYNC_ENABLED));
      list.put("data_roaming", Settings.System.getString(contentResolver, Settings.System.DATA_ROAMING));
      list.put("debug_app", Settings.System.getString(contentResolver, Settings.System.DEBUG_APP));
      list.put("development_settings_enabled", Settings.System.getString(contentResolver, Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED));
      list.put("device_name", Settings.System.getString(contentResolver, Build.MODEL));
      list.put("device_provisioned", Settings.System.getString(contentResolver, Settings.System.DEVICE_PROVISIONED));
      list.put("http_proxy", Settings.System.getString(contentResolver, Settings.System.HTTP_PROXY));
      list.put("install_non_market_apps", Settings.System.getString(contentResolver, Settings.System.INSTALL_NON_MARKET_APPS));
      list.put("mode_ringer", Settings.System.getString(contentResolver, Settings.System.MODE_RINGER));
      list.put("network_preference", Settings.System.getString(contentResolver, Settings.System.NETWORK_PREFERENCE));
      list.put("radio_bluetooth", Settings.System.getString(contentResolver, Settings.System.RADIO_BLUETOOTH));
      list.put("radio_cell", Settings.System.getString(contentResolver, Settings.System.RADIO_CELL));
      list.put("radio_nfc", Settings.System.getString(contentResolver, Settings.System.RADIO_NFC));
      list.put("radio_wifi", Settings.System.getString(contentResolver, Settings.System.RADIO_WIFI));
      list.put("show_processes", Settings.System.getString(contentResolver, Settings.System.SHOW_PROCESSES));
      list.put("stay_on_while_plugged_in", Settings.System.getString(contentResolver, Settings.System.STAY_ON_WHILE_PLUGGED_IN));
      list.put("transition_animation_scale", Settings.System.getString(contentResolver, Settings.System.TRANSITION_ANIMATION_SCALE));
      list.put("usb_mass_storage_enabled", Settings.System.getString(contentResolver, Settings.System.USB_MASS_STORAGE_ENABLED));
      list.put("use_google_mail", Settings.System.getString(contentResolver, Settings.System.USE_GOOGLE_MAIL));
      list.put("wait_for_debugger", Settings.System.getString(contentResolver, Settings.System.WAIT_FOR_DEBUGGER));
      list.put("wifi_device_owner_configs_lockdown", Settings.System.getString(contentResolver, Settings.Global.WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN));
      list.put("wifi_max_dhcp_retry_count", Settings.System.getString(contentResolver, Settings.System.WIFI_MAX_DHCP_RETRY_COUNT));
      list.put("wifi_mobile_data_transition_wakelock_timeout_ms", Settings.System.getString(contentResolver, Settings.System.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS));
      list.put("wifi_networks_available_notification_on", Settings.System.getString(contentResolver, Settings.System.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON));
      list.put("wifi_networks_available_repeat_delay", Settings.System.getString(contentResolver, Settings.System.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY));
      list.put("wifi_num_open_networks_kept", Settings.System.getString(contentResolver, Settings.System.WIFI_NUM_OPEN_NETWORKS_KEPT));
      list.put("wifi_on", Settings.System.getString(contentResolver, Settings.System.WIFI_ON));
      list.put("wifi_sleep_policy", Settings.System.getString(contentResolver, Settings.System.WIFI_SLEEP_POLICY));
      list.put("wifi_watchdog_on", Settings.System.getString(contentResolver, Settings.System.WIFI_WATCHDOG_ON));
      list.put("window_animation_scale", Settings.System.getString(contentResolver, Settings.System.WINDOW_ANIMATION_SCALE));
  }
}
