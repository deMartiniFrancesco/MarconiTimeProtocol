import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'marconi_time_protocol_method_channel.dart';

abstract class MarconiTimeProtocolPlatform extends PlatformInterface {
  /// Constructs a MarconiTimeProtocolPlatform.
  MarconiTimeProtocolPlatform() : super(token: _token);

  static final Object _token = Object();

  static MarconiTimeProtocolPlatform _instance = MethodChannelMarconiTimeProtocol();

  /// The default instance of [MarconiTimeProtocolPlatform] to use.
  ///
  /// Defaults to [MethodChannelMarconiTimeProtocol].
  static MarconiTimeProtocolPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [MarconiTimeProtocolPlatform] when
  /// they register themselves.
  static set instance(MarconiTimeProtocolPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
