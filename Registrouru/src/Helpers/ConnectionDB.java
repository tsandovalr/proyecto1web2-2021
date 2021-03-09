package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	
	
		
	static public Connection conexionDB() {
		
		
		String url = "postgres://yxowvurcyblyhc:f184ec7c42f22e7a1e015e48ea87fd9e9d1167386a0bb52f69f6461ae4d2baa6@ec2-35-174-118-71.compute-1.amazonaws.com:5432/d7gr0419rqonks";
		String passDB = "f184ec7c42f22e7a1e015e48ea87fd9e9d1167386a0bb52f69f6461ae4d2baa6";
		String userDB = "yxowvurcyblyhc";
		
		
		
		
		
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, userDB, passDB);
			System.out.println("conexion con base de datos exitosa...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return conn;
		
	}
	
	
	
	static public void InsertarRegistro(Object[] obj) {		
	
			Connection con = conexionDB();
			PreparedStatement ps = null;
			try {
				
				ps = con.prepareStatement(
						"CREATE TABLE IF NOT EXISTS login" +
		                    "(username VARCHAR(100)," +
		                    "password VARCHAR(100)," +
		                    "country VARCHAR(30),"+
		                    "city VARCHAR(30),"+
		                    "gender VARCHAR(30),"+
		                    "tlf INTEGER,"+
		                    "CONSTRAINT login_pkey PRIMARY KEY(username)"
		                    + ");");		
				ps.executeUpdate();
			
				
				ps = con.prepareStatement("INSERT INTO login VALUES "+"('"+obj[0]+"', '"+obj[1]+"','"+obj[2]+
						"', '"+obj[3]+"', '"+obj[4]+"', '"+obj[5]+"');");
				ps.executeUpdate();
				
				System.out.println("registro añadido");
				
				con.close();
				
				
				
			} catch (Exception e) {
				
				System.out.println(e);
				System.out.println("crear la base de datos e intentar de nuevo");
			}
			
	}
	
	
	
	public static void Update(String UsuarioDeLogin, String NuevoUsuario, String ViejaPassword, String NuevaPassword, 
			String Nuevocountry, String Nuevacity, String Nuevogender, String Nuevotlf, 
			String Nuevacedula, String Nuevadir, String Nuevaocupacion) {
		
		Connection conn = conexionDB();
		
		try {
			
			Statement stmt = conn.createStatement ();
			
			
			
			if(!ViejaPassword.equals("") && !NuevaPassword.equals("")) {
				
				stmt.executeUpdate ("update login set password='"+NuevaPassword+"' where password='"+ViejaPassword+"' and username='"+UsuarioDeLogin+"'");
				
			}
			
			
			
			if(  !(NuevoUsuario.equals(""))   ) {
				stmt.executeUpdate ("update login set username='"+NuevoUsuario+"' where username='"+UsuarioDeLogin+"'");
			
			}
			stmt.executeUpdate ("update login set country='"+Nuevocountry+"' "
					+ ", city='"+Nuevacity+"', gender='"+Nuevogender+"', tlf='"+Nuevotlf+"'"
							+ " ,cedula='"+Nuevacedula+"' ,dir='"+Nuevadir+"' ,ocupacion='"+Nuevaocupacion+"' where username='"+UsuarioDeLogin+"'");
			
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}

	
	
	
	public static String Delete(String user, String pass) {
		
		
		Connection conn = conexionDB();
		
		try {
			Statement stmt = conn.createStatement ();
			stmt.executeUpdate ("delete from login where username='"+user+"' and password='"+pass+"'");
		} catch (SQLException e) {			
			e.printStackTrace();
			return"fail";
		}
		
		return "success";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	static public ConnectionDB getInstances() {
		
		return new ConnectionDB();
	}
	
	
	
	

}
