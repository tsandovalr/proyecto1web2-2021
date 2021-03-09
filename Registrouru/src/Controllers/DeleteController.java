package Controllers;

import Helpers.ConnectionDB;

public class DeleteController {
	
	
	public static String Delete(String user, String pass) {
		
		LoginController.sesion.invalidate();
		
		return ConnectionDB.Delete(user, pass);
		
	}
	
	
	
	

}
