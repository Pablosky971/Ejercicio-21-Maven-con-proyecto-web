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
	 * @return false si el usuario indicado no est� registrado en el sistema, y true si lo est�.
	 */
	public boolean comprobacionUsuarioLogin(Usuario u) {
		
		if(u.getPassword().equals("") || u.getNombre().equals("")) {
			return false;
		}
		
		u = du.obtenerUsuario(u);
		
		if(!u.getNombre().equals("") && !u.getPassword().equals("")) {
			return true;
		}
		return false;
	}
	public List<Usuario> listarUsuarios() {
		List<Usuario> l = du.listarUsuarios();
		return l;
	}

}
