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

public class DaoUsuarioMySQL implements DaoUsuario{

	private Connection conexion;
	
	
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/usuario";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			
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
	
	public Usuario obtenerUsuario(String nombre, String password) {
		
		if(!abrirConexion()) {
			return null;
		}
		
		Usuario u = null;
		String query = "select ID,NOMBRE,PASSWORD from usuarios " + "where nombre = ? and password = ?";
		
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1,nombre);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new Usuario();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setPassword(rs.getString(3));
				
			}
			
		} catch(SQLException e) {
			System.out.println("Error al obtener el usuario" + nombre);
			u=null;
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		return u;
	}

	
	public List<Usuario> listarUsuarios() {
		
		if(!abrirConexion()) {
			return null;
		}
		
		List<Usuario> l = new ArrayList<>();
		String query = "select ID,NOMBRE,PASSWORD from coches";
		
		
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
