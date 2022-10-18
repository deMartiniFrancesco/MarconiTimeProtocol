import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'mtp_platform_interface.dart';

/// An implementation of [MtpPlatform] that uses method channels.
class MethodChannelMtp extends MtpPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('mtp');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
