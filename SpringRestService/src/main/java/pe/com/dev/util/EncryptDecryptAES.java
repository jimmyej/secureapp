package pe.com.dev.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptAES {
	
	private static final String ALGORITHM = "AES";
	private static final String UTF8 = "UTF-8";
	static String IV = "AAAAAAAAAAAAAAAA";
	static String plaintext = "test text 123\0\0\0"; /* Note null padding */
	static String encryptionKey = "1a2b3c4d5e6f7f8g";//16 max

	public static void main(String[] args) {
		try {

			System.out.println("==Java==");
			System.out.println("plain:   " + plaintext);

			String encrypted = encrypt(plaintext, encryptionKey);
			System.out.println("encrypted:  "+encrypted);

			String decrypted = decrypt(encrypted, encryptionKey);
			System.out.println("decrypt: " + decrypted);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String toEncrypt, String encryptionKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(UTF8), ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes(UTF8)));
		byte[] encryptedValue64 = cipher.doFinal(toEncrypt.getBytes(UTF8));
		Base64 encoder = new Base64();
		byte[] enc = encoder.encode(encryptedValue64);
		String encryptedValue = new String(enc, UTF8);
		return encryptedValue;
	}

	public static String decrypt(String toDecrypt, String encryptionKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(UTF8), ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes(UTF8)));
		Base64 decoder = new Base64();
		byte[] decryptedValue64 = decoder.decode(toDecrypt);
		byte[] dec = cipher.doFinal(decryptedValue64);
		String decryptedValue = new String(dec, UTF8);
		return decryptedValue;
	}
}
