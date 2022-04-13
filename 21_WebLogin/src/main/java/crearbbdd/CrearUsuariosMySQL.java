package crearbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * CREATE TABLE usuarios ( id int(11) NOT NULL AUTO_INCREMENT,
 *  nombre varchar(45) DEFAULT NULL, password varchar(45) DEFAULT NULL, PRIMARY KEY (id) );
 *  
 */


// Instancia insertadas para probar el GET.
/*
 * INSERT INTO `usuarios` (nombre, password) VALUES ("Pablosky", "XOXOGryffindor");

 */

/*
 * INSERT INTO `usuarios` (nombre, password) VALUES ("Mery", "XOXOSlytherin");

 */

/*
 * INSERT INTO `usuarios`(`nombre`, `password`) VALUES ('FdePablo','elMejorProfe');
 */
public class CrearUsuariosMySQL {
	
	// Para que sea compatible con Tomcat.
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
		}
		
		System.out.println("Se ha cargado el Driver de MySQL");
	}
	
	private Connection conexion;
	public static void main(String[] args) {
		
		CrearUsuariosMySQL bd = new CrearUsuariosMySQL();
		bd.crearBBDD();
		
		
	}
	
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
	
	public boolean crearBBDD() {
		if(!abrirConexion()){
			return false;
		}
		boolean estaCreada = true;
		
		try {
			
			Statement state = conexion.createStatement();
			state.execute("CREATE TABLE usuarios ( id int(11) NOT NULL AUTO_INCREMENT,"
					+ " nombre varchar(45) DEFAULT NULL, password varchar(45) DEFAULT NULL, PRIMARY KEY (id) );");
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al crear: ");
			estaCreada = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return estaCreada;
	}
		

}
