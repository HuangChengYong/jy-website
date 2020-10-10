package com.jyinfo.jy_utils.UUIDGenerator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * @author Felix.yu
 */
public class UUIDGenerator {

    private static final Log log = LogFactory.getLog(com.jyinfo.jy_utils.UUIDGenerator.UUIDGenerator.class);

    private static SecureRandom seederStatic;
    private static byte addr[];
    private static String midValueStatic = null;
    private String midValue;
    private SecureRandom seeder;
    private static long prevMillis = 0L;
    private static byte addrBytes[] = null;

    static {
        seederStatic = null;
        addr = null;
        try {
            addr = InetAddress.getLocalHost().getAddress();
            addrBytes = InetAddress.getLocalHost().getAddress();
            StringBuffer buffer = new StringBuffer(8);
            buffer.append(toHex(toInt(addr), 8));
            midValueStatic = buffer.toString();
            seederStatic = new SecureRandom();
            seederStatic.nextInt();
        } catch (Exception ex) {
            log.error("", ex);
        }
    }

    public UUIDGenerator() {
        midValue = null;
        seeder = null;
        StringBuffer buffer = new StringBuffer(16);
        buffer.append(midValueStatic);
        buffer.append(toHex(System.identityHashCode(this), 8));
        midValue = buffer.toString();
        seeder = new SecureRandom();
        seeder.nextInt();
    }

    public static String generate(Object obj) {
        StringBuffer uid = new StringBuffer(32);
        long currentTimeMillis = System.currentTimeMillis();
        uid.append(toHex((int) (currentTimeMillis & -1L), 8));
        uid.append(midValueStatic);
        uid.append(toHex(System.identityHashCode(obj), 8));
        uid.append(toHex(getRandom(), 8));
        return uid.toString();
    }

    public static String generate16(Object obj) {
        StringBuffer uid = new StringBuffer(16);
        uid.append(toHex(System.identityHashCode(obj), 8));
        uid.append(toHex(getRandom(), 8));
        return uid.toString();
    }

    public String generate() {
        StringBuffer uid = new StringBuffer(32);
        long currentTimeMillis = System.currentTimeMillis();
        uid.append(toHex((int) (currentTimeMillis & -1L), 8));
        uid.append(midValue);
        uid.append(toHex(seeder.nextInt(), 8));
        return uid.toString();
    }

    private static String toHex(int value, int length) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buffer = new StringBuffer(length);
        int shift = length - 1 << 2;
        for (int i = -1; ++i < length; ) {
            buffer.append(hexDigits[value >> shift & 0xf]);
            value <<= 4;
        }

        return buffer.toString();
    }

    private static int toInt(byte bytes[]) {
        int value = 0;
        for (int i = -1; ++i < bytes.length; ) {
            value <<= 8;
            value |= bytes[i];
        }

        return value;
    }

    private static synchronized int getRandom() {
        return seederStatic.nextInt();
    }

    private static synchronized long getSystemTimeMillis() {
        long millis = System.currentTimeMillis();
        if (millis > prevMillis) {
            prevMillis = millis;
        } else {
            prevMillis++;
        }
        return prevMillis;
    }

    public static Long getUniqueLong() {
        long l = getSystemTimeMillis();
        l *= 1000L;
        long b1 = addrBytes[3] & 0xff;
        l += b1;
        return Long.valueOf(l);
    }

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    /*
    * 长度为8位的UUID
     */
    public static String generateShortUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

    /**
     * 长度为指定位数的UUID
     * @param uuidLength
     * @return
     */
    public static String generateUUID(int uuidLength) {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < uuidLength; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }
}