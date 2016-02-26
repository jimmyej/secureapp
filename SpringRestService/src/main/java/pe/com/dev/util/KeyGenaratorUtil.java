package pe.com.dev.util;

import java.util.UUID;

import org.springframework.security.crypto.keygen.KeyGenerators;

public class KeyGenaratorUtil {

	public KeyGenaratorUtil(){
		
	}
	public static String generateKey(){
		return KeyGenerators.string().generateKey();
	}
	public static String generateKeyUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Randon key: "+generateKey());
			//String uuid = UUID.randomUUID().toString();//UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("uuid = " + generateKeyUUID());
			
		}
		
	}
}
