import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:global_settings_list/global_settings_list.dart';

void main() => runApp(const MyApp());

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  MyAppState createState() => MyAppState();
}

class MyAppState extends State<MyApp> {
  String? _platformVersion = 'Unknown';
  String? _autoTimezone, _autoTime;
  String _daftar = "";

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String? platformVersion, autoTimezone, autoTime;
    Map<String, dynamic>? list;

    try {
      autoTimezone = await GlobalSettingsList.autoTimeZone;
      list = await GlobalSettingsList.list;
      //autoTime = await GlobalSettingsList.autoTime;
    } on PlatformException {
      autoTimezone = 'Gagal';
      autoTime = 'Gagal';
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
      _autoTimezone = autoTimezone;
      _autoTime = autoTime;
      _daftar = "";

      list?.forEach((k, v) {
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
              ElevatedButton(
                onPressed: initPlatformState,
                child: const Text("Load"),
              ),
              Expanded(flex: 1, child: SingleChildScrollView(child: Text(_daftar)))
            ],
          ),
        ),
      ),
    );
  }
}
