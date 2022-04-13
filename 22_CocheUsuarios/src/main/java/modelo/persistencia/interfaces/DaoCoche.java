package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

public interface DaoCoche {
	
	/**
	 * M�todo que sirve para dar de alta a un nuevo coche en el sistema.
	 * @param c es el coche que queremos dar de alta.
	 * @return true si se ha registrado con �xito, y false si ha ocurrido alg�n error y no se alamacena7
	 * correctamente.
	 */
	boolean altaCoche(Coche c);
	
	/**
	 * M�todo usado para dar de baja un coche ya registrado en el sistema.
	 * @param id para indicar que coche queremos dar de baja
	 * @return true si se ha dado de baja, y false si falla y no se suprime el coche se�alado.
	 */
	boolean bajaCoche(int id);
	
	/**
	 * M�todo emepleado para modificar los valores del coche que se espcifica.
	 * @param c del coche que se quiere actualizar.
	 * @return true si el coche se modifica correctamente seg�n los nuevos valores explicitados, y false
	 * si falla y no se efect�a la operaci�n.
	 */
	boolean modificarCoche(Coche c);
	
	/**
	 * M�todo que se emplea para obtener un coche por su id.
	 * @param id que se�ala el coche que se quiere obtener.
	 * @return devuelve el coche correspondiente al id especificado.	 
	 * */
	Coche buscarCocheId(int id);
	
	/**
	 * M�todo que se emplea para obtener un coche por su matr�cula.
	 * @param matr�cula que se�ala el coche que se quiere obtener.
	 * @return devuelve el coche correspondiente a la matr�cula especificada, y, si no se encuentra, null.	 
	 * */
	Coche buscarCocheMatricula(String matricula);
	
	/**
	 * M�todo que se emplea para obtener un coche por su marca.
	 * @param marca que se�ala el coche que se quiere obtener.
	 * @return devuelve el coche correspondiente a la marca especificada y, si no se encuentra, null.	 
	 * */
	Coche buscarCocheMarca(String marca);
	
	/**
	 * M�todo que se emplea para obtener un coche por su modelo.
	 * @param modelo que se�ala el coche que se quiere obtener.
	 * @return devuelve el coche correspondiente al modelo especificada y, si no se encuentra, null.	 
	 * */
	Coche buscarCocheModelo(String modelo);
	
	/**
	 * 
	 * @return todos los coches registrados en el sistema y, si no se encuentran, null.
	 */
	List<Coche> coches();
	
	
}
