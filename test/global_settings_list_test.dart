import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:global_settings_list/src/global_settings_list.dart';

void main() {
  const MethodChannel channel = MethodChannel('global_settings_list');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await GlobalSettingsList.platformVersion, '42');
  });
}
