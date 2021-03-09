package Controllers;

import java.security.NoSuchAlgorithmException;

import Helpers.ConnectionDB;
import Helpers.Hashing;
import Helpers.PropertiesReader;


public class RegisterController {
	
	
	
	
	
	
	static public String register(String username, String password, String country, String city, String gender, String tlf ) throws NoSuchAlgorithmException {
		
		String passHash = Hashing.getHash(password);
		
		Object[] objeto = {username, passHash, country, city, gender, tlf};
		
		System.out.println(username + " " + passHash + " " + country + " " + gender + " " + tlf + " ");
		
		ConnectionDB.InsertarRegistro(objeto);
		
		return"{'Message': 'User created', 'status':200 }";
	}
	
	
	
	
	
	

}
