package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Usuario;

public interface DaoUsuario {
	
	Usuario obtenerUsuario(Usuario u);
	List<Usuario> listarUsuarios();
	
	

}
