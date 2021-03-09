package Helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	
	
	
	    public static String getHash(String pass) throws NoSuchAlgorithmException {
		byte [] input = pass.getBytes();
		MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
		
		SHA256.update(input);
		
		byte[]digest = SHA256.digest();
		
		StringBuffer hexDigest = new StringBuffer();
		for(int i=0; i<digest.length; i++) {
			hexDigest.append(Integer.toString((digest[i]&0xff)+0x100,16).substring(1));	
		}
		
		
		return hexDigest.toString();	
	}
	
	
		
	
	
	

}
