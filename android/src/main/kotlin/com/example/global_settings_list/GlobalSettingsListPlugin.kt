package com.example.global_settings_list


import android.content.ContentResolver
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import java.util.Locale

/** GlobalSettingsListPlugin */
class GlobalSettingsListPlugin : FlutterPlugin, MethodCallHandler {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private lateinit var channel: MethodChannel
    private lateinit var contentResolver: ContentResolver
    private var list: HashMap<String, Any?> = HashMap()
    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "global_settings_list")
        channel.setMethodCallHandler(this)
        contentResolver = flutterPluginBinding.applicationContext.contentResolver
        listGlobal()
    }


    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            "getAdbStatus" -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    val adbUsbStatus =
                        Settings.Global.getString(contentResolver, Settings.Global.ADB_ENABLED)
                    val adbWifiStatus =
                        Settings.Global.getString(
                            contentResolver,
                            "adb_wifi_enabled"
                        )
                    result.success(adbUsbStatus == "1" || adbWifiStatus == "1")
                } else {
                    result.success(null)
                }
            }

            "get" -> {
                listGlobal()
                result.success(
                    list[call.argument<Any>("setting_name").toString()
                        .lowercase(Locale.getDefault())]
                )
            }

            "getList" -> {
                listGlobal()
                result.success(list)
            }

            "getPlatformVersion" -> {
                result.success("Android " + Build.VERSION.RELEASE)
            }

            else -> {
                result.notImplemented()
            }
        }
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    private fun listGlobal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) listGlobalSettings() else listGlobalSettingsOld()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun listGlobalSettings() {
        list["adb_enabled"] =
            Settings.Global.getString(contentResolver, Settings.Global.ADB_ENABLED)
        list["adb_wifi_enabled"] = Settings.Global.getString(
            contentResolver,
            "adb_wifi_enabled"
        )
        list["airplane_mode_on"] =
            Settings.Global.getString(contentResolver, Settings.Global.AIRPLANE_MODE_ON)
        list["airplane_mode_radios"] =
            Settings.Global.getString(contentResolver, Settings.Global.AIRPLANE_MODE_RADIOS)
        list["always_finish_activities"] =
            Settings.Global.getString(contentResolver, Settings.Global.ALWAYS_FINISH_ACTIVITIES)
        list["animator_duration_scale"] =
            Settings.Global.getString(contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE)
        list["auto_time"] = Settings.Global.getString(contentResolver, Settings.Global.AUTO_TIME)
        list["auto_time_zone"] =
            Settings.Global.getString(contentResolver, Settings.Global.AUTO_TIME_ZONE)
        list["bluetooth_on"] =
            Settings.Global.getString(contentResolver, Settings.Global.BLUETOOTH_ON)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list["boot_count"] =
                Settings.Global.getString(contentResolver, Settings.Global.BOOT_COUNT)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list["contact_metadata_sync_enabled"] = Settings.Global.getString(
                contentResolver,
                Settings.Global.CONTACT_METADATA_SYNC_ENABLED
            )
        }
        if(Build.VERSION.SDK_INT <= 32) {
            list["data_roaming"] =
                Settings.System.getString(contentResolver, Settings.Global.DATA_ROAMING)
        }
        list["debug_app"] = Settings.Global.getString(contentResolver, Settings.Global.DEBUG_APP)
        list["development_settings_enabled"] =
            Settings.Global.getString(contentResolver, Settings.Global.DEVELOPMENT_SETTINGS_ENABLED)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            list["device_name"] =
                Settings.Global.getString(contentResolver, Settings.Global.DEVICE_NAME)
        }
        list["device_provisioned"] =
            Settings.Global.getString(contentResolver, Settings.Global.DEVICE_PROVISIONED)
        list["http_proxy"] = Settings.Global.getString(contentResolver, Settings.Global.HTTP_PROXY)
        list["install_non_market_apps"] =
            Settings.Global.getString(contentResolver, Settings.Secure.INSTALL_NON_MARKET_APPS)
        list["mode_ringer"] =
            Settings.Global.getString(contentResolver, Settings.Global.MODE_RINGER)
        list["network_preference"] =
            Settings.Global.getString(contentResolver, Settings.Global.NETWORK_PREFERENCE)
        list["radio_bluetooth"] =
            Settings.Global.getString(contentResolver, Settings.Global.RADIO_BLUETOOTH)
        list["radio_cell"] = Settings.Global.getString(contentResolver, Settings.Global.RADIO_CELL)
        list["radio_nfc"] = Settings.Global.getString(contentResolver, Settings.Global.RADIO_NFC)
        list["radio_wifi"] = Settings.Global.getString(contentResolver, Settings.Global.RADIO_WIFI)
        list["show_processes"] =
            Settings.Global.getString(contentResolver, Settings.Global.SHOW_PROCESSES)
        list["stay_on_while_plugged_in"] =
            Settings.Global.getString(contentResolver, Settings.Global.STAY_ON_WHILE_PLUGGED_IN)
        list["transition_animation_scale"] =
            Settings.Global.getString(contentResolver, Settings.Global.TRANSITION_ANIMATION_SCALE)
        list["usb_mass_storage_enabled"] =
            Settings.Global.getString(contentResolver, Settings.Global.USB_MASS_STORAGE_ENABLED)
        list["use_google_mail"] =
            Settings.Global.getString(contentResolver, Settings.Global.USE_GOOGLE_MAIL)
        list["wait_for_debugger"] =
            Settings.Global.getString(contentResolver, Settings.Global.WAIT_FOR_DEBUGGER)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            list["wifi_device_owner_configs_lockdown"] =
                Settings.Global.getString(
                    contentResolver,
                    Settings.Global.WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN
                )
        }
        list["wifi_max_dhcp_retry_count"] =
            Settings.Global.getString(contentResolver, Settings.Global.WIFI_MAX_DHCP_RETRY_COUNT)
        list["wifi_mobile_data_transition_wakelock_timeout_ms"] =
            Settings.Global.getString(
                contentResolver,
                Settings.Global.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS
            )
        list["wifi_networks_available_notification_on"] =
            Settings.Global.getString(
                contentResolver,
                Settings.Global.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON
            )
        list["wifi_networks_available_repeat_delay"] =
            Settings.Global.getString(
                contentResolver,
                Settings.Global.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY
            )
        list["wifi_num_open_networks_kept"] =
            Settings.Global.getString(contentResolver, Settings.Global.WIFI_NUM_OPEN_NETWORKS_KEPT)
        list["wifi_on"] = Settings.Global.getString(contentResolver, Settings.Global.WIFI_ON)
        list["wifi_sleep_policy"] =
            Settings.Global.getString(contentResolver, Settings.Global.WIFI_SLEEP_POLICY)
        list["wifi_watchdog_on"] =
            Settings.Global.getString(contentResolver, Settings.Global.WIFI_WATCHDOG_ON)
        list["window_animation_scale"] =
            Settings.Global.getString(contentResolver, Settings.Global.WINDOW_ANIMATION_SCALE)
    }

    private fun listGlobalSettingsOld() {
        list["adb_enabled"] =
            Settings.System.getString(contentResolver, Settings.System.ADB_ENABLED)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            list["adb_wifi_enabled"] = Settings.Global.getString(
                contentResolver,
                "adb_wifi_enabled"
            )
        }
        list["airplane_mode_on"] =
            Settings.System.getString(contentResolver, Settings.System.AIRPLANE_MODE_ON)
        list["airplane_mode_radios"] =
            Settings.System.getString(contentResolver, Settings.System.AIRPLANE_MODE_RADIOS)
        list["always_finish_activities"] =
            Settings.System.getString(contentResolver, Settings.System.ALWAYS_FINISH_ACTIVITIES)
        list["animator_duration_scale"] =
            Settings.System.getString(contentResolver, Settings.System.ANIMATOR_DURATION_SCALE)
        list["auto_time"] = Settings.System.getString(contentResolver, Settings.System.AUTO_TIME)
        list["auto_time_zone"] =
            Settings.System.getString(contentResolver, Settings.System.AUTO_TIME_ZONE)
        list["bluetooth_on"] =
            Settings.System.getString(contentResolver, Settings.System.BLUETOOTH_ON)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list["boot_count"] =
                Settings.System.getString(contentResolver, Settings.Global.BOOT_COUNT)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list["contact_metadata_sync_enabled"] =
                Settings.System.getString(
                    contentResolver,
                    Settings.Global.CONTACT_METADATA_SYNC_ENABLED
                )
        }
        if(Build.VERSION.SDK_INT <= 32) {
            list["data_roaming"] =
                Settings.System.getString(contentResolver, Settings.Global.DATA_ROAMING)
        }
        list["debug_app"] = Settings.System.getString(contentResolver, Settings.System.DEBUG_APP)
        list["development_settings_enabled"] =
            Settings.System.getString(contentResolver, Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED)
        list["device_name"] = Settings.System.getString(contentResolver, Build.MODEL)
        list["device_provisioned"] =
            Settings.System.getString(contentResolver, Settings.System.DEVICE_PROVISIONED)
        list["http_proxy"] = Settings.System.getString(contentResolver, Settings.System.HTTP_PROXY)
        list["install_non_market_apps"] =
            Settings.System.getString(contentResolver, Settings.System.INSTALL_NON_MARKET_APPS)
        list["mode_ringer"] =
            Settings.System.getString(contentResolver, Settings.System.MODE_RINGER)
        list["network_preference"] =
            Settings.System.getString(contentResolver, Settings.System.NETWORK_PREFERENCE)
        list["radio_bluetooth"] =
            Settings.System.getString(contentResolver, Settings.System.RADIO_BLUETOOTH)
        list["radio_cell"] = Settings.System.getString(contentResolver, Settings.System.RADIO_CELL)
        list["radio_nfc"] = Settings.System.getString(contentResolver, Settings.System.RADIO_NFC)
        list["radio_wifi"] = Settings.System.getString(contentResolver, Settings.System.RADIO_WIFI)
        list["show_processes"] =
            Settings.System.getString(contentResolver, Settings.System.SHOW_PROCESSES)
        list["stay_on_while_plugged_in"] =
            Settings.System.getString(contentResolver, Settings.System.STAY_ON_WHILE_PLUGGED_IN)
        list["transition_animation_scale"] =
            Settings.System.getString(contentResolver, Settings.System.TRANSITION_ANIMATION_SCALE)
        list["usb_mass_storage_enabled"] =
            Settings.System.getString(contentResolver, Settings.System.USB_MASS_STORAGE_ENABLED)
        list["use_google_mail"] =
            Settings.System.getString(contentResolver, Settings.System.USE_GOOGLE_MAIL)
        list["wait_for_debugger"] =
            Settings.System.getString(contentResolver, Settings.System.WAIT_FOR_DEBUGGER)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            list["wifi_device_owner_configs_lockdown"] =
                Settings.System.getString(
                    contentResolver,
                    Settings.Global.WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN
                )
        }
        list["wifi_max_dhcp_retry_count"] =
            Settings.System.getString(contentResolver, Settings.System.WIFI_MAX_DHCP_RETRY_COUNT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            list["wifi_mobile_data_transition_wakelock_timeout_ms"] =
                Settings.System.getString(
                    contentResolver,
                    Settings.Global.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS
                )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            list["wifi_networks_available_notification_on"] =
                Settings.System.getString(
                    contentResolver,
                    Settings.Global.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON
                )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            list["wifi_networks_available_repeat_delay"] =
                Settings.System.getString(
                    contentResolver,
                    Settings.Global.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY
                )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            list["wifi_num_open_networks_kept"] =
                Settings.System.getString(
                    contentResolver,
                    Settings.Global.WIFI_NUM_OPEN_NETWORKS_KEPT
                )
        }
        list["wifi_on"] = Settings.System.getString(contentResolver, Settings.System.WIFI_ON)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            list["wifi_sleep_policy"] =
                Settings.System.getString(contentResolver, Settings.Global.WIFI_SLEEP_POLICY)
        }
        list["wifi_watchdog_on"] =
            Settings.System.getString(contentResolver, Settings.System.WIFI_WATCHDOG_ON)
        list["window_animation_scale"] =
            Settings.System.getString(contentResolver, Settings.System.WINDOW_ANIMATION_SCALE)
    }
}
