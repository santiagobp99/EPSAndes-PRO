package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOUsuario {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El idRol de nombre-tabla
	 */
	public long getId();
	
	/**
	 * @return El idRol de nombre-tabla
	 */
	public long getIdRol();

	/**
	 * @return El nombre de nombre-tabla
	 */
	public String getNombre();

	/**
	 * @return El correo de nombre-tabla
	 */
	public String getCorreo();
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
