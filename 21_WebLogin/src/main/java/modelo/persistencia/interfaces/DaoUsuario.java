package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Usuario;

public interface DaoUsuario {
	
	Usuario obtenerUsuario(String nombre, String password);
	List<Usuario> listarUsuarios();
	
	

}
