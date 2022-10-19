import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:marconi_time_protocol/marconi_time_protocol_method_channel.dart';

void main() {
  MethodChannelMarconiTimeProtocol platform = MethodChannelMarconiTimeProtocol();
  const MethodChannel channel = MethodChannel('marconi_time_protocol');

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
