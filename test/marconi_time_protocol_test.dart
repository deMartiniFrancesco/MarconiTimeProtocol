import 'package:flutter_test/flutter_test.dart';
import 'package:marconi_time_protocol/marconi_time_protocol.dart';
import 'package:marconi_time_protocol/marconi_time_protocol_platform_interface.dart';
import 'package:marconi_time_protocol/marconi_time_protocol_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockMarconiTimeProtocolPlatform
    with MockPlatformInterfaceMixin
    implements MarconiTimeProtocolPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final MarconiTimeProtocolPlatform initialPlatform = MarconiTimeProtocolPlatform.instance;

  test('$MethodChannelMarconiTimeProtocol is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelMarconiTimeProtocol>());
  });

  test('getPlatformVersion', () async {
    MarconiTimeProtocol marconiTimeProtocolPlugin = MarconiTimeProtocol();
    MockMarconiTimeProtocolPlatform fakePlatform = MockMarconiTimeProtocolPlatform();
    MarconiTimeProtocolPlatform.instance = fakePlatform;

    expect(await marconiTimeProtocolPlugin.getPlatformVersion(), '42');
  });
}
