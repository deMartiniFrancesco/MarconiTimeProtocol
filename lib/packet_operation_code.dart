import 'dart:core';

enum PacketOperationCode {
  REQ_DOCENTE(1),
  REQ_AULA(2),
  REQ_CLASSE(3),
  REQ_DOCENTE_ADESSO(11),
  REQ_AULA_ADESSO(12),
  REQ_CLASSE_ADESSO(13),
  REPLY(21),
  DATA_ERROR(22),
  END_OF_DATA(23),
  REQ_REGISTRAZIONE(24),
  REG_SUCCESS(25),
  REG_ERROR(26);

  const PacketOperationCode(this.operationCode);

  final int operationCode;

  static PacketOperationCode? findByValue(int intType) {
    for (PacketOperationCode packetOperationCode
        in PacketOperationCode.values) {
      if (packetOperationCode.getOperationCode() == intType) {
        return packetOperationCode;
      }
    }
    return null;
  }

  int getOperationCode() {
    return operationCode;
  }
}
