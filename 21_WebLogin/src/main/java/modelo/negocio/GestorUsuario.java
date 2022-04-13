package modelo.negocio;

import java.util.List;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuarioMySQL;
import modelo.persistencia.interfaces.DaoUsuario;

public class GestorUsuario {
	
	private DaoUsuario du = new DaoUsuarioMySQL();
	
	/**
	 * M�todo que valida los credenciales introducidos y verifica si se encuentra registrado en la BD o no.
	 * @param u usuario que se comprueba.
	 * @return 0 si el usuario indicado no est� registrado en el sistema, y 1 si lo est�.
	 */
	public int comprobacionUsuarioLogin(String nombre, String password) {
		
		int res = 0;
		
		Usuario usuario = du.obtenerUsuario(nombre, password);
		
		if(usuario != null) {
			
			res = 1;
		
		} 
		
		
		return res;
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> l = du.listarUsuarios();
		return l;
	}

}
