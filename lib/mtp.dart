
import 'mtp_platform_interface.dart';

class Mtp {
  Future<String?> getPlatformVersion() {
    return MtpPlatform.instance.getPlatformVersion();
  }
}
