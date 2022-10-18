package com.example.mtp.packages.registration;



import com.example.mtp.PacketOperationCode;
import com.example.mtp.packages.MTPPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MTPRegistrationError extends MTPPacket {

    public MTPRegistrationError() {
        super(PacketOperationCode.REG_ERROR);
        super.bytePacket = getBytePacket();
    }

    public MTPRegistrationError(byte[] bytePacket) {
        super(Arrays.copyOfRange(bytePacket, 0, 1 + Integer.BYTES));
    }

    @Override
    public byte[] getBytePacket() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(operationCode.getOperationCode());
        try {
            outputStream.write(new byte[4]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }

    @Override
    public String toString() {
        return "MTSRegistrationError{" +
                "\n\toperationCode=" + operationCode +
                ",\n\tbytePacket=" + Arrays.toString(bytePacket) +
                "\n}";
    }

}
