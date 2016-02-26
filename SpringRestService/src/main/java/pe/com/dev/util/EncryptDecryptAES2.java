package pe.com.dev.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptAES2 {
	private static final String ALGORITHM = "AES";
	private static final String UTF8 = "utf-8";

	public static String encrypt(String value, String keyValue) {
		Key key = new SecretKeySpec(keyValue.getBytes(), ALGORITHM);
		Cipher cipher;
		String encryptedValue64 = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptedByteValue = cipher.doFinal(value.getBytes(UTF8));
			Base64 encoder = new Base64();
			byte[] enc = encoder.encode(encryptedByteValue);
			encryptedValue64 = new String(enc, UTF8);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptedValue64;
	}

	public static String decrypt(String value, String keyValue) {
		Key key = new SecretKeySpec(keyValue.getBytes(), ALGORITHM);
		Cipher cipher;
		String decryptedValue = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			Base64 decoder = new Base64();
			byte[] decryptedValue64 = decoder.decode(value);
			byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
			decryptedValue = new String(decryptedByteValue, UTF8);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decryptedValue;
	}
	public static void main(String[] args) {
		String key = "1a2b3c4d5e6f7f8g";
		System.out.println("key= "+key);
		String encrypted = encrypt("Hola Mundo", key);
		System.out.println("encrypted= "+encrypted);
		String decrypted = decrypt(encrypted, key);
		System.out.println("decrypted= "+decrypted);
	}

}
