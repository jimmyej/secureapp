package pe.com.jse.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptDES {

	byte[] temporalGeneratedKey;

	public static String encrypt(String originalText, String key) {
		String encryptedKey = null;
//		SecretKeySpec desKey = new SecretKeySpec(new String((key.trim().concat("999999999")).substring(0, 8)).getBytes(),"DES");
		SecretKeySpec desKey = new SecretKeySpec(key.getBytes(),"DES");
		Cipher cipher = null;
		byte[] encryptedKeyBytes = null;
		try {
			cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			encryptedKeyBytes = cipher.doFinal(originalText.getBytes());
			encryptedKey = Base64.encodeBase64String(encryptedKeyBytes);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		}
		return encryptedKey;
	}

	public static String decrypt(String encryptedText, String key) {
		String decrypted = null;
		// Generamos Clave Secreta
//		SecretKeySpec desKey = new SecretKeySpec(new String((key.trim().concat("999999999")).substring(0, 8)).getBytes(),"DES");
		SecretKeySpec desKey = new SecretKeySpec(key.getBytes(),"DES");
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			byte cipherText[] = Base64.decodeBase64(encryptedText);
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			byte bclearText[] = cipher.doFinal(cipherText);
			decrypted = new String(bclearText);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		}
		return decrypted;
	}

	/**************************************************************************/
	public String generateKey() {
		String generatedKey = null;
		try {
			SecureRandom sr = new SecureRandom("seed".getBytes("UTF-8"));
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			keygen.init(256, sr);
			SecretKey aesKey = keygen.generateKey();
			byte[] key = aesKey.getEncoded();
			generatedKey = new String(Base64Util.encodeBytes(key));
			temporalGeneratedKey = key;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return generatedKey;
	}

	public static void main(String[] args) {
		try {
			EncryptDecryptDES su = new EncryptDecryptDES();

			System.out.println("=============================================");
			System.out.println("Llave Generada: " + su.generateKey());
			System.out.println("Clave Encriptada: " + encrypt("0123456789", "12345678"));
			System.out.println("Clave Desencriptada: " + decrypt("7VWl5YIZgB7zbyKM8mz3+Q==", "12345678"));
			System.out.println("=============================================");
		} catch (Exception ex) {
			Logger.getLogger(EncryptDecryptDES.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
