
import 'marconi_time_protocol_platform_interface.dart';

class MarconiTimeProtocol {
  Future<String?> getPlatformVersion() {
    return MarconiTimeProtocolPlatform.instance.getPlatformVersion();
  }
}
