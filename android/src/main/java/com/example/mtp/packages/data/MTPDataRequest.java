package com.example.mtp.packages.data;


import com.example.mtp.PacketOperationCode;
import com.example.mtp.Utility;
import com.example.mtp.packages.MTPPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class MTPDataRequest extends MTPPacket {
    private final int uuid;


    public MTPDataRequest(PacketOperationCode operationCode, int uuid) {
        super(operationCode);
        this.uuid = uuid;
        super.bytePacket = getBytePacket();
    }

    public MTPDataRequest(byte[] bytePacket) {
        super(Utility.trim(bytePacket));
        uuid = new BigInteger(Arrays.copyOfRange(super.bytePacket, 1, 1 + Integer.BYTES)).intValue();
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
        return "MTSDataRequest{" +
                "\n\toperationCode=" + operationCode +
                ",\n\tuuid=" + uuid +
                ",\n\tbytePacket=" + Arrays.toString(bytePacket) +
                "\n}";
    }
}
