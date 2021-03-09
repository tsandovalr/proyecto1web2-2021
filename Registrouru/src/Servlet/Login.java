package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Servlet.Registro;
import Controllers.Infocontroller;
import Controllers.LoginController;
import Helpers.Auth;


@MultipartConfig()
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(LoginController.Login(request));
	
		
	}


	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LoginController.sesion.invalidate();
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print("Ha cerrado sesion exitosamente.");
		
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
	
		out.print(LoginController.UserSession);
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
