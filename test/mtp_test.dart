import 'package:flutter_test/flutter_test.dart';
import 'package:mtp/mtp.dart';
import 'package:mtp/mtp_platform_interface.dart';
import 'package:mtp/mtp_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockMtpPlatform
    with MockPlatformInterfaceMixin
    implements MtpPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final MtpPlatform initialPlatform = MtpPlatform.instance;

  test('$MethodChannelMtp is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelMtp>());
  });

  test('getPlatformVersion', () async {
    Mtp mtpPlugin = Mtp();
    MockMtpPlatform fakePlatform = MockMtpPlatform();
    MtpPlatform.instance = fakePlatform;

    expect(await mtpPlugin.getPlatformVersion(), '42');
  });
}
