package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOIps {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * @return El idEps de nombre-tabla
	 */
	public long getIdEps();

	/**
	 * @return La ubicacion de nombre-tabla
	 */
	public String getUbicacion();

	/**
	 * @return El nombre de nombre-tabla
	 */
	public String getNombre();

	/**
	 * @return El tipo de nombre-tabla
	 */
	public String getTipo();

	/**
	 * @return El capacidad de nombre-tabla
	 */
	public int getCapacidad();
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
