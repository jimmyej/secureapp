package pe.com.jse.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

public class EncryptDecryptAES {

	private static final String ALGORITHM = "AES";
	private static final int SIZE = 16;
	private static final String UTF8 = "utf-8";
	
    public static String encrypt(String value, String keyValue)
    {
        Key key = new SecretKeySpec(keyValue.getBytes(),ALGORITHM);
        Cipher cipher;
        String encryptedValue64 = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	        byte [] encryptedByteValue = cipher.doFinal(value.getBytes(UTF8));
	        encryptedValue64 = Base64.encodeBase64String(encryptedByteValue);
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
    
    public static String decrypt(String value, String keyValue)
    {
        Key key =  new SecretKeySpec(keyValue.getBytes(),ALGORITHM);
        Cipher cipher;
        String decryptedValue = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        byte [] decryptedValue64 = Base64.decodeBase64(value);
	        byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
	        decryptedValue = new String(decryptedByteValue,UTF8);
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
    
    public static String generateKeyAlphaNumeric(){
    	return RandomStringUtils.randomAlphanumeric(SIZE);
    }
    public static String generateKeyAscii(){
    	return RandomStringUtils.randomAscii(SIZE);
    }
    public static String generateKeyUUID(){
    	return UUID.randomUUID().toString().replaceAll("-", "").substring(0,SIZE);
    }
    
	public static void main(String[] args) {
		String uuid = generateKeyUUID();
		System.out.println("uuid="+uuid);
		
		String randomString = RandomStringUtils.randomAlphabetic(EncryptDecryptAES.SIZE);
		System.out.println("randomString="+randomString);
		String randomStringNumeric = generateKeyAlphaNumeric();
		System.out.println("randomStringNumeric="+randomStringNumeric);
		String randomAscii = generateKeyAscii();
		System.out.println("randomAscii="+randomAscii);
		
        String password = "Summer2014";
        System.out.println("plain pass="+password);
        String encryptedPassword = EncryptDecryptAES.encrypt(password,uuid);
        System.out.println("encrypted pass="+encryptedPassword);
        String decryptedPassword = EncryptDecryptAES.decrypt(encryptedPassword,uuid);    
        System.out.println("decrypted pass="+decryptedPassword);
	}
}
