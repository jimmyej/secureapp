package pe.com.dev.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptDES2 {
	
	private static final String ALGORITHM = "PBEWithMD5AndDES";
	private static final String UTF8 = "UTF-8";
	
	// 8-byte Salt
	byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };
	// Iteration count
	int iterationCount = 19;

	public EncryptDecryptDES2() {

	}

	/**
	 * @param secretKey Key used to encrypt data
	 * @param plainText Text input to be encrypted
	 * @return Returns encrypted text
	 */
	public String encrypt(String secretKey, String plainText) {
		// Key generation for enc and desc
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
		SecretKey key;
		Cipher ecipher;
		String encStr = null;
		try {
			key = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(keySpec);
			// Prepare the parameter to the ciphers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			// Enc process
			ecipher = Cipher.getInstance(key.getAlgorithm());
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			byte[] in = plainText.getBytes(UTF8);
			byte[] out = ecipher.doFinal(in);

			Base64 encoder = new Base64();
			byte[] enc = encoder.encode(out);
			encStr = new String(enc, UTF8);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return encStr;
	}

	/**
	 * @param secretKey Key used to decrypt data
	 * @param encryptedText encrypted text input to decrypt
	 * @return Returns plain text after decryption
	 */
	public String decrypt(String secretKey, String encryptedText) {
		// Key generation for enc and desc
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
		SecretKey key;
		Cipher dcipher;
		String plainStr = null;
		try {
			key = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(keySpec);
			// Prepare the parameter to the ciphers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
			// Decryption process; same key will be used for decr
			dcipher = Cipher.getInstance(key.getAlgorithm());
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

			Base64 decoder = new Base64();
			byte[] enc = decoder.decode(encryptedText);
			byte[] utf8 = dcipher.doFinal(enc);
			
			plainStr = new String(utf8, UTF8);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
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
		return plainStr;
	}

	public static void main(String[] args) throws Exception {
		EncryptDecryptDES2 cryptoUtil = new EncryptDecryptDES2();
		String key = "1a2b3c4d5e6f7f8g1a2b3c4d5e6f7f8g1a2b3c4d5e6f7f8g1a2b3c4d5e6f7f8g";
		String plain = "This is an important message";
		String enc = cryptoUtil.encrypt(key, plain);
		System.out.println("Original text: " + plain);
		System.out.println("Encrypted text: " + enc);
		String plainAfter = cryptoUtil.decrypt(key, enc);
		System.out.println("Original text after decryption: " + plainAfter);
	}
}
