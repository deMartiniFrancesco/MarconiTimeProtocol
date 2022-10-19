import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'marconi_time_protocol_platform_interface.dart';

/// An implementation of [MarconiTimeProtocolPlatform] that uses method channels.
class MethodChannelMarconiTimeProtocol extends MarconiTimeProtocolPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('marconi_time_protocol');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
