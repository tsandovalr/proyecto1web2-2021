package Helpers;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Auth {
	
	
	
	static public boolean AuthCheck(String username, String password) {
		
		Connection cn = null;
		
		cn = ConnectionDB.conexionDB();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			 stmt = cn.createStatement ();
			 stmt.executeQuery ("select * from login where username = '"+username+"'");
			 rs = stmt.getResultSet ();
			 
			 String passHasheada = "";
			 passHasheada = Hashing.getHash(password);
			 
			 
			 while (rs.next()){
				 				 
				 String contrasena = rs.getString (2);				 
				 if(contrasena.equals(passHasheada)) return true;			 
				 
			 }
			 
			 stmt.close ();
			 cn.close();
		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	
	
	
	
	
	

}
