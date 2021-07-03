package app.gui.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Serialization {

    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    private static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    private static String encodeHexString(byte[] byteArray) {
        final StringBuilder hex = new StringBuilder();
        for (final byte b : byteArray) {
            hex.append(byteToHex(b));
        }
        return hex.toString();
    }

    private static byte hexToByte(String hexString) {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    private static int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if (digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: " + hexChar);
        }
        return digit;
    }

    private static byte[] decodeHexString(String hexString) {
        if (hexString.length() % 2 == 1) {
            throw new IllegalArgumentException(
                    "Invalid hexadecimal String supplied.");
        }

        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            bytes[i / 2] = hexToByte(hexString.substring(i, i + 2));
        }
        return bytes;
    }

    public static String serializeObject(final Serializable serializable) {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();
             final ObjectOutputStream oos = new ObjectOutputStream(baos)) {

            oos.writeObject(serializable);
            byte[] buf = baos.toByteArray();

            return encoder.encodeToString(encodeHexString(buf).getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return "";
    }

    public static <T> T deserializeObject(final String serializedObject) {
        final byte[] buf = decodeHexString(new String(decoder.decode(serializedObject)));
        try (final ByteArrayInputStream bais = new ByteArrayInputStream(buf);
             final ObjectInputStream ois = new ObjectInputStream(bais)) {

            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

}
