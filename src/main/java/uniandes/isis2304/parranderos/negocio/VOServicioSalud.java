package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los m�todos get de nombre-tabla.
 * Sirve para proteger la informaci�n del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Santiago Ballesteros
 * @author Tomas Langebaek
 */
public interface VOServicioSalud {
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	
	/**
	 * @return El idIps de nombre-tabla
	 */
	public long getId();
	
	/**
	 * @return El idIps de nombre-tabla
	 */
	public long getIdIps();

	/**
	 * @return El tipo de nombre-tabla
	 */
	public String getTipo();

	/**
	 * @return La descripcion de nombre-tabla
	 */
	public String getDescripcion();
	
	/**
	 * @return La descripcion de nombre-tabla
	 */
	public int getOrden();
	
	/**
	 * @return Una cadena con la informaci�n b�sica de nombre-tabla
	 */
	@Override
	public String toString();
	
}
