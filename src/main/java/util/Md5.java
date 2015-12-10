package util;

import org.apache.xerces.impl.dv.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by yangdan
 */
public class Md5 {



    /**
     * Des加密解密
     */
    private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };
    private static String desKey = "phcnccbl";
    /**
     * 加密DES
     * @param encryptString
     * @return
     * @throws Exception
     */
    public static String encryptDES(String encryptString) throws Exception {
// IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(desKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
        return Base64.encode(encryptedData);
    }
    /**
     * 解密DES
     * @param decryptString
     * @return
     * @throws Exception
     */
    public static String decryptDES(String decryptString) throws Exception {
        byte[] byteMi = new Base64().decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
// IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
        SecretKeySpec key = new SecretKeySpec(desKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte decryptedData[] = cipher.doFinal(byteMi);
        return new String(decryptedData);
    }

    /**
     * MD5加密
     */
    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    /**
     * byte转换16进制字符串
     * @param b
     * @return
     */
    public static String toHexString(byte[] b) {
// String to byte
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }
    /**
     * md5加密
     * @param s
     * @return
     */
    public static String md5(String s) {
        try {
// Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            String result = toHexString(messageDigest);
// return result.toLowerCase();
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}

