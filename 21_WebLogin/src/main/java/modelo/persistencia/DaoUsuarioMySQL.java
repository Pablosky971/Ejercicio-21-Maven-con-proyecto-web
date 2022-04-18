package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Usuario;
import modelo.persistencia.interfaces.DaoUsuario;

public class DaoUsuarioMySQL implements DaoUsuario {

	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
		}
		
		System.out.println("Se ha cargado el Driver de MySQL");
	}
	
	private Connection conexion;
	
	
	
	public boolean abrirConexion() throws ClassNotFoundException{
		
		String url = "jdbc:mysql://localhost:3306/usuario";
		String usuario = "root";
		String password = "";
		try {
			
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Usuario obtenerUsuario(Usuario u) {
		
		try {
		if(!abrirConexion()) {
			System.out.println("No he abierto bien la conexión");
			return null;
		}
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		String query = "select NOMBRE,PASSWORD from usuarios " + "where nombre = ?";
		
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1,u.getNombre());
			ResultSet rs = ps.executeQuery();
			
			Usuario res = new Usuario();
			
			while(rs.next()) {
			
			
				res.setNombre(rs.getString(1));
				res.setPassword(rs.getString(2));
				
			}
			
			return res;
			
		} catch(SQLException e) {
			System.out.println("Error al obtener el usuario" + u.getNombre());
			u=null;
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		return null;
	}

	
	public List<Usuario> listarUsuarios() {
		
		try {
			if(!abrirConexion()) {
				System.out.println("No he abierto bien la conexión");
				return null;
			}
			} catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		
		List<Usuario> l = new ArrayList<>();
		String query = "select ID,NOMBRE,PASSWORD from usuarios";
		
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setPassword(rs.getString(3));
				
				l.add(u);
			}
			
		} catch(SQLException e) {
			System.out.println("Error al obtener los usuarios registrados en el sistema");
			
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		
		return l;
	}
	
	

}
