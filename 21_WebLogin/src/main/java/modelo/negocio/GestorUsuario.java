package modelo.negocio;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuarioMySQL;
import modelo.persistencia.interfaces.DaoUsuario;

public class GestorUsuario {
	
	/**
	 * Método que valida los credenciales introducidos y verifica si se encuentra registrado en la BD o no.
	 * @param u usuario que se comprueba.
	 * @return 0 si el usuario indicado no está registrado en el sistema, y 1 si lo está.
	 */
	public int comprobacionUsuarioLogin(Usuario u) {
		
		int res = 0;
		DaoUsuario du = new DaoUsuarioMySQL();
		Usuario usuario = du.obtenerUsuario(u.getNombre(), u.getPassword());
		
		if(usuario != null) {
			
			res = 1;
		
		} else {
			
		}
		
		
		return res;
	}

}
