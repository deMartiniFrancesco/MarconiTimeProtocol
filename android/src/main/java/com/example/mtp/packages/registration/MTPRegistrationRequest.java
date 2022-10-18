package com.example.mtp.packages.registration;

import com.example.mtp.PacketOperationCode;
import com.example.mtp.Utility;
import com.example.mtp.packages.MTPPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MTPRegistrationRequest extends MTPPacket {
    private final String name;

    public MTPRegistrationRequest(String name) {
        super(PacketOperationCode.REQ_REGISTRAZIONE);
        this.name = name;
        super.bytePacket = getBytePacket();
    }

    public MTPRegistrationRequest(byte[] bytePacket) {
        super(Utility.trim(bytePacket));
        name = new String(Arrays.copyOfRange(super.bytePacket, 1, super.bytePacket.length));
    }

    @Override
    public byte[] getBytePacket() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(operationCode.getOperationCode());
        try {
            outputStream.write(name.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }

    @Override
    public String toString() {
        return "MTSRegistrationRequest{" +
                "\n\toperationCode=" + operationCode +
                ",\n\tname='" + name + '\'' +
                ",\n\tbytePacket=" + Arrays.toString(bytePacket) +
                "\n}";
    }
}
