package util;

import org.apache.xerces.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Des {
	private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };
	private static String desKey = "phcnccbl";

	public static String encryptDES(String encryptString) throws Exception {
		// IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(desKey.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

		return Base64.encode(encryptedData);
	}

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
}