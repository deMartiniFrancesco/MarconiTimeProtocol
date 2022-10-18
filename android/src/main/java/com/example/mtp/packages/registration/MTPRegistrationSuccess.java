package com.example.mtp.packages.registration;


import com.example.mtp.PacketOperationCode;
import com.example.mtp.packages.MTPPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class MTPRegistrationSuccess extends MTPPacket {
    private final int uuid;

    public MTPRegistrationSuccess(int uuid) {
        super(PacketOperationCode.REG_SUCCESS);
        this.uuid = uuid;
        super.bytePacket = getBytePacket();
    }

    public MTPRegistrationSuccess(byte[] bytePacket) {
        super(Arrays.copyOfRange(bytePacket, 0, 1 + Integer.BYTES));
        uuid = new BigInteger(Arrays.copyOfRange(super.bytePacket, 1, super.bytePacket.length)).intValue();
    }

    @Override
    public byte[] getBytePacket() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(operationCode.getOperationCode());
        try {
            outputStream.write(ByteBuffer.allocate(Integer.BYTES).putInt(uuid).array());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }

    @Override
    public String toString() {
        return "MTSRegistrationSuccess{" +
                "\n\toperationCode=" + operationCode +
                ",\n\tuuid=" + uuid +
                ",\n\tbytePacket=" + Arrays.toString(bytePacket) +
                "\n}";
    }

}
