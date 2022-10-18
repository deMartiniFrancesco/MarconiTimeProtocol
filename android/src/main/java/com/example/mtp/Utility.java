package com.example.mtp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Utility {

    public static byte[] concatByteArrays(byte[] a, byte[] b) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(a);
        bos.write(b);
        return bos.toByteArray();
    }

    public static byte[] toIntegerLength(byte[] bytes) {
        int lenBytes = bytes.length;
        if (lenBytes < Integer.BYTES) {
            try {
                return concatByteArrays(new byte[Integer.BYTES - lenBytes], bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Arrays.copyOfRange(bytes, lenBytes - Integer.BYTES, lenBytes);
    }

    public static byte[] trim(byte[] bytes) {
        int i = bytes.length - 1;
        while (i >= 0 && bytes[i] == 0) --i;
        return Arrays.copyOf(bytes, i + 1);
    }
}
