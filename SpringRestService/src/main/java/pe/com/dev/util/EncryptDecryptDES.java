package pe.com.dev.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptDES {
	
	private static final String ALGORITHM = "DES";
	private static final String CIPHER = "DES/CBC/PKCS5Padding";
	private static final String UTF8 = "utf-8";
	static IvParameterSpec iv;

	public static void main(String[] args) throws Exception {
		
		String key = "1a2b3c4d5e6f7f8g1a2b3c4d5e6f7f8g1a2b3c4d5e6f7f8g1a2b3c4d5e6f7f8g";
		System.out.println("Key: " + key);
		
		String toEncrypt = "The shorter you live, the longer you're dead!";
		System.out.println("toEncrypt: " + toEncrypt);
		
		String encrypted = encrypt(toEncrypt, key);
		System.out.println("Encrypted text: " + encrypted.toString());

		String decrypted = decrypt(encrypted, key);
		System.out.println("Decrypted text: " + decrypted);
		
	}
	
	public static String encrypt(String toEncrypt, String key) {
		// create a binary key from the argument key (seed)
		SecureRandom sr = new SecureRandom(key.getBytes());
		KeyGenerator kg;
		String encryptedValue = null;
		try {
			kg = KeyGenerator.getInstance(ALGORITHM);
			kg.init(sr);
			SecretKey sk = kg.generateKey();

			// create an instance of cipher
			Cipher cipher = Cipher.getInstance(CIPHER);
			// generate an initialization vector (IV)
			SecureRandom secureRandom = new SecureRandom();
			byte[] ivspec = new byte[cipher.getBlockSize()];
			secureRandom.nextBytes(ivspec);
			iv = new IvParameterSpec(ivspec);
			// initialize the cipher with the key and IV
			cipher.init(Cipher.ENCRYPT_MODE, sk, iv);
			// enctypt!
			byte[] encryptedValue64 = cipher.doFinal(toEncrypt.getBytes());
			Base64 encoder = new Base64();
			byte[] encrypted = encoder.encode(encryptedValue64);
			
			encryptedValue = new String(encrypted, UTF8);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptedValue;
	}
	
	public static String decrypt(String toDecrypt, String key) {
		// create a binary key from the argument key (seed)
		SecureRandom sr = new SecureRandom(key.getBytes());
		KeyGenerator kg;
		String decryptedValue = null;
		try {
			kg = KeyGenerator.getInstance(ALGORITHM);
			kg.init(sr);
			SecretKey sk = kg.generateKey();

			// do the decryption with that key
			Cipher cipher = Cipher.getInstance(CIPHER);
			cipher.init(Cipher.DECRYPT_MODE, sk, iv);
			Base64 decoder = new Base64();
			byte[] decryptedValue64 = decoder.decode(toDecrypt);
			byte[] decrypted = cipher.doFinal(decryptedValue64);
			decryptedValue = new String(decrypted, UTF8);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
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
}