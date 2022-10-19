import 'package:flutter/services.dart';
import 'package:marconi_time_protocol/packet_operation_code.dart';

class MarconiTimeProtocol {
  static const MethodChannel _channel = MethodChannel('marconi_time_protocol');

  String _ipTarget;
  int _port;

  MarconiTimeProtocol({
    required String ipTarget,
    required int port,
  })  : _ipTarget = ipTarget,
        _port = port;

  static Future<String> getPlatformVersion() async {
    return await _channel.invokeMethod('getPlatformVersion');
  }

  set port(int value) {
    _port = value;
  }

  set ipTarget(String value) {
    _ipTarget = value;
  }

  Future<PacketOperationCode?> _sendPacket({
    required PacketOperationCode packetType,
    Map<String, dynamic> args = const {},
  }) async {
    Map<String, dynamic> arguments = <String, dynamic>{
      'ip': _ipTarget,
      'port': _port,
      'packetType': packetType.operationCode,
      ...args,
    };
    return PacketOperationCode.findByValue(await _channel.invokeMethod('sendPacket', arguments));
  }

  Future<PacketOperationCode?> sendRegistrationRequest({required String name}) {
    return _sendPacket(
      packetType: PacketOperationCode.REQ_REGISTRAZIONE,
      args: {'name': name},
    );
  }

  Future<PacketOperationCode?> sendDataRequest({
    required PacketOperationCode packetType,
    required int uuid,
    String request = "",
  }) {
    return _sendPacket(
      packetType: packetType,
      args: {
        'uuid': uuid,
        'request': request,
      },
    );
  }
}
