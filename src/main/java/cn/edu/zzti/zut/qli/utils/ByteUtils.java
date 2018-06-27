package cn.edu.zzti.zut.qli.utils;

public final class ByteUtils {

    public static byte[] concat(byte[]... bytesList) {
        int offset = 0;
        byte[] result = new byte[length(bytesList)];
        for (byte[] bytes: bytesList) {
            System.arraycopy(bytes, 0, result, offset, bytes.length);
            offset += bytes.length;
        }
        return result;
    }

    public static int length(byte[]... bytesList) {
        int length = 0;
        for (byte[] bytes: bytesList) {
            length += bytes.length;
        }
        return length;
    }
}
