import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'mtp_method_channel.dart';

abstract class MtpPlatform extends PlatformInterface {
  /// Constructs a MtpPlatform.
  MtpPlatform() : super(token: _token);

  static final Object _token = Object();

  static MtpPlatform _instance = MethodChannelMtp();

  /// The default instance of [MtpPlatform] to use.
  ///
  /// Defaults to [MethodChannelMtp].
  static MtpPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [MtpPlatform] when
  /// they register themselves.
  static set instance(MtpPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
