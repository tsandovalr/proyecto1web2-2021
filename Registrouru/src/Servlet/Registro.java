package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.LoginController;
import Controllers.RegisterController;

@MultipartConfig()
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registro() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String usuario = request.getParameter("user");
		String password = request.getParameter("pass");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		String tlf = request.getParameter("tlf");
		
		if(usuario.equals("") || password.equals("")|| country.equals("")
				|| city.equals("")|| tlf.equals(""))out.print("Debe rellenar los campos para registrarse.");
		else {
			try {
				out.println(RegisterController.register(
						request.getParameter("user"), 
						request.getParameter("pass"),
						request.getParameter("country"),
						request.getParameter("city"),
						request.getParameter("gender"),
						request.getParameter("tlf")
						));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
