package Controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Helpers.Auth;
import Helpers.ConnectionDB;

import Helpers.Hashing;

public class LoginController {
	
	public static String PassSession = "";
	public static String PassHasheadaSession = "";
	public static String UserSession = "";
	public static HttpSession sesion = null;
	
	

	
	public static String Login (HttpServletRequest request) {
		
		if(Auth.AuthCheck(request.getParameter("user"), request.getParameter("pass"))) {						
			sesion = request.getSession();
			sesion.setAttribute("user", request.getParameter("user"));
			sesion.setAttribute("pass", request.getParameter("pass"));
			
			UserSession = (String) sesion.getAttribute("user");
			PassSession = (String) sesion.getAttribute("pass");
			try {
				PassHasheadaSession = Hashing.getHash(PassSession);
	
				
			} catch (NoSuchAlgorithmException e) {				
				e.printStackTrace();
			}
			
		
			
			return "success";			
		}else {						
			return "Datos incorrectos.";
		}
		
		
		
	}}



	
	
	
	
	
	
	


