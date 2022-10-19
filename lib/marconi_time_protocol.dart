
import 'package:flutter/services.dart';

class MarconiTimeProtocol {
  static const MethodChannel _channel = MethodChannel('marconi_time_protocol');


  static Future<String> getPlatformVersion() async {
    return await _channel.invokeMethod('getPlatformVersion');
  }

}
