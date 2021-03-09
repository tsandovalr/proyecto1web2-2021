package Controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Helpers.ConnectionDB;
import Helpers.Hashing;

public class UpdateController {
	
	LoginController obj = new LoginController();
	
	
	
	public static String Update(HttpServletRequest request) throws NoSuchAlgorithmException {
		
		String NuevaPass = request.getParameter("NuevaPassword");
		String RepetirPass = request.getParameter("RepetirPassword");
		String Usuario = request.getParameter("NuevoUsuario");
		String country = request.getParameter("Nuevocountry");
		String city = request.getParameter("Nuevacity");
		String gender = request.getParameter("Nuevogender");
		String tlf = request.getParameter("Nuevotlf");
		String cedula = request.getParameter("Nuevacedula");
		String dir = request.getParameter("Nuevadir");
		String ocupacion = request.getParameter("Nuevaocupacion");
		
		String PasswordDeLogin = LoginController.PassSession;
		String UsernameDeLogin = LoginController.UserSession;
		
		
		if(NuevaPass.equals("") && RepetirPass.equals("") && Usuario.equals(""))return "ninguna";
		
		else if(NuevaPass.equals(RepetirPass)) {
			
			String PasswordDeLoginHasheada = "";
			String NuevaPassHasheada = "";
			
			if(!NuevaPass.equals("") && !RepetirPass.equals("")) {
			
			
			PasswordDeLoginHasheada = Hashing.getHash(PasswordDeLogin);
			NuevaPassHasheada = Hashing.getHash(NuevaPass);
			}
			
			ConnectionDB.Update(UsernameDeLogin, Usuario, PasswordDeLoginHasheada, NuevaPassHasheada,country,city,gender,tlf,
					cedula,dir,ocupacion);
			
			return "success";
			
			
		}else {
			
			return "fail";
		}
		
		
		
		
	}
	

	
	
	public static HttpSession getInstance(HttpSession obj) {
		return obj;
	}
	
	

}
