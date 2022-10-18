import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mtp/mtp_method_channel.dart';

void main() {
  MethodChannelMtp platform = MethodChannelMtp();
  const MethodChannel channel = MethodChannel('mtp');

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
    expect(await platform.getPlatformVersion(), '42');
  });
}
