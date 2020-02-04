# global_settings_list_example

Demonstrates how to use the global_settings_list plugin.

## Getting Started

import the plugin
```flutter
    import 'package:global_settings_list/global_settings_list.dart';
```

full example

```flutter
    import 'package:flutter/material.dart';
    import 'dart:async';

    import 'package:flutter/services.dart';
    import 'package:global_settings_list/global_settings_list.dart';

    void main() => runApp(MyApp());

    class MyApp extends StatefulWidget {
      @override
      _MyAppState createState() => _MyAppState();
    }

    class _MyAppState extends State<MyApp> {
      String _platformVersion = 'Unknown', _autoTimezone, _autoTime, _daftar = "";
      Map<String, dynamic> _list;

      @override
      void initState() {
        super.initState();
        initPlatformState();
      }

      // Platform messages are asynchronous, so we initialize in an async method.
      Future<void> initPlatformState() async {
        String platformVersion, autoTimezone, autoTime;
        Map<String, dynamic> list;

        try {
          autoTimezone = await GlobalSettingsList.autoTimeZone;
          list = await GlobalSettingsList.list;
          autoTime = await GlobalSettingsList.autoTime;
        } on PlatformException {
          autoTimezone = 'Failed to Get';
          autoTime = 'Failed to Get';
        }

        // If the widget was removed from the tree while the asynchronous platform
        // message was in flight, we want to discard the reply rather than calling
        // setState to update our non-existent appearance.
        if (!mounted) return;

        setState(() {
          _platformVersion = platformVersion;
          _autoTimezone = autoTimezone;
          _autoTime = autoTime;
          _list = list;
          _daftar = "";

          list.forEach((k, v) {
            _daftar += "$k : $v \n";
          });
        });
      }

      @override
      Widget build(BuildContext context) {
        return MaterialApp(
          home: Scaffold(
            appBar: AppBar(
              title: const Text('Plugin example app'),
            ),
            body: Center(
              child: Column(
                children: <Widget>[
                  Text('Running on: $_platformVersion\n'),
                  Text('Auto Timezone : $_autoTimezone'),
                  Text('Auto Time : $_autoTime'),
                  RaisedButton(
                    child: Text("Load"),
                    onPressed: initPlatformState,
                  ),
                  Expanded(
                      flex: 1,
                      child: SingleChildScrollView(child: Text(_daftar ?? "tes")))
                ],
              ),
            ),
          ),
        );
      }
    }

```


## list of global settings
- GlobalSettingsList.adbEnabled
- GlobalSettingsList.airplaneModeOn
- GlobalSettingsList.airplaneModeRadios
- GlobalSettingsList.alwaysFinishActivities
- GlobalSettingsList.animatorDurationScale
- GlobalSettingsList.autoTime
- GlobalSettingsList.autoTimeZone
- GlobalSettingsList.bluetoothOn
- GlobalSettingsList.bootCount
- GlobalSettingsList.contactMetadataSyncEnabled
- GlobalSettingsList.dataRoaming
- GlobalSettingsList.debugApp
- GlobalSettingsList.developmentSettingsEnabled
- GlobalSettingsList.deviceName
- GlobalSettingsList.deviceProvisioned
- GlobalSettingsList.httpProxy
- GlobalSettingsList.installNonMarketApps
- GlobalSettingsList.modeRinger
- GlobalSettingsList.networkPreference
- GlobalSettingsList.radioBluetooth
- GlobalSettingsList.radioCell
- GlobalSettingsList.radioNfc
- GlobalSettingsList.radioWifi
- GlobalSettingsList.showProcesses
- GlobalSettingsList.stayOnWhilePluggedIn
- GlobalSettingsList.transitionAnimationScale
- GlobalSettingsList.usbMassStorageEnabled
- GlobalSettingsList.useGoogleMail
- GlobalSettingsList.waitForDebugger
- GlobalSettingsList.wifiDeviceOwnerConfigsLockdown
- GlobalSettingsList.wifiMaxDhcpRetryCount
- GlobalSettingsList.wifiMobileDataTransitionWakelockTimeoutMs
- GlobalSettingsList.wifiNetworksAvailableNotificationOn
- GlobalSettingsList.wifiNetworksAvailableRepeatDelay
- GlobalSettingsList.wifiNumOpenNetworksKept
- GlobalSettingsList.wifiOn
- GlobalSettingsList.wifiSleepPolicy
- GlobalSettingsList.wifiWatchdogOn
- GlobalSettingsList.windowAnimationScale
- GlobalSettingsList.list